package my.examples.was;

import java.net.ServerSocket;
import java.net.Socket;

public class Connector {
    private int port;

    public Connector(int port){
        this.port = port;
    }
    // 소캣 생성하기
    public void run(){
        ServerSocket serverSocket = null;
        try{
            serverSocket = new ServerSocket(port);
            while(true) {
                Socket socket = serverSocket.accept();
                Handler handler = new Handler(socket);
                handler.start();
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try { serverSocket.close(); }catch (Exception e){}
        }
    }
}
