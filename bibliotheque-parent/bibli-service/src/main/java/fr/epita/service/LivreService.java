package fr.epita.service;

import java.util.List;

import fr.epita.entity.Livre;

public interface LivreService {
	
	/* cette méthode permet d'enregistrer un livre dans la base de données.
	 * @param l le livre à enregistrer
	 */

	String enregistrerLivre(Livre l);
	Livre recupererLivre(Long id);
	void modifierLivre (Livre l);
	void supprimerLivre(Livre l);
	List<Livre>recupererLivres();
}
