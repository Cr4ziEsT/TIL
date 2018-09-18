package my.examples.kjdbcexam;

import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JDBCExam02 {
    /* 첫번째
    public static void main(String[] args) throws Exception{
        // JDBC 프로그래밍 방법
        // 1. Driver를 등록한다
        // Class.forName("드라이브이름") //DBMS마다 달라짐
        Class.forName("org.h2.Driver");

        // 2. 커넥션과 관련된 인터페이스를 선언한다.
        //    JDBC URL은 DBMS마다 형식이 다르다
        // Connection conn = DriverManager.getConnection("url 이름", "유저 이름", "비밀번호");
        //    커넥션은 반드시 finally에서 close한다.
        Connection conn = null;

        // 3. SQL을 실행하기 위한 Interface를 선언한다.
        PreparedStatement ps = null;
        // 4. 결과를 읽어오기 위한 interface를 선언한다. 전부 java.sql 패키지
        ResultSet rs = null;

        try{
            conn = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test;DB_CLOSE_DELAY=-1", "sa", "");
            System.out.println("성공!");
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            conn.close();
        }

        /*
        1. 접속
        2. SQL 준비
        3. 결과 실행하여 한 줄씩 읽어온다.

        ㄱ. Connection(접속)
        Class.forName("드라이브명");
        Connection conn = DriverManger.getConnection(" ", " ", " ");
                            ㄴ> DBMS에 종속적이지 않게 하기 위해 클래스명이 DriverMager이지만
                                Class.forName()에서 사용된 값에 대한 리턴값으로 나오게 된다.
        ㄴ. PreparedStatement(SQL 준비, 바인딩)
        PreparedStatement ps = conn.preparedStatement(SQL); -> 이 SQL문을 실행할 준비
        ㄷ. ResultSet(결과 실행)
        ResultSet rs = ps.executeQuery();
         */
    public static void main(String[] args){


        //2. 커넥션과 관련된 interface를 선언한다.
        //   JDBC URL은 DBMS마다 형식이 다르다.
        //   커넥션은 반드시 finally 에서 close한다.
        Connection conn =  null;

        //3. SQL을 실행하기 위한 interface를 선언한다.
        PreparedStatement ps = null;

        //4. 결과를 읽어오기 위한 interface를 선언한다.
        ResultSet rs = null;
        try{
            //1. Driver를 등록한다.
            Class.forName("org.h2.Driver");

            //5. SQL 준비한다.
            String sql = "SELECT role_id, description FROM ROLE";

            // a. DB에 연결한다.
            conn = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test;DB_CLOSE_DELAY=-1",
                    "sa", "");

            // db에 sql을 준비해달라고 한다.
            // ps는 db안에서 준비된 sql을 참조하는 변수.
            ps = conn.prepareStatement(sql);

            // 준비된 sql을 실행하게 한다. 실행한 결과는 dbms에 있다.
            // rs는 실행된 결과를 참조하는 변수
            // executeQuery() : select문 실행, executeUpdate() : insert, update, delete
            rs = ps.executeQuery();

            // next()는 1건의 data를 읽어온다. 1건의 data는 여러개의 컬럼으로 구성되어 있다.
            // next()가 호출되면 한건의 읽어오는데 그 결과는 ResultSet(rs)이 가지고 있다.
            while(rs.next()){   // (rs.next()는 boolean 값을 리턴한다. -> 읽어 올 데이터가 있다면 true, 없다면 false)
                int roleId = rs.getInt(1); // 첫번째 칼럼의 값을 정수로 읽어온다.
                String description = rs.getString(2); // 두번째 칼럼은 문자열로 읽어온다.
                System.out.println(roleId + ", " + description);
            }

        }catch(Exception ex){
            ex.printStackTrace();
        }finally {
            try {
                rs.close();
            }catch(Exception ex){}
            try {
                ps.close();
            }catch(Exception ex){}
            try {
                conn.close();
            }catch(Exception ex){}
        }
    }
}
