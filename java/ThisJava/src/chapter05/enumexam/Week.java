package chapter05.enumexam;

/*
- 열거 타입
:한정된 값만을 갖는 데이터 타입을 의미  ex) 요일(월,화,수,목,금,토,일) or 계절(봄,여름,가을,겨울) '요일/계절'이라는 열거 타입
:열거 타입은 몇 개의 열거 상수 중에서 하나의 상수를 저장하는 데이터 타입이다.
 */

// 01. 열거 타입의 선언
public enum Week {  // 열거 타입의 선언은 열거 타입의 이름(Week)을 정하고 열거 타입 이름(Week)으로 소스 파일을(.java) 생성해야 한다.
    MONDAY,     // 열거 상수
    TUESDAY,    // 열거 타입의 값으로 사용됨
    WEDNESDAY,  // 관례적으로 열거 상수는 모두 대문자로 작성
    THURSDAY,   // 여러 단어로 구성될 경우 단어 사이를 밑줄(_)로 연결   ex) LOGIN_SUCCESS
    FRIDAY,
    SATURDAY,
    SUNDAY
}
