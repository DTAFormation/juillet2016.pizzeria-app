package fr.pizzeria.spring.web.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.pizzeria.model.Commande;
import fr.pizzeria.spring.web.repository.ICommandeRepository;

/**
 * Resource Pizza.
 */
@RestController
@RequestMapping("/commandes")
public class CommandeResource {

	@Autowired private ICommandeRepository commandeDao;

	@RequestMapping(method = RequestMethod.GET)
	public List<Commande> listAllCommandes() {
		return commandeDao.findAll();
	}

	@RequestMapping(method = RequestMethod.POST)
	public Commande addCommande(@RequestBody Commande commande) {
		return commandeDao.save(commande);
	}

}
