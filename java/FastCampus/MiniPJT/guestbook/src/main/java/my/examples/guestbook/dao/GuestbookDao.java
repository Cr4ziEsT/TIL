package my.examples.guestbook.dao;

import my.examples.guestbook.servlet.Guestbook;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.time.ZoneId;
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
            conn = DbUtil.connect(dbUrl, dbId, dbPassword);
            String sql = "select id, name, content, regdate from guestbook order by id desc";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while(rs.next()){
                Guestbook guestbook = new Guestbook();
                guestbook.setId(rs.getLong(1));
                guestbook.setName(rs.getString(2));
                guestbook.setContent(rs.getString(3));
                Date dbDate = rs.getDate(4);    // java.sql.Date
                LocalDateTime ldt = dbDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
                guestbook.setRegate(ldt);
                list.add(guestbook);
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }finally{
            DbUtil.close(conn,ps,rs);
        }
        return list;
    }
}
