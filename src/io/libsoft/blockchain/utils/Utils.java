package io.libsoft.blockchain.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.libsoft.blockchain.crypto.Sha256;
import io.libsoft.blockchain.model.Block;
import java.security.SecureRandom;
import java.util.Random;

public class Utils {

  private static Random random = new SecureRandom();
  private static final int FAIL_BIT = 0x80;
  private static Gson gson = new GsonBuilder().setPrettyPrinting().create();

  public static int leadingZeros(byte[] bytes) {
    int count = 0;
    for (byte b : bytes) {
      for (int i = 0; i < 8; i++) {
        if ((b & FAIL_BIT) == FAIL_BIT) {
          return count;
        }
        b = (byte) (b << 1);
        count++;
      }
    }
    return count;
  }

  public static String print(Object object) {
    return gson.toJson(object);
  }

  public static long newNonce() {
    return random.nextLong();
  }

  public static String blockPrinter(Block block) {
    return block.blockNumber + "\n"
        + Sha256.asBinaryString(block.prevHash) + "\n"
        + Sha256.asBinaryString(block.hash) + "\n"
        + block.dateCreated + "\n"
        + block.body + "\n"
        + block.nonce + "\n";
  }


}
