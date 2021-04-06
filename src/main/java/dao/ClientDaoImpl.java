package dao;

import model.Client;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import util.HibernateUtil;

import java.util.List;

public class ClientDaoImpl implements ClientDao {
    Logger logger = Logger.getLogger(ClientDaoImpl.class);

    public void save(Client client) {
        logger.debug(String.format("save. client{id=%d, email=%s, phone = %d}",
                client.getId(), client.getEmail(), client.getPhone()));
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(client);
        transaction.commit();
        session.close();
    }

    public Client getById(long id) {
        logger.debug(String.format("getById. client{id=%d}", id));
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        return session.byId(Client.class).getReference(id);
    }

    public void update(Client client) {
        logger.debug(String.format("update. client{id=%d, email=%s, phone = %d}",
                client.getId(), client.getEmail(), client.getPhone()));
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Client updatedClient = session.getReference(Client.class, client.getId());
        session.getTransaction().begin();
        updatedClient.setName(client.getName());
        updatedClient.setEmail(client.getEmail());
        updatedClient.setPhone(client.getPhone());
        updatedClient.setAbout(client.getAbout());
        updatedClient.setAge(client.getAge());
        session.getTransaction().commit();
        session.close();
    }

    public void delete(Client client) {
        logger.debug(String.format("delete. client{id=%d, email=%s, phone = %d}",
                client.getId(), client.getEmail(), client.getPhone()));
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(client);
        transaction.commit();
        session.close();
    }

    public List<Client> searchClientByPhoneNumber(long phone) {
        logger.debug(String.format("searchClientByPhoneNumber. client{phone=%d}", phone));
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        return (List<Client>) session.createQuery("FROM model.Client WHERE phone = :phone")
                .setParameter("phone", phone).list();
    }
}
