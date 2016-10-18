package fr.pizzeria.admin.client;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.pizzeria.admin.metier.ClientService;
import fr.pizzeria.model.Client;

@WebServlet("/clients/new")
public class NouveauClientController extends HttpServlet {

	public static final String URL = "/clients/new";
	private static final String VUE_NOUVEAU_CLIENT = "/WEB-INF/views/clients/editerClient.jsp";
	@Inject
	private ClientService clientService;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("client", new Client());
		this.getServletContext().getRequestDispatcher(VUE_NOUVEAU_CLIENT).forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		String nom = req.getParameter("nom");
		String prenom = req.getParameter("prenom");
		String adresse = req.getParameter("adresse");
		String telephone = req.getParameter("telephone");
		boolean abonne = req.getParameter("abonne") == null ? false : true; // null
																			// ou
																			// on
		if (isBlank(nom) || isBlank(prenom) || isBlank(email) || isBlank(adresse) || isBlank(telephone)) {
			req.setAttribute("msgErreur", "Tous les paramètres sont obligatoires !");
			this.getServletContext().getRequestDispatcher(VUE_NOUVEAU_CLIENT).forward(req, resp);
		} else {
			Client clientSansId = null;

			clientSansId = new Client(nom, prenom, email, password, adresse, telephone, abonne);

			if (!clientService.isEmailTaken(email).isEmpty()) {
				req.setAttribute("msgErreur", "l'email existe deja ");
				req.setAttribute("client", clientSansId);
				this.getServletContext().getRequestDispatcher(VUE_NOUVEAU_CLIENT).forward(req, resp);
			} else {
				clientService.saveClient(clientSansId);
				resp.sendRedirect(this.getServletContext().getContextPath() + "/clients/list");
			}
		}
	}

	protected boolean isBlank(String param) {
		return param == null || param.isEmpty();
	}
}
