package my.examples.http;

import java.io.BufferedReader;
import java.util.HashMap;
import java.util.Map;

public class Request {
    private String method;
    private String path;
    private Map<String, String> header;

    public Request(BufferedReader in){
        String line = null;
        try {
            line = in.readLine();
            method = line.split(" ")[0];
            path = line.split(" ")[1];
            System.out.println(method);
            System.out.println(path);

            while(true){
                if(in.readLine().isEmpty()){
                    break;
                }else{
                    header = new HashMap<>();
                    line = in.readLine();
                    System.out.println(line.split(": ")[0]);
                    System.out.println(line.split(": ")[1]);
                    header.put(line.split(": ")[0], line.split(": ")[1]);
                }
            }
        }catch(Exception ex){ex.printStackTrace();}
    }
}
