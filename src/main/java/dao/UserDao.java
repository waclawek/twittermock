package dao;

import configuration.HibernateConfig;
import org.hibernate.Session;
import org.hibernate.Transaction;
import post.Post;
import user.User;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class UserDao {

    private Session session;

    public User read(String userName) {
        session = HibernateConfig.getSessionFactory().openSession();
        User user = session.get(User.class, userName);
        session.detach(user);
        session.close();
        return user;
    }

    public String save(User user) {
        session = HibernateConfig.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        String name = (String) session.save(user);
        transaction.commit();
        session.close();
        return name;

    }

    public List<User> getAllUsers(){
        session = HibernateConfig.getSessionFactory().openSession();
        List<User> userList = loadAllData(User.class, session);
        session.close();
        return userList;

    }

    private static <T> List<T> loadAllData(Class<T> type, Session session) {
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<T> criteria = builder.createQuery(type);
        criteria.from(type);
        List<T> data = session.createQuery(criteria).getResultList();
        return data;
    }


}
