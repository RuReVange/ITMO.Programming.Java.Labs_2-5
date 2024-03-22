package itmo.dev.repositories.impl;

import itmo.dev.models.Cat;
import itmo.dev.models.Owner;
import itmo.dev.repositories.InitHibernate;
import itmo.dev.repositories.interfaces.OwnerRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class OwnerRepositoryImpl implements OwnerRepository {

    private final SessionFactory sessionFactory;

    public OwnerRepositoryImpl() {

        sessionFactory = InitHibernate.getSessionFactory();
    }

    @Override
    public void save(Owner entity) {

        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.persist(entity);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public Owner findById(Integer id) {

        Session session = sessionFactory.openSession();
        Owner result = session.get(Owner.class, id);
        session.close();

        return result;
    }

    @Override
    public List<Owner> findAll() {

        Session session = sessionFactory.openSession();
        List<Owner> result = session.createQuery("from Owner", Owner.class).list();
        session.close();

        return result;
    }

    @Override
    public Owner update(Owner entity) {

        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.merge(entity);

        Owner result = session.get(Owner.class, entity.getId());
        session.getTransaction().commit();
        session.close();

        return result;
    }

    @Override
    public void delete(Owner entity) {

        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.remove(entity);
        session.getTransaction().commit();
        session.close();
    }
}
