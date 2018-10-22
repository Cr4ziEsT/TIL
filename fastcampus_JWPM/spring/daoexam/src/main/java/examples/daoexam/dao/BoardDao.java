package examples.daoexam.dao;

import examples.daoexam.dto.Board;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
/*
Dao 만드는 방법

- @Repository 애노테이션을 붙인다.   // Dao 객체가 Bean 으로 등록되기 위해서!
- 필드로 JdbcTemplate, SimpleJdbcInsert 가 선언된다.
- 생성자에서 DataSource를 주입받아서 JdbcTemplate을 초기화한다.
- 경우에 따라서는 생성자에서 insert할려고 SimpleJdbcInsert를 초기화 한다.
    // 어떤 경우? 어떠한 속성 값이 자동으로 증가되는 경우
 */

// BoardDao 는 Spring JDBC 로 만듦
@Repository
public class BoardDao {
    private NamedParameterJdbcTemplate jdbc;    // jdbc 프로그래밍을 하기 위한 객체를 갖는다.
    private SimpleJdbcInsert insertAction;      // board table 에 insert 하기 위한 객체를 갖는다. insert SQL 문장을 내부적으로 자동으로 만들어줌

    public BoardDao(DataSource dataSource) {
        this.jdbc = new NamedParameterJdbcTemplate(dataSource);
        this.insertAction = new SimpleJdbcInsert(dataSource)
                .withTableName("board")         // .withTableName은 자기 자신을 리턴해줌 ( -> board table 에 insert 하겠다~)
                .usingGeneratedKeyColumns("id");// 자동 생성되는 칼럼(id) 값이 있을 경우 설정해준다.
    }


    public Long addBoard(Board board) {
        // SqlParameterSource : 일종의 Map 객체
        // BeanPropertySqlParameterSource : Board DTO의 내용을 읽어들여서 Insert문장에 바인딩 할 값을 가지고 있는 SqlParameterSouce 객체를 생성.
        SqlParameterSource params = new BeanPropertySqlParameterSource(board);  // 결국 board 객체로부터 sql에 바인딩 할 값을 갖고 있는 객체를 생성하는 것

        // id가 자동으로 증가하지 않을 경우에는 다음과 같이 execute()메소드를 사용한다.
        // insertAction.execute(Map) or  insertAction.execute(SqlParameterSource)

        // id 가 자동으로 증가하면 값이 궁금할 수 있다. 이때 executeAndReturnKey 메소드를 사용하여
        // insert가 실행되고, 자동으로 증가한 id값을 리턴한다.
        return insertAction.executeAndReturnKey(params).longValue();
    }
}