package my.examples.wepapp;

import my.examples.was.Request;

public class RequestTest {
    public static void main(String[] args){
        // pom에서 의존성 추가를 하였기 때문에 다른 프로젝트의 클래스도 사용할 수 있게 됨.
        Request request = new Request(null, null);
    }
}
