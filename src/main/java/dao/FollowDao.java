package dao;

import configuration.HibernateConfig;
import org.hibernate.Session;
import org.hibernate.Transaction;
import post.Post;
import user.Follow;
import user.User;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.Set;
import java.util.stream.Collectors;

public class FollowDao {
    private Session session;

    public Set<Follow> getAllFollows(){
        session = HibernateConfig.getSessionFactory().openSession();
        Set<Follow> followSet = loadAllData(Follow.class, session);
        session.close();
        return followSet;

    }

    private static <T> Set<T> loadAllData(Class<T> type, Session session) {
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<T> criteria = builder.createQuery(type);
        criteria.from(type);
        Set<T> data = session.createQuery(criteria).getResultStream().collect(Collectors.toSet());
        return data;
    }

    public int createFollow(String currentUsername, String usernameToFollow) {
        session = HibernateConfig.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        User currentUser = session.get(User.class, currentUsername);
        User userToFollow = session.get(User.class, usernameToFollow);
        Follow follow = new Follow(currentUser, userToFollow);
        int id = (int) session.save(follow);
        transaction.commit();
        session.close();
        return id;

    }

    public void destroyFollow(String currentUsername, String usernameToUnFollow) {
        session = HibernateConfig.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        User currentUser = session.get(User.class, currentUsername);
        User userToUnFollow = session.get(User.class, usernameToUnFollow);

        Set<Follow> follows = loadAllData(Follow.class, session);
        for (Follow follow: follows) {
            if(follow.getFollower().equals(currentUser) && follow.getFollowee().equals(userToUnFollow)){
                session.remove(follow);
                //better try this under
                //by nie wciagac całego seta follow tylko pojedynczy
                //hql
                //criteria api
                //session.createQuery("")
            }
        }
        transaction.commit();
        session.close();
    }
}
