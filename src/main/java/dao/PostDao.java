package dao;

import configuration.HibernateConfig;
import org.hibernate.Session;
import org.hibernate.Transaction;
import post.Post;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class PostDao {

    private Session session;

    public int save(Post post) {
        session = HibernateConfig.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        int id = (int) session.save(post);
        transaction.commit();
        session.close();
        return id;
    }

    public List<Post> getAllPosts() {
        session = HibernateConfig.getSessionFactory().openSession();
        List<Post> postList = loadAllData(Post.class, session);
        session.close();
        return postList;

    }

    private static <T> List<T> loadAllData(Class<T> type, Session session) {
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<T> criteria = builder.createQuery(type);
        criteria.from(type);
        List<T> data = session.createQuery(criteria).getResultList();
        return data;
    }

    public void deletePost(int postId) {
        session = HibernateConfig.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Post post = session.get(Post.class, postId);
        session.delete(post);
        transaction.commit();
        session.close();
    }
}
