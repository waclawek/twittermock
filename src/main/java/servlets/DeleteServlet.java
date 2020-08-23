package servlets;

import service.PostService;
import service.ServiceProvider;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/deletePost"}, name = "deletePost")
public class DeleteServlet extends HttpServlet {

    PostService postService = ServiceProvider.getPostService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int postId = Integer.parseInt(req.getParameter("delete"));
        postService.deletePost(postId);
        req.getRequestDispatcher("/post").forward(req, resp);
    }
}
