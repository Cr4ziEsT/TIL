package my.examples.was;

import java.io.*;
import java.net.Socket;

public class Handler extends Thread{
    private Socket socket;

    public Handler(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run(){
        // 소켓아 일하자
        // 요청, 응답, servlet
        InputStream in = null;
        OutputStream out = null;
        try {
            // 요청
            in = socket.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            Request request = new Request(br);
            // 응답
            out = socket.getOutputStream();
            PrintWriter pw = new PrintWriter(new OutputStreamWriter(out));
            Response response = new Response(out, pw);
            // 요청 path 경로를 읽어 파일 출력
            DefaultServlet defaultServlet = new DefaultServlet(request, response);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try{ in.close(); } catch(Exception e){}
            try{ out.close(); } catch(Exception e){}
            try{ socket.close(); } catch(Exception e){}
        }
    }
}
