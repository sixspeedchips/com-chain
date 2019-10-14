package io.libsoft.blockchain.model;

import io.libsoft.blockchain.crypto.Sha256;

public class Block {

  public long blockNumber;
  public byte[] prevHash;
  public byte[] hash;
  public long dateCreated;
  public String body;
  public long nonce;

  public Block(long blockNumber, byte[] prevHash, byte[] hash, long dateCreated,
      String body, long nonce) {
    this.blockNumber = blockNumber;
    this.prevHash = prevHash;
    this.hash = hash;
    this.dateCreated = dateCreated;
    this.body = body;
    this.nonce = nonce;
  }


  public byte[] compute() {
    byte[] hash = Sha256.digestAsBytes(blockNumber,
        prevHash, dateCreated, body, nonce);
    this.hash = hash;
    return hash;
  }

  public static Block genesis() {
    long now = System.currentTimeMillis();
    byte[] hash = Sha256.digestAsBytes(0,
        new byte[]{0}, now, "GENESIS", 0L);
    return new Block(0, new byte[]{0}, hash, now, "GENESIS", 0L);
  }
}
