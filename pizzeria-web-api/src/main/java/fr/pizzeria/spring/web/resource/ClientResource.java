package fr.pizzeria.spring.web.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.pizzeria.model.Client;
import fr.pizzeria.spring.web.repository.IClientRepository;

/**
 * Resource Client.
 */
@RestController
@RequestMapping("/clients")
public class ClientResource {

	@Autowired
	private IClientRepository clientDao;

	@RequestMapping(method = RequestMethod.POST)

	public Enregirstrement saveClients(@RequestBody Client newClient) {
		Enregirstrement mes = new Enregirstrement();

		if (isBlank(newClient.getNom()) || isBlank(newClient.getEmail()) || isBlank(newClient.getPassword())) {
			mes.setMessage("les paramètres nom, email et password sont obligatoires !");
			mes.setSucces(false);
		} else {
			clientDao.save(newClient);

			mes.setSucces(true);
		}
		return mes;
	}

	protected boolean isBlank(String param) {
		return param == null || param.isEmpty();
	}
}
