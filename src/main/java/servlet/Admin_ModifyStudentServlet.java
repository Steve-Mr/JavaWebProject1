package servlet;

import dao.StudentDAO;
import vo.Student;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Admin_ModifyStudentServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String numOfStu = request.getParameter("numOfStu");
        try {
            Student student = new StudentDAO().getStudentByStuno(numOfStu);
            request.setAttribute("selectedstudent",student);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/admin/admin_modifystudent.jsp");
            dispatcher.forward(request, response); //内部跳转，将处理信息存储在request中
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {

            //String operate = request.getParameter("submit");//教师所选操作：“暂存”或者“提交”
            String stuno = request.getParameter("stuno");
            //System.out.println(stuno);

            String stupwd = request.getParameter("stupwd");
            //System.out.println(stupwd);

            String stuname = request.getParameter("stuname");
            //System.out.println(stuname);

            String stusex = request.getParameter("stusex");
            //System.out.println(stusex);

            if(stupwd.equals("")||stuname.equals("")||stusex.equals("")){
                request.setAttribute("erMsg1","请检查学生信息");
            }else {
                Student student = new Student();
                student.setStuno(stuno);
                student.setPassword(stupwd);
                student.setStuname(stuname);
                student.setStusex(stusex);
                StudentDAO sdao = new StudentDAO();
                sdao.modifyStudent(student, stuno);
                request.setAttribute("okayMsg1", "学生修改成功");

            }
            RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/admin/admin_modifystudent.jsp");
            dispatcher.forward(request, response); //内部跳转，将处理信息存储在request中

            }catch (Exception e){
            e.printStackTrace();
        }
    }
}
