package itmo.dev.repositories;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class InitHibernate {

    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {

        if (sessionFactory == null) {
            try {

                Configuration configuration = new Configuration().configure();
                sessionFactory = configuration.buildSessionFactory();
            }
            catch (Exception e) {

                e.printStackTrace();
            }
        }
        return sessionFactory;
    }

    public static void shutdownSessionFactory() {

        if (sessionFactory != null) {
            sessionFactory.close();
        }
    }
}
