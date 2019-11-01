package fr.epita.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Livre {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idLivre;
	
	private String titre;
	private String emplacement;
	private Date parution;
	private String langue;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.EAGER,cascade = {CascadeType.MERGE,CascadeType.PERSIST})
	private Categorie categorie;
	
	@ManyToMany(cascade = {CascadeType.MERGE,CascadeType.PERSIST})
	private List <Auteur> auteurs;
	
	@OneToMany(fetch = FetchType.LAZY)
	private List <Exemplaire> exemplaires;
	
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getEmplacement() {
		return emplacement;
	}
	public void setEmplacement(String emplacement) {
		this.emplacement = emplacement;
	}
	public Date getParution() {
		return parution;
	}
	public void setParution(Date parution) {
		this.parution = parution;
	}
	public String getLangue() {
		return langue;
	}
	public void setLangue(String langue) {
		this.langue = langue;
	}
		
	public void setAuteurs(List<Auteur> auteurs) {
		this.auteurs = auteurs;
	}
	public List<Auteur> getAuteurs() {
		return auteurs;
	}
	public Categorie getCategorie() {
		return categorie;
	}
	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}
	public Long getIdLivre() {
		return idLivre;
	}
	public void setIdLivre(Long idLivre) {
		this.idLivre = idLivre;
	}
	
	public List<Exemplaire> getExemplaires() {
		return exemplaires;
	}
	public void setExemplaires(List<Exemplaire> exemplaires) {
		this.exemplaires = exemplaires;
	}
	
	
}
