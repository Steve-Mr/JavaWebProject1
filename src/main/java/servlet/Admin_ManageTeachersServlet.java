package servlet;

import dao.StudentDAO;
import dao.TeacherDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

public class Admin_ManageTeachersServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int countPerPage = 5;
        HttpSession session = request.getSession();
        String pageIndex = request.getParameter("pageIndex");
        if(pageIndex == null){
            pageIndex = "1";
        }
        int currentPageIndex = Integer.parseInt(pageIndex);
        TeacherDAO tdao = new TeacherDAO();
        int teacherCount = tdao.getTeacherCount();
        ArrayList pageTeachers = tdao.queryPage(currentPageIndex,countPerPage);
        int pageCount;
        if(teacherCount % countPerPage == 0){
            pageCount = teacherCount/countPerPage;
        }
        else {
            pageCount = teacherCount/countPerPage+1;
        }
        session.setAttribute("teacherCount", new Integer(teacherCount));
        session.setAttribute("pageCount", new Integer(pageCount));
        session.setAttribute("pageTeachers",pageTeachers);
        session.setAttribute("currentPageIndex",pageIndex);
        RequestDispatcher rd = request.getRequestDispatcher("/jsp/admin/admin_manageTeachers.jsp");
        rd.forward(request,response);
    }
}
