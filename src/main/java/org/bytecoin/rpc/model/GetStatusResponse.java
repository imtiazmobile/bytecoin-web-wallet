package org.bytecoin.rpc.model;

import lombok.Data;

@Data
public class GetStatusResponse {
    private Integer peerCount;
    private Integer blockCount;
    private String lastBlockHash;
    private Integer knownBlockCount;
}