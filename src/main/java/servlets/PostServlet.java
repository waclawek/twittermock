package servlets;

import dao.UserDao;
import post.Post;
import service.PostService;
import service.ServiceProvider;
import service.UserService;
import user.Follow;
import user.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@WebServlet("/post")
public class PostServlet extends HttpServlet {

    private PostService postService = ServiceProvider.getPostService();
    private UserService userService = ServiceProvider.getUserService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String content = request.getParameter("content");
        String username = (String) request.getSession().getAttribute("username");
        postService.addPost(content, username);
        response.sendRedirect("/post");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Post> postList = postService.findAll();
        request.setAttribute("posts", postList);
        String userName = (String) request.getSession().getAttribute("username");
        //set of followees of current user (users which current user follows)
        Set<Follow> followees = userService.getFollowees(userName);
        //change to stream
        Set<String> usernameOfFollowees = new HashSet<>();
        for (Follow follow : followees){
            usernameOfFollowees.add(follow.getFollowee().getUserName());
        }
        request.setAttribute("followees", usernameOfFollowees);
        List<User> users = userService.getUsers();
        request.setAttribute("users", users);

        RequestDispatcher dispatcher = request.getRequestDispatcher("post.jsp");
        dispatcher.forward(request,response);




    }
}
