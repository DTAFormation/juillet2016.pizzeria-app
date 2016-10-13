package fr.pizzeria.admin.web.pizza;

import fr.pizzeria.admin.metier.PizzaService;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;

@WebServlet("/pizzas/new")
public class NouvellePizzaController extends HttpServlet {

  public static final String URL = "/pizzas/new";
  private static final String VUE_NOUVELLE_PIZZA = "/WEB-INF/views/pizzas/editerPizza.jsp";
  @Inject
  private PizzaService pizzaService;

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    req.setAttribute("pizza", new Pizza());
    this.getServletContext().getRequestDispatcher(VUE_NOUVELLE_PIZZA).forward(req, resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    String nom = req.getParameter("nom");
    String urlImage = req.getParameter("urlImage");
    String prix = req.getParameter("prix");
    String code = req.getParameter("code");
    // TODO Ajouter le support de la catégorie
    // String categorie = req.getParameter("categorie");

    if (isBlank(nom) || isBlank(urlImage) || isBlank(prix)) {
      req.setAttribute("msgErreur", "Tous les paramètres sont obligatoires !");
      this.getServletContext().getRequestDispatcher(VUE_NOUVELLE_PIZZA).forward(req, resp);
    } else {
      Pizza pizzaSansId = new Pizza(code, nom, new BigDecimal(prix), CategoriePizza.VIANDE);
      pizzaSansId.setUrlImage(urlImage);
      pizzaService.savePizza(pizzaSansId);
      resp.sendRedirect("/pizzas/list");
    }
  }

  protected boolean isBlank(String param) {
    return param == null || param.isEmpty();
  }
}
