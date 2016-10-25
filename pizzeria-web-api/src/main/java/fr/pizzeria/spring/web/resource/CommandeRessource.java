package fr.pizzeria.spring.web.resource;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import fr.pizzeria.model.Commande;
import fr.pizzeria.spring.web.repository.ICommandeRepository;

/**
 * Resource Client.
 */
@RestController
@RequestMapping("/commandes")
public class CommandeRessource {
	
	@Autowired
	private ICommandeRepository commandeDao;
//	
//	@RequestMapping(method = RequestMethod.POST)
//	public void saveCommands(@RequestBody Commande newCmd, HttpServletResponse response) {
//	}
//	
	@RequestMapping(method = RequestMethod.GET)
	  public List<Commande> listAllPizzas() {
	    return commandeDao.findAll();
	  }
}
