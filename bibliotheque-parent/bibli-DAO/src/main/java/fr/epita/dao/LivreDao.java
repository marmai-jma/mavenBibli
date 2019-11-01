package fr.epita.dao;

import java.util.List;

import fr.epita.entity.Livre;

public interface LivreDao {
	void creerLivre(Livre l);
	Livre trouverLivre (Long id);
	List<Livre> findAll();
	//void supprimerLivre(Long id); 
	void supprimer(Livre l);
	void modifierLivre (Livre l);
}
