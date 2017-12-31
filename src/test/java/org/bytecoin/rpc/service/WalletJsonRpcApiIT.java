package org.bytecoin.rpc.service;

import java.io.IOException;

import org.assertj.core.api.Assertions;
import org.bytecoin.rpc.model.GetAddressesResponse;
import org.bytecoin.rpc.model.GetStatusResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.NONE)
public class WalletJsonRpcApiIT {
	@Autowired
	private WalletJsonRpcApi walletJsonRpcApi;

	@Test
	public void getStatus() throws IOException {
		GetStatusResponse status = walletJsonRpcApi.getStatus();
		
		Assertions.assertThat(status).satisfies(r -> {
			Assertions.assertThat(r.getBlockCount()).isGreaterThan(0);
			Assertions.assertThat(r.getKnownBlockCount()).isGreaterThan(0);
			Assertions.assertThat(r.getLastBlockHash()).isNotEmpty();
			Assertions.assertThat(r.getPeerCount()).isGreaterThan(0);
		});
	}
	
	@Test
	public void getAddresses() throws IOException {
		GetAddressesResponse addresses = walletJsonRpcApi.getAddresses();
		
		Assertions.assertThat(addresses.getAddresses())
			.isNotEmpty()
			.allSatisfy(a -> {
				Assertions.assertThat(a).isNotEmpty();
			});
	}
}