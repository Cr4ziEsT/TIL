package my.examples.http;

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

        try {
            String requestLine = br.readLine();
            String[] split = requestLine.split(" ");
            if(split.length > 2){
                method = split[0];
                path = split[1];
            }

            String headerLine = null;
            while ((headerLine = br.readLine()) != null) {
                if (headerLine.equals(""))
                    break;
                int index1 = headerLine.indexOf(':');
                String headerName = null;
                String headerValue = null;
                if(index1 != -1) {
                    headerName = headerLine.substring(0, index1);
                    headerValue = headerLine.substring(index1 + 1).trim();
                }
                headers.put(headerName, headerValue);
            }
        }catch(Exception ex){
            throw new RuntimeException("잘못된 요청 : " + ex.toString());
        }
    }
}
