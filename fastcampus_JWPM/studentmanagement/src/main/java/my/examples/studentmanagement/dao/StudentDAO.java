//package my.examples.studentmanagement.dao;
//
//import my.examples.studentmanagement.Student;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.util.ArrayList;
//import java.util.List;
//
//public class StudentDAO {
//    private DbConfig dbConfig;
//
//    public StudentDAO(DbConfig dbConfig){
//        this.dbConfig = dbConfig;
//    }
//
//    public int addStudentInfo(Student student){
//        int count = 0;
//        Connection conn = DbUtil.connection(dbConfig);
//        String sql = "INSERT INTO student(idx, name, kor_num, eng_num, math_num) VALUES (null, ?, ?, ?, ?)";
//        PreparedStatement ps = null;
//        try{
//            ps = conn.prepareStatement(sql);
//            ps.setString(1, student.getName());
//            ps.setInt(2, student.getKorNum());
//            ps.setInt(3, student.getEngNum());
//            ps.setInt(4, student.getMathNum());
//            count = ps.executeUpdate();
//        }catch (Exception ex){
//            ex.printStackTrace();
//        }finally {
//            DbUtil.close(conn, ps);
//        }
//        return count;
//    }
//
//    public List<Student> getStudentInfo(){
//        List<Student> students = new ArrayList<>();
//        Connection conn = DbUtil.connection(dbConfig);
//        String sql = "SELECT name, kor_num, eng_num, math_num FROM student";
//        PreparedStatement ps = null;
//        ResultSet rs = null;
//        try{
//            ps = conn.prepareStatement(sql);
//            rs = ps.executeQuery();
//
//            while(rs.next()){
//                String name = rs.getString(1);
//                int korNum = rs.getInt(2);
//                int engNum = rs.getInt(3);
//                int mathNum = rs.getInt(4);
//
//                Student student = new Student(name, korNum, engNum, mathNum);
//                students.add(student);
//            }
//
//        }catch (Exception ex){
//            ex.printStackTrace();
//        }finally {
//            DbUtil.close(conn, ps, rs);
//        }
//        return students;
//    }
//}
