package fr.pizzeria.spring.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.pizzeria.model.Commande;

public interface ICommandeRepository extends JpaRepository<Commande, Integer> {

}
