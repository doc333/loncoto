package utils;

import java.util.List;

import beans.Client;

public interface IClientDAO {
	public List<Client> findAll();
	public Client findById(int id);
	public Client save(Client client);
}
