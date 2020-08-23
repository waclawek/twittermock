package servlets;

import service.FollowService;
import service.ServiceProvider;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/unfollow"}, name = "unfollow")
public class UnFollowServlet extends HttpServlet {

    FollowService followService = ServiceProvider.getFollowService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String usernameToFollow = req.getParameter("unfollow");
        String currentUser = (String) req.getSession().getAttribute("username");
        followService.unFollow(currentUser, usernameToFollow);

        req.getRequestDispatcher("/post").forward(req, resp);


    }
}
