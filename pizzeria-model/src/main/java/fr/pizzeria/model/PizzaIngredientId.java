package fr.pizzeria.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
@Embeddable
public class PizzaIngredientId implements Serializable{
	@ManyToOne
	@JoinColumn(name = "Pizza" )
	private Pizza pizza;
	@ManyToOne
	@JoinColumn(name = "Ingredient")
	private Ingredient ingredient;
	
	public Pizza getPizza() {
		return pizza;
	}
	public void setPizza(Pizza pizza) {
		this.pizza = pizza;
	}
	public Ingredient getIngredient() {
		return ingredient;
	}
	public void setIngredient(Ingredient ingredient) {
		this.ingredient = ingredient;
	}
	
	
}
