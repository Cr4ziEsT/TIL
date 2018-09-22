package my.examples.was;

import java.io.*;
import java.net.Socket;

public class Handler extends Thread {
    private Socket socket;

    public Handler(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run(){
        // 소켓이 할 일을 정해주자(Request, Response, Servlet)
        InputStream in = null;
        OutputStream out = null;
        try{
            // 요청
            in = socket.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            Request request = new Request(in, br);
            // 응답
            out = socket.getOutputStream();
            PrintWriter pw = new PrintWriter(new OutputStreamWriter(out));
            Response response = new Response(out, pw);

            // request, response를 이용하여 무엇을 할까?
            // 1. path정보에 해당하는 동적 프로그램이 있는지 확인한다.
            // ex : /today  --->  TodayServlet이 실행한 결과가 보여준다.
            // 2. 동적프로그램이 아니라면
            //       path에 해당하는 파일이 있는지 찾아본다.
            //       있으면 해당 파일의 내용을 보여주고, 없으면 404 오류를 출력한다.

            // 2번 구현해보기
            DefaultServlet defaultServlet = new DefaultServlet();
            defaultServlet.service(request, response);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try{ in.close(); }catch (Exception e){}
            try{ out.close(); }catch (Exception e){}
            try{ socket.close(); }catch (Exception e){}
        }
    }
}
