package io.libsoft.blockchain.model;

import static io.libsoft.blockchain.utils.Utils.leadingZeros;

import io.libsoft.blockchain.crypto.Sha256;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Random;

public class Main {



  public static void main(String[] args) throws InterruptedException {

    System.out.println(Runtime.getRuntime().availableProcessors());
    System.out.println(Sha256.digest("Hello, World!").asHexString());
    System.out.println(Sha256.digest("Hello, World!").asBinaryString());
    BlockChain blockChain = new BlockChain();
    blockChain.addBlock(Block.genesis());
    Thread miner = new Thread(new Miner().setChain(blockChain));

    miner.start();

    miner.join();
    System.out.println(new Random().nextLong());


  }




}
