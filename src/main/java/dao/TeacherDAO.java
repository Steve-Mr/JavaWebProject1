package dao;

import vo.Teacher;

import java.sql.*;
import java.util.ArrayList;

public class TeacherDAO {

    private Connection conn = null;

    public void initConnection() throws Exception{
        Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection("jdbc:mysql://localhost/SCHOOL?useSSL=false&allowPublicKeyRetrieval=true", "scott", "tiger");
    }

    public void closeConnection() throws Exception{
        conn.close();
    }

    public Teacher getTeacherByTeano(String teano) throws Exception{
        Teacher tea = null;
        this.initConnection();
        //Class.forName("com.mysql.jdbc.Driver");
        //Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/SCHOOL?useSSL=false&allowPublicKeyRetrieval=true", "scott", "tiger");
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
        //conn.close();
        this.closeConnection();
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



    public int getTeacherCount(){
        try{
            this.initConnection();
            String sql = "SELECT COUNT(*) FROM T_TEACHER";
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
        String sql = "SELECT TEANO,TEANAME,TEASEX,TITLE FROM T_TEACHER LIMIT ?,?";
        ArrayList pageTeachers = new ArrayList();
        try {
            this.initConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, (currentPageIndex - 1) * countPerPage);
            ps.setInt(2, countPerPage);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Teacher teacher = new Teacher();
                teacher.setTeano(rs.getString("TEANO"));
                teacher.setTeaname(rs.getString("TEANAME"));
                teacher.setTeasex(rs.getString("TEASEX"));
                teacher.setTitle(rs.getString("TITLE"));
                pageTeachers.add(teacher);
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
            return pageTeachers;
        }


}
