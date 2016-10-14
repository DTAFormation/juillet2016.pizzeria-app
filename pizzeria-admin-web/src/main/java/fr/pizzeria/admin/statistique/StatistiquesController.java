package fr.pizzeria.admin.statistique;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet(urlPatterns = {"/statistiques"})
public class StatistiquesController extends HttpServlet {

	private static final String VUE_STATISTIQUES = "/WEB-INF/views/statistiques/statistiques.jsp";
	
}
