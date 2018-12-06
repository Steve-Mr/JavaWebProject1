package filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

//@WebFilter(filterName = "CookieFilter",urlPatterns = "/welcome.jsp")
public class CookieFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        chain.doFilter(request, response);

        HttpServletRequest servletRequest = (HttpServletRequest) request;
        HttpServletResponse servletResponse = (HttpServletResponse) response;
        Cookie[] cookies = servletRequest.getCookies();
        HttpSession session = servletRequest.getSession();
        String usernameCookie = null;
        String passwordCookie = null;
        String typeCookie = null;
        if(cookies!=null){
            for (Cookie cookie : cookies) {
                if ("account".equals(cookie.getName())) {
                    usernameCookie = cookie.getValue(); // 得到cookie的用户名
                    System.out.println(usernameCookie);
                }
                if ("password".equals(cookie.getName())) {
                    passwordCookie = cookie.getValue(); // 得到cookie的密码
                    System.out.println(passwordCookie);
                }
                if ("type".equals(cookie.getName())) {
                    typeCookie = cookie.getValue(); // 得到cookie的type
                    System.out.println(typeCookie);
                }
            }
            if (usernameCookie != null && passwordCookie != null && typeCookie != null) { // 如果存在
                if(typeCookie.equals("student")){
                    session.setAttribute("account",usernameCookie);
                    session.setAttribute("password",passwordCookie);
                    session.setAttribute("type",typeCookie);
                    servletResponse.sendRedirect("/servlet/LoginServlet");
                    return;
                }
                else if(typeCookie.equals("teacher")){
                    session.setAttribute("teano",usernameCookie);
                    session.setAttribute("teapwd",passwordCookie);
                    session.setAttribute("type",typeCookie);
                    servletResponse.sendRedirect("/servlet/LoginServlet");
                    return;
                }
            }
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}