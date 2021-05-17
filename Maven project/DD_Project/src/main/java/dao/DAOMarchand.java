package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import metier.Marchand;
import util.Context;


public class DAOMarchand implements IDAO<Marchand,Integer>{

	public Marchand findById(int id) {	
		EntityManager em = Context.get_instance().getEmf().createEntityManager();	
		Marchand marchand=em.find(Marchand.class, id);	
		em.close();	
		return marchand;	
	}

	public List<Marchand> findAll() {
		EntityManager em = Context.get_instance().getEmf().createEntityManager();
		List<Marchand> myMarchands = em.createQuery("select m from Marchand m", Marchand.class).getResultList();
		em.close();
		return myMarchands;
	}

	public Marchand save(Marchand marchand) {
		EntityManager em = Context.get_instance().getEmf().createEntityManager();
		em.getTransaction().begin();
		marchand=em.merge(marchand);
		em.getTransaction().commit();
		em.close();
		return marchand;
	}

	public void delete(Marchand marchand) {
		EntityManager em = Context.get_instance().getEmf().createEntityManager();
		em.getTransaction().begin();
		marchand=em.merge(marchand);
		em.remove(marchand);
		em.getTransaction().commit();
		em.close();
	}	
	
	// Permet de trouver l'inventaire d'un marchand
	public Marchand findByIdWithInventaire(int id) {
		EntityManager em = Context.get_instance().getEmf().createEntityManager();
		Query query = em.createQuery("select distinct m from Marchand m join fetch m.inventaire where m.id =:id", Marchand.class);
		query.setParameter("id", id);
		Marchand myMarchand = (Marchand) query.getSingleResult();
		em.close();
		return myMarchand;
	}
}