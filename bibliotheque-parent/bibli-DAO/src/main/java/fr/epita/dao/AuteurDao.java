package fr.epita.dao;

import fr.epita.entity.Auteur;

public interface AuteurDao {
	void creerAuteur(Auteur a);
	Auteur trouverAuteur (Long id);
	void supprimerAuteur(Long id); 
	void modifierAuteur (Auteur a);
}
