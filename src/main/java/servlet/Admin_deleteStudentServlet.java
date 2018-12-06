package servlet;

import dao.StudentDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Admin_deleteStudentServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String numOfStu = request.getParameter("numOfStu");
        try{
            StudentDAO sdao = new StudentDAO();
            sdao.deleteStudent(numOfStu);
            RequestDispatcher rd = request.getRequestDispatcher("/jsp/admin/admin_deleteStudent.jsp");
            rd.forward(request,response);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
