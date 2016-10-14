package fr.pizzeria.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

import javax.persistence.Table;

@Entity
@Table(name = "pizza_ingredient")
@IdClass(PizzaIngredientId.class)
public class PizzaIngredients {
	@Id
	private PizzaIngredientId id;

	private Double quantiteRequise;

	public PizzaIngredients() {
		super();
	}

	public PizzaIngredients(PizzaIngredientId id, Double quantiteRequise) {
		this.id = id;
		this.quantiteRequise = quantiteRequise;
	}

	public PizzaIngredientId getId() {
		return id;
	}

	public void setId(PizzaIngredientId id) {
		this.id = id;
	}

	public Double getQuantiteRequise() {
		return quantiteRequise;
	}

	public void setQuantiteRequise(Double quantiteRequise) {
		this.quantiteRequise = quantiteRequise;
	}
	
	public Pizza getPizza(){
		return id.getPizza();
	}
	public Ingredient getIngredienty(){
		return id.getIngredient();
	}
	
	
	

	
	
	
	

}
