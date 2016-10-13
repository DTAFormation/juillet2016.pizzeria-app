package fr.pizzeria.admin.web.pizza;

import fr.pizzeria.admin.metier.PizzaService;

import java.util.logging.Logger;
import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Contrôleur de la page Liste des pizzas.
 */
@WebServlet("/pizzas/list")
public class ListerPizzaController extends HttpServlet {

  private static final Logger LOG = Logger.getLogger(ListerPizzaController.class.getName());

  private static final String VUE_LISTER_PIZZAS = "/WEB-INF/views/pizzas/listerPizzas.jsp";
  private static final String ACTION_EDITER = "editer";
  private static final String ACTION_SUPPRIMER = "supprimer";

  @Inject private PizzaService pizzaService;

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    req.setAttribute("listePizzas", this.pizzaService.findAll());
    RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher(VUE_LISTER_PIZZAS);
    dispatcher.forward(req, resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    String action = req.getParameter("action"); // editer ou supprimer
    String code = req.getParameter("code"); // identifiant de la pizza

    switch (action) {

      case ACTION_EDITER:
        resp.sendRedirect(this.getServletContext().getContextPath()
            + EditerPizzaController.URL
            + "?code="
            + code);
        break;
      case ACTION_SUPPRIMER:
        pizzaService.deletePizza(code);
        req.setAttribute("msg", "La pizza code = " + code + " a été supprimée");
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
