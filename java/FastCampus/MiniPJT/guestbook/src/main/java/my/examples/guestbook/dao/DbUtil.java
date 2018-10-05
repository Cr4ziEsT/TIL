package my.examples.guestbook.dao;

import java.sql.*;

// DB 사용시에는 항상 연결과 close가 필요하다. 따라서 중첩되서 일어나므로 따로 클래스를 작성해준다.
public class DbUtil {
    public static Connection connect(String dbUrl, String dbId, String dbPassword) throws RuntimeException{
        Connection conn = null;
        try {
            Class.forName("org.h2.Driver"); // Driver 등록
            conn = DriverManager.getConnection(dbUrl, dbId, dbPassword);    // DB에 연결
        }catch (Exception ex){
            throw new RuntimeException(ex);
        }
        return conn;
    }

    // insert, update, delete
    public static void close(Connection conn, PreparedStatement ps){
        if(ps != null){
            try{
                ps.close();
            }catch(SQLException ex){
                //
            }
        }
        if(conn != null){
            try{
                conn.close();
            }catch (SQLException ex){
                //
            }
        }
    } // close

    public static void close(Connection conn, PreparedStatement ps, ResultSet rs){
        if(rs != null){
            try{
                rs.close();
            }catch (SQLException ex){
                //
            }
        }
        close(conn, ps);
    } // close
}
