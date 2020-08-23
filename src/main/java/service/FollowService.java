package service;

import dao.FollowDao;
import user.Follow;
import user.User;

public class FollowService {

    public void addFollow(String currentUser, String userToFollow){
        FollowDao followDao = new FollowDao();
        followDao.createFollow(currentUser, userToFollow);

    }

    public void unFollow(String currentUser, String userToUnFollow){
        FollowDao followDao = new FollowDao();
        followDao.destroyFollow(currentUser, userToUnFollow);

    }



}
