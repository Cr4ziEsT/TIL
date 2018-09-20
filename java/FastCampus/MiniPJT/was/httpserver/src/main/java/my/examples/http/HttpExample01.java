package my.examples.http;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

// 간단하게 만들어보기
public class HttpExample01 {
    public static void main(String[] args) {
        // server 만들기
        try {
            ServerSocket serverSocket = new ServerSocket(8080);
            Socket socket = serverSocket.accept();
            System.out.println("서버가 실행되었습니다.");

            // 요청
            InputStream in = socket.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            // 요청 라인 출력
            String requestLine = br.readLine();
            System.out.println(requestLine);
            // 헤더 라인 출력
            String headerLine = null;
            while((headerLine = br.readLine()) != null){
                if(headerLine.equals("")){
                    break;
                }
                System.out.println("headerLine : " + headerLine);
            }

            // 응답
            File file = new File("c:\\java\\index.html");

            OutputStream out = socket.getOutputStream();
            PrintWriter pw = new PrintWriter(new OutputStreamWriter(out));

            pw.println("HTTP/1.1 200 OK");
            pw.println("Content-Type: text/html; charset=UTF-8");
            pw.println("Content-Length: " + file.length());
            pw.println("");
            pw.flush();

            FileInputStream fis = new FileInputStream(file);
            byte[] buffer = new byte[1024];
            int readCount = 0;
            while((readCount = fis.read(buffer)) != -1){
                out.write(buffer, 0, readCount);
                out.flush();
            }
            fis.close();
            in.close();
            out.close();
            socket.close();
        }catch(Exception e) {
            e.printStackTrace();
        }
    }
}
