package service;

import dao.AccountDao;
import dao.AccountDaoImpl;
import model.Account;
import org.apache.log4j.Logger;

public class AccountServiceImpl implements AccountService {

    Logger logger = Logger.getLogger(AccountServiceImpl.class);

    public void save(Account account) {
        logger.debug(account.toString());
        AccountDao accountDao = new AccountDaoImpl();
        accountDao.save(account);
    }

    public Account getByID(long id) {
        logger.debug(String.format("Account with id = %d}", id));
        AccountDao accountDao = new AccountDaoImpl();
        return accountDao.getById(id);
    }

    public void update(Account account) {
        logger.debug(account.toString());
        AccountDao accountDao = new AccountDaoImpl();
        accountDao.update(account);
    }

    public void delete(Account account) {
        logger.debug(account.toString());
        AccountDao accountDao = new AccountDaoImpl();
        accountDao.delete(account);
    }
}
