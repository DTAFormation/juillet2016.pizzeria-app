package fr.pizzeria.spring.web.resource;

import java.util.List;
import fr.pizzeria.spring.web.repository.IClientRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.pizzeria.model.Client;

@RestController
@RequestMapping("/clients")
public class ClientResource {

	@Autowired
	private IClientRepository clientDao;

	@RequestMapping(method = RequestMethod.GET)
	  public List<Client> listAllClient() {
	    return clientDao.findAll();
	}

	@RequestMapping(method = RequestMethod.POST)
	public Client saveClient(@RequestBody Client client) {
		return clientDao.save(client);
	}
	
}
