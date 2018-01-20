package org.bytecoin.rpc.service;

import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.bytecoin.rpc.model.CreateAddressResponse;
import org.bytecoin.rpc.model.GetAddressesResponse;
import org.bytecoin.rpc.model.GetSpendKeysResponse;
import org.bytecoin.rpc.model.GetStatusResponse;
import org.bytecoin.support.PortMappingInitializer;
import org.bytecoin.support.PropagateDockerRule;
import org.junit.ClassRule;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.rules.RuleChain;
import org.junit.rules.TestRule;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.palantir.docker.compose.DockerComposeRule;
import com.palantir.docker.compose.connection.waiting.HealthChecks;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.NONE)
@ActiveProfiles("it")
@ContextConfiguration(initializers = PortMappingInitializer.class)
public class WalletJsonRpcApiIT {	
    private static DockerComposeRule docker = DockerComposeRule.builder()
            .file("src/test/resources/docker-compose.yml")
            .waitingForService("bytecoin-rpc-wallet", HealthChecks.toHaveAllPortsOpen())
            .build();
    
    @ClassRule
    public static TestRule exposePortMappings = RuleChain.outerRule(docker).around(new PropagateDockerRule(docker));
     	
	@Autowired
	private WalletJsonRpcApi walletJsonRpcApi;

	@Test
	public void getStatus() {
		GetStatusResponse status = walletJsonRpcApi.getStatus();
		
		Assertions.assertThat(status).satisfies(r -> {
			Assertions.assertThat(r.getBlockCount()).isGreaterThan(0);
			Assertions.assertThat(r.getKnownBlockCount()).isGreaterThan(0);
			Assertions.assertThat(r.getLastBlockHash()).isNotEmpty();
			Assertions.assertThat(r.getPeerCount()).isGreaterThan(-1);
		});
	}
	
	@Test
	public void getAddresses() {
		GetAddressesResponse addresses = walletJsonRpcApi.getAddresses();
		
		Assertions.assertThat(addresses.getAddresses())
			.isNotEmpty()
			.allSatisfy(a -> {
				Assertions.assertThat(a).isNotEmpty();
			});
	}
	
	@Test
	public void getSpendKeys() {
		GetAddressesResponse addresses = walletJsonRpcApi.getAddresses();
		
		Optional<String> anyAddress = addresses.getAddresses().stream().findAny();
		
		Assertions.assertThat(anyAddress)
			.isNotEmpty()
			.satisfies(a -> {				
				GetSpendKeysResponse spendKeys = walletJsonRpcApi.getSpendKeys(anyAddress.get());
				Assertions.assertThat(spendKeys.getSpendPublicKey()).isNotEmpty();
				Assertions.assertThat(spendKeys.getSpendSecretKey()).isNotEmpty();
			});
	}	
	
	@Test
	@Ignore
	public void createAddress() {
		CreateAddressResponse createAddress = walletJsonRpcApi.createAddress(null, null);
		
		Assertions.assertThat(createAddress.getAddress()).isNotEmpty();
	}	
}