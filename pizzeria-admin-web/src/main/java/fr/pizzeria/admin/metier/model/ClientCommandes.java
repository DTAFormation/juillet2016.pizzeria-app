package fr.pizzeria.admin.metier.model;

import fr.pizzeria.model.Client;

public class ClientCommandes {
	
	private Client client;
	private double valMoyenne;
	
	public ClientCommandes(Client client, double valMoyenne) {
		super();
		this.client = client;
		this.valMoyenne = valMoyenne;
	}

	public ClientCommandes() {
		super();
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public double getValMoyenne() {
		return valMoyenne;
	}

	public void setValMoyenne(double valMoyenne) {
		this.valMoyenne = valMoyenne;
	}

}
