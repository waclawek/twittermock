package servlets;

import service.FollowService;
import service.ServiceProvider;
import service.UserService;
import user.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/follow"}, name = "follow")
public class FollowServlet extends HttpServlet {

    UserService userService = ServiceProvider.getUserService();
    FollowService followService = ServiceProvider.getFollowService();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String usernameToFollow = req.getParameter("follow");
        String currentUser = (String) req.getSession().getAttribute("username");
        followService.addFollow(currentUser, usernameToFollow);

        req.getRequestDispatcher("/post").forward(req, resp);


    }
}
