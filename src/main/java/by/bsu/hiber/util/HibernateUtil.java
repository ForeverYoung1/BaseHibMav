package by.bsu.hiber.util;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static final SessionFactory sessionFactory;
private static  Session session;

    static {
        try {
//            Configuration aconf = new AnnotationConfiguration()
//                    .addAnnotatedClass(by.bsu.hib.entity.Course.class)
//                    .addAnnotatedClass(by.bsu.hib.entity.Student.class);
//
//            aconf.configure();
//            sessionFactory = aconf.buildSessionFactory();
            //SessionFactory factory = new Configuration().configure().buildSessionFactory();
//            Session session = factory.openSession();

           sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
        } catch (Throwable e) {
            System.err.println("Initial SessionFactory creation failed. " + e);
            throw new ExceptionInInitializerError(e);
        }
    }

//    public static Session getSession() {
//        return session;
//    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;

    }



}
