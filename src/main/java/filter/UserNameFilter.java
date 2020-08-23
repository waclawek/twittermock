package filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(urlPatterns = {"/post"})
public class UserNameFilter extends HttpFilter {

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        String userName = (String) req.getSession().getAttribute("username");
        if(userName == null || userName.isEmpty() || userName.isBlank()){
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("error.jsp");
            requestDispatcher.forward(req, res);
        }
        chain.doFilter(req, res);
    }




}
