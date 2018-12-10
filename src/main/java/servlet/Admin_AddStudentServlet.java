package servlet;

import dao.StudentDAO;
import vo.Student;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Admin_AddStudentServlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{

        String stuno = request.getParameter("stuno");
        String stupwd = request.getParameter("stupwd");
        String stuname = request.getParameter("stuname");
        String stusex = request.getParameter("stusex");

        if(stuno.equals("")||stupwd.equals("")||stuname.equals("")||stusex.equals("")){
            request.setAttribute("erMsg1","输入信息不得为空，请检查学生信息");
        }
        else{
            StudentDAO sdao = new StudentDAO();
            try{
                Student stu = sdao.getStudentByStuno(stuno);
                if(stu!=null){
                    request.setAttribute("erMsg1","该学号已经存在，请检查学生信息");
                }
                else {
                    try {
                    sdao.insertStudent(stuno, stupwd, stuname, stusex);
                    } catch (Exception e) {
                    e.printStackTrace();
                    }
                    request.setAttribute("okayMsg1", "学生添加成功");
                }
            }catch (Exception ex){
                ex.printStackTrace();
            }
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/admin/admin_addstudent.jsp");
        dispatcher.forward(request, response);

    }
}
