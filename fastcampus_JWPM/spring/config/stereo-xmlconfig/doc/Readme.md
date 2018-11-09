### 학습 순서
- ApplicationContext 설정 방법(Bean 설정 방법 2가지)
    - XML
        1. test/java/soundsystem/MyBean을 이용
        2. Exam01~03을 만들며 xml 설정 방법에 대해 익힘
        3. 새로운 프로젝트로 주사위 게임을 만들되 가장 높은 숫자가 나온 플레이어가 승자가 되도록 만든다.     
        4. 학생 관리 프로그램 만들기(doc/jpg 파일 참고, Git->miniprojec/studentmanagement 미완성, 완성시키기)
        
    - Java Config
        1. 간단한 주사위 게임 예제 (Exam05, DiceConfig, XML설정으로 되어 있던(Dice, Game, Player) 파일을 javaConfig로 변경)
        2. XML 설정 파일로 되어있는 StudentManagementSystem 을 JavaConfig로 변경한다.
        3. 이후에 StudentConfig 작성(Exam06, StudentConfig, UI, Student, Control)

    - 이 두 개를 학습하고 교재 진행
        [링크](https://github.com/urstory/fastcampus2/blob/master/config/spring01.pdf) 또는 교재 참조
        Spring Framework 란... 부터 시작, 의존성 주입 방법까지 설명
    
    - 교재 후 실습(의존성 주입 방법), book 예제(Exam07, BookConfig, BookService, book 패키지)
    
    - 실습 후 교재 진행(오토와이어링 ~ Spring JDBC)
    
    - 이후 daoexam 패키지 코드를 보면서 진행...