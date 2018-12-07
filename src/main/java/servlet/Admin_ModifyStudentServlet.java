package servlet;

import dao.StudentDAO;
import vo.Student;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//todo : modify student
public class Admin_ModifyStudentServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String numOfStu = request.getParameter("numOfStu");
        try {
            Student student = new StudentDAO().getStudentByStuno(numOfStu);
            request.setAttribute("selectedstudent",student);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/admin/admin_modifystudent.jsp");
            dispatcher.forward(request, response); //内部跳转，将处理信息存储在request中
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {

            //String operate = request.getParameter("submit");//教师所选操作：“暂存”或者“提交”
            String stuno = request.getParameter("stuno");//选修该门课程的所有学生的学号
            System.out.println(stuno);

            String stupwd = request.getParameter("stupwd");//该门课程的课程号
            System.out.println(stupwd);

            String stuname = request.getParameter("stuname");//教师录入的分数
            System.out.println(stuname);

            String stusex = request.getParameter("stusex");//教师录入的分数
            System.out.println(stusex);

            Student student = new Student();
            student.setStuno(stuno);
            student.setPassword(stupwd);
            student.setStuname(stuname);
            student.setStusex(stusex);
            StudentDAO sdao = new StudentDAO();
            sdao.modifyStudent(student, stuno);

            RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/admin/admin_modifystudent.jsp");
            dispatcher.forward(request, response); //内部跳转，将处理信息存储在request中
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
