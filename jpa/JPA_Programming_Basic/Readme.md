# JPA 프로그래밍 기초

> 해당 내용은 김영한님이 강의하신 [JPA 프로그래밍 기초](https://tacademy.skplanet.com/live/player/onlineLectureDetail.action?seq=149)를 보고 작성하였습니다.



## 1강 JPA 소개

### 왜 JPA를 써야하는가?

- SQL 중심적인 개발의 문제점
  - 무한 반복, 지루한 코드
  - 엔티티 신뢰 문제
  - SQL에 **의존적**인 개발
- 계층형 아키텍처에 맞는 진정한 의미의 계층 분할이 어려움
- 패러다임의 불일치
  - 객체 vs 관계형 DB
    1. 상속
       - 객체는 상속 관계
       - Table은 슈퍼타입과 서브타입 관계
    2. 연관관계
       - 객체는 참조를 사용 : member.getTeam();
       - 테이블은 외래키를 사용 : JOIN ON M.TEAM_ID = T.TEAM_ID
       - 객체는 방향성이 있다.
       - 테이블은 방향성이 없다.
    3. 데이터 타입
    4. 데이터 식별 방법
- 객체는 자유롭게 객체 그래프를 탐색할 수 있어야 한다.
- 객체답게 모델링 할수록 매핑 작업이 늘어남
- 객체를 자바 컬렉션에 저장하듯이 DB에 저장할 수는 없을까?

### JPA?

- Java Persistence API
- 자바 진영의 ORM 기술 표준

### ORM?

- Object-relational mapping(객체 관계 매핑)
- 객체는 객체대로 설계
- 관계형 데이터베이스는 관계형 데이터베이스대로 설계
- ORM 프레임워크가 중간에서 매핑
- 대중적인 언어에는 대부분 ORM 기술이 존재

### JPA!

- JPA는 애플리케이션과 JDBC 사이에서 동작
- JPA 동작
  - 저장
    - Entity 분석
    - INSERT SQL 생성
    - JDBC API 사용
    - 패러다임 불일치 해결!!
  - 조회
    - SELECT SQL 생성
    - JDBC API 사용
    - ResultSet 매핑
    - 패러다임 불일치 해결!!
- JPA는 표준 명세
  - JPA는 인터페이스의 모음
  - JPA 2.1 표준 명세를 구현한 3가지 구현체
  - 하이버네이트, EclipseLink, DataNuclus
- JPA 사용의 이점
  - SQL 중심적인 개발에서 객체 중심으로 개발
  - 생산성
  - 유지보수
  - 패러다임의 불일치 해결
  - 성능
  - 데이터 접근 추상화와 벤더 독립성
  - 표준

### ORM은 객체와 RDB 두 기둥위에 있는 기술

- JPA는 결국 하나의 방법일 뿐이다. 해당 JPA를 보고 머리 속에 바로 SQL이 나올 수 있도록 SQL에 대한 기본적인 연습이 충분히 필요하다.



## 2강 JPA 기초와 매핑

### 객체 매핑하기

- Entity : JPA가 관리할 객체

  - 엔티티라고 함
- @Id : DB PK와 매핑할 필드

- ```java
  @Entity
  public class Member {
      @Id
      private Long id;
      private String name;
  }
  // 위와 동일
  create table Member (
      id bigint not null,
      name varchar(255),
      primary key (id)
  )
  ```

### persistence.xml

- JPA 설정 파일
- /META-INF/persistence.xml 에 위치해야 함

### 데이터베이스 방언

- JPA는 특정 데이터베이스에 종속적이지 않은 기술
- 각각의 DB가 제공하는 SQL 문법과 함수는 조금씩 다르다.
  - 가변 문자 : MySQL은 VARCHAR, Oracle은 VARCHAR2
  - 문자열을 자르는 함수 : SQL 표준은 SUBSTRING(), Oracle은 SUBSTR()
  - 페이징 : MySQL은 LIMIT, Oracle은 ROWNUM
- 방언 : SQL 표준을 지키지 않거나 특정 데이터베이스만의 고유한 기능

- hibernate.dialect 속성에 지정
- 하이버네이트는 45가지 방언을 지원해준다.

### 애플리케이션 개발

- 엔티티 매니저 팩토리 설정
- 엔티티 매니저 설정
- 트랜잭션
- 비지니스 로직(CRUD)

### 엔티티 매니저 설정

1. Persistence가 META-INF/persistence.xml에 있는 설정 정보를 조회한다.
2. EntityManagerFactory를 생성한다.
3. EntityManagerFactory가 EntityManager를 생성한다.

### 주의

- 엔티티 매니저 팩토리는 하나만 생성해서 애플리케이션 전체에서 공유
- 엔티티 매니저는 쓰레드간에 공유하면 안된다.(사용하고 버려야한다.)
- JPA의 모든 데이터 변경은 트랜잭션 안에서 실행
- but 스프링부트와 결합하면 위와 같은 주의점들을 스프링부트가 자동으로 해결...

### 실습

[Link]()

## 3강 필드와 컬럼 매핑

### 데이터베이스 스키마 자동 생성하기

- DDL을 애플리케이션 실행 시점에 자동 생성
- 테이블 중심 -> 객체 중심
- 데이터베이스 방언을 활용해서 데이터베이스에 맞는 적절한 DDL 생성
- 이렇게 **생성된 DDL은 개발 장비에서만 사용**
- 생성된 DDL은 운영서버에서는 사용하지 않거나, 적절히 다듬은 후 사용
- hibernate.hbm2ddl.auto
  - **create** : 기존 테이블 삭제 후 다시 생성 (DROP + CREATE)
  - **create-drop** : create와 같으나 종료시점에 테이블을 DROP
  - **update** : 변경분만 반영(운영 DB에는 사용하면 안됨)
  - **validate** : 엔티티와 테이블이 정상 매핑되었는지만 확인
  - **none** : 사용하지 않음

### 스키마 자동 생성의 주의점

- **운영 장비에는 절대 create, create-drop, update 사용하면 안됨!!**
- 개발 초기 단계에는 create 또는 update
- 테스트 서버는 update 또는 validate
- 스테이징과 운영 서버는 validate 또는 none

### 매핑 어노테이션

- @Column

  - 가장 많이 사용됨
  - **name : 필드와 매핑할 테이블의 컬럼 이름**(가장 많이 사용됨)
  - insertable, updatable: 읽기 전용
  - nullable : null 허용 여부 결정, DDL 생성시 사용
  - nuique : 유니크 제약 조건, DDL 생성시 사용
  - columnDefinition, length, precision, scale (DDL)

- @Temporal

  - 날짜 타입 매핑

  - ```java
    @Temporal(TemporalType.DATE)
    private Date date;	// 날짜
    
    @Temporal(TemporalType.TIME)
    private Date time;	// 시간
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date timestamp;	// 날짜와 시간
    ```

- @Enumerated

  - 열거형 매핑

  - EnumType.ORDINAL : 순서를 저장(기본값), DB가 꼬일 수 있으므로 사용하지 말자

  - **EnumType.STRING : 열거형 이름을 그대로 저장, 가급적 이것을 사용하자!!**

  - ```java
    @Enumerated(EnumType.STRING)
    private RoleType reolType;
    ```

- @Lob

  - CLOB, BLOB 매핑
  - 글의 본문처럼 길이가 긴 문자열을 받을 때 사용
  - CLOB : String, char[], java.sql.CLOB
  - BLOB : byte[], java.sql.BLOB

- @Transient

  - 이 필드는 매핑하지 않는다.
  - 애플리케이션에서 DB에 저장하지 않는 필드
  - 웬만하면 사용하지 말자



## 3강 식별자 매핑

### 식별자 매핑 어노테이션

- @Id
- @GeneratedValue

### 식별자 매핑 방법

- @Id(직접 매핑)
- @GeneratedValue
  - **IDENTITY** : 데이터베이스에 위임, MYSQL을 사용할 때 주로 사용
  - **SEQUENCE** :  데이터베이스 시퀀스 오브젝트 사용, ORACLE을 사용할 때 주로 사용
    - @SequenceGenerator 필요
  - **TABLE** : 키 생성용 테이블 사용, 모든 DB에서 사용
    - @TableGenerator 필요
  - **AUTO** : 방언에 따라 자동 지정, 기본값

### 권장하는 식별자 전략

- 기본 키 제약 조건 : null 이 되면 안됨, 유일해야 함, **변하면 안된다.**
- 미래까지 이 조건을 만족하는 자연키는 찾기 어렵다. 대체키를 사용하자!!
- **권장 : Long + 대체키 + 키 생성 전략 사용**

### 실습

[Link]()



## 4강, 5강 연관관계 매핑

> '객체지향 설계의 목표는 자율적인 객체들의 **협력 공동체**를 만드는 것이다.'
>
> **​											- 조영호(객체지향의 사실과 오해)**

### 객체를 테이블에 맞추어 모델링

- 객체를 테이블에 맞추어 데이터 중심으로 모델링하면, 협력 관계를 만들 수 없다.
- **테이블은 외래키로 조인**을 해서 연관된 테이블을 찾는다.
- **객체는 참조**를 사용해서 연관된 객체를 찾는다.
- 테이블과 객체 사이에는 이런 큰 간격이 있다.

```java
// 참조 대신에 외래키를 그대로 사용
@Entity
public class Member {
    @Id @GeneratedValue
    private Long id;
    
    @Column(name = "USERNAME")
    private String name;
    private int age;
    
    @Column(name = "TEMA_ID")
    private Long teamId;		// 외래키를 그대로 사용
}
@Entity
public class Team {
    @Id @GeneratedValue
    private Long id;
    private String name;
}

// 외래키 식별자를 직접 다룸
public class Main(){
    public static void main(String[] args){
        ...
		// 팀 저장
		Team team = new Team();
		team.setName("TeamA");
		em.persist(team);

		// 회원 저장
		Member member = new Member();
		member.setName("member1");
		member.setTeamId(team.getId());
		em.persist(member);
        
        /* 식별자로 다시 조회, 객체 지향적인 방법은 아님 */
        // 조회
        Member findMember = em.find(Member.class, member.getId());
        // 연관관계가 없음
        Team findTeam = em.find(Team.class, team.getId());
    }
}
```

### 연관관계 매핑 이론 - 단방향 매핑

- Member 객체를 이용해서 Team 객체를 찾을수는 있지만, Team 객체를 이용해서 Member 객체를 찾을수는 없다.

```java
// 객체의 참조와 테이블의 외래키를 매핑
@Entity
public class Member {
    @Id @GeneratedValue
    private Long id;
    
    @Column(name = "USERNAME")
    private String name;
    private int age;
    
//    @Column(name = "TEMA_ID")
//    private Long teamId;		// 외래키를 그대로 사용
    
    @ManyToOne
    @JoinColumn(name = "TEAM_ID")	// 외래키를 매핑
    private Team team;				// 객체를 참조
}
@Entity
public class Team {
    @Id @GeneratedValue
    private Long id;
    private String name;
}

// 연관관계 저장
public class Main(){
    public static void main(String[] args){
        ...
		// 팀 저장
		Team team = new Team();
		team.setName("TeamA");
		em.persist(team);
		// 회원 저장
		Member member = new Member();
		member.setName("member1");
		member.setTeam(team);	// 단방향 연관관계 설정, 참조 저장
		em.persist(member);
        
        /* 참조로 연관관계 조회 - 객체 그래프 탐색 */
        // 조회
        Member findMember = em.find(Member.class, member.getId());
        // 참조를 사용해서 연관관계 조회
        Team findTeam = findMember.getTeam();
        
        /* 연관관계 수정*/
        // 새로운 팀B
        Team teamB = new Team();
        teamB.setName("TeamB");
        em.persist(teamB);
        // 회원1에 새로운 팀B 설정
        member.setTeam(teamB);
    }
}
```

### 연관관계 매핑 이론 - 양방향 매핑

- Member 객체와 Team 객체를 이용해서 서로를 찾을 수 있다.

```java
// Member 엔티티는 단방향과 동일
@Entity
public class Member {
    @Id @GeneratedValue
    private Long id;
    
    @Column(name = "USERNAME")
    private String name;
    private int age;
    
    @ManyToOne
    @JoinColumn(name = "TEAM_ID")	// 외래키를 매핑
    private Team team;				// 객체를 참조
}

// Team 엔티티는 컬렉션을 추가
@Entity
public class Team {
    @Id @GeneratedValue
    private Long id;
    
    private String name;
    
    @OneToMany(mappedBy = "team")
    List<Member> members = new ArrayList<Member>();
}

// 반대 방향으로 객체 그래프 탐색
public class Main(){
    public static void main(String[] args){
        ...
		// 팀 저장
		Team team = new Team();
		team.setName("TeamA");
		em.persist(team);
		// 회원 저장
		Member member = new Member();
		member.setName("member1");
		member.setTeam(team);	// 단방향 연관관계 설정, 참조 저장
		em.persist(member);
        
        /* 참조로 연관관계 조회 - 객체 그래프 탐색 */
        // 조회
        Team team = em.find(Team.class, team.getId());
        // 역방향 조회
        int member Size = findTeam.getMembers().size();
        
        /* 연관관계 수정*/
        // 새로운 팀B
        Team teamB = new Team();
        teamB.setName("TeamB");
        em.persist(teamB);
        // 회원1에 새로운 팀B 설정
        member.setTeam(teamB);
    }
}
```

### 연관관계의 주인과 mappedBy

- mappedBy = JPA의 멘붕 클래스 1
- mappedBy는 처음에는 이해하기 어렵다.
- **객체와 테이블간에 연관관계를 맺는 차이를 이해해야 한다.**

### 객체와 테이블이 관계를 맺는 차이

- 객체 연관관계(2개)
  - 회원 -> 팀 연관관계 1개(단방향)
  - 팀 -> 회원 연관관계 1개(단방향)
- 테이블 연관관계(1개)
  - 회원 <-> 팀의 연관관계 1개(양방향)

### 객체의 양방향 관계

- 객체의 **양방향 관계는 사실 양방향 관계가 아니라 서로 다른 단방향 관계 2개를 억지로 만든 것이다.**

- 따라서 객체를 양방향으로 참조하려면 단방향 연관관계를 2개 만들어야 한다.

- A -> B (a.getB());

- B -> A (b.getA());

- ```java
  //exme
  class A {
      B b;
  }
  class B {
      A a;
  }
  ```

### 테이블의 양방향 연관관계

- 테이블은 **외래키 하나**로 두 테이블의 연관관계를 관리한다.

- MEMBER.TEAM_ID 외래키 하나로 양방향 연관관계를 가진다.(양쪽으로 조인할 수 있다.)

- ```sql
  SELECT * 
  MEMBER M 
  JOIN TEAM T ON M.TEAM_ID = T.TEAM_ID
  
  SELECT * 
  FROM TEAM T
  JOIN MEMBER M ON T.TEAM_ID = M.TEAM_ID
  ```

### 객체는 둘 중 하나가 외래키를 관리해야 한다.

### 연관관계의 주인(Owner)

**양방향 매핑 규칙**

- 객체의 두 관계 중 하나를 연관관계의 주인으로 지정
- **연관관계의 주인만이 외래키를 관리(등록, 수정, 삭제)**
- **주인이 아닌 쪽은 조회(읽기)만 가능**
- 주인은 mappedBy 속성을 사용하지 않는다!
- 주인이 아니면 mappedBy 속성으로 <u>주인을 지정</u>해준다!

### 누구를 주인으로?

- 사용할 테이블에서 **외래키가 있는 곳**을 주인으로 정하자!!
- 객체지향 설계에서 순환참조는 안 좋다...양방향은 안좋아...그러므로 웬만하면 단방향으로 만들자
- 설계 전부 단방향으로 매핑해서 만들고 개발 도중 양방향이 필요하게 될 경우에 사용하는 것이 좋다

### 양방향 매핑시 가장 많이 하는 실수

```java
// 연관관계의 주인에 값을 입력하지 않음
public class Main(){
    public static void main(String[] args){
		
		Team team = new Team();
		team.setName("TeamA");
		em.persist(team);
	
		Member member = new Member();
		member.setName("member1");
		
        // 역방향(주인이 아닌 방향)만 연관관계 설정
        team.getMembers().add(member);
        
		em.persist(member);
    }
}
// MEMBER TABLE의 TEAM_ID 값이 NULL 로 들어가게 됨(역방향으로 연관관계를 설정했기 때문에)
```

### 양방향 매핑시 연관관계의 주인에 값을 입력해야 한다.

```java
public class Main(){
    public static void main(String[] args){
		
		Team team = new Team();
		team.setName("TeamA");
		em.persist(team);
	
		Member member = new Member();
		member.setName("member1");
		
        // *연관관계의 주인에 값을 설정* (TEAM_ID 에 값이 정상적으로 들어가게 됨)
        member.setTeam(team);	
        
        // 순수한 객체 관계를 고려하면 항상 양쪽 다 값을 입력해야 한다.
        team.getMembers().add(member);
        
		em.persist(member);
    }
}
```

### 양방향 매핑의 장점

- **단방향 매핑만으로도 이미 연관관계 매핑은 완료된 것이다.**
- 양방향 매핑은 반대 방향으로 조회(객체 그래프 탐색) 기능이 추가된 것 뿐이다.
- JPQL에서 역방향으로 탐색할 일이 많다
- 단방향 매핑을 잘 하고 양방향은 필요할 때 추가해도 된다. 테이블에 전혀 영향을 주지 않음!!



## 다양한 매핑 어노테이션 소개

### 연관관계 매핑 어노테이션

- 다대일 (@ManyToOne)
- 일대다 (@OneToMany)
- 일대일 (@OneToOne)
- 다대다 (@ManyToMany)
  - 잘 쓰이지 않는다. 웬만하면 일대다 다대일 매핑을 통해 설정해주자!
- @JoinColumn, @JoinTable

### 상속 관계 매핑 어노테이션

- @Inheritance
- @DiscriminatorColumn
- @DiscriminatorValue
- @MappedSuperclass(매핑 속성만 사용)
- 책을 참고하여 학습하자! 지금은 기초시간~

### 복합키 어노테이션

- @IdClass
- @EmbeddedId
- @Embeddable
- @MapsId



## 6강 JPA 내부구조

### JPA에서 가장 중요한 2가지

- 객체와 관계형 데이터베이스 매핑하기(Object Rlational Mapping)
  - 1강 ~ 5강
- **영속성 컨텍스트**

### 엔티티 매니저 팩토리와 엔티티 매니저

- 엔티티 매니저 팩토리에서 유저의 요청이 올 때마다 쓰레드가 별도로 생성되어야 하고 엔티티 매니저가 생성되어야 한다. 생성된 엔티티 매니저는 내부적으로 데이터베이스 커넥션풀에서 DB를 사용하게 된다.

### 영속성 컨텍스트

- JPA를 이해하는데 가장 중요한 용어
- '엔티티를 영구 저장하는 환경'이라는 뜻
- EntityManager.persist(entity);

### 엔티티 매니저?? 영속성 컨텍스트??

- 영속성 컨텍스트는 논리적인 개념
- 엔티티 매니저를 통해서 영속성 컨텍스트에 접근

- **"엔티티 매니저가 생성되면 영속성 컨텍스트가 내부에 있구나! 캐쉬같은 놈이구나!"** 라고 이해하고 넘어가자

### 엔티티의 생명주기

- **비영속 (new/transient)**

  - 영속성 컨텍스트와 전혀 관계가 없는 상태

  - ```java
    // 객체를 생성한 상태 (비영속)
    Member member = new Member();
    member.setId("member1");
    member.setUsername("회원1");
    ```

- **영속 (managed)**

  - 영속성 컨텍스트에 저장된 상태, 영속성 컨텍스트가 관리하는 상태

  - ```java
    // 객체를 생성한 상태 (비영속)
    Member member = new Member();
    member.setId("member1");
    member.setUsername("회원1");
    
    EntityManager em = emf.createEntityManager();
    em.getTransaction().begin();	// 트랜잭션 시작
    
    // 객체를 저장한 상태 (영속)
    em.persist(member);		
    ```

- **준영속 (detached)**

  - 영속성 컨텍스트에 저장되었다가 분리된 상태

  - ```java
    // 회원 엔티티를 영속성 컨텍스트에서 분리, 준영속 상태
    em.detach(member);
    ```

- **삭제 (remove)**

  - 삭제된 상태

  - ```java
    em.remove(member);
    ```

### 왜 중간에 영속성 컨텍스트가 존재하는 걸까? 무슨 이점이 있을까?

- 내부에 1차 캐시가 존재(트랜잭션이 시작하고 끝날때 까지만 유지한다.)
- 동일성(identity) 보장
- 트랜잭션을 지원하는 쓰기 지연(transactional write-behind)
- 변경 감지(Dirty Checking)
- 지연 로딩(Lazy Loading)

### 1차 캐시

```java
// 하나의 트랜잭션
// 엔티티를 생성한 상태 (비영속)
Member member = new Member();
member.setId("member1");
member.setUsername("회원1");

// 엔티티를 영속(1차 캐시에 저장)
em.persist(member);

// 이미 1차 캐시에 해당 객체가 존재하므로 1차 캐시에서 조회하여 DB에 쿼리문을 보내지 않는다.
Member findMember = em.find(Member.class, "member1");
// 해당 객체는 1차캐시에 존재하지 않으므로 DB에 쿼리문을 보내어 조회한다.
Member findMember2 = em.find(Member.class, "member2");
```

1. find("member2")를 entityManager 내부에 존재하는 **1차 캐시**에 member2가 존재하는지 찾는다.
2. 1차 캐시에 없는 것을 확인하고 DB를 조회한다.
3. DB에서 조회되어 나온 결과를 **1차 캐시에 저장**한다.
4. 결과를 반환한다.

### 영속 엔티티의 동일성 보장

```java
Member a = em.find(Member.class, "member1");
Member b = em.find(Member.class, "member2");

System.out.println(a == b); // 동일성 비교 : True
```

- 1차 캐시로 반복 가능한 읽기(Repeatable Read) 등급의 트랜잭션 격리 수준을 데이터베이스가 아닌 애플리케이션 차원에서 제공해준다.

### 엔티티 등록(트랜잭션을 지원하는 쓰기 지연)

```java
EntityManager em = emf. createEntityManager();
EntityTransaction transaction = em.getTransaction();
// 엔티티 매니저는 데이터 변경시 트랜잭션을 시작해야 한다.
transaction.begin();	// [트랜잭션] 시작

em.persist(memberA);
em.persist(memberB);
// 여기까지 INSERT SQL을 DB에 보내지 않는다.

// 커밋하는 순간 DB에 INSERT SQL을 보낸다.
transaction.commit();	// [트랜잭션] 커밋
```

![사진1](https://github.com/Kim-JunHyeong/TIL/blob/develop/jpa/JPA_Programming_Basic/image/01.png)

![사진2](https://github.com/Kim-JunHyeong/TIL/blob/develop/jpa/JPA_Programming_Basic/image/02.png)

### 엔티티 수정(변경 감지)

```java
EntityManager em = emf.createEntityManager();
EntityTransaction transaction = em.getTransaction();
transaction.begin();	// [트랜잭션] 시작

// 영속 엔티티 조회
Member memberA = em.find(Member.class, "memberA");

// 영속 엔티티 데이터 수정
member.setUsername("hi");
memberA.setAge(10);

// em.update(member) 이런 코드가 있어야 하지 않을까????(없어도 된다)

transaction.commit(); // [트랜잭션] 커밋
```

- **변경 감지(Dirty Checking)**

![사진3](https://github.com/Kim-JunHyeong/TIL/blob/develop/jpa/JPA_Programming_Basic/image/03.png)

### 엔티티 삭제

```java
// 삭제 대상 엔티티 조회
Member memberA = em.find(Member.class, "memberA");

em.remove(memberA); // 엔티티 삭제
```

### 플러시

- 영속성 컨텍스트의 변경 내용을 데이터베이스에 반영

### 플러시 발생

- 변경 감지
- 수정된 엔티티 쓰기 지연 SQL 저장소에 등록
- 쓰기 지연 SQL 저장소의 쿼리를 데이터베이스에 전송(등록, 수정, 삭제 쿼리)

### 영속성 컨텍스트를 플러시하는 방법

- `em.flush()` - 직접 호출
- `트랜잭션 커밋` - 플러시 자동 호출
- `JPQL 쿼리 실행` - 플러시 자동 호출

### JPQL 쿼리 실행시 플러시가 자동으로 호출되는 이유

```java
em.persist(memberA);
em.persist(memberB);
em.persist(memberC);
// 아직 DB에는 반영이 안되고 영속성 컨텍스트에 쌓여만 있음

// 중간에 JPQL 실행
// DB를 조회하면 해당 데이터가 존재하지 않기 때문에 이 경우에는 영속성 컨텍스트에 쌓인 쿼리문을 DB에 먼저 flush를 해준 뒤에 해당 쿼리가 작동하게 된다.
query = em.createQuery("select m from Member m", Member.class);
List<Member> members = query.getResultList();
```

- **주의!! -** 다른 라이브러리와 같이 쓸 경우에는 `flush()`를 직접 실행해주어야 한다.

### 플러시 모드 옵션

- `em.setFlushMode(FlushModeType.COMMIT)`
  - `FlushModeType.AUTO)` : 커밋이나 쿼리를 실행할 때 플러시(기본값)
  - `FlushModeType.COMMIT` : 커밋할 때만 플러시

### 플러시는!!

- 영속성 컨텍스트를 비우지 않음
- 영속성 컨텍스트의 변경 내용을 데이터베이스에 동기화 하는 작업
- 트랜잭션이라는 작업 단위가 중요!! -> 커밋 직전에만 동기화하면 된다.

### 준영속 상태

- 영속 -> 준영속
- 영속 상태의 엔티티가 영속성 컨텍스트에서 분리(detached)
- 영속성 컨텍스트가 제공하는 기능을 사용하지 못함

### 준영속 상태로 만드는 방법

- `em.detach(entity)` : 특정 엔티티만 준영속 상태로 전환
- `em.clear()` : 영속성 컨텍스트를 완전히 초기화
- `em.close()` : 영속성 컨텍스트를 종료



## 프록시와 즉시로딩, 지연로딩

### Member를 조회할 때 Team도 함께 조회해야 할까?

- 단순히 member 정보만 사용하는 비지니스 로직
- `println(member.getName());`

### 지연 로딩(LAZY)을 사용해서 프록시로 조회

```java
@Entity
public class Member {
	@Id
	@GeneratedValue
	private Long id;

    @Column(name = "USERNAME")
	private String name;
	
    @ManyToOne( fetch = FetchType.LAZY ) // ** 단순히 Member만 사용하는 경우 굳이 Team을 미리 조회할 필요가 없다. 이럴경우 LAZY를 사용한다.
	@JoinColumn(name = "TEAM_ID")
	private Team team;
}

// 지연 로딩(LAZY)을 사용해서 프록시(가짜 객체)로 조회(이때는 DB에서 Member만 조회한다.)
Member member = em.find(Member.class, 1L);

Team team = member.getTeam();
team.getName();	// 실제 team을 사용하는 시점에 Team을 조회(이때 DB를 조회)
```

### Member와 Team을 자주 함께 사용한다면?

### 즉시 로딩(EAGER)을 사용해서 함께 조회

```java
@Entity
public class Member {
	@Id
	@GeneratedValue
	private Long id;
	
    @Column(name = "USERNAME")
	private String name;
	
    @ManyToOne( fetch = FetchType.EAGER ) // ** Member 조회시 항상 Team도 같이 조회
	@JoinColumn(name = "TEAM_ID")
	private Team team;
}
```

- **실제 현업에서는 즉시로딩(EAGER)을 사용하지 않고 전부 지연로딩(LAZY)을 사용하며 조회할 때 fetch join을 사용하여 한 번에 조회한다.**

### 프록시와 즉시로딩 주의

- **가급적 지연 로딩을 사용**
- 즉시 로딩을 적용하면 예상치 못한 SQL이 발생
- 즉시 로딩은 JPQL에서 1+N 문제를 일으킨다.
- **@ManyToOne, @OneToOne은 기본이 즉시로딩(EAGER) -> LAZY로 설정**
- @OneToMany, @ManyToMany는 기본이 지연로딩(LAZY)
- <u>하지만 지연로딩을 사용하려면 entity가 영속성 컨텍스트에 등록되어 있어야 한다.(영속상태여야 한다.)</u>
- 현업에서는 스프링 프레임워크에서 트랜잭션이 끝날 시점에 컨트롤러에서 lazy 로딩을 하려고 할 때 lazy로딩이 없어지게 되는데 이 때 lazy exception이 발생할 수 있다.(그럼 영속상태로 만들어주는 것으로 문제를 해결한다.)



## 7강 JPA 객체지향쿼리

## JPA는 다양한 쿼리 방법을 지원

- **JPQL**
- JPA Criteria
- **QueryDSL**
- 네이티브 SQL
- JDBC API 직접 사용, MyBatis, SpringJdbcTemplate 함께 사용

### JPQL 소개

- 가장 단순한 조회 방법
  - `EntityManager.find()`
  - 객체 그래프 탐색(`a.getB().getC()`)
- 나이가 18살 이상인 회원을 모두 검색하고 싶다면?? 

### JPQL

- JPA를 사용하면 엔티티 객체를 중심으로 개발

- 문제는 검색 쿼리

- 검색을 할 때도 테이블이 아닌 엔티티 <u>객체를 대상</u>으로 검색

- 모든 DB 데이터를 객체로 변환해서 검색하는 것은 불가능

- 애플리케이션이 필요한 데이터만 DB에서 불러오려면 결국 검색 조건이 포함된 SQL이 필요

- <u>JPA는 SQL을 추상화한 JPQL이라는 객체 지향 쿼리 언어 제공</u>

- SQL과 문법 유사, SELECT, FROM, WHERE, GROUP BY, HAVING, JOIN 지원

- **JPQL은 엔티티 객체를 대상으로 쿼리**

- **SQL은 데이터베이스 테이블을 대상으로 쿼리**

- ```java
  // 검색
  String jpql = "select m From Member m where m.name like "'%hello%'";
      
  List<Member> result = em.createQuery(jpql, Member.class).getResultList();
  ```

- 테이블이 아닌 객체를 대상으로 검색하는 객체 지향 쿼리

- SQL을 추상화해서 특정 데이터베이스 SQL에 의존X

- JPQL을 한 마디로 정의하면 **객체 지향 SQL**

### JPQL과 실행된 SQL

```java
// 검색
String jpql = "select m from Member m where m.age > 18";

List<Member> result = em.createQuery(jpql, Member.class).getResultList();

// 실행된 SQL
	select
		m.id as id,
		m.age as age,
		m.USERNAME as USERNAME,
		m.TEAM_ID as TEAM_ID,
	from
		Member m
	where
		m.age>18
```

### JPQL 문법

```sql
select_문 :: = 
	select_절
	from_절
	[where_절]
	[groupby_절]
	[having_절]
	[orderby_절]
	
update_문 :: = update_절 [where_절]
delete_문 :: = delete_절 [where_절]
```

- 엔티티와 속성은 대소문자 구분(Member, username)
- JPQL 키워드는 대소문자 구분 안함(SELECT, FROM, where)
- **엔티티 이름을 사용, 테이블 이름이 아님(Member)**
- **별칭은 필수!!**

### 결과 조회 API

- `query.getResultList()` : 결과가 하나 이상, 리스트 반환
- `query.getSingleResult()` : 결과가 정확히 하나, 단일 객체 반환(정확히 하나가 아니면 예외 발생)

### 파라미터 바인팅 - 이름 기준, 위치 기준

- `SELECT m FROM Member m WHERE m.username=:username query.setParameter("username", usernameParam);` 
  - 이런건 웬만하면 이름을 쓰자...
- `SELECT m FROM Member m WHERE m.username=?1 query.setParameter(1, usernameParam);`

### 프로젝션(select절에 자신이 보고 싶은 것을 적는 것)

- `SELECT m FROM Member m` : 엔티티 프로젝션
- `SELECT m.team FROM Member m` : 엔티티 프로젝션
- `SELECT m.username, m.age FROM Member m` : 단순 값 프로젝션
- `new` 명령어: *단순 값을 DTO로 바로 조회*
  `SELECT new jpabook.jpql.UserDTO(m.username, m.age) FROM Member m`
- DISTINCT는 중복 제거

### 페이징 API

- JPA는 페이징을 다음 두 API로 추상화
- `setFirstResult(int startPosition)` : 조회 시작 위치(0부터 시작)

- `setMaxResults(int maxResult)` : 조회할 데이터 수

```java
// 페이징 쿼리 예시
String jpql = "select m from Member m order by m.name desc";
List<Member> resultList = em.createQuery(jpql, Member.class)
    .setFirstResult(10)
    .setMaxResults(20)
    .getResultList();
// 모든 데이터베이스에 대한 방언이 들어가게 된다.
```

### 집합과 정렬

- GROUP BY, HAVING
- ORDER BY

### 조인

- 내부 조인 : `SELECT m FROM Member m [INNER] JOIN m.team t`
- 외부 조인 : `SELECT m FROM Member m LEFT [OUTER] JOIN m.team t`
- 세타 조인 : `SELECT count(m) from Member m, Team t WHERE m.username = t.name`
- **참고 : 하이버네이트 5.1부터 세타 조인도 외부 조인 가능**

### 페치 조인

- 현업에서 많이 사용함

- 엔티티 객체 그래프를 한 번에 조회하는 방법
- 별칭을 사용할 수 없다.
- JPQL : `SELECT m FROM Member m join fetch m.team` -> 멤버를 조회할 때 팀도 한 번에 가져옴
- SQL : `SELECT M.*, T.* FROM MEMBER T INNER JOIN TEAM T ON M.TEAM_ID=T.ID`

```java
// 페치 조인 예시
String jpql = "SELECT m FROM Member m join fetch m.team";

List<Member> members = em.createQuery(jpql, Member.class).getResultList();

for (Member member : members) {
    // 페치 조인으로 회원과 팀을 함께 조회해서 지연로딩(LAZY) 발생 안함
    System.out.println("username = " + member.getUsername() + ", " +
					   "teamname = " + member.getTeam().name());
}
```

### JPQL 기타

- 서브 쿼리 지원
- EXISTS, IN
- BETWEEN, LIKE, IS NULL

### JPQL 기본 함수

- CONCAT
- SUBSTRING
- TRIM
- LOWER, UPPER
- LENGTH
- LOCATE
- ABS, SQRT, MOD
- SIZE, INDEX(JPA 용도)

### CASE 식

- 기본 CASE 식

  - ```SQL
    select
    	case when m.age <= 10 then '학생요금'
    		when m.age >= 60 then '경로요금'
    		else '일반요금'
    	end
    from Member m
    ```

- 단순 CASE 식

  - ```SQL
    select
    	case t.name
    		when '팀A' then '인센티브110%'
    		when '팀B' then '인센티브120%'
    		else '인센티브105%'
    	end
    from Team t
    ```

- COALESCE : 하나씩 조회해서 NULL이 아니면 반환

  - ```SQL
    select coalesce(m.username,'이름 없는 회원') from Member m
    ```

- NULLIF : 두 값이 같으면 NULL 반환, 다르면 첫 번째 값 반환

  - ```SQL
    select NULLIF(m.username, '관리자') from Member m
    ```

### 사용자 정의 함수 호출

- 하이버네이트는 사용 전 방언에 추가해야 한다.
  - `select function('group_concat', i.name) from Item i`

### Named 쿼리 - 정적 쿼리

- 미리 정의해서 이름을 부여해두고 사용하는 JPQL
- 어노테이션, XML에 정의
- 애플리케이션 로딩 시점에 초기화 후 재사용
- 애플리케이션 로딩 시점에 쿼리를 검증

### Named 쿼리 - 어노테이션

- 쿼리에 문제가 있을 경우 스프링을 띄울 때 문법 오류를 잡아준다.
- @Query도 가능하다.

```java
@Entity
@NamedQuery(
	name = "Member.findByUsername",
	query="select m from Member m where m.username = :username"
)
public class Member {
	...
}

List<Member> resultList =
	em.createNamedQuery("Member.findByUsername", Member.class)
		.setParameter("username", "회원1")
		.getResultList();
```

### Named 쿼리 - XML에 정의

```xml
<!-- [META-INF/persistence.xml] -->
<persistence-unit name="jpabook" >
	<mapping-file>META-INF/ormMember.xml</mapping-file>

<!-- [META-INF/ormMember.xml] -->
<?xml version="1.0" encoding="UTF-8"?>
<entity-mappings xmlns="http://xmlns.jcp.org/xml/ns/persistence/orm" version="2.1">
    
	<named-query name="Member.findByUsername">
		<query><![CDATA[
			select m
			from Member m
			where m.username = :username
		]]></query>
	</named-query>

    <named-query name="Member.count">
		<query>select count(m) from Member m</query>
	</named-query>
    
</entity-mappings>
```

### Named 쿼리 환경에 따른 설정

- XML이 항상 우선권을 가진다.
- 애플리케이션 운영 환경에 따라 다른 XML을 배포할 수 있다.



## 8강 JPA 기반 프로젝트

- Spring Data JPA
- QueryDSL

### 스프링 데이터 JPA 소개

- 지루하게 반복되는 CRUD 문제를 세련된 방법으로 해결
- **개발자는 인터페이스만 작성**
- 스프링 데이터 JPA가 구현 객체를 동적으로 생성해서 주입
- 쿼리 메서드 기능
  - 메서드 이름으로 쿼리 생성
  - @Query 어노테이션으로 쿼리 직접 정의
- 메서드 이름으로 쿼리 생성
  - 메서드 이름만으로 JPQL 생성

### QueryDSL 소개

- SQL과 JPQL을 코드로 작성할 수 있도록 도와주는 빌더 API
- JPA 크리테이라에 비해서 편리하고 실용적임
- 오픈 소스

### SQL, JPQL의 문제점

- SQL, JPQL은 문자, Type-check 불가능
- 해당 로직 실행 전까지 작동여부 확인 불가

### QueryDSL 장점

- 문자가 아닌 **코드**로 작성

- **컴파일 시점에 문법 오류 발견**
- 코드 자동완성(IDE 도움)
- 단순하고 쉬움, 코드 모양이 JPQL과 거의 비슷
- 동적 쿼리