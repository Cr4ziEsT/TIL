package my.examples.was;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

public class DefaultServlet {
    public void service(Request request, Response response){
        // 응답하기
        String webpath = request.getPath(); // 요청한 path를 알아낸다.
        if(webpath.equals("/")){
            webpath = webpath + "index.html";   // 기본 경로(/)에 대한 응답 파일 지정
        }
        String path = "/java" + webpath;
        File file = new File(path); // 해당 경로의 파일 정보를 읽는다.

        OutputStream out = response.getOut();   // 응답에 대한 내용을 알아낸다.
        PrintWriter pw = response.getPw();

        if(file.exists()){ // 파일이 있다면 해당 파일 정보를 브라우저에 알려준다.(일단 임의로 설정)
            pw.println("HTTP/1.1 200 OK");
            pw.println("Content-Type: text/html; charset=UTF-8");
            pw.println("Content-Length: " + file.length());
            pw.println("");
            pw.flush(); // 네트워크 데이터 전송이므로 반드시...

            FileInputStream fis = null; // 해당 파일의 내용을 브라우저에 출력해준다.
            try{
                fis = new FileInputStream(file);
                byte[] buffer = new byte[1024];
                int readCount = 0;
                while((readCount = fis.read(buffer)) != -1){
                    out.write(buffer, 0, readCount);
                    out.flush(); // 네트워크 전송이므로...
                }
            }catch(Exception e){
                e.printStackTrace();
            }finally{
                try{ fis.close(); } catch(Exception e){}
            }
        }else{  // 파일이 없다면 404 정보를 브라우저에 알려준다.(일단 임의로 설정)
            pw.println("HTTP/1.1 404 NOT FOUND");
            pw.println("Content-Type: text/html; charset=UTF-8");
            pw.println("");
            pw.flush();
        }
    }
}
