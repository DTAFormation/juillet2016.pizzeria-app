package fr.pizzeria.spring.web.resource;

import fr.pizzeria.spring.web.repository.IClientRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.pizzeria.model.Client;






@RestController
@RequestMapping("/login")
public class LoginResource {

	@Autowired
	private IClientRepository clientDao;

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> LogClient(@RequestBody Client client) {
		Client login = clientDao.findByEmailAndMotDePasse(client.getEmail(), client.getMotDePasse());
		return login != null ?  ResponseEntity.ok(login) : ResponseEntity.noContent().build();
	}
	
	
	
	
}
