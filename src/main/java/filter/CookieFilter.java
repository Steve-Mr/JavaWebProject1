package filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

//@WebFilter(filterName = "CookieFilter",urlPatterns = "/index.jsp")
public class CookieFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        chain.doFilter(request, response);

        HttpServletRequest servletRequest = (HttpServletRequest) request;
        HttpServletResponse servletResponse = (HttpServletResponse) response;
        Cookie[] cookies = servletRequest.getCookies();
        HttpSession session = servletRequest.getSession();
        String cookieAccount = null;
        String cookiePassword = null;
        String cookieType = null;
        if(cookies!=null){
            for (Cookie cookie : cookies) {
                if ("account".equals(cookie.getName())) {
                    cookieAccount = cookie.getValue(); // 得到cookie的用户名
                    System.out.println(cookieAccount);
                }
                if ("password".equals(cookie.getName())) {
                    cookiePassword = cookie.getValue(); // 得到cookie的密码
                    System.out.println(cookiePassword);
                }
                if ("type".equals(cookie.getName())) {
                    cookieType = cookie.getValue(); // 得到cookie的type
                    System.out.println(cookieType);
                }
            }
            if (cookieAccount != null && cookiePassword != null && cookieType != null) { // 如果存在
                    session.setAttribute("account",cookieAccount);
                    session.setAttribute("password",cookiePassword);
                    session.setAttribute("type",cookieType);
                    servletResponse.sendRedirect("/servlet/LoginServlet");
                    return;
                }
            }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}