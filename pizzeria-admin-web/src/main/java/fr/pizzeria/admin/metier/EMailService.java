package fr.pizzeria.admin.metier;

import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.pizzeria.model.Client;
import fr.pizzeria.model.Email;

@Stateless
public class EMailService {

	private Session session;

	@PersistenceContext
	protected EntityManager em;

	@Inject
	ClientService clientService;


	public void setEm(EntityManager em2) {
		this.em = em2;
	}

	public List<Email> findAll() {
		return em.createQuery("select e from Email e", Email.class).getResultList();
	}

	
	public void envoyeEmail(String adresseMail, String pizza) {
		String value = String.format("<!DOCTYPE html>"
				+ "Bonjour cher client !"
				+ "<br>"
				+ "Nous avons le plaisir de vous proposer cette semaine une promotion exeptionnelle ! "
				+ "<br>"
				+ "La pizza <strong>%s</strong> est à moitié prix !"
				+ "<br>"
				+ "Venez vite à notre pizzeria pour en profiter.",pizza);
		send(adresseMail, "promotion de la semaine", value, pizza);


	}

	public void envoyeEmailPromotionPizza(String pizza) {
		List<Client> clients = clientService.findAll();
		System.err.println("Liste des clients :" + clients);
		for (Client client : clients) {
			System.err.println("EMail du client :" + client.getEmail());
			if (client.isAbonne()) {
				envoyeEmail(client.getEmail(), pizza);
			}

		}

	}

	public void send(String addresses, String topic, String textMessage, String pizza) {

		Properties prop = System.getProperties();
		prop.put("mail.smtp.host", "aspmx.l.google.com");
		prop.put("mail.smtp.port", "25");

		Session session = Session.getDefaultInstance(prop, null);
		try {
			String expediteur = "newsletter@DTA.fr";
			Date date = new Date();
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(expediteur));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(addresses));
			message.setSubject(topic);
			message.setContent(textMessage, "text/html; charset=utf-8");
			message.setSentDate(date);
			Transport.send(message);
			// sauvegarde de l'email pour historique
			Email email = new Email(expediteur, addresses, date, topic, pizza, textMessage);
			saveEmail(email);
			System.err.println("Email envoyé vers : " + addresses);
		} catch (MessagingException e) {
			Logger.getLogger(EMailService.class.getName()).log(Level.WARNING, "Cannot send mail", e);
		}

	}
	
	// sauvegarde des emails pour historique
	public void saveEmail(Email email) {
		em.persist(email);
	}

}