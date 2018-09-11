package examples.first.io;
import java.io.*;

public class IoExam03 {
    // main메소드에서 Exception을 발생해도 무시하려면 throws Exception을 붙인다.
    public static void main(String[] args) throws Exception{
        String str = "hello world!";
        byte[] buffer = str.getBytes();

        InputStream in = new ByteArrayInputStream(buffer);
        OutputStream out = new FileOutputStream("c://java//buffer.txt");

        CopyUtil.copy(in, out);

        InputStream in2 = new FileInputStream("c://java//buffer.txt");
        OutputStream out2 = new ByteArrayOutputStream();

        CopyUtil.copy(in2, out2);

        byte[] result = ((ByteArrayOutputStream) out2).toByteArray();
        String str2 = new String(result);
        System.out.println(str2);
    }
}
