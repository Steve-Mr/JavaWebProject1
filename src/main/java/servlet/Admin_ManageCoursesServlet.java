package servlet;

import dao.CourseDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

//todo: check page2

public class Admin_ManageCoursesServlet extends HttpServlet {

    public void doGet(HttpServletRequest request,HttpServletResponse response)
            throws ServletException, IOException{
        int countPerPage = 5;
        HttpSession session = request.getSession();
        String pageIndex = request.getParameter("pageIndex");
        if(pageIndex == null){
            pageIndex = "1";
        }
        int currentPageIndex = Integer.parseInt(pageIndex);
        CourseDAO cdao = new CourseDAO();
        int courseCount = cdao.getCourseCount();
        ArrayList pageCourses = cdao.queryPage(currentPageIndex,countPerPage);
        int pageCount;
        if(courseCount % countPerPage == 0){
            pageCount = courseCount/countPerPage;
        }
        else {
            pageCount = courseCount/countPerPage+1;
        }
        session.setAttribute("courseCount", new Integer(courseCount));
        session.setAttribute("pageCount", new Integer(pageCount));
        session.setAttribute("pageCourses",pageCourses);
        session.setAttribute("currentPageIndex",pageIndex);
        RequestDispatcher rd = request.getRequestDispatcher("/jsp/admin/admin_manageCourses.jsp");
        rd.forward(request,response);
    }
}
