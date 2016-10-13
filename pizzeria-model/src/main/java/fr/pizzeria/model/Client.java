package fr.pizzeria.model;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Client {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nom;
	private String prenom;
	private String email;
	private String motDePasse;
	private String sexe;
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dateNaissance;
	private String adresseNum;
	private String adresseRue;
	private String adresseDetail;
	private String adresseCodePostal;
	private String adresseVille;
	private String numeroTel;

	
	
	public Client(Integer id, String nom, String prenom, String email, String motDePasse) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.motDePasse = motDePasse;
	}

	public Client(String nom, String prenom, String email, String motDePasse) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.motDePasse = motDePasse;
	}


	public Client(Integer id, String nom, String prenom, String email, String motDePasse, String sexe,
			Calendar dateNaissance, String adresseNum, String adresseRue, String adresseDetail,
			String adresseCodePostal, String adresseVille, String numeroTel) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.motDePasse = motDePasse;
		this.sexe = sexe;
		this.dateNaissance = dateNaissance;
		this.adresseNum = adresseNum;
		this.adresseRue = adresseRue;
		this.adresseDetail = adresseDetail;
		this.adresseCodePostal = adresseCodePostal;
		this.adresseVille = adresseVille;
		this.numeroTel = numeroTel;
	}

	public Client() {
		super();
		// TODO Auto-generated constructor stub
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

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}
	
	public String getSexe() {
		return sexe;
	}

	public void setSexe(String sexe) {
		this.sexe = sexe;
	}

	public Calendar getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Calendar dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public String getAdresseNum() {
		return adresseNum;
	}

	public void setAdresseNum(String adresseNum) {
		this.adresseNum = adresseNum;
	}

	public String getAdresseRue() {
		return adresseRue;
	}

	public void setAdresseRue(String adresseRue) {
		this.adresseRue = adresseRue;
	}

	public String getAdresseDetail() {
		return adresseDetail;
	}

	public void setAdresseDetail(String adresseDetail) {
		this.adresseDetail = adresseDetail;
	}

	public String getAdresseCodePostal() {
		return adresseCodePostal;
	}

	public void setAdresseCodePostal(String adresseCodePostal) {
		this.adresseCodePostal = adresseCodePostal;
	}

	public String getAdresseVille() {
		return adresseVille;
	}

	public void setAdresseVille(String adresseVille) {
		this.adresseVille = adresseVille;
	}

	public String getNumeroTel() {
		return numeroTel;
	}

	public void setNumeroTel(String numeroTel) {
		this.numeroTel = numeroTel;
	}
	
	

}
