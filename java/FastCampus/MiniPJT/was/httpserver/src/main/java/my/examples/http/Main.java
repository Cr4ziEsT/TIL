package my.examples.http;

public class Main {
    public static void main(String[] args){
        MiniWAS miniWAS = new MiniWAS();
        miniWAS.start();
        System.out.println("서버가 실행되었습니다.");
    }
}
