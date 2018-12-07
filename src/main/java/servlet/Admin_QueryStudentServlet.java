package servlet;

import dao.StudentDAO;
import vo.Student;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class Admin_QueryStudentServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //HttpSession session = request.getSession();
        StudentDAO sdao = new StudentDAO();
        String stuno = (String)request.getParameter("stuno");
        try{
            Student stu = sdao.getStudentByStuno(stuno);
            request.setAttribute("selectedstudent",stu);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/admin/admin_querystudent.jsp");
            dispatcher.forward(request, response); //内部跳转，将处理信息存储在request中
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
