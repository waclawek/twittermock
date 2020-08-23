package service;

public class ServiceProvider {

    private static final PostService postService = new PostService();
    private static final UserService userService = new UserService();
    private static final FollowService followService = new FollowService();

    public static UserService getUserService(){
        return userService;
    }

    public static PostService getPostService(){
        return postService;
    }

    public static FollowService getFollowService() {return followService;}

}
