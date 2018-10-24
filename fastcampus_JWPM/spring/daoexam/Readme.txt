java.sql.SQLException: Unable to load authentication plugin 'caching_sha2_password' 오류 발생 시 아래와 같은 방법으로 해결.

mysql root계정으로 접속하여 다음처럼 변경

ALTER USER 계정명@'%' IDENTIFIED WITH mysql_native_password BY '암호';

ALTER USER connect@'%' IDENTIFIED WITH mysql_native_password BY 'connect';

----------------

DataSource는 인터페이스고 해당 인터페이스를 구현하는 객체가 필요.(DBCP, HikariCP)

https://commons.apache.org/proper/commons-dbcp/     -> DBCP
https://github.com/brettwooldridge/HikariCP         -> HikariCP
이 두개는 DataSource를 구현하고 있는 구현체이고, 또 다른 말로는 ConnectionPool 이라고 부른다.

- DataSource
: ConnectionPool을 사용하기 위한 인터페이스이다.

- ConnectionPool
: 커넥션들을 미리 연결해서 가지고 있는 객체.
왜 미리 커넥션을 연결해놓느냐? 이 커넥션을 연결할때 비용이 발생한다.(메모리, CPU 등 컴퓨터 자원을 많이 사용함)
미리 커넥션을 연결해 놓았다는 것은 프로그램을
커넥션을 빌려와서 사용하고, 돌려준다. DataSource로 부터 Connection을 얻은 후,
해당 Connection을 close()하면 커넥션을 되돌려준다.

- 커넥션을 빨리 되돌려주려면?
1) slow sql을 제거한다.
2) 과도하게 많은 sql 이 사용되면 안된다.
3) DB에는 과도한 커넥션을 연결할 수 없다.

스터디 : 커텍션 풀에 어떤 설정을 할 수 있는지 공부.
-------------------------------------------

- 트랜젝션 처리를 하려면
DataSource, PlatformTransactionManager 를 구현하는 Bean을 선언한다.
Java Config에 @EnableTransactionManagement 을 붙여주면, 트랜잭션과 관련된 AOP가 적용된다.

---------------------------------------------

Spring JDBC

- Spring JDBC에서 가장 핵심은 JdbcTemplate
- JdbcTemplate을 좀 더 편하게 사용할 수 있도록 하는 클래스 NamedParameterJdbcTemplate

● JdbcTemplate ?
- JDBC의 지루한 코드를 줄여주는 기능을 가지고 있다.
// insert, update, delete, select
- 사용자는 SQL을 작성하고, 해당 SQL에 바인딩할 객체(보통 Map)를 설정한다.
// select
- select한 결과를 DTO에 담아주는 기능을 가지고 있다.-> Mapper 기능

● NamedParameterJdbcTemplate은 해당 기능에 더해 ?대신에 이름을 사용할 수 있도록 한다.

Dao 만드는 방법

- @Repository 애노테이션을 붙인다.   // Dao 객체가 Bean 으로 등록되기 위해서!
- 필드로 JdbcTemplate, SimpleJdbcInsert 가 선언된다.
- 생성자에서 DataSource를 주입받아서 JdbcTemplate을 초기화한다.
- 경우에 따라서는 생성자에서 insert할려고 SimpleJdbcInsert를 초기화 한다.
    // 어떤 경우? 어떠한 속성 값이 자동으로 증가되는 경우
    public BoardDao(DataSource dataSource){
        this.jdbc = new NamedParameterJdbcTemplate(dataSource);

        this.insertAction = new SimpleJdbcInsert(dataSource)
                .withTableName("board")
                .usingGeneratedKeyColumns("id"); // 자동생성되는 칼럼이 있을 경우 설정
    }


SimpleJdbcInsert 는 이insert SQL문장을 내부적으로 자동으로 만든다.
insert into board values( ?, ?, ..... );

?에 채울 값은 SqlParameterSource, Map형태로 만든다.

    public Long addBoard(Board board){
       SqlParameterSource params = new BeanPropertySqlParameterSource(board);
       return insertAction.executeAndReturnKey(params).longValue();
    }

---------------

● NamedParameterJdbcTemplate (JDBC 프로그래밍을 더 편하게 하기 위한 객체)
- insert, udpate, delete 를 하려면?
:update(SQL, 바인딩할객체) 메소드를 사용

- 1건 or null 을 select하려면 (조건이 없으면 NULL 이 나올 수 있음)
:queryForObject(SQL, 바인딩할객체, Mapper)

- 0건 이상의 List로 select하려면