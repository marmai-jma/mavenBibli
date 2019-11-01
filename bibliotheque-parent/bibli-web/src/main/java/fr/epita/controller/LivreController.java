package fr.epita.controller;

import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import fr.epita.entity.Livre;
import fr.epita.service.LivreService;

@Path("/livre")
public class LivreController {
	@Autowired
	LivreService service;
	
	@Path("/enregistrer")
	@Produces(MediaType.APPLICATION_JSON)
	public void enregistrerLivre() {
		Livre l = new Livre();
		l.setTitre("Les misérables");
		service.enregistrerLivre(l);
	}
}
