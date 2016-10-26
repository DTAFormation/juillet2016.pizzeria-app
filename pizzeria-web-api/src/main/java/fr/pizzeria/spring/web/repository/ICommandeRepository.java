package fr.pizzeria.spring.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import fr.pizzeria.model.Commande;
import java.lang.Integer;

public interface ICommandeRepository extends JpaRepository<Commande, Integer>{
	//List<Commande> findByActif(boolean actif);
}
