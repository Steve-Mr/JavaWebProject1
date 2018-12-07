package servlet;

import dao.StudentDAO;
import vo.Student;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Admin_QueryStudentServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        StudentDAO sdao = new StudentDAO();
        String stuno = (String)request.getParameter("stuno");
        System.out.println(stuno);

        if(stuno.equals("")){ //学号输入不能为空
            request.setAttribute("erMsg1","请检查输入内容");
        }
        else {
            try {
                    Student stu = sdao.getStudentByStuno(stuno);
                    if (stu==null) { //数据库中无此条记录
                      request.setAttribute("erMsg1", "未检索到结果，请检查输入内容");
                    } else {
                        request.setAttribute("selectedstudent", stu);

                    }
                }catch (Exception e) {
                    e.printStackTrace();
                }
            }
        RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/admin/admin_querystudent.jsp");
        dispatcher.forward(request, response); //内部跳转，将处理信息存储在request中
        }
}
