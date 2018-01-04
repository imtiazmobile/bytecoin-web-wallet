package org.bytecoin.rpc.model;

import lombok.Data;

@Data
public class GetSpendKeysResponse {
    private String spendSecretKey;
    private String spendPublicKey;
}