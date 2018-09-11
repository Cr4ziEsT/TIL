package examples.first.io;

import java.io.File;

public class FileExam04 {
    public static void main(String[] args){
        String fileName = File.separator + "java" + File.separator + "a" + File.separator + "b";
        File file = new File(fileName);
        if(!file.exists()){ // 맨 앞에 !가 붙으면 역이 된다. 따라서 해당 파일이 존재하지 않다면으로 조건이 바뀐다.
            file.mkdirs();  // 하위에 하위까지 모두 디렉토리를 생성해준다.
        }
    }
    /*
    // 존재하지 않는 디렉토리를 원하는 위치에 새로 생성하기
    public static void main(String[] args){
    // 생성할 위치를 지정해준다.
        File file = new File("c:\\java\\d\\c\\b\\a");
    // 해당 폴더가 존재하지 않는다면 새로 생성해준다.
        if(!file.exists()){
            file.mkdirs();
        }
    }

    // 존재하지 않는 디렉토리를 원하는 위치에 새로 생성하기
    public static void main(String[] args){
        File file = new File("c:\\java\\a\\b");
        if(!file.exists){
            file.mkdirs();
        }
    }

    public static void main(String[] args){
        String fileName = File.separator + "java" + File.separator + "a" + File.separator + "c";
        File file = new File(fileName);
        if(!file.exists){
            file.mkdirs
        }
    }

    public static void main(String[] args){
        File file = new File("c:\\java\\c\\b");
        if(!file.exists){
            file.mkdirs
        }
    }
     */
}
