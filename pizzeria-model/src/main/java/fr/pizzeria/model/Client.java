package fr.pizzeria.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

@Entity
public class Client {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nom;
	private String prenom;
	private String email;
	private boolean actif = true;
	private String adresse;
	private String telephone;
	private Date dateDerniereModification;
	private boolean abonne;

	public Client(Integer id, String nom, String prenom, String email, String adresse, String telephone) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.adresse = adresse;
		this.telephone = telephone;
	}

	/**
	 * @param id
	 * @param nom
	 * @param prenom
	 * @param email
	 * @param adresse
	 * @param telephone
	 * @param abonne
	 */
	public Client(Integer id, String nom, String prenom, String email, String adresse, String telephone, boolean abonne) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.adresse = adresse;
		this.telephone = telephone;
		this.abonne = abonne;
	}

	public Client(String nom, String prenom, String email, String adresse, String telephone) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.adresse = adresse;
		this.telephone = telephone;
	}

	public Client(String nom, String prenom, String email, String adresse, String telephone, boolean abonne) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.actif = actif;
		this.adresse = adresse;
		this.telephone = telephone;
		this.abonne = abonne;
	}

	public Client() {
		super();
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public Date getDateDerniereModification() {
		return dateDerniereModification;
	}

	public void setDateDerniereModification(Date dateDerniereModification) {
		this.dateDerniereModification = dateDerniereModification;
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

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public boolean isAbonne() {
		return abonne;
	}

	public void setAbonne(boolean abonne) {
		this.abonne = abonne;
	}

	@PrePersist
	@PreUpdate
	public void onPersist() {
		this.dateDerniereModification = new Date();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (actif ? 1231 : 1237);
		result = prime * result + ((adresse == null) ? 0 : adresse.hashCode());
		result = prime * result + ((dateDerniereModification == null) ? 0 : dateDerniereModification.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
		result = prime * result + ((prenom == null) ? 0 : prenom.hashCode());
		result = prime * result + ((telephone == null) ? 0 : telephone.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Client other = (Client) obj;
		if (actif != other.actif)
			return false;
		if (adresse == null) {
			if (other.adresse != null)
				return false;
		} else if (!adresse.equals(other.adresse))
			return false;
		if (dateDerniereModification == null) {
			if (other.dateDerniereModification != null)
				return false;
		} else if (!dateDerniereModification.equals(other.dateDerniereModification))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		if (prenom == null) {
			if (other.prenom != null)
				return false;
		} else if (!prenom.equals(other.prenom))
			return false;
		if (telephone == null) {
			if (other.telephone != null)
				return false;
		} else if (!telephone.equals(other.telephone))
			return false;
		return true;
	}
}
