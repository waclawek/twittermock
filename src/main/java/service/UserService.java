package service;

import dao.UserDao;
import infrastructure.passwordMenagment.PasswordHash;
import infrastructure.passwordMenagment.PasswordHashing;
import user.Follow;
import user.User;

import java.util.List;
import java.util.Set;

public class UserService {

    public void addUser(String userName, String password){
        UserDao userDao = new UserDao();
        if(userDao.read(userName) != null){
            return;
        }
        PasswordHash passwordHash = new PasswordHashing();
        String newPassword = passwordHash.passwordHash(password);
        User user = new User(userName, newPassword);
        userDao.save(user);
    }

    public User getUser(String username){
        UserDao userDao = new UserDao();
        return userDao.read(username);
    }

    public boolean authenticate(String userName, String password){
        UserDao userDao = new UserDao();
        User user = userDao.read(userName);
        if(user == null){
            return false;
        }else {
            PasswordHash passwordHash = new PasswordHashing();
            String newPassword = passwordHash.passwordHash(password);
            if(user.getPassword().equals(newPassword)){
                return true;
            }else {
                return false;
            }
        }
    }

    /**
     * returns Set of followees of provided user
     * @param userName
     * @return
     */
    public Set<Follow> getFollowees(String userName) {
        UserDao userDao = new UserDao();
        User user = userDao.read(userName);
        return user.getFollowees();
    }

    public List<User> getUsers(){
        UserDao userDao = new UserDao();
        return userDao.getAllUsers();
    }

}
