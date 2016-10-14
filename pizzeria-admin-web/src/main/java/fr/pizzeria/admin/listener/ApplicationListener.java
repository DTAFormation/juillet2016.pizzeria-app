package fr.pizzeria.admin.listener;

import java.math.BigDecimal;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import javax.inject.Inject;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import fr.pizzeria.admin.batch.BatchClientDel;
import fr.pizzeria.admin.metier.ClientService;
import fr.pizzeria.admin.metier.CommandeService;
import fr.pizzeria.admin.metier.EMailService;
import fr.pizzeria.admin.metier.IngredientService;
import fr.pizzeria.admin.metier.LivreurService;
import fr.pizzeria.admin.metier.PizzaService;
import fr.pizzeria.admin.metier.UtilisateurService;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Client;
import fr.pizzeria.model.Commande;
import fr.pizzeria.model.Ingredient;
import fr.pizzeria.model.Livreur;
import fr.pizzeria.model.Pizza;
import fr.pizzeria.model.StatutCommande;
import fr.pizzeria.model.Utilisateur;

@WebListener
public class ApplicationListener implements ServletContextListener {

	@Inject
	PizzaService pizzaService;

	@Inject
	EMailService eMailService;

	@Inject
	ClientService clientService;

	@Inject
	UtilisateurService utilisateurService;

	@Inject
	LivreurService livreurService;

	@Inject
	IngredientService ingredientService;

	@Inject
	CommandeService commandeService;

	@Inject
	BatchClientDel bcd;

	private Map<String, Ingredient> ingredients = new HashMap<>();
	private List<Livreur> livreurs = new ArrayList<>();
	private List<Client> clients = new ArrayList<>();
	private List<Pizza> pizzas = new ArrayList<>();

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		ResourceBundle bundle = ResourceBundle.getBundle("application");
		boolean dev = Boolean.parseBoolean(bundle.getString("prof.dev"));
		if (dev) {
			initIngredients();
			initPizzas();
			try {
				initClients();
			} catch (GeneralSecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			initLivreurs();
			initUtilisateurs();
			initCommandes();
		}
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
	}

	private void initIngredients() {
		ingredients.put("CHA", new Ingredient("CHA", "Champignon"));
		ingredients.put("MOZ", new Ingredient("MOZ", "Mozzarella"));
		ingredients.put("TOM", new Ingredient("TOM", "Tomate"));
		ingredients.put("BAS", new Ingredient("BAS", "Basilic"));
		ingredients.put("HUI", new Ingredient("HUI", "Huile d'olive"));
		ingredients.put("JAM", new Ingredient("JAM", "Jambon"));
		ingredients.put("CHE", new Ingredient("CHE", "Cheddar"));
		ingredients.put("BLE", new Ingredient("BLE", "Bleu"));
		ingredients.put("COM", new Ingredient("COM", "Comté"));
		ingredients.put("BAR", new Ingredient("BAR", "Sauce barbecue"));
		ingredients.put("BOE", new Ingredient("BOE", "Boeuf"));
		ingredients.put("MER", new Ingredient("MER", "Merguez"));
		ingredients.put("POU", new Ingredient("POU", "Poulet"));
		ingredients.put("SAU", new Ingredient("SAU", "Saumon"));

		ingredients.forEach((k, v) -> {
			ingredientService.saveIngredient(v);
		});
	}

	private void initPizzas() {
		Pizza p1 = new Pizza("MAR", "Margherita", new BigDecimal(12.50), CategoriePizza.SANS_VIANDE);
		p1.setUrlImage("/static/images/margarita.jpg");
		p1.addIngredient(ingredients.get("CHA"));
		p1.addIngredient(ingredients.get("MOZ"));
		p1.addIngredient(ingredients.get("TOM"));
		p1.addIngredient(ingredients.get("BAS"));
		p1.addIngredient(ingredients.get("HUI"));
		pizzas.add(p1);

		Pizza p2 = new Pizza("REI", "Reine", new BigDecimal(14.50), CategoriePizza.VIANDE);
		p2.setUrlImage("/static/images/reine.jpg");
		p2.addIngredient(ingredients.get("TOM"));
		p2.addIngredient(ingredients.get("CHA"));
		p2.addIngredient(ingredients.get("JAM"));
		p2.addIngredient(ingredients.get("MOZ"));
		pizzas.add(p2);

		Pizza p3 = new Pizza("FRO", "La 4 fromages", new BigDecimal(12.00), CategoriePizza.SANS_VIANDE);
		p3.setUrlImage("/static/images/fromages.jpg");
		p3.addIngredient(ingredients.get("TOM"));
		p3.addIngredient(ingredients.get("CHE"));
		p3.addIngredient(ingredients.get("COM"));
		p3.addIngredient(ingredients.get("BLE"));
		p3.addIngredient(ingredients.get("MOZ"));
		p3.addIngredient(ingredients.get("BAS"));
		pizzas.add(p3);

		Pizza p4 = new Pizza("CAN", "La cannibale", new BigDecimal(12.50), CategoriePizza.VIANDE);
		p4.setUrlImage("/static/images/cannibale.jpg");
		p4.addIngredient(ingredients.get("BAR"));
		p4.addIngredient(ingredients.get("MOZ"));
		p4.addIngredient(ingredients.get("BOE"));
		p4.addIngredient(ingredients.get("MER"));
		p4.addIngredient(ingredients.get("POU"));
		pizzas.add(p4);

		Pizza p5 = new Pizza("PEC", "Pêcheur", new BigDecimal(15.00), CategoriePizza.POISSON);
		p5.setUrlImage("/static/images/saumon.jpg");
		p5.addIngredient(ingredients.get("TOM"));
		p5.addIngredient(ingredients.get("CHE"));
		p5.addIngredient(ingredients.get("CHA"));
		p5.addIngredient(ingredients.get("SAU"));
		p5.addIngredient(ingredients.get("MOZ"));
		p5.addIngredient(ingredients.get("FRO"));
		pizzas.add(p5);

		pizzas.forEach(p -> {
			pizzaService.savePizza(p);
		});
	}

	private void initClients() throws GeneralSecurityException {
		clients.add(new Client("LeStalker", "Bob", "test1@googlemail.com", "kikou", "5 rue lamer", "0612134565", true));
		clients.add(new Client("Rodriguez", "Robert", "test2@gmail.com", "kikou", "18 rue pueblo", "0712134565"));
		clients.add(new Client("HoldTheDoor", "Hodor", "test3@gmail.com", "kikou", "15 bd des anglais", "0612145565",
				true));

		clients.forEach(c -> {
			clientService.saveClient(c);
		});
	}

	private void initUtilisateurs() {
		List<Utilisateur> utilisateurs = new ArrayList<>();

		utilisateurs
				.add(new Utilisateur("De Monmirail", "Basil", "basildm@gmail.com", utilisateurService.encode("admin")));
		utilisateurs
				.add(new Utilisateur("Montjoie", "Octave", "octavem@gmail.com", utilisateurService.encode("admin")));
		utilisateurs.add(new Utilisateur("admin", "admin", "admin@gmail.com", utilisateurService.encode("admin")));

		utilisateurs.forEach(u -> {
			utilisateurService.saveUtilisateur(u);
		});
	}

	private void initLivreurs() {
		livreurs.add(new Livreur("Hollande", "François"));
		livreurs.add(new Livreur("Cameron", "David"));
		livreurs.add(new Livreur("Targaryen", "Daenerys"));

		livreurs.forEach(l -> {
			livreurService.saveLivreur(l);
		});
	}

	private void initCommandes() {
		List<Commande> commandes = new ArrayList<>();
		Commande c1 = new Commande("CMD1", StatutCommande.NON_TRAITE, Calendar.getInstance(), livreurs.get(0),
				clients.get(0));
		Commande c2 = new Commande("CMD2", StatutCommande.NON_TRAITE, Calendar.getInstance(), livreurs.get(1),
				clients.get(1));
		Commande c3 = new Commande("CMD3", StatutCommande.NON_TRAITE, Calendar.getInstance(), livreurs.get(2),
				clients.get(2));
		commandes.add(c1);
		commandes.add(c2);
		commandes.add(c3);

		commandes.forEach(c -> {
			commandeService.saveCommande(c);
		});

		c1.addPizza(pizzas.get(0), 2);
		c1.addPizza(pizzas.get(1), 3);
		c1.addPizza(pizzas.get(2), 0);
		c1.addPizza(pizzas.get(3), 0);
		c1.addPizza(pizzas.get(4), 0);
		c2.addPizza(pizzas.get(0), 0);
		c2.addPizza(pizzas.get(1), 5);
		c2.addPizza(pizzas.get(2), 1);
		c2.addPizza(pizzas.get(3), 2);
		c2.addPizza(pizzas.get(4), 0);
		c3.addPizza(pizzas.get(0), 2);
		c3.addPizza(pizzas.get(1), 0);
		c3.addPizza(pizzas.get(2), 2);
		c3.addPizza(pizzas.get(3), 0);
		c3.addPizza(pizzas.get(4), 0);

		commandes.forEach(c -> {
			commandeService.updateCommande(c.getNumeroCommande(), c);
		});
	}
}
