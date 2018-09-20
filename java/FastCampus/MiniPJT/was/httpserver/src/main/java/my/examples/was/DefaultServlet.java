package my.examples.was;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

public class DefaultServlet {
    public DefaultServlet(Request request, Response response) {
        String webpath = request.getPath();
        if (webpath.equals("/")) {
            webpath = webpath + "index.html";
        }
        String path = "C:\\tmp\\www" + webpath;
        File file = new File(path);

        OutputStream out = response.getOut();
        PrintWriter pw = response.getPw();

        if(file.exists()){
            pw.println("HTTP/1.1 200 OK");
            pw.println("Content-Type: text/html; charset=UTF-8");
            pw.println("Content-Length: " + file.length());
            pw.println("");
            pw.flush();

            FileInputStream fis = null;
            try{
                fis = new FileInputStream(file);
                byte[] buffer = new byte[1024];
                int readCount = 0;
                while((readCount = fis.read(buffer)) != -1){
                    out.write(buffer, 0, readCount);
                    out.flush();
                }
            }catch(Exception e){
                e.printStackTrace();
            } finally {
                try{ fis.close(); }catch(Exception e){}
            }
        }else{
            pw.println("HTTP/1.1 404 NOT FOUND");
            pw.println("Content-Type: text/html; charset=UTF-8");
            pw.println("");
            pw.flush();
        }
    }
}
