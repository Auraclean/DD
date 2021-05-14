package util;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dao.DAOArchetype;
import dao.DAOItem;
import dao.DAOMarchand;
import metier.Archetype;
import metier.Joueur;
import metier.Marchand;

public class Context {

	private static Context _instance = null; 
	
	/*---------------------------------------- Toutes les variables static du main ----------------------------------------*/
	
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("villageDD");
	
	private Joueur p = new Joueur();
	private Marchand m = new Marchand(); 
	private Archetype classe = new Archetype();
	
	private List<Marchand> marchands = new ArrayList<Marchand>();

	private DAOArchetype daoArc = new DAOArchetype();
	private DAOItem daoItem = new DAOItem();
	private DAOMarchand daoMar = new DAOMarchand();

	/*------------------------------------------ Constructeur + getters/setters ------------------------------------------*/
	
	private Context() {}

	public static Context get_instance() {
		if(_instance==null) {_instance=new Context();}
		return _instance;
	}

	public EntityManagerFactory getEmf() {
		return emf;
	}

	public void setEmf(EntityManagerFactory emf) {
		this.emf = emf;
	}

	public Joueur getP() {
		return p;
	}

	public void setP(Joueur p) {
		this.p = p;
	}

	public Marchand getM() {
		return m;
	}

	public void setM(Marchand m) {
		this.m = m;
	}

	public Archetype getClasse() {
		return classe;
	}

	public void setClasse(Archetype classe) {
		this.classe = classe;
	}

	public List<Marchand> getMarchands() {
		return marchands;
	}

	public void setMarchands(List<Marchand> marchands) {
		this.marchands = marchands;
	}

	public DAOArchetype getDaoArc() {
		return daoArc;
	}

	public void setDaoArc(DAOArchetype daoArc) {
		this.daoArc = daoArc;
	}

	public DAOItem getDaoItem() {
		return daoItem;
	}

	public void setDaoItem(DAOItem daoItem) {
		this.daoItem = daoItem;
	}

	public DAOMarchand getDaoMar() {
		return daoMar;
	}

	public void setDaoMar(DAOMarchand daoMar) {
		this.daoMar = daoMar;
	}

}
