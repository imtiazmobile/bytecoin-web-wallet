
# Bytecoin Web Wallet

Under work! Soon this will be updated. 

In order to develop *Bytecoin RPC Wallet* must be running. See more at [willianantunes/bytecoin-rpc-wallet](https://hub.docker.com/r/willianantunes/bytecoin-rpc-wallet/).

## bcn-walletd-ms

It's the micro-service which handles the communication with [Bytecoin RPC Wallet JSON RPC API](https://wiki.bytecoin.org/wiki/Bytecoin_RPC_Wallet_JSON_RPC_API).

You can run integration test just typing the following command (you machine must have Docker installed): `mvn integration-test`

## bcn-walletd-fe

It's the front-end side. It'll use `bcn-walletd-ms` and maybe other services to make everything work.