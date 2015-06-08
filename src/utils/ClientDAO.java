package utils;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

import beans.Client;

public class ClientDAO implements IClientDAO {

	@PersistenceContext
	private EntityManager em;
	public EntityManager getEm() {
		return em;
	}
	public void setEm(EntityManager em) {
		this.em = em;
	}
	
	@Transactional
	public List<Client> findAll() {
		return em.createQuery("from Client", Client.class).getResultList();
	}
	@Transactional
	public Client findById(int id) {
		return em.find(Client.class, id);
	}
	@Transactional
	public Client save(Client client) {
		if (client.getId() > 0 ) {
			client = em.merge(client);
		}
		else {
			em.persist(client);
		}
		
		return client;
	}
	
	
}
