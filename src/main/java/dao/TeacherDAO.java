package dao;

import vo.Teacher;

import java.sql.*;

public class TeacherDAO {

    public Teacher getTeacherByTeano(String teano) throws Exception{
        Teacher tea = null;
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/SCHOOL?useSSL=false&allowPublicKeyRetrieval=true", "scott", "tiger");
        Statement stat = conn.createStatement();
        String sql = "SELECT * FROM T_TEACHER WHERE TEANO ='"+teano+"'";
        ResultSet rs = stat.executeQuery(sql);
        if(rs.next()){
            tea=new Teacher();
            tea.setTeano(teano);
            tea.setPassword(rs.getString("TEAPWD").trim());
            tea.setTeaname(rs.getString("TEANAME").trim());
            tea.setTeasex(rs.getString("TEASEX").trim());
            tea.setTitle(rs.getString("TITLE").trim());
        }
        conn.close();

        return tea;
    }

    public void updateTeacher(Teacher tea) throws Exception{
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/SCHOOL?useSSL=false&allowPublicKeyRetrieval=true", "scott", "tiger");
        String sql = "UPDATE T_TEACHER SET TEAPWD = ? WHERE TEANO =?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1,tea.getPassword());
        ps.setString(2,tea.getTeano());
        ps.executeQuery();
        conn.close();

    }


}
