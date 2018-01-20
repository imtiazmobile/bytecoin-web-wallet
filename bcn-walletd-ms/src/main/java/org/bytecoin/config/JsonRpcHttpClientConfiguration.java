package org.bytecoin.config;

import java.io.IOException;

import org.bytecoin.rpc.service.WalletJsonRpcApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.googlecode.jsonrpc4j.spring.JsonProxyFactoryBean;

@Configuration
public class JsonRpcHttpClientConfiguration {	
    @Bean
    public JsonProxyFactoryBean autoJsonRpcClientProxyCreator(@Value("${bytecoin.rpc-wallet-api-endpoint}") String bytecoinWalletdEndpoint) throws IOException {
    	JsonProxyFactoryBean proxy = new JsonProxyFactoryBean();
    	proxy.setServiceUrl(bytecoinWalletdEndpoint);
    	proxy.setServiceInterface(WalletJsonRpcApi.class);
    	
        return proxy;
    }	
}