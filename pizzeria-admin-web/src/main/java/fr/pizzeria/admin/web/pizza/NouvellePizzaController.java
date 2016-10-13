package fr.pizzeria.admin.web.pizza;

import java.io.IOException;
import java.math.BigDecimal;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.pizzeria.admin.metier.IngredientService;
import fr.pizzeria.admin.metier.PizzaService;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

@WebServlet("/pizzas/new")
public class NouvellePizzaController extends HttpServlet {

	public static final String URL = "/pizzas/new";
	private static final String VUE_NOUVELLE_PIZZA = "/WEB-INF/views/pizzas/editerPizza.jsp";
	@Inject
	private PizzaService pizzaService;
	@Inject
	private IngredientService ingredientService;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("pizza", new Pizza());
		req.setAttribute("listeIngredient", ingredientService.findAll());
		this.getServletContext().getRequestDispatcher(VUE_NOUVELLE_PIZZA).forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nom = req.getParameter("nom");
		String urlImage = req.getParameter("urlImage");
		String prix = req.getParameter("prix");
		String code = req.getParameter("code");
		String[] ingredients = req.getParameterValues("ingredient");
		String categorie = req.getParameter("categorie");

		// TODO Ajouter le support de la catégorie
		// String categorie = req.getParameter("categorie");

		if (isBlank(nom) || isBlank(urlImage) || isBlank(prix)) {
			req.setAttribute("msgErreur", "Tous les paramètres sont obligatoires !");
			req.setAttribute("pizza", new Pizza());
			this.getServletContext().getRequestDispatcher(VUE_NOUVELLE_PIZZA).forward(req, resp);

		} else if (!pizzaService.isCodeTaken(code).isEmpty()) {
			req.setAttribute("msgErreur", "le code existe deja ");
			req.setAttribute("pizza", new Pizza());

			this.getServletContext().getRequestDispatcher(VUE_NOUVELLE_PIZZA).forward(req, resp);
		} else {
			Pizza pizzaSansId = new Pizza(code, nom, new BigDecimal(prix), CategoriePizza.valueOf(categorie));
			if (ingredients != null) {
				for (String ingredient : ingredients) {
					pizzaSansId.addIngredient(ingredientService.findOneIngredient(ingredient));
				}
			}
			pizzaSansId.setUrlImage(urlImage);
			pizzaService.savePizza(pizzaSansId);
			resp.sendRedirect(req.getContextPath() + "/pizzas/list");
		}
	}

	/**
	 * setter utiliser lors des tests du controller
	 * 
	 * @param pizzaService
	 */
	public void setPizzaService(PizzaService pizzaService) {
		this.pizzaService = pizzaService;
	}

	/**
	 * setter utiliser lors des tests du controller
	 * 
	 * @param pizzaService
	 */
	public void setIngredientService(IngredientService ingredientService) {
		this.ingredientService = ingredientService;
	}

	protected boolean isBlank(String param) {
		return param == null || param.isEmpty();
	}
}
