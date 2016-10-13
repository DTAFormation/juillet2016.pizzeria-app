package fr.pizzeria.admin.metier;

import fr.pizzeria.model.Pizza;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class PizzaService {

  @PersistenceContext protected EntityManager em;


  public List<Pizza> findAll() {
    return em.createQuery("select p from Pizza p", Pizza.class).getResultList();
  }

  public Pizza findOnePizza(String code) {
    return em.createQuery("select p from Pizza p where p.code=:code", Pizza.class)
        .setParameter("code", code)
        .getSingleResult();
  }

  public void updatePizza(String code, Pizza pizzaAvecId) {
    findOnePizza(code); // vérifie qu'une pizza est présente
    em.merge(pizzaAvecId);
  }

  public void savePizza(Pizza pizzaSansId) {
    em.persist(pizzaSansId);
  }

  public void deletePizza(String code) {
    em.remove(findOnePizza(code));
  }
}
