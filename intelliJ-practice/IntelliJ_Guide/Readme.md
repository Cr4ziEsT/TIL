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
  - ``Ctrl + Shift + A`` > ``plugins`` > ``browse repo...`` > ``presentation assistent``  설치



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
  - ``Ctrl + Shift + J``

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



### 검색 - 텍스트

1. 현재 파일에서 검색
   Ctrl + F
2. 현재 파일에서 교체
   Ctrl + R(위의 창은 찾고자 하는 단어, 아래는 바꾸고자 하는 단어)
   Replace 버튼 = 한번에 하나만, Replace All 버튼 = 한번에 모두
3. 전체 파일에서 검색
   Ctrl + Shift + F
4. 전체 파일에서 교체
   Ctrl + Shift + R
5. 정규표현식으로 검색, 교체(HTML 파일에서 자주 쓰임)
   Ctrl + Shift + F 에서 Regex 체크
   Ctrl + Shfit + R 에서 교체



### 검색 - 기타

1. 파일 검색
   Ctrl + Shift + N
   클래스명 외에 패키지명을 같이 적어줄 수 있다.
2. 메소드 검색
   Ctrl + Shift + Alt + N
3. Action 검색 (별표)
   Ctrl + Shift + A
   모든 이벤트와 옵션들을 검색할 수 있다.
4. 최근 열었던 파일 목록 보기
   Ctrl + E
5. 최근 수정한 파일 목록 보기
   Ctrl + Shift + E



### 자동완성

1. 스마트 자동 완성
   ~~Ctrl + Space = 그냥 자동완성(모든 경우의 수를 다 보여줌)~~
   Ctrl + Shift + Space 를 사용하자
   메소드 내의 인자값을 넣을때도 사용할 수 있다.

2. 스태틱 메소드 자동 완성
   Ctrl + Space + Space

3. getter/setter/생성자 자동 완성
   Alt + Insert

4. overriide 메소드 자동 완성

   Ctrl + I



### Live Template

1. Live Template 소개
   psvm, sout ... 지정된 코드를 자동으로 만들어주는 기능
   ifn = if문 자동 완성
2. Live Template 목록 보기
   Ctrl + J
3. Live Template 추가하기(보통 ORM에서 많이 씀 ent)
   1. Ctrl + Shift + A 를 눌러 Live Template 검색
   2. other 에서 우측의 ``+`` 버튼을 누른다.
   3. 어디서 쓸 수 있을지 선택해준다. Define



### 리펙토링 - Extract(추출하기)

1. 변수 추출하기(Extract Variable 이라고 함)
   Ctrl + Alt + V
   동일한 변수에 대해서 하나의 변수로 뽑을 수 있다.
2. 파라미터 추출하기
   Ctrl + Alt + P
3. 메소드 추출하기
   Ctrl + Alt + M
4. 이너클래스 추출하기
   클래스를 밖으로 뽑을 수 있다.
   F6
   이너클래스를 공용의 클래스로 사용해야 될 경우 사용하기에 편리하다.

