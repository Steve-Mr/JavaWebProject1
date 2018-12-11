package servlet;

import dao.CourseDAO;
import vo.Teacher;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class Tea_EnterScore1Servlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Teacher tea = (Teacher)request.getSession().getAttribute("teacher");
        CourseDAO cdao = new CourseDAO();

        try{
            ArrayList courses = cdao.getCourseByTeano(tea.getTeano());//获取教师开设的所有课程，方便教师选择课程进行成绩录入
            if(courses.size()!=0){
                request.setAttribute("courses",courses);
            }
            RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/teacher/tea_enterscore1.jsp");
            dispatcher.forward(request, response); //内部跳转，将处理信息存储在request中
        }catch(Exception ex){	ex.printStackTrace();}
    }
}