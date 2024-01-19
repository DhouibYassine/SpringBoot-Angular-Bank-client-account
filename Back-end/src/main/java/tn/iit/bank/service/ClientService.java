package tn.iit.bank.service;

import org.springframework.stereotype.Service;
import tn.iit.bank.exception.ClienttNotFoundException;
import tn.iit.bank.model.Client;
import tn.iit.bank.repository.ClientDao;

import java.util.List;

@Service
public class ClientService {
	private ClientDao clientDao;

	public ClientService(ClientDao clientDao) {
		this.clientDao = clientDao;
	}

	public List<Client> findAll() {
		return clientDao.findAll();
	}

	public Client findById(String id) {
		return clientDao.findById(id).orElseThrow(() -> new ClienttNotFoundException(id));

	}

	public void save(Client clientToSave) {
		clientDao.save(clientToSave);
	}

	public void delete(String id) {
		clientDao.deleteById(id);
	}

	public void update(Client newClient, String id) {
		Client client = findById(id);
		client.setNom(newClient.getNom());
		client.setPrenom(newClient.getPrenom());
		clientDao.save(client);
	}
}
