package fr.epita.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import fr.epita.entity.Livre;

@Repository
public class LivreDaoImpl implements LivreDao  {
	
	EntityManagerFactory emf=Persistence.createEntityManagerFactory("bibliothequePU");
	//@PersistenceContext(unitName = "bibliothequePU")
	EntityManager em;//=emf.createEntityManager();
	
	public void creerLivre(Livre l) {
		em=emf.createEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(l);
			em.getTransaction().commit();
		}catch (Exception se) {
			// TODO: handle exception
			em.getTransaction().rollback();
		}
		finally {
			em.close(); // demande explicite de fermeture au pool de connexion
		}
	}
	
	public Livre trouverLivre (Long id) {
		em=emf.createEntityManager();
		return em.find(Livre.class, id); 
	}
	
	/*
	public void supprimerLivre(Long id) {
		Livre l = trouverLivre(id);
		em.remove(l);
	}
	*/
	
	public void modifierLivre (Livre l) {
		em=emf.createEntityManager();
		try {
			em.getTransaction().begin();
			em.merge(l);
			em.getTransaction().commit();
		}catch (Exception se) {
			// TODO: handle exception
			em.getTransaction().rollback();
		}
		finally {
			em.close(); // demande explicite de fermeture au pool de connexion
		}
	}

	public void supprimer(Livre l) {
		// TODO Auto-generated method stub
		em=emf.createEntityManager();
		try {
			em.getTransaction().begin();
			em.remove(l);
			em.getTransaction().commit();
		}catch (Exception se) {
			// TODO: handle exception
			em.getTransaction().rollback();
		}
		finally {
			em.close(); // demande explicite de fermeture au pool de connexion
		}
	}

	public List<Livre> findAll() {
		// TODO Auto-generated method stub
		em=emf.createEntityManager();
		List<Livre> results;
		try {
			em.getTransaction().begin();		// pas obligatoire sur une recherche
			Query query=em.createQuery("SELECT l FROM Livre l");
			results=query.getResultList();
			em.getTransaction().commit();       // pas obligatoire sur une recherche
		}finally {
			em.close();
		}
		return results;
	}
}
