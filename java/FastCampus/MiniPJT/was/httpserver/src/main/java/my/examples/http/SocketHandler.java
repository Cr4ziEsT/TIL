package my.examples.http;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class SocketHandler extends Thread {
    private Socket socket;

    public SocketHandler(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run(){
        BufferedReader in = null;
        PrintWriter out = null;

        try{
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            Request request = new Request(in);
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            try{
                in.close();
            }catch(Exception ex){}
        }
    }
}
