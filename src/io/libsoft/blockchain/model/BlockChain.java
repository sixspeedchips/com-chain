package io.libsoft.blockchain.model;

import java.util.LinkedList;

public class BlockChain {


  private LinkedList<Block> blockChain;


  public BlockChain() {
    blockChain = new LinkedList<>();
  }

  public void addBlock(Block block){
//    if(blockChain.size() > 1){
//    } else {
//      if(validate(block)){
//        blockChain.add(block);
//      }
//    }
    blockChain.add(block);

  }

  private boolean validate(Block block) {
    Block prevBlock = blockChain.peekLast();
    byte[] hash = block.compute();
    for (int i = 0; i < prevBlock.hash.length; i++) {
      if((prevBlock.hash[i] & block.hash[i]) != hash[i]){
        return false;
      }
    }

    return true;
  }

  public Block mostRecent(){
    return blockChain.peekLast();
  }
}
