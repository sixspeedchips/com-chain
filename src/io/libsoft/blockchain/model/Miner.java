package io.libsoft.blockchain.model;

import io.libsoft.blockchain.crypto.Sha256;
import io.libsoft.blockchain.utils.Utils;

public class Miner implements Runnable {

  private static final int DIFFICULTY = 20;
  private BlockChain chain;
  private boolean running;

  public Miner setChain(BlockChain chain) {
    this.chain = chain;
    return this;
  }

  @Override
  public void run() {
    running = true;
    String message = "Hello world";
    long blockNumber = 0;
    byte[] hash;
    byte[] prevHash;
    long dateCreated;
    long nonce = Utils.newNonce();
    int leading;

    while (running) {
      prevHash = chain.mostRecent().hash;
      blockNumber = chain.mostRecent().blockNumber+1;
      dateCreated = System.currentTimeMillis();
      hash = Sha256.digestAsBytes(blockNumber, prevHash, dateCreated, message, nonce);
      
      if((leading=Utils.leadingZeros(hash))> DIFFICULTY){
        Block block = new Block(blockNumber, prevHash, hash, dateCreated, message, nonce);
        chain.addBlock(block);
        nonce = Utils.newNonce();
        System.out.println(Utils.blockPrinter(block));
      }
      nonce++;
    }
  }


  public void pause() {
    running = false;
  }
}
