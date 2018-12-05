package servlet;

import dao.CourseDAO;
import dao.ScoreDAO;
import vo.Course;
import vo.Score;
import vo.Student;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class Stu_SelectCourseServlet extends HttpServlet {


    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Student stu = (Student)request.getSession().getAttribute("student");
        ScoreDAO sdao = new ScoreDAO();

        try{
            ArrayList info = sdao.getScoreByStuno(stu.getStuno());
            if(info.size()!=0){
                request.setAttribute("msg2", "对不起,您已经选好课程了！");
            }
            else{
                CourseDAO cdao = new CourseDAO();
                /*若可以选课,从数据库获取所有课程,放入request中*/
                ArrayList allcourse = cdao.getAllCourse();
                for(int i=0;i<allcourse.size();i++){
                    Course cou = (Course)allcourse.get(i);
                }
                request.setAttribute("allcourse",allcourse);
            }
            RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/student/stu_selectcourse.jsp");
            dispatcher.forward(request, response); //内部跳转，将处理信息存储在request中
        }catch(Exception ex){ex.printStackTrace();}
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        /*为简化流程，该系统要求学生选课的总学分刚好满20则选课成功，系统自动向考试成绩表中添加记录；否则，选课失败，界面刷新后仍停留本页面*/
        Student stu = (Student)request.getSession().getAttribute("student");
        ScoreDAO sdao = new ScoreDAO();
        CourseDAO cdao = new CourseDAO();

        try{
            ArrayList al = cdao.getAllCoursename();//得到所有课程名称
            ArrayList selectedcourses = new ArrayList();
            float allCredit = 0;

            /*计算选取课程的总学分*/
            for(int i=0;i<al.size();i++){
                String coursename = (String)al.get(i);
                String courseno = request.getParameter(coursename);
                if(courseno!=null){
                    Course cou1 = cdao.getCourseByCourseno(courseno);
                    allCredit += cou1.getCredit();
                    selectedcourses.add(cou1);
                }
            }

            /*总学分刚好满20时，选课成功，更新信息到数据库*/
            if(allCredit==20){
                for(int i=0;i<selectedcourses.size();i++){
                    Course cou2 = (Course)selectedcourses.get(i);
                    Score sco = new Score();
                    sco.setStuno(stu.getStuno());
                    sco.setCourseno(cou2.getCourseno());
                    sdao.insertScore(sco);
                }
                request.setAttribute("msg2", "选课成功！");
            }
            RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/student/stu_selectcourse.jsp");
            dispatcher.forward(request, response); //内部跳转，将处理信息存储在request中
        }catch(Exception ex){	ex.printStackTrace();}
    }

}
