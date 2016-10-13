package fr.pizzeria.admin.filter;

import fr.pizzeria.admin.web.AuthentificationController;

import java.util.stream.Stream;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/*")
public class AuthentificationFilter implements Filter {

  private static final String[] NO_FILTER_URL = {"/api", "/login", "/static"};

  @Override
  public void destroy() {

  }

  @Override
  public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
      throws IOException, ServletException {
    HttpServletRequest httpRequest = (HttpServletRequest) req;
    HttpServletResponse httpResponse = (HttpServletResponse) resp;
    String emailAuthentifie = (String) httpRequest.getSession().getAttribute(AuthentificationController.AUTH_EMAIL);

    boolean noFilter = Stream.of(NO_FILTER_URL).anyMatch(httpRequest.getRequestURI()::contains);

    if (!noFilter && emailAuthentifie == null) {
      httpResponse.sendRedirect(httpRequest.getServletContext().getContextPath() + AuthentificationController.URL);
    } else {
      chain.doFilter(req, resp);
    }
  }

  @Override
  public void init(FilterConfig config) throws ServletException {

  }
}
