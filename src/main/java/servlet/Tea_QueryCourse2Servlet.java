package servlet;

import dao.ScoreDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class Tea_QueryCourse2Servlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String courseno = request.getParameter("courseno");
        ScoreDAO sdao = new ScoreDAO();

        try{
            ArrayList scores = sdao.getScoreByCourseno(courseno);//获取所选课程的考试信息
            if(scores.size()==0){
                request.getSession().setAttribute("msg7", "对不起,暂无学生选修该门课程！");
            }
            else{
                request.setAttribute("msg7", null);
                request.setAttribute("scores", scores);
            }
            request.getRequestDispatcher("/jsp/teacher/tea_querycourse2.jsp").forward(request, response);//内部跳转
        }catch(Exception ex){	ex.printStackTrace();}
    }
}