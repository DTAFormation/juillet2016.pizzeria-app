package fr.pizzeria.admin.web.stock;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.pizzeria.admin.metier.IngredientService;

@WebServlet("/stocks/list")
public class VoirStockIngredientController extends HttpServlet{
	
	private static final String VUE_STOCK_INGREDIENT = "/WEB-INF/views/stock/listerStock.jsp";
	
	@Inject
	private IngredientService ingredientService;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("listeIngredients", this.ingredientService.findAll());
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher(VUE_STOCK_INGREDIENT);
		dispatcher.forward(req, resp);
	}
	
}
