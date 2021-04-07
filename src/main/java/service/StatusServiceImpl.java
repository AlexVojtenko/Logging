package service;

import dao.StatusDao;
import dao.StatusDaoImpl;
import model.Status;
import org.apache.log4j.Logger;

public class StatusServiceImpl implements StatusService {

    Logger logger = Logger.getLogger(StatusServiceImpl.class);

    public void save(Status status) {
        logger.debug(status.toString());
        StatusDao statusDao = new StatusDaoImpl();
        statusDao.save(status);
    }

    public Status getByID(long id) {
        logger.debug(String.format("Status with id = %d}", id));
        StatusDao statusDao = new StatusDaoImpl();
        return statusDao.getById(id);
    }

    public void update(Status status) {
        logger.debug(status.toString());
        StatusDao statusDao = new StatusDaoImpl();
        statusDao.update(status);
    }

    public void delete(Status status) {
        logger.debug(status.toString());
        StatusDao statusDao = new StatusDaoImpl();
        statusDao.delete(status);
    }
}
