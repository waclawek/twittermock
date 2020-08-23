package configuration;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import post.Post;
import user.Follow;
import user.User;

public class HibernateConfig {

    private static SessionFactory sessionFactory;


    public static SessionFactory getSessionFactory(){
        if(sessionFactory == null){
            Configuration configuration = new Configuration().configure();
            configuration.addAnnotatedClass(User.class);
            configuration.addAnnotatedClass(Post.class);
            configuration.addAnnotatedClass(Follow.class);
            sessionFactory = configuration.buildSessionFactory();
        }
        return sessionFactory;
    }

    public static void shutDown(){
        if(sessionFactory != null){
            sessionFactory.close();
        }
    }
}
