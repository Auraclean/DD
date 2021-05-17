package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import metier.Joueur;
import metier.Marchand;
import util.Context;


public class DAOJoueur implements IDAO<Joueur,Integer>{

	public Joueur findById(int id) {	
		EntityManager em = Context.get_instance().getEmf().createEntityManager();	
		Joueur joueur=em.find(Joueur.class, id);	
		em.close();	
		return joueur;	
	}

	public List<Joueur> findAll() {
		EntityManager em = Context.get_instance().getEmf().createEntityManager();
		List<Joueur> myJoueurs = em.createQuery("select j from joueur j", Joueur.class).getResultList();
		em.close();
		return myJoueurs;
	}

	public Joueur save(Joueur joueur) {
		EntityManager em = Context.get_instance().getEmf().createEntityManager();
		em.getTransaction().begin();
		joueur=em.merge(joueur);
		em.getTransaction().commit();
		em.close();
		return joueur;
	}

	public void delete(Joueur joueur) {
		EntityManager em = Context.get_instance().getEmf().createEntityManager();
		em.getTransaction().begin();
		joueur=em.merge(joueur);
		em.remove(joueur);
		em.getTransaction().commit();
		em.close();
	}	
	
	public Joueur findByIdWithInventaire(int id) {
		EntityManager em = Context.get_instance().getEmf().createEntityManager();
		Query query = em.createQuery("select distinct j from Joueur j join fetch j.inventaire where j.id =:id", Joueur.class);
		query.setParameter("id", id);
		Joueur myJoueur = (Joueur) query.getSingleResult();
		em.close();
		return myJoueur;
	}
}