package my.examples.was;

import java.io.BufferedReader;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

// 요청에 대한 일처리
public class Request {
    private BufferedReader br;
    private String mathod;
    private String path;
    private Map<String, String> headers;

    public String getMathod() {
        return mathod;
    }

    public String getPath() {
        return path;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public Request(BufferedReader br) {
        this.br = br;
        headers = new HashMap<>();

        try {
            // 요청 라인 분류
            String requestLine = br.readLine();
            String[] split = requestLine.split(" " );
            if(split.length > 2){
                mathod = split[0];
                path = split[1];
            }
            // 헤더 정보 분류
            String headerLine = null;
            while((headerLine = br.readLine()) != null){
                if(headerLine.equals(""))   break;

                int index = headerLine.indexOf(':');
                String headerName = null;
                String headerValue = null;
                if(index != -1) {
                    headerName = headerLine.substring(0, index);
                    headerValue = headerLine.substring(index + 1).trim();
                }
                headers.put(headerName, headerValue);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
