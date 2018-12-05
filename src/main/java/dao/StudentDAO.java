package dao;

import vo.Student;

import java.sql.*;
import java.util.ArrayList;

public class StudentDAO {

    public Student getStudentByStuno(String stuno) throws Exception{//通过学号获得学生信息
        Student stu = null;//attention！
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/SCHOOL?useSSL=false&allowPublicKeyRetrieval=true", "scott", "tiger");

        Statement stat = conn.createStatement();
        String sql = "select * from T_STUDENT where STUNO='"+stuno+"'";
        ResultSet rs = stat.executeQuery(sql);
        if(rs.next()){
            stu = new Student();
            stu.setStuno(stuno);
            stu.setPassword(rs.getString("STUPWD").trim());
            stu.setStuname(rs.getString("STUNAME").trim());
            stu.setStusex(rs.getString("STUSEX").trim());
        }
        conn.close();
        return stu;
    }

    public void updateStudent(Student stu) throws Exception{//修改学生信息
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/SCHOOL?useSSL=false&allowPublicKeyRetrieval=true", "scott", "tiger");
        String sql = "update T_STUDENT set stupwd=? where stuno=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, stu.getPassword());
        ps.setString(2, stu.getStuno());
        ps.executeUpdate();
        conn.close();
    }

    public int getStudentCount(){ //获取学生总数
        try{
            this.initConnection();
            String sql = "SELECT COUNT(*) FROM T_STUDENT";
            Statement stat = conn.createStatement();
            ResultSet rs = stat.executeQuery(sql);
            rs.next();
            int pageCouont = rs.getInt(1);
            return pageCouont;
        }catch(Exception ex){
            ex.printStackTrace();
        }finally {
            try{
                this.closeConnection();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return 0;
    }

    public ArrayList queryPage(int currentPageIndex, int countPerPage){
        String sql = "SELECT STUNO,STUNAME,STUSEX FROM T_STUDENT LIMIT ?,?";
        ArrayList pageStudents = new ArrayList();
        try{
            this.initConnection();
            PreparedStatement ps= conn.prepareStatement(sql);
            ps.setInt(1,(currentPageIndex-1)*countPerPage);
            ps.setInt(2,currentPageIndex*countPerPage);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Student student = new Student();
                student.setStuno(rs.getString("STUNO"));
                student.setStuname(rs.getString("STUNAME"));
                student.setStusex(rs.getString("STUSEX"));
                pageStudents.add(student);
            }
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        finally {
            try{
                this.closeConnection();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return pageStudents;
    }

    private Connection conn = null;

    public void initConnection() throws Exception{
        Class.forName("oracle.jdbc.driver.OracleDriver");
        conn = DriverManager.getConnection("jdbc:mysql://localhost/SCHOOL?useSSL=false&allowPublicKeyRetrieval=true", "scott", "tiger");
    }

    public void closeConnection() throws Exception{
        conn.close();
    }
}
