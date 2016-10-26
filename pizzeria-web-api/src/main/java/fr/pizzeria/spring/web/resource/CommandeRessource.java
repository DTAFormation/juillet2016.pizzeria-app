package fr.pizzeria.spring.web.resource;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.pizzeria.model.Client;
import fr.pizzeria.model.ClientCommande;
import fr.pizzeria.model.Commande;
import fr.pizzeria.model.Pizza;
import fr.pizzeria.model.PizzaCommande;
import fr.pizzeria.model.StatutCommande;
import fr.pizzeria.model.StatutCommandePaiement;
import fr.pizzeria.spring.web.repository.IClientRepository;
import fr.pizzeria.spring.web.repository.ICommandeRepository;
import fr.pizzeria.spring.web.repository.IPizzaRepository;

/**
 * Resource Client.
 */
@RestController
@RequestMapping("/commandes")
public class CommandeRessource {

	@Autowired
	private ICommandeRepository commandeDao;
	
	@Autowired
	private IClientRepository clientDao;
	
	@Autowired
	private IPizzaRepository pizzaDao;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Commande> listAllPizzas() {
		return commandeDao.findAll();
	}

	@RequestMapping(method = RequestMethod.POST)
	public void saveCommande(@RequestBody ClientCommande clientCommande , HttpServletResponse response) {
		
		
		// date
		DateFormat dateTodayCommande = new SimpleDateFormat("yyyyMMddHHmmss");
		Client client = clientDao.findOne(clientCommande.getIdClient());
		System.out.println(client);
		System.out.println(clientCommande.getPizzascom());
		String  numeroCommande = "COM"+ client.getId()+dateTodayCommande.format(new Date());
		Commande c1 = new Commande();
		commandeDao.save(c1);
		//c1 = new Commande(numeroCommande,StatutCommandePaiement.NON_PAYEE, StatutCommande.NON_TRAITE, Calendar.getInstance(),client);
		c1.setClient(client);
		c1.setDateCommande(Calendar.getInstance());
		c1.setNumeroCommande(numeroCommande);
		c1.setStatut( StatutCommande.NON_TRAITE);
		c1.setStatutPaiement(StatutCommandePaiement.NON_PAYEE);
		
		for (PizzaCommande pizzacommande : clientCommande.getPizzascom()) {
			Pizza p = pizzaDao.findOne(pizzacommande.getIdPizza());
			c1.addPizza(p,pizzacommande.getQuantite());
		}
		commandeDao.save(c1);
		// num de commande
		
		//statut livrais
		//StatutCommande.NON_TRAITE;
		
		// statut paiement
		// sup
		//client id
		//livreur
		// sauver la commander 
		// sauver la commande pizza
	}
}
