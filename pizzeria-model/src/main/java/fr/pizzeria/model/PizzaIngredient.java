package fr.pizzeria.model;
//test
public class PizzaIngredient {
	private Integer idPizza;
	private Integer idIngredient;
	private Double quantiteRequise;
	
	public PizzaIngredient(Integer idPizza, Integer idIngredient, Double quantiteRequise) {
		super();
		//Correspond à id de la pizza
		this.idPizza = idPizza;
		//Correspond à id de l'ingredient
		this.idIngredient = idIngredient;
		//les 2 premier attribut sont la clef primaire de cette table
		
		this.quantiteRequise = quantiteRequise;
	}

	public Integer getIdPizza() {
		return idPizza;
	}

	public void setIdPizza(Integer idPizza) {
		this.idPizza = idPizza;
	}

	public Integer getIdIngredient() {
		return idIngredient;
	}

	public void setIdIngredient(Integer idIngredient) {
		this.idIngredient = idIngredient;
	}

	public Double getQuantiteRequise() {
		return quantiteRequise;
	}

	public void setQuantiteRequise(Double quantiteRequise) {
		this.quantiteRequise = quantiteRequise;
	}
	
	
	
}
