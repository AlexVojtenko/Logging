package service;

import dao.ClientDao;
import dao.ClientDaoImpl;
import model.Client;
import org.apache.log4j.Logger;

import java.util.List;

public class ClientServiceImpl implements ClientService {

    Logger logger = Logger.getLogger(ClientServiceImpl.class);

    public void save(Client client) {
        logger.debug(client.toString());
        ClientDao clientDao = new ClientDaoImpl();
        clientDao.save(client);
    }

    public Client getByID(long id) {
        logger.debug(String.format("Client with id = %d}", id));
        ClientDao clientDao = new ClientDaoImpl();
        return clientDao.getById(id);
    }

    public void update(Client client) {
        logger.debug(client.toString());
        ClientDao clientDao = new ClientDaoImpl();
        clientDao.update(client);
    }

    public void delete(Client client) {
        logger.debug(client.toString());
        ClientDao clientDao = new ClientDaoImpl();
        clientDao.delete(client);
    }

    public List<Client> searchClientByPhoneNumber(long phone) {
        logger.debug(String.format("Client with phone = %d}", phone));
        ClientDao clientDao = new ClientDaoImpl();
        return clientDao.searchClientByPhoneNumber(phone);
    }
}
