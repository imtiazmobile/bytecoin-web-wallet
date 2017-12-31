package org.bytecoin.rpc.service;

import org.bytecoin.rpc.model.GetAddressesResponse;
import org.bytecoin.rpc.model.GetStatusResponse;

/**
 * Mapped service interface regarding Bytecoin RPC Wallet JSON RPC API.
 * @author Willian Antunes
 * @see <a href="https://wiki.bytecoin.org/wiki/Bytecoin_RPC_Wallet_JSON_RPC_API">Bytecoin RPC Wallet JSON RPC API<a/>
 */
public interface WalletJsonRpcApi {
	/**
	 * @see <a href="https://wiki.bytecoin.org/wiki/Get_status_-_Bytecoin_RPC_Wallet_API">Get status<a/> 
	 */
	GetStatusResponse getStatus();
	/**
	 * @see <a href="https://wiki.bytecoin.org/wiki/Get_addresses-_Bytecoin_RPC_Wallet_API">Get addresses- Bytecoin RPC Wallet API<a/> 
	 */	
	GetAddressesResponse getAddresses();
}