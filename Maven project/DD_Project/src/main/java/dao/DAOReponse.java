package dao;

import java.util.List;
import javax.persistence.EntityManager;
import metier.Reponse;
import util.Context;

public class DAOReponse implements IDAO<Reponse,Integer>{

	public Reponse findById(int id) {
		EntityManager em = Context.get_instance().getEmf().createEntityManager();
		Reponse reponse=em.find(Reponse.class, id);
		em.close();
		return reponse;
	}

public List<Reponse> findAll() {
	EntityManager em = Context.get_instance().getEmf().createEntityManager();	
		List<Reponse> myReponses = em.createQuery("select r from Reponse r", Reponse.class).getResultList();
		em.close();
		return myReponses;
	}

	public Reponse save(Reponse reponse) {
		EntityManager em = Context.get_instance().getEmf().createEntityManager();
		em.getTransaction().begin();
		reponse=em.merge(reponse);
		em.getTransaction().commit();
		em.close();
		return reponse;
	}

	public void delete(Reponse reponse) {
		EntityManager em = Context.get_instance().getEmf().createEntityManager();
		em.getTransaction().begin();
		reponse=em.merge(reponse);
		em.remove(reponse);
		em.getTransaction().commit();
		em.close();
	}	
}