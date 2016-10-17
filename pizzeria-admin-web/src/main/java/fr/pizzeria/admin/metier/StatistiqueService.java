package fr.pizzeria.admin.metier;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.pizzeria.admin.metier.model.ClientCommandes;
import fr.pizzeria.admin.metier.model.LivreurCommandes;
import fr.pizzeria.admin.metier.model.PizzaVentes;

@Stateless
public class StatistiqueService {

	@PersistenceContext
	protected EntityManager em;

	public void setEm(EntityManager em2) {
		this.em = em2;
	}

	public List<PizzaVentes> findPizzasParVentes() {
		return em.createQuery("SELECT new fr.pizzeria.admin.metier.model.PizzaVentes(p, SUM(c.quantite)) from Pizza p, CommandePizza c where c.pizzaId = p.id GROUP BY c.pizzaId ORDER BY SUM(c.quantite) DESC", fr.pizzeria.admin.metier.model.PizzaVentes.class).getResultList();
	}
	
	public List<ClientCommandes> findClientsParCommandes() {
		List<ClientCommandes> listeCommandes =  em.createQuery("SELECT new fr.pizzeria.admin.metier.model.ClientCommandes(c, SUM(cp.quantite * p.prix)) FROM Client c, Commande cd, CommandePizza cp, Pizza p WHERE c.id = cd.client.id AND cd.id = cp.commandeId AND cp.pizza.id = p.id GROUP BY c.id, cd.id", fr.pizzeria.admin.metier.model.ClientCommandes.class).getResultList();
		List<ClientCommandes> valeursMoyennes = new ArrayList<>();
		//for(ClientCommandes item : listeCommandes) {
			
		//}
		return listeCommandes;
	}
	//List<ClientCommandes> listeCommandes =  em.createQuery("SELECT c, SUM(cp.quantite * p.prix) as val_com FROM Client c LEFT JOIN Commande cd ON c.id = cd.clientId LEFT JOIN commandePizza cp ON cd.id = cp.commandeId LEFT JOIN pizza p ON cp.pizza_id = p.id GROUP BY c.id, cd.id", fr.pizzeria.admin.metier.model.ClientCommandes.class).getResultList();
	//List<ClientCommandes> listeCommandes =  em.createQuery("SELECT new fr.pizzeria.admin.metier.model.ClientCommandes(c, SUM(cp.quantite * p.prix)) FROM Client c, Commande cd WHERE c.id = cd.client.id, CommandePizza cp WHERE cd.id = cp.commandeId, Pizza p WHERE cp.pizza_id = p.id GROUP BY c.id, cd.id", fr.pizzeria.admin.metier.model.ClientCommandes.class).getResultList();
	
	
	public List<LivreurCommandes> findLivreursParCommandes() {
		return em.createQuery("SELECT new fr.pizzeria.admin.metier.model.LivreurCommandes(l, COUNT(c.id)) FROM Livreur l, Commande c WHERE l.id = c.livreur.id GROUP BY l.id", fr.pizzeria.admin.metier.model.LivreurCommandes.class).getResultList();
	}

}
