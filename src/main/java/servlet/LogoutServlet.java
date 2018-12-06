package servlet;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LogoutServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        /*销毁所有session，跳转回登录界面*/
        response.setHeader("Cache-Control","no-cache");
        request.getSession().invalidate();
        Cookie[] cookies;
        cookies = request.getCookies();
        if( cookies != null ){
            for (Cookie cookie:cookies){
                cookie.setMaxAge(0);
                response.addCookie(cookie);
            }
        }
        response.sendRedirect("/index.jsp");
    }
}
