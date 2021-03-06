package util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dao.DAOArchetype;
import dao.DAOItem;
import dao.DAOJoueur;
import dao.DAOMarchand;
import dao.DAOQuestion;
import dao.DAOReponse;
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
	
	private String p1 = "Inconnu : ";
	
	private DAOJoueur daoP = new DAOJoueur();
	private DAOArchetype daoArc = new DAOArchetype();
	private DAOItem daoItem = new DAOItem();
	private DAOMarchand daoMar = new DAOMarchand();
	private DAOQuestion daoQues = new DAOQuestion();
	private DAOReponse daoRep = new DAOReponse();

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

	public String getP1() {
		return p1;
	}

	public void setP1(String p1) {
		this.p1 = p1;
	}

	public DAOArchetype getDaoArc() {
		return daoArc;
	}

	public DAOJoueur getDaoP() {
		return daoP;
	}

	public void setDaoP(DAOJoueur daoP) {
		this.daoP = daoP;
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

	public DAOQuestion getDaoQues() {
		return daoQues;
	}

	public void setDaoQues(DAOQuestion daoQues) {
		this.daoQues = daoQues;
	}

	public DAOReponse getDaoRep() {
		return daoRep;
	}

	public void setDaoRep(DAOReponse daoRep) {
		this.daoRep = daoRep;
	}

}
