package io.libsoft.blockchain.network;


import java.io.IOException;
import java.net.ServerSocket;
import java.util.HashMap;
import java.util.Map;

public class ServerManager implements Runnable {

  boolean awake;
  ServerSocket server;
  Map<String, Connection> connections;

  public ServerManager() throws IOException {
    server = new ServerSocket();
    connections = new HashMap<>();
  }

  @Override
  public void run() {
    awake = true;
    Connection connection;
    while(awake){

      try {

        server.accept();
      } catch (IOException e) {
        e.printStackTrace();
      }

    }


  }
}
