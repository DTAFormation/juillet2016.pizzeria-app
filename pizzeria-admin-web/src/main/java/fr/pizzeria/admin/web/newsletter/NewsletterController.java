package fr.pizzeria.admin.web.newsletter;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.pizzeria.admin.metier.EMailService;
import fr.pizzeria.model.Utilisateur;

@WebServlet("/newsletter")
public class NewsletterController extends HttpServlet {

	private static final String VUE_NEWSLETTER = "/WEB-INF/views/newsletter/newsletter.jsp";
	@Inject
	private EMailService eMailService;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher(VUE_NEWSLETTER).forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String pizzaPromo = req.getParameter("pizzaPromo");
		System.err.println(pizzaPromo);
		eMailService.envoyeEmailPromotionPizza(pizzaPromo);
		resp.sendRedirect(this.getServletContext().getContextPath() + "/newsletter");
	}

}
