package fr.pizzeria.admin.web.ingredient;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.pizzeria.admin.metier.IngredientService;
import fr.pizzeria.admin.web.pizza.EditerPizzaController;
import fr.pizzeria.model.Ingredient;
import fr.pizzeria.model.Pizza;

/**
 * Contrôleur de la page Liste des ingredients.
 */
@WebServlet({ "/ingredients/list", "/ingredients/list/active", "/ingredients/list/inactive" })
public class ListerIngredientController extends HttpServlet {

	private static final String VUE_LISTER_INGREDIENT = "/WEB-INF/views/ingredient/listerIngredient.jsp";
	private static final String ACTION_EDITER = "editer";
	private static final String ACTION_SUPPRIMER = "supprimer";
	private static final String PATH_ACTIF = "/ingredients/list/active";
	private static final String PATH_INACTIF = "/ingredients/list/inactive";
	private static final String PATH_ALL = "/ingredients/list";
	private static final String ACTION_TOGGLE = "toggle";
	private static final String ACTIVE_ATTIBUTE = "active";

	@Inject
	private IngredientService ingredientService;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("listeIngredients", this.ingredientService.findAll());
		String active;
		String path = req.getServletPath();
		switch (path) {
			case PATH_ACTIF:
				active = "Actifs";
				req.setAttribute(ACTIVE_ATTIBUTE, active);
				break;
			case PATH_INACTIF:
				active = "Inactifs";
				req.setAttribute(ACTIVE_ATTIBUTE, active);
				break;
			case PATH_ALL:
				active = "Tous";
				req.setAttribute(ACTIVE_ATTIBUTE, active);
				break;
			default:
				active = "Actifs";
				req.setAttribute(ACTIVE_ATTIBUTE, active);
		}
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher(VUE_LISTER_INGREDIENT);
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("action"); // editer ou supprimer
		String code = req.getParameter("code"); // identifiant de la pizza

		switch (action) {
			case ACTION_EDITER:
				resp.sendRedirect(this.getServletContext().getContextPath() + EditerPizzaController.URL + "?code=" + code);
				break;
			case ACTION_SUPPRIMER:
				ingredientService.deleteIngredient(code);
				req.setAttribute("msg", "L'ingrédient code = " + code + " a été supprimé");
				doGet(req, resp);
				break;
			case ACTION_TOGGLE:
				Ingredient ingredient = ingredientService.findOneIngredient(code);
				ingredient.toggleActif();
				ingredientService.updateIngredient(code, ingredient);
				String reponseString = ingredient.isActif() ? "réactivé" : "désactivé";
				req.setAttribute("msg_success", "L'ingrédient " + ingredient.getNom() + " a bien été " + reponseString);
				doGet(req, resp);
				break;
			default:
				req.setAttribute("msg", "Action inconnue");
				resp.setStatus(400);
				doGet(req, resp);
				break;
		}
	}
}
