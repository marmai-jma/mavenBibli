package fr.epita.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.epita.entity.Categorie;
import fr.epita.entity.Livre;
import fr.epita.service.LivreService;


@RestController
public class LivreController {
	@Autowired
	LivreService service;
	
	@RequestMapping("/hello")
	public void enregistrerLivre() {
		Livre l = new Livre();
		List<Livre> listLivre=new ArrayList<>();
		Categorie categorie = new Categorie();
		categorie.setNom("Classique");
		l.setCategorie(categorie);
		listLivre.add(l);
		categorie.setLivres(listLivre);
		l.setTitre("Madame Bovary");
		service.enregistrerLivre(l);
	}
	
	@RequestMapping("/find/{id}")
	public Livre trouverLivre(@PathVariable("id") Long id) {
		Livre l = service.recupererLivre(id);
		System.out.println(l.getCategorie().getNom());
		return l;
	}
	
	@RequestMapping("/find/livres")
	public void trouverLivres() {
		List<Livre> results=service.recupererLivres();
		for (Livre l : results) {
			System.out.println(l.getTitre());
		}
		return;
	}
	
	@RequestMapping("/modif/{id}")
	public void modifLivre(@PathVariable("id") Long id) {
		Livre l = new Livre();
		l = service.recupererLivre(id);
		l.setTitre("Les misérables 2 - la vengeance");
		service.modifierLivre(l);
	}
	
	@RequestMapping("/supp/{id}")
	public void supprimerLivre(@PathVariable("id") Long id) {
		Livre l = new Livre();
		l = service.recupererLivre(id);
		service.supprimerLivre(l);
	}
}
