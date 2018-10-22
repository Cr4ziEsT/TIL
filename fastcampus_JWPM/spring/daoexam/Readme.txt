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
Java Config에 @EnableTransactionManagement 을 붙여주면, 트랜잭션과 관련된
AOP가 적용된다.