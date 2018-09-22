package my.examples.was;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;

// 간단하게 구현해보기(동적)
public class HTTPExam02 {
    public static void main(String[] args) throws Exception{ // 간단하게 확인을 위해 작성하여 main에 Exception 처리
                                                            // JVM으로 오류를 던지기 때문에 프로그램이 종료됨. 안 좋은 프로그래밍 방법
        ServerSocket serverSocket = new ServerSocket(8080);
        Socket socket = serverSocket.accept();

        // 요청받기
        InputStream in = socket.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        String requestLine = br.readLine();
        System.out.println(requestLine);

        String headerLine = null;
        while((headerLine = br.readLine()) != null){
            if(headerLine.equals(""))
                break;
            System.out.println("headerLine : " + headerLine);
        }

        LocalDateTime localDateTime = LocalDateTime.now();  // 계속 변화하는 시간을 이용
        String str = localDateTime.toString();

        OutputStream out = socket.getOutputStream();
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(out));
        pw.println("HTTP/1.1 200 OK");
        pw.println("Content-Type: text/html; charset=UTF-8");
        pw.println("Content-Length: " + str.length());
        pw.println("");
        pw.flush();

        pw.print(str);
        pw.flush();

        in.close();
        out.close();


        socket.close();
        serverSocket.close();
    }
}