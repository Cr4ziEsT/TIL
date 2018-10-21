package chapter05.enumexam;

import java.util.Calendar;

// 02. 열거 타입 변수 선언
public class EnumWeekExample {
    public static void main(String[] args) {
        Week day = Week.SUNDAY;   // 열거 상수는 단독으로 사용할 수 없다.(열거타입.열거상수 형식으로 사용)
        Week birthday = null;       // 열거 타입도 참조 타입이므로 null 값을 저장할 수 있음
        // 참조 타입 변수는 객체를 참조하는 변수
        // 열거 상수는 객체? -> Yes! 열거 상수는 열거 객체로 생성됨 ex) 열거 타입 Week는 총 7개의 Week 객체로 생성됨(월~일)
        // 메소드 영역에 생성된 열거 상수가 해당 Week 객체를 각각 참조

        // Week.SUNDAY와 열거 타입 변수 today는 서로 같은 Week 객체를 참조하게 된다.
        System.out.println(day == Week.SUNDAY);   // true

        Week today = Week.SUNDAY;   // 열거 타입 변수 선언

        Calendar cal = Calendar.getInstance();      // 날짜,시간 클래스
        int week = cal.get(Calendar.DAY_OF_WEEK);   // 일(1) ~ 토(7) 까지의 숫자를 리턴

        switch (week) {
            case 1:
                today = Week.SUNDAY;
                break;
            case 2:
                today = Week.MONDAY;
                break;
            case 3:
                today = Week.TUESDAY;
                break;
            case 4:
                today = Week.WEDNESDAY;
                break;
            case 5:
                today = Week.THURSDAY;
                break;
            case 6:
                today = Week.FRIDAY;
                break;
            case 7:
                today = Week.SATURDAY;
                break;
        } // case
        System.out.println("오늘 요일 : " + today);

        if (today == Week.SUNDAY) {
            System.out.println("일요일에는 축구를!");
        } else {
            System.out.println("그 외에는 ....");
        }
    }
}
/* 03. 열거 객체의 메소드
모든 열거 타입은 컴파일 시에 Enum 클래스를 상속하게 됨.
따라서 Enum 클래스의 필드와 메소드를 상속받는다.

리턴 타입     메소드(매개 변수)             설명
String      name()                열거 객체의 문자열을 리턴
int         ordinal()             열거 객체의 순번(0부터 시작)을 리턴
int         compareTo()           열거 객체를 비교해서 순번 차이를 리턴
열거 타입     valueOf(String name)  주어진 문자열의 열거 객체를 리턴
열거 배열     values()              모든 열거 객체들을 배열로 리
 */

