package servlet;

import dao.ScoreDAO;
import vo.Student;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class Stu_QueryScoreServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Student stu = (Student)request.getSession().getAttribute("student");
        ScoreDAO sdao = new ScoreDAO();

        try{
            ArrayList score = sdao.getScoreByStuno(stu.getStuno());//获取该生的考试信息
            if(score==null){
                request.setAttribute("msg3", "对不起,您还没有选课！");
            }
            else{
                request.setAttribute("msg3", null);
                request.setAttribute("score", score);
            }
            RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/student/stu_queryscore.jsp");
            dispatcher.forward(request, response); //内部跳转，将处理信息存储在request中
        }catch(Exception ex){	ex.printStackTrace();}
    }

}
