package my.examples.chat;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;


import java.io.*;
import java.net.Socket;

public class SocketHandler extends Thread {
    private ChatServer chatServer;
    private Socket socket;
    private String name;

    public SocketHandler(ChatServer chatServer, Socket socket) {
        this.chatServer = chatServer;
        this.socket = socket;
    }

    @Override
    public void run() {

        System.out.println("SocketHandler Start");
        /* exception 발생
        InputStream in = socket.getInputStream();
        OutputStream out = socket.getOutputStream();
        */
        // 한 줄로 입력받고, 한 줄로 출력하기를 원함
        BufferedReader in = null;
        PrintWriter out = null;
        try {
            //exception 발생, 한 줄로 입력받고, 한 줄로 출력하기
            //in = socket.getInputStream();
            //out = socket.getOutputStream();

            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));

            this.name = in.readLine();  // 첫 줄은 무조건 이름이다.
            chatServer.broadcast(this.name + " 님이 입장했어요.");

            chatServer.addPrintWriter(out);

            String line = null;

            while ((line = in.readLine()) != null) {

                // out.println(line);
                // out.flush();    // 네트워크 프로그래밍에서는 운영체제가 클라이언트에게
                                // 데이터를 입력받아도 보내주지 않을 수 있기 때문에
                                // 강제적으로 보내주는 명령어를 써준다.

                chatServer.broadcast(this.name + " : " + line);
            }

        } catch (Exception ex) {
            System.out.println("Chat Handler close");
        } finally {
            chatServer.removePrintWriter(out);
            chatServer.broadcast(this.name + " 님이 퇴장했어요.");
            System.out.println("Chat Handler finally");
            try {
                in.close();
            } catch (Exception e) {
            }
            try {
                out.close();
            } catch (Exception e) {
            }
        }
    }
}
/*
public class SocketHandler extends Thread{
    private Socket socket;
    private ChatServer chatServer;

    public SocketHandler(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run(){
        BufferedReader in = null;
        PrintWriter out = null;
        try{
            System.out.println("Socket Handler start");
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out =  new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
            String line = null;

            while((line = in.readLine()) != null){
                out.println(line);
                out.flush();
            }

        }catch(Exception ex){
            System.out.println("Socket Handler close");
        }finally{
            System.out.println("Socket Handler finally");
            try{ in.close(); }catch(Exception ex){}
            try{ out.close(); }catch(Exception ex){}
        }
    }
}
*/