package dao;

import model.Status;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class StatusDaoImpl implements StatusDao {
    Logger logger = Logger.getLogger(StatusDaoImpl.class);

    public void save(Status status) {
        logger.debug(String.format("save. status{id=%d, alias=%s}", status.getId(), status.getAlias()));
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(status);
        transaction.commit();
        session.close();
    }

    public Status getById(long id) {
        logger.debug(String.format("getById. status{id=%d}", id));
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        return session.byId(Status.class).getReference(id);
    }

    public void update(Status status) {
        logger.debug(String.format("update. status{id=%d, alias=%s}", status.getId(), status.getAlias()));
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Status updatedStatus = session.getReference(Status.class, status.getId());
        session.getTransaction().begin();
        updatedStatus.setAlias(status.getAlias());
        updatedStatus.setDescription(status.getDescription());
        session.getTransaction().commit();
        session.close();
    }

    public void delete(Status status) {
        logger.debug(String.format("update. status{id=%d, alias=%s}", status.getId(), status.getAlias()));
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(status);
        transaction.commit();
        session.close();
    }
}
