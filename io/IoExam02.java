package examples.first.io;

import java.io.*;

import static java.lang.System.out;

public class IoExam02 {
    // []로 읽고 []로 쓴다.
    public static void main(String[] args){
        InputStream in = null;
        OutputStream out = null;
        try{
            File file = new File("c:\\java\\out.txt");
            if(!file.isDirectory() && file.exists()){
                in = new FileInputStream(file);
                out = new FileOutputStream("c:\\java\\txtout.txt"); // 이것 역시 낫파운드 예외가 발생 가능
                byte[] buffer = new byte[1024];
                int readCount = 0;
                // 예를들어 파일의 크기가 3000이라면 3번 읽어 들인다.
                while((readCount = in.read(buffer)) != -1){
                    out.write(buffer, 0, readCount);
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

    /* []로 읽고 []로 쓴다.
    public static void main(String[] args){
        InputStream in = null;
        OutputStream out = null;
        try{
            File file = new File("c:\\java\\out.txt");

            if(!file.isDirectory() && file.exists()){
                in = new FileInputStream(file);
                out = new FileOutputStream("c:\\java\\outtxt.txt");

                byte[] buffer = new byte[1024]; // 디스크에서는 대부분 1024byte 씩 읽기 때문에 보편적으로 배열의 크기를 1024로 선언한다.
                int readCount = 0;
                for((readCount = in.read(buffer)) != -1){
                    out.write(buffer, 0, readCount);    // 1024 만큼 읽으라고 하였지만 1024만큼 못 읽을 수 있다.
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
                in = new FileInputStream(file);
                out = new FileOutputStream("c:\\java\\outtxt.txt");

                byte[] buffer = new byte[1024];
                int readCount = 0;
                for((readCount = in.read(buffer)) != -1){
                    out.write(buffer, 0, readCount);
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
