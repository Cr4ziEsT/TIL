# IntelliJ 가이드 내용 정리

>  해당 내용은 Inflean의 창천향로님이 강의하신 [IntelliJ를 시작하시는 분들을 위한 IntelliJ 가이드](https://www.inflearn.com/course/intellij-guide/)를 참고하여 작성하였습니다.
>
>  - [창천향로님의 GitHub](github.com/jojoldu)
>  - [창천향로님의 Blog](https://jojoldu.tistory.com/)



## ToolBox 추천

- Toolbox 를 통해서 JetBrains IDE 제품들의 IDE 여러 설정들을 간단하게 할 수 있음



## 프로젝트 생성

- Create New Project
- Java Application 개발 시 Java를 선택하기 보다는 Maven or Gradle 와 같은 빌드 환경을 선택하자
- 프로젝트 생성
  - GroupId : 프로젝트 그룹
  - ArtifactId : 그룹의 하위 모듈

- Mac OS와 Windows & Linux 는 서로 단축키가 다름
  - 개발 시 사용한 단축키를 MaxOS와 Windows & Linux 에서는 어떻게 쓰이는지 보여주는 플러그인 설치
  - ``Ctrl + Shift + A`` > ``plugins`` > ``browse repositories`` > ``presentation assistent``  설치



---

## 코드 Edit

### 메인메소드 생성 및 실행

- 내가 현재 위치에서 생성할 수 있는 디렉토리, 패키지, 클래스 등의 모든 목록 보기
  - Project(``Ctrl + 1``)의 폴더나 파일 우클릭 후 New 를 통해서 보기 -> 마우스를 사용하는 것은 생산성에 좋지 않다
  - ``Alt + Insert (Mac : Command + N)``

- Code Templete 맛보기
  - 축약어, 자주 사용하는 메소드를 미리 정의해 놓음
    - ``psvm`` : public static void main(String[] args) 생성 
    - ``sout`` : System.out.println() 생성

- 실행환경 설정(Run)
  - 현재 포커스 실행 : ``Shift + Ctrl + F10 (Mac : Ctrl + Shift + R)``
  - 이전 실행 : ``Shift + F10 (Mac : Ctrl + R)`` 



### 라인 수정하기

- 라인 복사하기 
  - ``Ctrl + D (Mac : Command + D)``

- 라인 삭제하기 
  - ``Ctrl + Y (Mac : Command + Delete(백스페이스))``

- 라인 합치기
  - 여러 줄에 걸쳐 만들어진 코드를 하나의 줄로 합치기
  - 문자열을 합치는 단위는 라인 단위
  - ``Ctrl + Shift + J (Mac : Command + Shift + J)``

- 라인 단위 옮기기 
  - 구문에 관계없이 이동 : ``Shift + Alt + Up/Down (Mac : Command(Option) + Shift + Alt + Up/Down)``
  - 구문 안에서만 이동 : ``Ctrl + Shift + Up/Down (Mac : Command + Shift + Up/Down)``

- 엘리먼트(Element) 단위로 옮기기
  - ``Ctrl + Shift + Alt + Right/Left (Mac : Command + Shift + Alt + Right/Left)``



### 코드 즉시보기

- 인자값 즉시 보기
  - ``Ctrl + P (Mac : Command + P)``

- 코드 구현부 즉시 보기
  - ``Ctrl + Shift + I (Mac : Alt + Space / Command + Y)``
    - 클래스에 사용 시 : 클래스의 전체 코드가 보여짐
    - 메소드에 사용 시 : 해당 메소드의 코드가 보여짐
    - 유료 버전에서는 자바 뿐만 아니라 HTML -> js, css 등을 호출 시 호출하는 다른 정적 파일도 미리보기가 가능함

- Doc 즉시 보기
  - ``Ctrl + Q``
    - 포커스에 있는 내용의 javadoc을 보여줌
    - 마찬가지로 유료버전에서는 HTML에서도 사용할 수 있음(이때는 MDN의 내용이 보여짐)



## 포커스

### 포커스 - 에디터

- 단어별 이동
  - ``Ctrl + Right/Left (Mac : Alt + Right/Left)`` 

- 단어별 선택
  - ``Ctrl + Shift + Right/Left (Mac : Alt + Shift + Right/Left)``

- 라인 첫/끝 이동
  - ``Home/End (Mac : fn + Right/Left)``

- 라인 전체 선택
  - ``Shift + Home/End (Mac : fn + Shift + Right/Left)``

- Page UP/DOWN
  - ``PageUp/PageDown (Mac : fn + Up/Down)``



### 포커스 - 특수키

- 포커스 범위 한 단계씩 늘리기
  - 늘리기 : ``Ctrl + W  (Mac : Alt + Up)``
  - 줄이기 : ``Ctrl + Shift + W (Mac : Alt + Down)``

- 포커스 뒤로/앞으로 가기
  - ``Ctrl + Alt + Rigth/Left (Mac : Alt + ]/[ )``

- 멀티 포커스
  - ``Ctrl + Ctrl + Up/Down (Mac : Alt + Alt + Up/Down)``

- 오류 라인으로 자동 포커스
  - ``F2  (Mac : F2)``



## 검색

### 검색 - 텍스트

- 현재 파일에서 검색
  - ``Ctrl + F (Mac : Command + F)``

- 현재 파일에서 교체
  - ``Ctrl + R (Mac : Command + R)``
  - 위의 창은 찾고자 하는 단어, 아래는 바꾸고자 하는 단어
  - Replace 버튼 = 한번에 하나만, Replace All 버튼 = 한번에 모두

- 프로젝트 전체에서 검색
  ``Ctrl + Shift + F (Mac : Command + Shift + R) ``

- 프로젝트 전체에서 교체
  ``Ctrl + Shift + R (Mac : Command + Shift + R)``

- 정규표현식으로 검색, 교체(HTML 파일에서 자주 쓰임)
  - Ctrl + Shift + F 에서 ``Regex `` 체크
  - Ctrl + Shfit + R 에서 교체
  - [참고 블로그(창천향로님 블로그)](https://jojoldu.tistory.com/160)



### 검색 - 기타

- 파일 검색
  - ``Ctrl + Shift + N (Mac : Command + Shift + O)``
  - 클래스명 외에 패키지명을 같이 적어줄 수 있다.
  - ex) sp2라는 패키지 안에 있는 Member.java 파일을 찾고 싶다면 검색창에 ``sp2/Member`` 입력

- 메소드 검색
  - ``Ctrl + Shift + Alt + N (Mac : Command + Alt + O)``

- Action 검색 ``중요``
  - ``Ctrl + Shift + A (Mac : Command + Shift + A)``
  - 인텔리제이의 모든 이벤트와 옵션들을 검색할 수 있다.

- 최근 열었던 파일 목록 보기
  - ``Ctrl + E (Mac : Command + E)``

- 최근 수정한 파일 목록 보기
  - ``Ctrl + Shift + E (Mac : Command + Shift + E)``



## 자동완성

### 자동완성

- 스마트 자동 완성

  - ~~일반적인 자동 완성 : ``Ctrl + Space (Mac : Ctrl + Space)~~``
  - ``Ctrl + Shift + Space (Mac : Ctrl + Shift + Space)``

  - 메소드에 인자값을 넣을때도 사용할 수 있다.

- 스태틱 메소드 자동 완성
  - ``Ctrl + Space + Space (Mac : Ctrl + Space + Space)``

- Getter / Setter / 생성자 자동 완성
  - ``Alt + Insert (Mac : Command + N)``

- Overriide 메소드 자동 완성
  - ``Ctrl + I (Mac : Ctrl + I)``



### Live Template

- Live Template 소개
  - ``psvm``, ``sout``, ``ifn`` 등 지정된 코드를 자동으로 만들어주는 기능

- Live Template 목록 보기
  - ``Ctrl + J (Mac : Command + J)``

- Live Template 추가하기(보통 ORM에서 많이 씀 ent)
  - ``Ctrl + Shift + A`` 를 눌러 ``Live Template`` 검색

  - other 에서 우측의 ``+`` 버튼을 누른다.
  - Abbreviation : 축약어 입력, Description : 설명, Template Text : 적용할 코드 입력
  - ``Define`` : 어디서 쓸 수 있을지 선택해준다. Java에서만 사용하므로 Java 선택



## 리펙토링

### 리펙토링 - Extract(추출하기)

- 변수 추출하기(Extract Variable 이라고 함)
  - ``Ctrl + Alt + V (Mac : Command + Option + V)``
  - 동일한 변수에 대해서 하나의 변수로 뽑을 수 있다.

- 파라미터 추출하기
  - ``Ctrl + Alt + P (Mac : Command + Option + P)``

- 메소드 추출하기
  - ``Ctrl + Alt + M (Mac : Command + Option + M)``

- 이너클래스 추출하기, 이동하기
  - 해당 이너 클래스명에 포커스를 두고 ``F6``
  - 이너클래스를 공용의 클래스로 사용해야 될 경우 사용하기에 편리하다.



### 리펙토링 기타

- 동일한 이름 일괄 변경하기
  - 변경하고자 하는 이름에 포커스를 두고 ``Shift + F6 (Mac : Shift + F6)``
- 타입 일괄 변경하기
  - ``Ctrl + Shift + F6 (Mac : Command + Shift + F6)``
- Import 정리하기
  - 파일 하나에서 직접 정리 : ``Ctrl + Alt + O (Mac : Ctrl + Option + O)``
  - 파일을 열 때 자동으로 정리 : ``Ctrl + Alt + A`` -> ``optimize import on`` 검색 -> ``Auto Import 부분을 ON으로 변경``
- 코드 자동 정렬하기
  - ``Ctrl + Alt + L (Mac : Command + Option + L)``



## 디버깅

### 디버깅

디버깅을 할 때에는 Line Number 가 보여야 편하므로 보이지 않는다면 우클릭 후 Show Line Number 선택

Break Point 설정 : 해당 라인 클릭 or 포커스 라인에서 ``Ctrl + F8``

- Debug 모드로 실행하기 - 즉시 실행
  - ``Windows/Linux 단축키 없음 (Mac : Ctrl + Shift + D)``
- Debug 모드로 실행하기 - 이전 실행
  - ``Shift + F9 (Mac : Ctrl + D)``
  - 상단 우측에 남아있는 이전에 실행했던 메소드 실행

- Resume
  - ``F9 (Mac : Command + Option + R)``
  - 다음 브레이크 포인트로 넘어가기
  - 좌측은 Call Stack 이라고 하며, 현재 브레이크 포인트까지 오기까지 어떤 메소드를 통해서 왔는지 알 수 있다.
- Step Over
  - `` F8 (Mac : F8)``
  - 현재 브레이크 포인트에서 다음 한 줄 실행
- Step Into
  - ``F7 (Mac : F7)``
  - 현재 브레이크 포인트의 다음 실행할 메소드 안으로 들어감
- Step Out
  - ``Shift + F8 (Mac : Shift + F8)``
  - Step Into를 통해 포커스가 특정 메소드 안으로 들어왔을 때 다시 밖으로 나감
- Condition
  - ``브레이크 포인트에서 우클릭, ConditionalBreak에 브레이크를 걸 조건 입력 후 Done.``(조건은 자바코드를 짜듯이 짜면 된다.)
  - 반복문에서 특정 조건을 가졌을 때만 브레이크 하도록 설정 가능
  - 브레이크 코드에서 쓸 수 있는 모든 코드를 사용할 수 있음
- Evaluate Expression
  - ``Alt + F8 (Mac : Option + F8)``
  - 라이브러리 분석에 도움이 됨
  - 현재 브레이크 걸려있는 상태에서 코드를 실행, 연산까지 가능
  - 켤 때마다 초기화 됨
- Watch
  - 단축키는 없음(안경모양의 버튼)
  - 브레이크 된 시점부터 다음 브레이크까지 값이 변하는 것을 실시간으로 볼 수 있음
  - 브레이크 이후의 코드 변경 확인



## Git & Github

### Git 기본 기능 사용하기

- Git View On

  - View -> Tool Windows -> Version Control

  - ``Alt + 9 (Mac : Command + 9)``
    - Local Changes : 변경이 필요하거나 변경한 파일의 확인이 필요한 경우 사용(Show Diff (단축키 : ``Ctrl + D``)를 통해서 변경 사항을 확인하고 그 안에서도 변경할 수 있음 / Revert = 변경 사항 취소)
    - Log : 커밋 로그 확인, 우클릭 시 커밋에 관련된 여러 기능을 사용할 수 있음
    - Console 

- Git Option Popup

  - ``Alt + Back Quote(`) (Mac : Ctrl + V)``

- Git History

  - ``Git Option Popup -> 4. Show History``

- Branch

  - ``Git Option Popup -> 7. Branches``

- Commit

  - ``Git Option Popup -> 1. Commit`` or ``Ctrl + K (Mac : Command + K)``

- Push

  - `Ctrl + Shift +K (Mac : Command + Shift + K)` 
  - 파일이 새로 생성된 경우에는 커밋&푸시를 지원하지 않으므로 push는 별도로 진행해야 함

- Pull

  - ``단축키가 없음``
  - Action 검색(``Ctrl + Shift + A``)을 통해 ``git pull`` 검색 후 ``Pull`` 클릭



### Github 연동하기

- 기존 프로젝트 Github에 연동하기
  - Action 검색(``Ctrl + Shift + A``) -> ``share github`` 입력 후 ``Share Project on Github`` 선택
  - Login
  - New repository name, Remote name(origin), Description 입력 후 Share 클릭
  - Commit Message 입력

- Github 프로젝트 Clone 받기
  - 메인 화면에서 ``Check out from Version Control`` -> ``Git`` 선택
  - URL 입력 or 로그인 시 자신의 프로젝트 목록에서 선택할 수 있음



## 플러그인

### 플러그인

- 플러그인 설치
  - Action 검색(``Ctrl + Shift + A``) -> ``plugins`` 검색 ``Preferences plugins`` 선택
  - ``Browse repositories`` 선택
  - ``sort by Downloads`` : 어느 정도 검증된 플러그인 확인 가능(다운로드 순으로 정렬)
- 추천 플러그인
  - ``.ignore``
  - ``presentation assistent`` : 프로젝트 생성 부분에서 소개
  - ``BashSupport`` : shell file 작성을 도와줌
    - 터미널 사용 : ``Alt + F12 (Mac : Option + F12)``
    - 터미널에서 작성된 .sh 파일 실행 가능
  - ``Material Theme UI``
  - 번역 플러그인 : jojoldu 검색 후 설치 (``단축키 : Alt 1, 2, 3 (Mac : Option + 1, 2, 3)``)
    - ``Alt + 1`` : 영어를 한글로 번역
    - ``Alt + 2`` : 한글을 영어로 변역
    - ``Alt + 3`` : 긴 문장을 번역

