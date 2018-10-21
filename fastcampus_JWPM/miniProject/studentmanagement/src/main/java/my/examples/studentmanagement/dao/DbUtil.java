package my.examples.studentmanagement.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DbUtil {
    public static Connection connection(DbConfig dbConfig) throws RuntimeException{
        Connection conn = null;
        try{
            Class.forName(dbConfig.getDbDriver());
            conn = DriverManager.getConnection(dbConfig.getDburl(), dbConfig.getDbId(), dbConfig.getDbPwd());
        }catch (Exception ex){
            throw new RuntimeException();
        }
        return conn;
    }

    public static void close(Connection conn, PreparedStatement ps){
        if(ps != null){
            try{
                ps.close();
            }catch (Exception ex){
                ex.printStackTrace();
            }
        }
        if(conn != null){
            try{
                conn.close();
            }catch (Exception ex){
                ex.printStackTrace();
            }
        }
    }

    public static void close(Connection conn, PreparedStatement ps, ResultSet rs){
        if(rs != null) {
            try {
                rs.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        close(conn, ps);
    }
}
