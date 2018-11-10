Spring JUnit Test
 1. pom.xml 파일에 다음의 의존성 추가 (Test와 관련된 의존성)
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-test</artifactId>
            <version>${spring.version}</version>
        </dependency>
        <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
            <version>4.12</version>
            <scope>test</scope>
        </dependency>
 schema.sql 문서는 테이블 생성과 insert 문이 만들어져 있는데 실행할때마다 매번 같은 데이터가 있으면 편리하기 때문에
 2. DataSource부분을 다음과 같이 수정
 DataSource객체가 만들어지고 자동으로 schema.sql 을 실행한다.
     @Bean
    public DataSource dataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(driverClassName);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        DatabasePopulatorUtils.execute(createDatabasePopulator(), dataSource);
        return dataSource;
    }
     private DatabasePopulator createDatabasePopulator() {
        ResourceDatabasePopulator databasePopulator = new ResourceDatabasePopulator();
        databasePopulator.setContinueOnError(true);
        databasePopulator.addScript(new ClassPathResource("schema.sql"));
        return databasePopulator;
    }
        -> DatabasePopulatorUtils.execute(createDatabasePopulator(), dataSource) -> createDatabasePopulator() 필요
        -> private DatabasePopulator createDatabasePopulator() {} 프라이빗한 생성자
        -> return databasePopulator; 를 리턴해준다.
        -> 그런데 databasePopulator는 databasePopulator.addScript(new ClassPathResource("schema.sql")); 파라미터로 schema.sql을 갖고 있다.
        -> 따라서 DatabasePopulatorUtils.execute(createDatabasePopulator(), dataSource); 이것이 실행되고 dataSource가 만들어지면
        -> schema.sql 안의 sql 문장이 자동으로 실행된다.
 3. Test 클래스를 작성(BoardDaoTest)
 * 단위 테스트가 무엇이지?
 ex)
  Controller --> Service --> Dao
  controller가 service를 사용하고 service가 dao를 사용한다.
  service를 테스트한다는 것은 dao가 잘못 만들어졌어도 service의 코드가 제대로 만들어졌다면 service의 테스트는 성공해야한는 것을 말한다.
* 통합 테스트가 무엇인지?
 ex)
 Controller --> Service --> Dao
 Service의 메소드를 테스트, service도 잘 실행되고 dao도 잘 실행되는 것을 말한다.
 객체와 객체들이 상호연관을 맺고 동작해야 된다는 것을 의미
* JUnit 이 무엇이지?
 단위 테스트를 하기 위한 도구
* Mock 이 무엇이지?
 JUnit을 잘 사용하기 위해 알아야 하는 개념
* 값의 검증은 어떻게 할까?
 test/java/패키지명/클래스 를 작성 -> Assert 메소드를 이용해서 테스트
 @RunWith 는 JUnit 이 제공하는 애노테이션인데, 확장점을 제공한다.
 @RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ApplicationConfig.class)
위의 2줄은 스프링이 JUnit의 기능을 확장하여 ApplicationConfig.class를
읽어들여 내부적으로 ApplicationContext를 생성한다.(왜? Spring은 Bean Container를 갖고 있어야 한다.)
 package examples.daoexam.dao;
 import examples.daoexam.config.ApplicationConfig;
import examples.daoexam.config.DBConfig;
import examples.daoexam.dto.Board;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
 import java.util.List;
 @RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ApplicationConfig.class)
public class BoardDaoTest {
     @Test
    public void init(){
     }
 }