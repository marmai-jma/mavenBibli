package fr.epita.service;

import fr.epita.entity.Auteur;

public interface AuteurService {
	
	/* cette méthode permet d'enregistrer un livre dans la base de données.
	 * @param l le livre à enregistrer
	 */

	String enregistrerAuteur(Auteur a);
	Auteur recupererAuteur(Long id);
	void modifierAuteur (Auteur a);
	void supprimerAuteur(Long id);
}
