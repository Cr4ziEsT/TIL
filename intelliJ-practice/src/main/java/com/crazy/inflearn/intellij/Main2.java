package com.crazy.inflearn.intellij;

public class Main2 {
    public static void main(String[] args) {
        System.out.println("bbb");
        // 만약 다른 포커스의 실행환경에서 이전에 실행했던 클래스를 재실행하고 싶을때
        // Shift + F10
        // 이런 과거의 실행했던 정보를 저장하고 있는 것은 우측 상단의 start configuration 에서 설정 할 수 있으며, 자바 말고도 다른 것도 추가할 수 있다.
        Main main = new Main();
    }
}

/*
실행환경 실행 정리
1. 현재 포커스
Ctrl + Shift + F10
2. 이전 실행
Shift + F10
 */
