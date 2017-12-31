package org.bytecoin.rpc.model;

import java.util.List;

import lombok.Data;

@Data
public class GetAddressesResponse {
	List<String> addresses;
}