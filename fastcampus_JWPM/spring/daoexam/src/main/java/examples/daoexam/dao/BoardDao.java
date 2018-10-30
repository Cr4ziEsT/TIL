package examples.daoexam.dao;

import examples.daoexam.dto.Board;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
                .withTableName("board")         // .withTableName은 자기 자신을 리턴해줌 (board table 에 insert 하겠다)
                                                // (insert문장을 자동으로 만들어주기 위해서는 어떤 테이블인지 알아야 하므로..)
                .usingGeneratedKeyColumns("id");// 자동 생성되는 칼럼(id) 값이 있을 경우 설정해준다.(id는 자동으로 만들어주지 않아도 된다고 알려주는 역할)
    }


    public Long addBoard(Board board) {
        // SqlParameterSource : 일종의 Map 객체, insert 문장에 바인딩 할 값을 가지고 있음.
        // BeanPropertySqlParameterSource : Board DTO의 내용을 읽어들여서 Insert문장에 바인딩 할 값을 가지고 있는 SqlParameterSouce 객체를 생성.
        SqlParameterSource params = new BeanPropertySqlParameterSource(board);  // 결국 board 객체로부터 sql에 바인딩 할 값을 갖고 있는 객체를 생성하는 것

        // id가 자동으로 증가하지 않을 경우에는 다음과 같이 execute()메소드를 사용한다.
        // insertAction.execute(Map) or  insertAction.execute(SqlParameterSource)

        // id 가 자동으로 증가하면 값이 궁금할 수 있다. 이때 executeAndReturnKey 메소드를 사용하여
        // insert가 실행되고, 자동으로 증가한 id값을 리턴한다.
        return insertAction.executeAndReturnKey(params).longValue();
    }

    public int updateCount(Long id){    // id에 해당하는 count 증가!
        String sql = "update board set read_count = read_count + 1 where id = :id";
//        Map<String, Long> map = new HashMap<>();
//        map.put("id", id);
        // Map에 넣을 값이 하나밖에 없을 경우에는 아래와 같은 형식으로도 만들 수 있다.
        Map<String, Long> map = Collections.singletonMap("id", id);
        return jdbc.update(sql, map);   //update메소드는 입력, 수정, 삭제 할 때 사용하는 메소드(sql을 실행하고 map 객체를 바인딩)
    }

    public int deleteBoard(Long id){
        String sql = "DELETE FROM board WHWER id=:id";
        Map<String, Long> map = new HashMap<>();
        map.put("id", 1L);
        return jdbc.update(sql, map);
    }

    public int updateBoard(Board board){
        String sql = "UPDATE board SET name=:name, title=:title, content=:content WHERE id=:id";
//        Map<String, Object> map = new HashMap<>();
//        map.put("id", board.getId());
//        map.put("name", board.getName());
//        map.put("title", board.getTitle());
//        map.put("content", board.getContent());
        SqlParameterSource params = new BeanPropertySqlParameterSource(board);
        return jdbc.update(sql, params);
    }

    public Board getBoard(Long id){
        String sql = "select id, name, title, content, regdate, read_count     " +
                "from board where id = :id";
        try{
            // Board에 값을 담아주는 규칙을 가지고 있는 RowMapper를 만든다.
            // Board.class정보를 읽어들여서 프로퍼티(getter, setter)의 이름을 가지고 칼럼에 담아주는 규칙을 만든다.
            // 에를 들어, readCount라는 프로퍼티가 있으면 read_count라는 칼럼의 값을 담아준다.
            RowMapper<Board> rowMapper = BeanPropertyRowMapper.newInstance(Board.class);
            Map<String, ?> params = Collections.singletonMap("id", id);

            // 한건 or null 을 조회할 때는 queryForObject
            // 첫번째 파라미터 : sql
            // 두번째 파라미터 : 바인딩할 Map
            // 세번째 파라미터 : Mapper (칼럼을 DTO에 담아주기위한 규칙)
            return jdbc.queryForObject(sql, params, rowMapper);
            // queryForObject는 sql ?에 파라미터 값을 채워서 실행되고 내부적으로 ResultSet이 RowMapper를 이용해서 ResultSet을 얻은 결괄 dto에 담아서 리턴해준다
        }catch(Exception ex){
            return null;
        }
    }

    public List<Board> getBoards(){     // service에서 사용
        String sql = "SELECT id, name, title, content, regdate, read_count FROM board ORDER BY id DESC";
        try{
            RowMapper<Board> rowMapper = BeanPropertyRowMapper.newInstance(Board.class);
            return jdbc.query(sql, rowMapper);      // .query는 여러건 조회하는 것 (List를 반환)
            // sql이 실행되고 파라미터가 없으므로 rowMapper에 의해 작성된 매핑정보로 매핑만 해준다.
        }catch(Exception ex){
            return null;
        }
    }
}