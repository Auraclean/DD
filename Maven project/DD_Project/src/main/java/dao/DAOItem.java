package dao;

import java.util.List;
import javax.persistence.EntityManager;
import metier.Item;
import util.Context;

public class DAOItem implements IDAO<Item,Integer>{

	public Item findById(int id) {
		EntityManager em = Context.get_instance().getEmf().createEntityManager();
		Item item=em.find(Item.class, id);
		em.close();
		return item;
	}

public List<Item> findAll() {
	EntityManager em = Context.get_instance().getEmf().createEntityManager();	
		List<Item> myItems = em.createQuery("select i from Item i", Item.class).getResultList();		
		em.close();		
		return myItems;
	}

	public Item save(Item item) {
		EntityManager em = Context.get_instance().getEmf().createEntityManager();	
		em.getTransaction().begin();
		item=em.merge(item);
		em.getTransaction().commit();	
		em.close();
		return item;
	}

	public void delete(Item item) {	
		EntityManager em = Context.get_instance().getEmf().createEntityManager();	
		em.getTransaction().begin();
		item=em.merge(item);
		em.remove(item);
		em.getTransaction().commit();	
		em.close();
	}
}