package examples.first.io;

import java.io.*;

// 키보드로부터 한 줄씩 입력받아서 파일에 한 줄씩 출력하시오.
// quit 라고 입력하면 프로그램은 종료됩니다.
// 1. 어디서 읽어들이지? 키보드 (System.in : 표준입력 -> InputStream)
// 2. 어디에 쓰는 거지? 파일 (FileWriter : 파일에 char 단위 출력)
// 3. 읽는 방법? 한 줄씩 입력받는다. // BufferedReader
// 4. 쓰는 방법? 한줄씩 쓴다. // PrintWriter
public class IoExam05 {
    public static void main(String[] arsg) throws Exception{
        BufferedReader br = null;   // readLine() 한 줄 읽어들이는 메소드
        PrintWriter pw = null;  // println() 메소드를 갖고 있다.
                                // null -> 어디서 읽어 들일지는 주인공이 정하는 것이기 때문에 null 값으로...
        try{
            br = new BufferedReader(new InputStreamReader(System.in));
            pw = new PrintWriter(new FileWriter("/tmp/read.txt"));
            String line = null;
            int count = 1;
            while((line = br.readLine()) != null){
                if("quit".equals(line)){
                    break; // while문을 끝낸다.
                }
                pw.println(count + " : " + line);
                count++; // count = count + 1
            }

        }catch(Exception ex){
            ex.printStackTrace();
        }finally {
            try{
                br.close();
            }catch (IOException ex){}

            pw.close();
        }
    }
}
