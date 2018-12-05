package filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class SessionCheckFilter implements Filter {


    public void init(FilterConfig filterConfig) throws ServletException {	}


    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        HttpServletResponse response = (HttpServletResponse)servletResponse;
        HttpSession session = request.getSession();
        if (session.getAttribute("type") == null) {
            response.sendRedirect("/index.jsp");
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    public void destroy() {	}
}