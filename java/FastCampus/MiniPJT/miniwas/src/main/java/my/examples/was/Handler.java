package my.examples.was;

import java.io.*;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class Handler extends Thread{
    private static Map<String, Class> map;
    private static Map<String, HttpSerlvet> servletMap;
    static{
        servletMap = new HashMap<>();
        WebServletMapperManager wsmm = new WebServletMapperManager();
        map = wsmm.findServlet("/DEVEL/fastcampus2/miniwas/target/classes/");
    }
    private Socket socket;

    public Handler(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // 요청받기
            InputStream in = socket.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(in));

            OutputStream out = socket.getOutputStream();
            PrintWriter pw = new PrintWriter(new OutputStreamWriter(out));

            Request request = new Request(in, br);
            Response response = new Response(out, pw);

            String path = request.getPath();
            Class clazz = map.get(path);
            if(clazz != null) {
                HttpSerlvet httpSerlvet = servletMap.get(path);
                if(httpSerlvet == null){
                    httpSerlvet = (HttpSerlvet)clazz.newInstance(); // 객체가 생성
                    httpSerlvet.init();
                    servletMap.put(path, httpSerlvet);
                }
                pw.println("HTTP/1.1 200 OK");
                pw.println("Content-Type: text/html; charset=UTF-8");
                pw.println("");
                httpSerlvet.service(request, response);
                pw.flush();
                // request, response를 이용하여 무엇을할까?
                // 1. path정보에 해당하는 동적 프로그램이 있는지 확인한다.
                // ex : /today  --->  TodayServlet이 실행한 결과가 보여준다.
            }else {
                // 2. 동적프로그램이 아니라면
                //       path에 해당하는 파일이 있는지 찾아본다.
                //       있으면 해당 파일의 내용을 보여주고, 없으면 404 오류를 출력한다.
                DefaultServlet defaultServlet = new DefaultServlet();
                defaultServlet.service(request, response);
            }

            in.close();
            out.close();
            socket.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    } // run()
}



/*
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
*/