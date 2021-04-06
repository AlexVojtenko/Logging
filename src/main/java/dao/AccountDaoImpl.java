package dao;

import model.Account;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class AccountDaoImpl implements AccountDao {

    Logger logger = Logger.getLogger(AccountDaoImpl.class);

    public void save(Account account) {
        logger.debug(String.format("save. account{id=%d, client_id=%d, number = %s}",
                account.getId(), account.getClientId(), account.getNumber()));
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(account);
        transaction.commit();
        session.close();
    }

    public Account getById(long id) {
        logger.debug(String.format("getById. account{id=%d}", id));
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        return session.byId(Account.class).getReference(id);
    }

    public void update(Account account) {
        logger.debug(String.format("update. account{id=%d, client_id=%d, number = %s}",
                account.getId(), account.getClientId(), account.getNumber()));
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Account updatedAccount = session.getReference(Account.class, account.getId());
        session.getTransaction().begin();
        updatedAccount.setClientId(account.getClientId());
        updatedAccount.setNumber(account.getNumber());
        updatedAccount.setValue(account.getValue());
        session.getTransaction().commit();
        session.close();
    }

    public void delete(Account account) {
        logger.debug(String.format("delete. account{id=%d, client_id=%d, number = %s}",
                account.getId(), account.getClientId(), account.getNumber()));
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(account);
        transaction.commit();
        session.close();
    }
}
