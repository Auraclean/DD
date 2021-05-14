package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import metier.Archetype;
import util.Context;




public class DAOArchetype implements IDAO<Archetype,Integer>{

	public Archetype findById(int id) {
		
		
		EntityManager em = Context.get_instance().getEmf().createEntityManager();
		
		Archetype archetype=em.find(Archetype.class, id);
		
		em.close();
		
		return archetype;
		
	}

public List<Archetype> findAll() {
		
	EntityManager em = Context.get_instance().getEmf().createEntityManager();
		
		List<Archetype> myArchetypes = em.createQuery("select a from Archetype a", Archetype.class).getResultList();
		
		em.close();
		
		return myArchetypes;
	}

	public Archetype save(Archetype archetype) {
		
		EntityManager em = Context.get_instance().getEmf().createEntityManager();
		
		em.getTransaction().begin();
		archetype=em.merge(archetype);
		em.getTransaction().commit();
		
		
		em.close();
		return archetype;
	}

	public void delete(Archetype archetype) {
		
		EntityManager em = Context.get_instance().getEmf().createEntityManager();
		
		em.getTransaction().begin();
		archetype=em.merge(archetype);
		em.remove(archetype);
		em.getTransaction().commit();
		
		em.close();
}