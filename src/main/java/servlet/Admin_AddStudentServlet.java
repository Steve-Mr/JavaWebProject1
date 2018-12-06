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
            request.setAttribute("erMsg1","请检查学生信息");
        }
        else{
            StudentDAO sdao = new StudentDAO();
            String checkName="";
            try{
                Student stu = sdao.getStudentByStuno(stuno);
                checkName = stu.getStuname();
            }catch (Exception ex){
                ex.printStackTrace();
            }
            if(!checkName.equals("")){
                request.setAttribute("erMsg1","请检查学生信息");
            }
            else {
                try {
                    sdao.insertStudent(stuno, stupwd, stuname, stusex);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                request.setAttribute("okayMsg1", "学生添加成功");
            }
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/admin/admin_addstudent.jsp");
        dispatcher.forward(request, response);

    }
}
