package io.libsoft.blockchain.crypto;

import com.google.common.io.BaseEncoding;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Sha256 {

  private static MessageDigest digest;
  private byte[] hashed;

  static {
    try {
      digest = MessageDigest.getInstance("SHA-256");
    } catch (NoSuchAlgorithmException e) {
      e.printStackTrace();
    }
  }


  private Sha256(Object... objects) {
    hashed = getHash(objects);
  }

  private static byte[] getHash(Object[] objects) {
    digest.reset();
    for (Object object : objects) {
      digest.update(object.toString().getBytes(StandardCharsets.UTF_8));
    }
    return digest.digest();
  }

  public byte[] asBytes() {
    return this.hashed;
  }

  public String asBinaryString() {
    StringBuilder sb = new StringBuilder();
    for (byte b : this.hashed) {
      sb.append(String.format("%8s", Integer.toBinaryString(b & 0xFF)).replace(' ', '0'));
    }
    return sb.toString();
  }

  public static String asBinaryString(byte... bytes) {
    StringBuilder sb = new StringBuilder();
    for (byte b : bytes) {
      sb.append(String.format("%8s", Integer.toBinaryString(b & 0xFF)).replace(' ', '0'));
    }
    return sb.toString();
  }

  public String asHexString() {
    return asHexString(this.hashed);
  }

  public static String asHexString(byte[] hashed) {
    return BaseEncoding.base16().encode(hashed).toLowerCase();
  }

  public static Sha256 digest(Object... objects) {
    return new Sha256(objects);
  }

  public static byte[] digestAsBytes(Object... objects) {
    return getHash(objects);
  }

}
