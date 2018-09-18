package my.examples.http;

import java.net.ServerSocket;
import java.net.Socket;
// connector 연결하여 serversocket을 생성하는 객체
public class Connector extends Thread {
    private int port;

    public Connector(int port){
        this.port = port;
    }

    @Override
    public void run(){
        ServerSocket serverSocket = null;

        try{
            serverSocket = new ServerSocket(port);
            while(true){
                Socket socket = serverSocket.accept();
                SocketHandler handler = new SocketHandler(socket);
                handler.start();
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            try{ serverSocket.close(); }catch (Exception ex){}
        }
    }
}
