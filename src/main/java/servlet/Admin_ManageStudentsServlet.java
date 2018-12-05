package servlet;

import dao.StudentDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

public class Admin_ManageStudentsServlet extends HttpServlet {

    public void doGet(HttpServletRequest request,HttpServletResponse response)
        throws ServletException, IOException{
        int countPerPage = 5;
        HttpSession session = request.getSession();
        String pageIndex = request.getParameter("pageIndex");
        if(pageIndex == null){
            pageIndex = "1";
        }
        int currentPageIndex = Integer.parseInt(pageIndex);
        StudentDAO sdao = new StudentDAO();
        int studentCount = sdao.getStudentCount();
        ArrayList pageStudents = sdao.queryPage(currentPageIndex,countPerPage);
        int pageCount;
        if(studentCount % countPerPage == 0){
            pageCount = studentCount/countPerPage;
        }
        else {
            pageCount = studentCount/countPerPage+1;
        }
        session.setAttribute("studentCount", new Integer(studentCount));
        session.setAttribute("pageCount", new Integer(pageCount));
        session.setAttribute("pageStudents",pageStudents);
        session.setAttribute("currentPageIndex",pageIndex);
        RequestDispatcher rd = request.getRequestDispatcher("/jsp/admin/admin_manageStudents.jsp");
        rd.forward(request,response);
    }
}
