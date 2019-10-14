package io.libsoft.blockchain.crypto;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Sha256Test {

  @Test
  void asBinary() {
    assertEquals("0110100011100110010101101011001001010001111001100111111010000011010110001011111011111000010010000011101010110000110101010001110001100110000110011111001111100111101000011010100111110000111001110101100000111000110101000001111111110011011010001111011100101000",
      Sha256.digest("hello, world!").asBinaryString());

  }

  @Test
  void asString() {
    assertEquals("68e656b251e67e8358bef8483ab0d51c6619f3e7a1a9f0e75838d41ff368f728", Sha256.digest("hello, world!").asHexString());
  }
}