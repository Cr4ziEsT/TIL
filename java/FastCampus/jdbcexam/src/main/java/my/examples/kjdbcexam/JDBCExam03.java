package my.examples.kjdbcexam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JDBCExam03 {
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
            String sql = "SELECT role_id, description FROM ROLE where role_id = ?"; // 파싱

            // a. DB에 연결한다.
            conn = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test;DB_CLOSE_DELAY=-1",
                    "sa", "");

            // db에 sql을 준비해달라고 한다.
            // ps는 db안에서 준비된 sql을 참조하는 변수.
            ps = conn.prepareStatement(sql);
            // 물음표 부분이 준비가 안되어 있다. 이를 채워줘야한다. 이를 바인딩이라 함
            ps.setInt(1, 100);

            rs = ps.executeQuery();

            if(rs.next()){  //why if문 -> 있을 수도 있고 없을 수도 있기 때문에...
                int roleId = rs.getInt(1); // 첫번째 칼럼의 값을 정수로 읽어온다.
                String description = rs.getString(2); // 두번째 칼럼은 문자열로 읽어온다.
                System.out.println(roleId + ", " + description);
            }else{
                System.out.println("존재x");
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
