1. Lombok 플러그인을 설치 (딱 1번만 설치)
2. Lombok을 사용하기 위한 설정 ( Lombok을 사용하는 프로젝트마다 설정 )
 ------------
 3. DataSource를 설정, jsp에 대한 설정
pom.xml---------------------------------
		<dependency>
			<groupId>javax.servlet</groupId>
			<artifactId>jstl</artifactId>
		</dependency>
 		<dependency>
			<groupId>org.apache.tomcat.embed</groupId>
			<artifactId>tomcat-embed-jasper</artifactId>
		</dependency>

 application.properties------------------
 spring.mvc.view.prefix=/WEB-INF/views/
spring.mvc.view.suffix=.jsp
 spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.url=jdbc:mysql://localhost:3306/connectdb?useUnicode=true&characterEncoding=utf8      # 이모티콘을 사용하기 위해서는 DB에서도 설정을 utf8mb4로 변경해야 한다.
spring.datasource.username=connect
spring.datasource.password=connect
 ------------
 4. Entity객체를 생성한다. Entity를 통해 자동으로 테이블이 생성되도록 하자.

 application.properties 에 내용을 추가한다. ------
 spring.jpa.hibernate.ddl-auto= create-drop
spring.jpa.show-sql= true
spring.jpa.properties.hibernate.format_sql= true
 ---------------------------------------------------
- 패러다임 충돌
:sql과 자바의 객체지향은 서로 다른 방식이기 때문에 충돌이 발생한다. 그래서 Hibernate 가 탄생하게 됨

Hibernate (Object-Relational Mapping) ----> JPA ------> Spring DATA JPA
JPA는 인터페이스이다. JPA를 구현하고 있는 것이 Hibernate 이다.

--------------
Entity
