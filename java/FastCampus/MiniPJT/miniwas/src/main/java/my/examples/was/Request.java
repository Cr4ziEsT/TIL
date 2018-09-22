package my.examples.was;

import java.io.BufferedReader;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class Request {
    private InputStream in;
    private BufferedReader br;
    private String method;
    private String path;
    private Map<String, String> headers;

    public String getMethod() {
        return method;
    }

    public String getPath() {
        return path;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public Request(InputStream in, BufferedReader br){
        this.in = in;
        this.br = br;
        headers = new HashMap<>();

        try{
            // 요청 라인에서 method와 path 분류하기
            String requestLine = br.readLine();
            String[] sprit = requestLine.split(" ");
            if(sprit.length > 2){ // (method path version) 형식이므로 2 이상이여야 정상적인 요청
                method = sprit[0];
                path = sprit[1];
            }
            // header의 이름과 값을 분류
            String headerLine = null;
            while((headerLine = br.readLine()) != null){
                if(headerLine.equals(""))   break;  // header의 마지막 라인은 공백이므로...
                int index = headerLine.indexOf(':');
                String headerName = null;   // if문이 실행되지 않을 경우 반환할 값을 지정해주어야 함
                String headerValue = null;
                if(index != -1) { // indexOf는 찾는 값이 없으면 -1을 반환함
                    headerName = headerLine.substring(0, index);
                    headerValue = headerLine.substring(index + 1).trim(); // trim 명령어를 통해 공백을 제거
                }
                headers.put(headerName, headerValue);   // map에 저장해준다
            }
        }catch (Exception e){
            throw new RuntimeException("잘못된 요청 : " + e.toString());
        }
    }
}
