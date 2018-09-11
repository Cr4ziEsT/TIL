package examples.first.io;

import java.io.File;

public class FileExam02 {
    public static void main(String[] args){
        File file = new File("."); // .은 현재 경로를 말함(여기서는 자바 버츄얼머신이 실행하고 있는 경로를 말함)
        System.out.println(file.getAbsolutePath()); // 절대경로 출력(.getAbsolutePath)
                                                    // 절대경로는 /로 시작하거나 드라이브 명으로 시작
    /*
    public static void main(String[] args){
        // 현재 경로를 file이 참조하도록 함
        File file = new File(".");
        // file의 절대 경로를 출력
        System.out.println(file.getAbsolutePath());
    }

    public static void main(String[] args){
        File file = new File(".");
        System.out.println(file.getAbsolutePath());
    }

    public static void main(String[] args){
        File file = new File(".");
        System.out.println(file.getAbsolutePath());
    }

    public static void main(String[] args){
        File file = new File(".");
        System.out.println(file.getAbsolutePath());
    }

    public static void main(String[] args){
        File file = new File(".");
        System.out.println(file.getAbsolutePath());
    }
    */

    }
}
