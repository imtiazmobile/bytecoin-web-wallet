package org.bytecoin.rpc.service;

import org.bytecoin.rpc.model.CreateAddressResponse;
import org.bytecoin.rpc.model.GetAddressesResponse;
import org.bytecoin.rpc.model.GetSpendKeysResponse;
import org.bytecoin.rpc.model.GetStatusResponse;

import com.googlecode.jsonrpc4j.JsonRpcParam;

/**
 * Mapped service interface regarding Bytecoin RPC Wallet JSON RPC API.
 * @author Willian Antunes
 * @see <a href="https://wiki.bytecoin.org/wiki/Bytecoin_RPC_Wallet_JSON_RPC_API">Bytecoin RPC Wallet JSON RPC API<a/>
 * @see <a href="https://monero.stackexchange.com/questions/1051/list-of-common-monero-terms-and-definitions?rq=1">List of common Monero terms and definitions</a>
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
	
	/**
	 * @see <a href="https://wiki.bytecoin.org/wiki/Get_spend_keys_-_Bytecoin_RPC_Wallet_API">Get spend keys - Bytecoin RPC Wallet API<a/>
	 * @see <a href="https://www.reddit.com/r/Monero/comments/3q4j2g/how_do_i_use_view_and_spend_keys/">How do I use view and spend keys?</a> 
	 */		
	GetSpendKeysResponse getSpendKeys(@JsonRpcParam(value="address") String address);
	
	/**
	 * @see <a href="https://wiki.bytecoin.org/wiki/Create_address_-_Bytecoin_RPC_Wallet_API">Create address - Bytecoin RPC Wallet API<a/> 
	 */	
	CreateAddressResponse createAddress(@JsonRpcParam(value="secretSpendKey") String secretSpendKey, @JsonRpcParam(value="publicSpendKey") String publicSpendKey);
}