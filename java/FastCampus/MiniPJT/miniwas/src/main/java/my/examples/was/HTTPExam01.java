package my.examples.was;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

// 동작 원리를 간단하게 구현해보기(정적)
public class HTTPExam01 {
    public static void main(String[] args) {
        //        1) 접속
        //        2) 요청 (요청라인, 헤더, 빈줄, 바디)
        // 브라우저 ------------------> 서버
        //        <------------------
        //        3) 응답 (응답라인, 헤더, 빈줄, 바디)
        //        4) 연결 close

        ServerSocket serverSocket = null;
        InputStream in = null;
        OutputStream out = null;
        FileInputStream fis = null;
        try {
            // 1) 접속을 위한 서버 소캣 생성
            serverSocket = new ServerSocket(8080);
            Socket socket = serverSocket.accept();  // 블러킹 메소드를 통해서 연결을 대기
            // 2) 연결 요청
            in = socket.getInputStream();   // socket은 InputStream과 OutputStream을 제공해준다.
            BufferedReader br = new BufferedReader(new InputStreamReader(in));  // 스트림형식의 문자열을 한 줄씩 읽기 위함.(readLine 메소드)
            // 요청 라인을 참조할 변수 선언
            String requestLine = br.readLine(); // 한 줄의 내용을 requestLine이 참조
            System.out.println(requestLine); // 제대로 참조하는지 확인
            // 헤더 라인을 참조할 변수 선언
            String headerLine = null;
            while ((headerLine = br.readLine()) != null) {
                if (headerLine.equals("")) break;
                System.out.println("headerLine : " + headerLine); // 제대로 참조하는지 확인
            }
            // 3) 응답
            File file = new File("/java/index.html"); // 임의로 파일을 지정

            out = socket.getOutputStream();
            PrintWriter pw = new PrintWriter(new OutputStreamWriter(out)); // 스트림 형식의 문자열을 한 줄씩 쓰기 위함.(println 메소드)
            pw.println("HTTP/1.1 200 OK");
            pw.println("Content-Type: text/html; charset=UTF-8");
            pw.println("Content-Length: " + file.length()); // 응답 메세지에 표시 될 내용을 임의로 지정
            pw.println(""); // 헤더 마지막의 공백을 의미
            pw.flush(); // 네트워크로의 출력을 위해서는 마지막에 flush()를 사용해주어야 한다.

            fis = new FileInputStream(file); // 지정한 파일을 출력하기
            byte[] buffer = new byte[1024]; // 파일의 기본 단위 = byte, fis의 read 메소드는 byte[] 단위에서 읽어 출력함.
            int readCount = 0; // 1024개의 공간 중에서 사용하지 않은 공간은 읽지 않게 하기 위함
            while ((readCount = fis.read(buffer)) != -1) { // -1 은 null 값을 나타냄,
                out.write(buffer, 0, readCount); // buffer 공간을 0부터 readCount까지 출력
                out.flush(); // 역시 네트워크로 출력하므로 마지막에 flush()를 사용!
            }
        } catch (Exception ex) {

        } finally {
            // 연결 close, finally 부분에서 확실하게 닫아주자
            try {
                in.close();
            } catch (Exception e) {
            }
            try {
                out.close();
            } catch (Exception e) {
            }
            try {
                fis.close();
            } catch (Exception e) {
            }
            try {
                serverSocket.close();
            } catch (Exception e) {
            }
        }
    }
}
