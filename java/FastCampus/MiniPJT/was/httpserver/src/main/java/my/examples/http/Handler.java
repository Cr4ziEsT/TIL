package my.examples.http;

import java.io.*;
import java.net.Socket;

// 소켓 일하자
public class Handler extends Thread {
    private Socket socket;

    public Handler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run(){
        InputStream in = null;
        OutputStream out = null;
        try {
            in = socket.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(in));

            out = socket.getOutputStream();
            PrintWriter pw = new PrintWriter(new OutputStreamWriter(out));

            // 요청
            Request request = new Request(in, br);
            // 응답
            Response response = new Response(out, pw);

            System.out.println(request.getMethod());
            System.out.println(request.getPath());
            System.out.println(request.getHeaders());

            DefaultServlet defaultServlet = new DefaultServlet();

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try{ in.close(); }catch(Exception e){}
            try{ out.close(); }catch(Exception e){}
            try{ socket.close(); }catch(Exception e){}
        }
    }
}
