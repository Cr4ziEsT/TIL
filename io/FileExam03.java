package examples.first.io;

import java.io.File;

// 현재 경로의 파일들의 경로를 출력하라. (단, 디렉토리의 경우 [DIR]을 표시한다.
public class FileExam03 {
    public static void main(String[] args){
        File file = new File(".");
        File[] files = file.listFiles();    // listFiles 는 배열이 리턴됨.
                                            // .listFiles 는 해당 경로에 존재하는 파일이나 폴더를 배열로 리턴해준다.
        // 현재 목록에 있는 모든 파일과 디렉토리를 출력
        for(File f : files){
            if(f.isDirectory()){    // 디렉토리인지 아닌지 확인하는 메소드
                System.out.println("[DIR]" + f.getAbsolutePath());
            }else{
                System.out.println(f.length());
                System.out.println(f.getAbsolutePath());
            }
        }
    }

    /*
    // 현재 경로의 파일들의 경로를 출력하라.(단, 디렉토리의 경우 [DIR]을 표시한다.
    public static void main(String[] args){
        // 현재 경로를 알려줌
        File file = new File(".");
        // 참조 변수의 경로에 존재하는 파일이나 폴더 이름을 배열로 저장
        File[] files = file.listFiles();

        // 현재 경로에 있는 모든 파일과 디렉토리 출력
        for(File f : files){
            if(f.isDirectory()){    // .isDirectory 메소드를 통해 참조하는 것이 폴더인지 확인
                System.out.println("[DIR]" + f.getAbsolutePath());
            }else{
                System.out.println(f.getAbsolutePath());
            }
        }
    }


    // 현재 경로의 파일들의 경로를 출력하라.(단, 디렉토리의 경우 [DIR]을 표시한다.)
    public static void main(String[] args){
        File file = new File(".");
        File[] files = file.listFiles();

        for(File f : files){
            if(f.isDirectory(){
                System.out.println("[DIR]" + f.getAbsolutePath());
            }else{
                System.out.println(f.getAbsolutePath());
            }
        }
    }

    public static void main(String[] args){
        File file = new File(".");
        file[] files = file.listFiles;

        for(File f : files){
            if(f.isDirectory){
                System.out.println("[DIR]" + f.getAbsolutePath());
            }else{
                System.out.println(f.getAbsolutePath());
            }
        }
    }

    public static void main(String[] args){
        File file = new File(".");
        File[] files = file.listFiles;

        for(File f : files){
            if(f.isDirectory){
                System.out.println("[DIR]" + f.getAbsolutePath);
            }else{
                System.out.println(f.getAbsolutePath());
            }
        }
    }
     */
}
