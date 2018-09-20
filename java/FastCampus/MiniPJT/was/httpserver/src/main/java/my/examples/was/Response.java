package my.examples.was;

import java.io.OutputStream;
import java.io.PrintWriter;

public class Response {
    private OutputStream out;
    private PrintWriter pw;
    private String contentType;
    private long contentLength;
    private int statusCode;
    private String statusMessage;

    public PrintWriter getPw() {
        return pw;
    }

    public String getContentType() {
        return contentType;
    }

    public long getContentLength() {
        return contentLength;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public OutputStream getOut() {
        return out;
    }

    public void setContentLength(long contentLength) {
        this.contentLength = contentLength;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    public Response(OutputStream out, PrintWriter pw){
        this.out = out;
        this.pw = pw;
    }
}
