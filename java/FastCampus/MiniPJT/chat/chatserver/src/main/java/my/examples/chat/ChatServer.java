package my.examples.chat;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

public class ChatServer extends Thread {
    private int port; // 서버가 실행되는 port
    private Set<PrintWriter> socketSet = null;  // set : 같은 객체에 하나씩 저장


    public ChatServer(int port){ // 생성될 때 값을 갖고 있게 하고 싶다.
        this.port = port;
        this.socketSet = new CopyOnWriteArraySet<>();   // CopyOnWriteArraySet() : java.util.concurrent
    }

    public void addPrintWriter(PrintWriter out){
        socketSet.add(out);
    }
    public void removePrintWriter(PrintWriter out){
        socketSet.remove(out);
    }
    public void broadcast(String msg){
        for(PrintWriter out : socketSet){
            try {   // 네트워크로 데이터를 보내다가 네트워크가 끊어질 수 있기 때문에 try-catch로 오류를 처리한다.
                out.println(msg);
                out.flush();
            }catch(Exception e){}
        }
    }

    @Override
    public void run(){
        // 채팅 서버가 해야 할 작업
        // ServerSocket serverSocket = new ServerSocket(port); // ioexception 발생 반드시 try-catch 해야 함
        ServerSocket serverSocket = null;
        try{
            serverSocket = new ServerSocket(port);

            while(true) {   // 소켓은 계속 생성되며, 쓰레드이다.
                Socket socket = serverSocket.accept();  // 서버 소켓을 기다려야함, 블러킹메소드
                SocketHandler handler = new SocketHandler(this, socket); // 이번엔 SocketHandler 를 우리가 만들 것이다
                handler.start();
            }
        }catch(IOException ioe){
            ioe.printStackTrace();
        }finally {
            try{
                serverSocket.close();   // 이것도 오류가 발생하므로 try-catch 해야 한다.
            }catch (Exception ex){}
        }
    }
}

/*
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

public class ChatServer extends Thread {
    private int port;
    private Set<PrintWriter> socketSet = null;

    public ChatServer(int port){
        this.port = port;
        this.socketSet = new CopyOnWriteArraySet<>();
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
            try {
                serverSocket.close();
            }catch (Exception ex){}
        }
    }
}
*/