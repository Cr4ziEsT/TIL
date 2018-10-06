package my.examples.guestbook.dao;

import my.examples.guestbook.servlet.Guestbook;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class GuestbookDao {
    private String dbUrl = "jdbc:h2:tcp://localhost:9092/jdbc:h2:tcp://localhost/~/test;DB_CLOSE_DELAY=-1;";
    private String dbId = "sa";
    private String dbPassword = "";

    public List<Guestbook> getGuestbookList(){
        List<Guestbook> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{

        }catch (Exception ex){
            ex.printStackTrace();
        }finally{
            DbUtil.close(conn,ps,rs);
        }
        return list;
    }
}
