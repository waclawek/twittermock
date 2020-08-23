package servlets;

import service.PostService;
import service.ServiceProvider;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns="/authentication", name="Authentication")
public class AuthenticationServlet extends HttpServlet {

    private UserService userService = ServiceProvider.getUserService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (!userService.authenticate(username, password)) {
            response.sendRedirect("error.jsp");
            return;
        }

        HttpSession session = request.getSession();
        session.setAttribute("username", username);
        response.sendRedirect("/post");

    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
