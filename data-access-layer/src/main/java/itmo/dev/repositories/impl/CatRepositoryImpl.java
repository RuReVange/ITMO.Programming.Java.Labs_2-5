package itmo.dev.repositories.impl;

import itmo.dev.models.Cat;
import itmo.dev.repositories.InitHibernate;
import itmo.dev.repositories.interfaces.CatRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class CatRepositoryImpl implements CatRepository {

    private final SessionFactory sessionFactory;

    public CatRepositoryImpl() {

        sessionFactory = InitHibernate.getSessionFactory();
    }

    @Override
    public void save(Cat entity) {

        try(Session session = sessionFactory.openSession()){
        session.beginTransaction();
        session.persist(entity);
        session.getTransaction().commit();
        }
    }

    @Override
    public Cat findById(Integer id) {

        Session session = sessionFactory.openSession();
        Cat result = session.get(Cat.class, id);
        session.close();

        return result;
    }

    @Override
    public List<Cat> findAll() {

        Session session = sessionFactory.openSession();
        List<Cat> result = session.createQuery("from Cat", Cat.class).list();
        session.close();

        return result;
    }

    @Override
    public Cat update(Cat entity) {

        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.merge(entity);

        Cat result = session.get(Cat.class, entity.getId());
        session.getTransaction().commit();
        session.close();

        return result;
    }

    @Override
    public void delete(Cat entity) {

        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.remove(entity);
        session.getTransaction().commit();
        session.close();
    }
}
