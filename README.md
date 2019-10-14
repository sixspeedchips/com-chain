# COM chain

This is an exploratory project for blockchains based in Java.

## Introduction

With the advent of Satoshi's original blockchain as the backbone for the bitcoin network, blockchains have maintained a critical mass of interest. As a data structure, blockchains are a set of records, or blocks that are linked by cryptographic hashes where the hash of a preceding block is used in the hash of the next block. Cryptographic hashing functions are functions which have the property that they are one way functions, that is that given an input the output is easy to verify, but given a hash, there is no known way to reverse engeering the output besides brute force trial and error of random inputs. 

Here we will attempt to prototype in java a blockchain on a distributed network in which users compete to find the correct hashes(mining) which grant users the ability to add their messages to a shared network of comments. 
