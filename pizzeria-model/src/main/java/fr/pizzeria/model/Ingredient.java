package fr.pizzeria.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//Issue USA008

/*		Modifications effectuées :
 * 
 *  - Ajout de l'attribut quantité( décimal car l'unité est le kilo )
 */
@Entity
public class Ingredient {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String code;
	private String nom;
	@Column(name="quantite", columnDefinition="Decimal(10,3) default '0.00'")
	private Double quantite;
	private boolean actif = true;
	

	public Ingredient() {
		// default construct
	}
	
	public Ingredient(String code, String nom, Double quantite) {
		this.code = code;
		this.nom = nom;
		this.quantite = quantite;
	}
	
	
	public Ingredient(Integer id, String code, String nom, Double quantite) {
		this.id = id;
		this.code = code;
		this.nom = nom;
		this.quantite = quantite;
	}

	public Ingredient(Integer id, String code, String nom) {
		this.id = id;
		this.code = code;
		this.nom = nom;
	}

	public Ingredient(String code, String nom) {
		this.code = code;
		this.nom = nom;
	}

	public boolean isActif() {
		return actif;
	}

	public void setActif(boolean actif) {
		this.actif = actif;
	}

	public void toggleActif() {
		this.setActif(!this.actif);
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public  Double getQuantite() {
		return quantite;
	}

	public void setQuantite( Double quantite) {
		this.quantite = quantite;
	}
	
}
