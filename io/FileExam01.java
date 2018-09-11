package examples.first.io;

import java.io.File;

public class FileExam01 {
    public static void main(String[] args) {
        // 윈도우에서는 c:\\tmp\파일명 : \\ 되야 파일명
        // 유닉스 계열은(Linux, Mac) /tmp/파일명 : / 가 알려줌
        // 운영체제와 상관없는 경로명을 지정하는 방법(File.separator)
        // (현재 프로그램이 실행되는 폴더를 기준으로 상대경로를 지정할 수도 있다.)
        String fileName = File.separator + "java" + File.separator + "out.txt";
        // fileName에 해당하는 파일이나 폴더가 있을 수도 있고, 없을 수도 있다. 따라서 있는지 없는지 확인해야 한다.
        File file = new File(fileName);     // File 클래스는 파일의 정보를 읽어오는 것

        // 파일이 존재한다면(.exists)
        if (file.exists()) {
            System.out.println(fileName + "이 있어요.");
        }

    /* 해당 이름을 가진 파일(경로명은 2가지 방법)이 있는지 검색하기
    // 01. 운영체제와 상관없는 경로명을 지정
    // 02. 절대경로로 지정
    // 존재한다면 출력..

    public static void main(String[] args){
        String fileName = "c:" + File.separator + "java" + File.separator + "out.txt";
        // 원하는 이름을 가진 파일이 존재하는지 확인해야함
        File file01 = new File(fileName);
        File file02 = new File("c:\\java\\out.txt");

        // 파일이 존재한다면 출력
        if(file01.exists()){
            System.out.println(fileName + "01 이 존재합니다.");
        }
        if(file02.exists()){
            System.out.println(file02.getPath() + "02 이 존재합니다.");
        }
    }


    public static void main(String[] args){
        String fileName = File.separator + "java" + File.separator + "out.txt";
        File file = new File(fileName);
        if(file.exists()){
            System.out.println(fileName +이 있어요.");
        }
    }

    public static void main(String[] args){
        String fileName = File.separator + "java" + File.separator + "out.txt";
        File file = new File(fileName);
        if(file.exists){
            System.out.println(fileName + "이 있어요.");
        }
    }

    public static void main(String[] args){
        String fileName = File.separator + "java" + File.separator + "out.txt";
        File file = new File(fileName);
        if(file.exists){
            System.out.println(fileName + "이 있어요.");
        }
    }

    public static void main(String[] args){
        String fileName = File.separator + "java" + File.separator + "out.txt";
        File file = new File(fileName);
        if(file.exists()){
            System.out.println(fileName + "이 있어요.");
        }
    }
     */
    }
}