package dao;

import vo.Score;
import vo.ScoreSection;

import javax.servlet.jsp.jstl.sql.Result;
import java.sql.*;
import java.util.ArrayList;

public class ScoreDAO {

    public ArrayList getScoreByCourseno(String courseno) throws Exception{//获得某课程的考试信息
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/SCHOOL?useSSL=false&allowPublicKeyRetrieval=true", "scott", "tiger");
        ArrayList al = new ArrayList();
        Statement stat = conn.createStatement();
        String sql = "select * from T_SCORE A join T_COURSE B on A.courseno=B.courseno join T_STUDENT C on A.stuno=C.stuno"
                + " where A.courseno='"+courseno+"'";
        ResultSet rs = stat.executeQuery(sql);
        while(rs.next()){
            Score sco = new Score();
            sco.setStuno(rs.getString("stuno").trim());
            sco.setStuname(rs.getString("stuname").trim());
            sco.setCourseno(courseno);
            sco.setCoursename(rs.getString("coursename").trim());
            sco.setScore(rs.getFloat("score"));
            al.add(sco);
        }
        conn.close();

        return al;
    }

    public ArrayList getScoreSectionByCourseno(String courseno) throws Exception{//获得某课程的成绩分布
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/SCHOOL?useSSL=false&allowPublicKeyRetrieval=true", "scott", "tiger");
        ArrayList al = new ArrayList();
        Statement stat = conn.createStatement();
        String sql = "select courseno,coursename,case when score between 0 and 60 then '0-60' "+
                " when score between 60 and 70 then '60-70'"+
                " when score between 70 and 80 then '70-80'"+
                " when score between 80 and 90 then '80-90'"+
                " else '90-100' end as 分数段,count(*)人数 "+
                " from (select A.courseno courseno,B.coursename coursename,A.score score from" +
                " T_SCORE A join T_COURSE B on A.courseno=B.courseno where A.courseno='"+courseno+"') as suba"+
                " group by courseno,coursename,case when score between 0 and 60 then '0-60'"+
                " when score between 60 and 70 then '60-70'"+
                " when score between 70 and 80 then '70-80'"+
                " when score between 80 and 90 then '80-90'"+
                " else '90-100' end order by count(*)";
        ResultSet rs = stat.executeQuery(sql);
        while(rs.next()){
            ScoreSection ss = new ScoreSection();
            ss.setCourseno(courseno);
            ss.setCoursename(rs.getString("coursename").trim());
            ss.setSection(rs.getString("分数段"));
            ss.setNumber(rs.getInt("人数"));
            al.add(ss);
        }
        conn.close();

        return al;
    }

    public ArrayList getScoreByStuno(String stuno) throws Exception{//获得相应学号的考试信息
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/SCHOOL?useSSL=false&allowPublicKeyRetrieval=true", "scott", "tiger");
        ArrayList al = new ArrayList();
        Statement stat = conn.createStatement();
        String sql = "select * from T_SCORE A join T_STUDENT B on A.stuno=B.stuno join T_COURSE C on A.courseno=C.courseno"
                + " where A.stuno='"+stuno+"'";
        ResultSet rs = stat.executeQuery(sql);
        while(rs.next()){
            Score sco = new Score();
            sco.setStuno(stuno);
            sco.setStuname(rs.getString("stuname").trim());
            sco.setCourseno(rs.getString("courseno").trim());
            sco.setCoursename(rs.getString("coursename").trim());
            sco.setScore(rs.getFloat("score"));
            al.add(sco);
        }
        conn.close();

        return al;
    }

    public void insertScore(Score sco)throws Exception{
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/SCHOOL?useSSL=false&allowPublicKeyRetrieval=true", "scott", "tiger");
        String sql = "insert into T_SCORE(stuno,courseno) values(?,?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, sco.getStuno());
        ps.setString(2, sco.getCourseno());
        ps.executeUpdate();
        conn.close();

    }

    public void updateScore(Score sco)throws Exception{
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/SCHOOL?useSSL=false&allowPublicKeyRetrieval=true", "scott", "tiger");
        String sql = "update T_SCORE set score=?,state=? where stuno=? and courseno=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setFloat(1, sco.getScore());
        ps.setString(2, sco.getState());
        ps.setString(3, sco.getStuno());
        ps.setString(4, sco.getCourseno());
        ps.executeUpdate();
        conn.close();

    }

    private Connection conn = null;

    public void initConnection() throws Exception{
        Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection("jdbc:mysql://localhost/SCHOOL?useSSL=false&allowPublicKeyRetrieval=true", "scott", "tiger");
    }

    public void closeConnection() throws Exception{
        conn.close();
    }

    public int getStudentCount(String courseno){
        String sql ="select COUNT(*) from T_SCORE A join T_COURSE B  on A.courseno=B.courseno join T_STUDENT C on A.stuno=C.stuno"+ " where A.courseno='"+courseno+"'";
        try{
            this.initConnection();
            Statement stat = conn.createStatement();
            ResultSet rs = stat.executeQuery(sql);
            rs.next();
            int pageCount = rs.getInt(1);
            return pageCount;
        }catch (Exception ex){
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

}
