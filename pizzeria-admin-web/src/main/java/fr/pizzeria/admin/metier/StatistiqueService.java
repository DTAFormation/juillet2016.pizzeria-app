package fr.pizzeria.admin.metier;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.pizzeria.model.Client;

@Stateless
public class StatistiqueService {

	@PersistenceContext
	protected EntityManager em;

	public void setEm(EntityManager em2) {
		this.em = em2;
	}

	public List<Client> findAll() {
		return em.createQuery("SELECT p.*, SUM(c.quantite) FROM pizza p LEFT JOIN commande_pizza c ON p.id = c.pizzaId GROUP BY c.pizzaId ORDER BY SUM(c.quantite) DESC", Client.class).getResultList();
	}

}

// SELECT c.*, AVG(SUM(cp.quantite * p.prix)) FROM client c LEFT JOIN commande cd ON c.id = cd.client_id LEFT JOIN commande_pizza cp ON cd.id = cp.commandeId LEFT JOIN pizza p ON cp.pizzaId = p.id GROUP BY c.id