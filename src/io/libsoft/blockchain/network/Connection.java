package io.libsoft.blockchain.network;


import java.net.Socket;

public class Connection {


  private Socket connection;

  private Connection(Socket connection) {
    this.connection = connection;
  }

  public static Connection newConnection(Socket connection){
    return new Connection(connection);
  }
}
