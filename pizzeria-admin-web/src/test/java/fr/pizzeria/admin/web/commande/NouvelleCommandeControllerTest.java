package fr.pizzeria.admin.web.commande;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.math.BigDecimal;
import java.security.GeneralSecurityException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import fr.pizzeria.admin.metier.ClientService;
import fr.pizzeria.admin.metier.CommandeService;
import fr.pizzeria.admin.metier.LivreurService;
import fr.pizzeria.admin.metier.PizzaService;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Client;
import fr.pizzeria.model.Commande;
import fr.pizzeria.model.CommandePizza;
import fr.pizzeria.model.Ingredient;
import fr.pizzeria.model.Livreur;
import fr.pizzeria.model.Pizza;
import fr.pizzeria.model.StatutCommande;

@RunWith(MockitoJUnitRunner.class)
public class NouvelleCommandeControllerTest {

	@Mock
	HttpServletRequest req;

	@Mock
	HttpServletResponse resp;

	@Mock
	private CommandeService commandeService;
	@Mock
	private PizzaService pizzaService;
	@Mock
	private ClientService clientService;
	@Mock
	private LivreurService livreurService;

	@Test
	public void testDoPost2() throws ServletException, IOException, GeneralSecurityException {
		Ingredient ingredient = new Ingredient("CHA", "champignon");
		Ingredient ingredient2 = new Ingredient("SAM", "saumon");
		Ingredient ingredient3 = new Ingredient("FRO", "fromage");

		Pizza p = getPizza1(ingredient, ingredient2, ingredient3);

		Pizza p1 = getPizza2(ingredient2, ingredient3);

		List<Pizza> lp = new ArrayList<>();
		lp.add(p);
		lp.add(p1);

		Client c = new Client("Chaud", "Patate", "email", "", "adresse", "telephone");
		c.setId(8);
		Livreur l = new Livreur("nom", "prenom");
		l.setId(10);

		String cal = "2016-07-05 11:28";
		Calendar date = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		try {
			date.setTime(sdf.parse(cal));
		} catch (ParseException e) {
			throw new IllegalArgumentException("Format de la date incorrect !");
		}
		when(req.getParameter("numero")).thenReturn("COMTest");
		when(req.getParameter("statut")).thenReturn(StatutCommande.NON_TRAITE.name());
		when(req.getParameter("date")).thenReturn(cal);
		when(req.getParameter("livreur")).thenReturn(l.getId().toString());
		when(req.getParameter("client")).thenReturn(c.getId().toString());
		when(req.getParameter("PEP")).thenReturn("1");
		when(req.getParameter("SAM")).thenReturn("2");

		Commande cmd = new Commande("COMTest", StatutCommande.NON_TRAITE, date, l, c);

		CommandePizza cp = new CommandePizza(cmd, p, 1);
		CommandePizza cp1 = new CommandePizza(cmd, p1, 2);
		List<CommandePizza> lcp = new ArrayList<>();
		lcp.add(cp);
		lcp.add(cp1);
		cmd.setPizzas(lcp);
		when(commandeService.isCodeTaken("COMTest")).thenReturn(0L);
		when(livreurService.findOneLivreur(l.getId().toString())).thenReturn(l);
		when(clientService.findOneClientById(c.getId().toString())).thenReturn(c);
		when(pizzaService.findAll()).thenReturn(lp);

		NouvelleCommandeController controllerTest = new NouvelleCommandeController();
		controllerTest.setCommandeService(commandeService);
		controllerTest.setPizzaService(pizzaService);
		controllerTest.setLivreurService(livreurService);
		controllerTest.setClientService(clientService);

		controllerTest.doPost(req, resp);

		verify(commandeService).saveCommande(cmd);
		verify(commandeService).updateCommande(cmd.getNumeroCommande(), cmd);

	}

	private Pizza getPizza2(Ingredient ingredient2, Ingredient ingredient3) {
		Pizza p1 = new Pizza("SAM", "Saumon", new BigDecimal(12.5), CategoriePizza.VIANDE);
		p1.setUrlImage("http://placehold.it/350x150");
		p1.setId(5);
		p1.addIngredient(ingredient2);
		p1.addIngredient(ingredient3);
		return p1;
	}

	private Pizza getPizza1(Ingredient ingredient, Ingredient ingredient2, Ingredient ingredient3) {
		Pizza p = new Pizza("PEP", "peperoni", new BigDecimal(12.5), CategoriePizza.VIANDE);
		p.setUrlImage("http://placehold.it/350x150");
		p.setId(1);
		p.addIngredient(ingredient);
		p.addIngredient(ingredient2);
		p.addIngredient(ingredient3);
		return p;
	}

}
