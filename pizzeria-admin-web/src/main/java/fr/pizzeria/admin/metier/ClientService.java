package fr.pizzeria.admin.metier;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.pizzeria.model.Client;
import fr.pizzeria.model.Livreur;

@Stateless
public class ClientService {

	@PersistenceContext
	protected EntityManager em;

	public List<Client> findAll() {
		return em.createQuery("select c from Client c", Client.class).getResultList();
	}

	public Client findOneClient(String email) {
		return em.createQuery("select c from Client c where c.email=:email", Client.class)
				.setParameter("email", email).getSingleResult();
	}
	
	public Client findOneClientById(String id) {
		return em.createQuery("select c from Client c where c.id=:id", Client.class)
				.setParameter("id", Integer.parseInt(id)).getSingleResult();
	}

	public void updateClient(String oldEmail, Client clientAvecId) {
		Client oldClient = findOneClient(oldEmail);
		oldClient = clientAvecId;
		em.merge(oldClient);
	}

	public void saveClient(Client clientSansId) {
		em.persist(clientSansId);
	}

	public void deleteClient(String email) {
		Client c = findOneClient(email);
		if (c != null) {
			em.remove(c);
		}
	}
	public void hardDeleteClients() {
		List<Client>clients= em.createQuery("select c from Client c where  actif = false", Client.class).getResultList();
				for (Client client : clients) {
					System.out.println("client : "+client.getPrenom()+" "+ client.getNom());
					em.remove(client);
				}
	}
	public void setEm(EntityManager em2) {
		this.em = em2;
	}

	public List<Client> isEmailTaken(String email) {
		return em.createQuery("select c from Client c where c.email=:email and actif = true", Client.class)
				.setParameter("email", email).getResultList();
	}
}
