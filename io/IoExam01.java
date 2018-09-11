package examples.first.io;

import java.io.*;

// 1바이트씩 읽어서 1바이트씩 쓴다.
public class IoExam01 {
    public static void main(String[] args){
        InputStream in = null;
        OutputStream out = null;
        try{
            // 프로그래밍은 방어적으로 짜야한다.
            // FileInput/OutputStream은 NotFoundException이 발생할 수 있다.
            // 따라서 미리 존재하는지 검사하고 없다면 그 파일을 만들어 준다.
            File file = new File("c:\\java\\out.txt");
            if(!file.isDirectory() && file.exists()){
                in = new FileInputStream(file);
                out = new FileOutputStream("c:\\java\\txtxtttxx.txt"); // 이것 역시 낫파운드 예외가 발생 가능

                int readData = 0;
                while((readData = in.read()) != -1){
                    out.write(readData);    // -1을 만날때까지 기록한다.
                }
            }
        }catch(Exception ex){
            ex.printStackTrace();   //stack에 메서드가 호출된 기록을 남겨둠. 에러가 발생한 메소드의 호출 기록을 출력
        }finally{
            try{
                in.close();
            }catch(IOException ex){}
            try{
                out.close();
            }catch(IOException ex){}
        }
    }   //main


    /* 1 Byte 씩 읽고 1 Byte 씩 쓰기
    public static void main(String[] args){
        InputStream in = null;
        OutputStream out = null;
        try{    // 예측 가능한 오류는 최대한 발생이 되지 않도록 방어적으로 코드를 짜야한다.
            File file = new File("c:\\java\\out.txt");  // 자신이 읽어낼 파일명을 참조하도록 한다.
            if(!file.isDirectory() && file.exists()){   // 예측이 가능한 오류로써 읽을 파일이 폴더가 아니면서 해당 파일이 존재하는지 확인한다.
                in = new FileInputStream(file);         // 파일을 1Byte씩 읽어 임시 공간에 저장하고 이를 in 변수가 참조한다.
                out = new FileOutputStream("c:\\java\\txtout.txt"); // 해당 파일을 출력하고 이를 out 변수가 참조한다.

                int readData = 0;   // InputStream/OutputStream은 int type을 리턴한다. 하지만 이 둘은 1Byte 씩 읽고 쓴다.
                                    // 만약 1Byte 씩 읽고 쓴다면 파일의 끝(End of File)을 표현할 방법이 없다.
                                    // 그래서 4Byte의 공간 맨 마지막 1Byte 공간에 값을 넣고 나머지 부분은 0으로 채운다.
                                    // 이렇게 하면 EoF를 제외하면 모두 양수값을 가지게 된다.(음수는 최상위 bit가 1로 표시됨)
                                    // 따라서 EoF를 만나면 -1을 리턴하도록 하여 EoF를 표현할 수 있게 된다.
                while((readData = in.read()) != -1){    // in 변수가 참조하고 있는 파일을 EoF까지 1Byte 씩 읽는다.
                    out.write(readData);                // out 변수가 참조하고 있는 파일에 값을 출력한다.
                }
            }
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


    // 파일 데이터 복사 ( 1Byte 씩 읽고 쓰기)
    public static void main(String[] args){
        InputStream in = null;
        OutputStream out = null;
        try{
            File file = new File("c:\\java\\out.txt");
            if(!file.isDirectory() && file.exists()){
                in = new FileInputStream(file);
                out = new FileOutputStream("c:\\java\\outtxt.txt");

                readData = 0;
                for((readData = in.read()) != -1){
                    out.write(readData);
                }
            }
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
        OutputStream out = null;
        try{
                File file = new File("c:\\java\\out.txt");
                if(!file.isDirectory() && file.exists()){
                    in = FileInputStream(file);
                    out = FileOutputStream("c:\\java\\outtxt.txt");

                    readData = 0;
                    for((readData = in.read()) != -1){
                        out.write(readData);
                    }
                }
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
     */
}
