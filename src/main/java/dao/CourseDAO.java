package dao;

import vo.Course;
import vo.Student;

import java.sql.*;
import java.util.ArrayList;

public class CourseDAO {

    public ArrayList getAllCoursename() throws Exception{//获得所有课程名称
        ArrayList al = new ArrayList();
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/SCHOOL?useSSL=false&allowPublicKeyRetrieval=true", "scott", "tiger");
        String sql = "select distinct(coursename) from T_COURSE";
        Statement stat = conn.createStatement();
        ResultSet rs = stat.executeQuery(sql);
        while(rs.next()){
            al.add(rs.getString("COURSENAME").trim());
        }
        conn.close();

        return al;
    }

    public ArrayList getAllCourse() throws Exception{//获得所有课程
        ArrayList al = new ArrayList();
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/SCHOOL?useSSL=false&allowPublicKeyRetrieval=true", "scott", "tiger");
        String sql = "select * from T_COURSE A join T_TEACHER B on A.TEANO = B.TEANO";
        Statement stat = conn.createStatement();
        ResultSet rs = stat.executeQuery(sql);
        while(rs.next()){
            Course cou = new Course();
            cou.setCourseno(rs.getString("COURSENO").trim());
            cou.setCoursename(rs.getString("COURSENAME").trim());
            cou.setCredit(rs.getFloat("CREDIT"));
            cou.setTeano(rs.getString("TEANO").trim());
            cou.setTeaname(rs.getString("TEANAME").trim());
            al.add(cou);
        }
        conn.close();

        return al;
    }

    public Course getCourseByCourseno(String courseno) throws Exception{//根据课程号获取课程信息
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/SCHOOL?useSSL=false&allowPublicKeyRetrieval=true", "scott", "tiger");
        Course cou = null;
        String sql = "select * from T_COURSE A join T_TEACHER B on A.teano = B.teano where A.courseno='"+courseno+"'";
        Statement stat = conn.createStatement();
        ResultSet rs = stat.executeQuery(sql);
        if(rs.next()){
            cou = new Course();
            cou.setCourseno(courseno);
            cou.setCoursename(rs.getString("COURSENAME").trim());
            cou.setCredit(rs.getFloat("CREDIT"));
            cou.setTeano(rs.getString("TEANO").trim());
            cou.setTeaname(rs.getString("TEANAME").trim());
        }
        conn.close();

        return cou;
    }

    public ArrayList getCourseByTeano(String teano) throws Exception{//获得相应职工号的开课情况
        ArrayList al = new ArrayList();
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/SCHOOL?useSSL=false&allowPublicKeyRetrieval=true", "scott", "tiger");
        String sql = "select * from T_COURSE A join T_TEACHER B on A.teano = B.teano where B.teano='"+teano+"'";;
        Statement stat = conn.createStatement();
        ResultSet rs = stat.executeQuery(sql);
        while(rs.next()){
            Course cou = new Course();
            cou.setCourseno(rs.getString("COURSENO").trim());
            cou.setCoursename(rs.getString("COURSENAME").trim());
            cou.setCredit(rs.getFloat("CREDIT"));
            cou.setTeano(teano);
            cou.setTeaname(rs.getString("TEANAME").trim());
            al.add(cou);
        }
        conn.close();

        return al;
    }

    public ArrayList getCourseByStuno(String stuno) throws Exception{//获得相应学号选修好的课程
        ArrayList al = new ArrayList();
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/SCHOOL?useSSL=false&allowPublicKeyRetrieval=true", "scott", "tiger");
        String sql = "select * from T_COURSE A join T_SCORE B on A.courseno=B.courseno join T_TEACHER C on A.teano=C.teano"
                +" where B.stuno='"+stuno+"'";
        Statement stat = conn.createStatement();
        ResultSet rs = stat.executeQuery(sql);
        while(rs.next()){
            Course cou = new Course();
            cou.setCourseno(rs.getString("COURSENO").trim());
            cou.setCoursename(rs.getString("COURSENAME").trim());
            cou.setCredit(rs.getFloat("CREDIT"));
            cou.setTeano(rs.getString("TEANO").trim());
            cou.setTeaname(rs.getString("TEANAME").trim());
            al.add(cou);
        }
        conn.close();

        return al;
    }

    private Connection conn = null;

    public void initConnection() throws Exception{
        Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection("jdbc:mysql://localhost/SCHOOL?useSSL=false&allowPublicKeyRetrieval=true", "scott", "tiger");
    }

    public void closeConnection() throws Exception{
        conn.close();
    }

    public int getCourseCount(){ //获取课程总数
        try{
            this.initConnection();
            String sql = "SELECT COUNT(*) FROM T_COURSE";
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
        String sql = "SELECT distinct COURSENO,COURSENAME,CREDIT,TEANAME  from T_COURSE A join T_TEACHER B on A.TEANO = B.TEANO LIMIT ?,?";
        ArrayList pageStudents = new ArrayList();
        try{
            this.initConnection();
            PreparedStatement ps= conn.prepareStatement(sql);
            ps.setInt(1,(currentPageIndex-1)*countPerPage);
            ps.setInt(2,countPerPage);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Course course = new Course();
                course.setCourseno((rs.getString("COURSENO")));
                course.setCoursename(rs.getString("COURSENAME"));
                course.setTeaname(rs.getString("TEANAME"));
                course.setCredit(rs.getFloat("CREDIT"));
                pageStudents.add(course);
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

}
