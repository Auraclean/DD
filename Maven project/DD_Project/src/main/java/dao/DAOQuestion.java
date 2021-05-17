package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import metier.Question;
import util.Context;

public class DAOQuestion implements IDAO<Question,Integer>{

	public Question findById(int id) {
		EntityManager em = Context.get_instance().getEmf().createEntityManager();
		Question question=em.find(Question.class, id);
		em.close();
		return question;
	}

	public List<Question> findAll() {
		EntityManager em = Context.get_instance().getEmf().createEntityManager();
		List<Question> myQuestions = em.createQuery("select q from Question q", Question.class).getResultList();
		em.close();
		return myQuestions;
	}

	public Question save(Question question) {
		EntityManager em = Context.get_instance().getEmf().createEntityManager();
		em.getTransaction().begin();
		question=em.merge(question);
		em.getTransaction().commit();
		em.close();
		return question;
	}

	public void delete(Question question) {
		EntityManager em = Context.get_instance().getEmf().createEntityManager();
		em.getTransaction().begin();
		question=em.merge(question);
		em.remove(question);
		em.getTransaction().commit();
		em.close();
	}
	
	//Permet de trouver la liste de questions associée à un marchand
	public List<Question> findByIdMarchand(int id) {
		EntityManager em = Context.get_instance().getEmf().createEntityManager();
		Query query = em.createQuery("select distinct q from Question q join fetch q.reponses where q.marchand.id =:id", Question.class);
		query.setParameter("id", id);
		List<Question> questions = query.getResultList();
		em.close();
		return questions;
	}
}