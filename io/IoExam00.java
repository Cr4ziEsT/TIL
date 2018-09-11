package examples.first.io;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

// IO 코드의 기본 틀, 이것을 먼저 작성하고 코드를 만든다.
public class IoExam00 {
    public static void main(String[] args){
        InputStream in = null;     // -> 무엇을 입력할지는 정하지 않았기 때문에 null 값을 넣는다.
        OutputStream out = null;   // -> 무엇을 출력할지는 정하지 않았기 때문에 null 값을 넣는다.
        try{                        // IO 코드 작성 시 파일이 존재하지 않을 수 있어 Exception 오류가 발생할 수 있으므로
            // Code
        }catch(Exception ex){       // 이를 try-catch로 묶어 처리해준다.
            ex.printStackTrace();   //stack에 메서드가 호출된 기록을 남겨둠. 에러가 발생한 메소드의 호출 기록을 출력(...?)
        }finally{   // try-catch를 사용하면 오류가 발생될 시 프로그램을 종료하게 되는데
                    // finally 명령어는 종료되기 전에 마지막으로 해당 블럭에 있는 코드를 실행시킨다.
                    // 항상 사용한 시스템 자료를 반납하고 입출력 스트림을 닫아야 하므로 close 메소드를 사용해준다.
            try{
                in.close();
            }catch(IOException ex){}    // 이 때 IOException이 발생할 수 있으므로 try-catch로 묶어줘야 한다.
            try{
                out.close();
            }catch(IOException ex){}    // 마찬가지
        }
    }// main

    /*
    public static void main(String[] args){
        InputStream in = null;
        OutputStream out = null;
        try{

        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            try{
                in.close();
            }catch(IOException ex){}
            try{
                out.close();
            }catch(IOExcption ex){}
        }
    }//main

    public static void main(String[] args){
        InputStream in = null;
        InputStream in = null;
        try{

        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            try{
                in.close();
            }catch(IOException ex){}
            try{
                out.close();
            }catch(IOException ex){}
        }
    }
     */
}
