package service;

import dao.PostDao;
import dao.UserDao;
import post.Post;
import user.User;

import java.time.Instant;
import java.util.List;

public class PostService {

    public List<Post> findAll(){
        PostDao postDao = new PostDao();
        return postDao.getAllPosts();
    }

    public int addPost(String content, String userName){
        UserDao userDao = new UserDao();
        User user = userDao.read(userName);
        Post post = new Post(content, user, Instant.now());
        PostDao postDao = new PostDao();
        return postDao.save(post);
    }

    public void deletePost(int postId) {
        PostDao postDao = new PostDao();
        postDao.deletePost(postId);
    }
}
