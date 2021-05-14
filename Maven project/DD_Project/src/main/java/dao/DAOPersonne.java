package dao;

import java.util.List;
import javax.persistence.EntityManager;
import metier.Personne;
import util.Context;

public class DAOPersonne implements IDAO<Personne,Integer>{

	public Personne findById(int id) {		
		EntityManager em = Context.get_instance().getEmf().createEntityManager();	
		Personne personne=em.find(Personne.class, id);	
		em.close();	
		return personne;	
	}

public List<Personne> findAll() {	
	EntityManager em = Context.get_instance().getEmf().createEntityManager();	
		List<Personne> myPersonnes = em.createQuery("select p from Personne p", Personne.class).getResultList();
		em.close();
		return myPersonnes;
	}

	public Personne save(Personne personne) {	
		EntityManager em = Context.get_instance().getEmf().createEntityManager();
		em.getTransaction().begin();
		personne=em.merge(personne);
		em.getTransaction().commit();		
		em.close();
		return personne;
	}

	public void delete(Personne personne) {
		EntityManager em = Context.get_instance().getEmf().createEntityManager();	
		em.getTransaction().begin();
		personne=em.merge(personne);
		em.remove(personne);
		em.getTransaction().commit();	
		em.close();
	}
}