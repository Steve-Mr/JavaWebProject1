package dao;

import vo.Course;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
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

}
