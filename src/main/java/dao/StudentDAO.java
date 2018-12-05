package dao;

import vo.Student;

import java.sql.*;

public class StudentDAO {

    public Student getStudentByStuno(String stuno) throws Exception{//通过学号获得学生信息
        Student stu = null;//attention！
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/SCHOOL?useSSL=false", "scott", "tiger");

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
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/SCHOOL?useSSL=false", "scott", "tiger");
        String sql = "update T_STUDENT set stupwd=? where stuno=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, stu.getPassword());
        ps.setString(2, stu.getStuno());
        ps.executeUpdate();
        conn.close();
    }
}
