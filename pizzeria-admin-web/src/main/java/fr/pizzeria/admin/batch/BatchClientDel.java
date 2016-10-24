package fr.pizzeria.admin.batch;

import javax.ejb.Schedule;
import javax.ejb.Stateless;
import javax.inject.Inject;

import fr.pizzeria.admin.metier.ClientService;

@Stateless
public class BatchClientDel {

	@Inject
	private ClientService cs;

	public BatchClientDel() {

	}

	
	//@Schedule(minute = "*/1", hour = "*") // pour les tests, décommenter
	@Schedule(hour="6", dayOfMonth="1")     // Le premier de chaque mois à 6 heure du matin

	public void batch() {
		try {
			cs.hardDeleteClients();
		} catch (Exception e) {

			System.out.println("error running thread " + e.getMessage());
		}
	}
}

