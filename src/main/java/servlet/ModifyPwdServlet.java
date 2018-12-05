package servlet;

import dao.AdminDAO;
import dao.StudentDAO;
import dao.TeacherDAO;
import vo.Admin;
import vo.Student;
import vo.Teacher;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ModifyPwdServlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String type = request.getSession().getAttribute("type").toString();
        String oldPassword = request.getParameter("oldPassword");
        String newPassword1 = request.getParameter("newPassword1");
        String newPassword2 = request.getParameter("newPassword2");

        /*1.信息填写要完整*/
        if(oldPassword.equals("") || newPassword1.equals("") || newPassword2.equals("")){
            request.setAttribute("msg9", "请将信息填写完整");
        }
        /*2.新密码和密码确认要一致*/
        else if(!newPassword1.equals(newPassword2)){
            request.setAttribute("msg9", "密码确认不一致");
        }
        /*3.旧密码填写要正确*/
        else{
            if(type.equals("学生")){
                Student stu = (Student)request.getSession().getAttribute("student");
                if(!oldPassword.equals(stu.getPassword())){
                    request.setAttribute("msg9", "请输入正确的旧密码");
                }
                else{
                    StudentDAO sdao = new StudentDAO();
                    stu.setPassword(newPassword1);
                    try{
                        sdao.updateStudent(stu);
                    }catch(Exception ex){	ex.printStackTrace();}
                    request.setAttribute("okMsg9", "密码修改成功！ （为了保证您的帐号安全，建议重新登录！！）");
                }
            }
            else if(type.equals("教师")){
                Teacher tea = (Teacher)request.getSession().getAttribute("teacher");
                if(!oldPassword.equals(tea.getPassword())){
                    request.setAttribute("msg9", "请输入正确的旧密码");
                }
                else{
                    TeacherDAO tdao = new TeacherDAO();
                    tea.setPassword(newPassword1);
                    try{
                        tdao.updateTeacher(tea);
                    }catch(Exception ex){	ex.printStackTrace();}
                    request.setAttribute("okMsg9", "密码修改成功！ （为了保证您的帐号安全，建议重新登录！！）");
                }
            }
            else if(type.equals("管理员")){
                Admin admin = (Admin)request.getSession().getAttribute("admin");
                if(!oldPassword.equals(admin.getPassword())){
                    request.setAttribute("msg9", "请输入正确的旧密码");
                }
                else{
                    AdminDAO adao = new AdminDAO();
                    admin.setPassword(newPassword1);
                    try{
                        adao.updateAdmin(admin);
                    }catch(Exception ex){
                        ex.printStackTrace();
                    }
                    request.setAttribute("okMsg9", "密码修改成功！ （为了保证您的帐号安全，建议重新登录！！）");
                }
            }
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/modifyPwd.jsp");
        dispatcher.forward(request, response);//内部跳转
    }
}
