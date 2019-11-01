package fr.epita.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import fr.epita.entity.Auteur;

@Repository
public class AuteurDaoImpl implements AuteurDao  {
	@PersistenceContext(unitName = "bibliothequePU")
	EntityManager em;

	public void creerAuteur(Auteur a) {
		// TODO Auto-generated method stub
		em.persist(a);
	}

	public Auteur trouverAuteur(Long id) {
		// TODO Auto-generated method stub
		return em.find(Auteur.class, id);
	}

	public void supprimerAuteur(Long id) {
		// TODO Auto-generated method stub
		Auteur a = trouverAuteur(id);
		em.remove(a);
		
	}

	public void modifierAuteur(Auteur a) {
		// TODO Auto-generated method stub
		em.merge(a);
	}
}
