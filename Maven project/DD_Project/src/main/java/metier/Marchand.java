package metier;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Marchand extends Personne{

	@Column(name="magasin", length = 100)
	private String nomMagasin;
	@Column(name="affinite")
	private int affinite;
	private Double modPrix;
	//Plusieurs marchands ne peuvent pas être affectés à une même question, pas de cascade avec mappedBy
	@OneToMany(mappedBy = "marchand")
	//@JoinTable(name="questions",joinColumns = @JoinColumn(name="idMarchand"),inverseJoinColumns = @JoinColumn(name="idQuestion"))
	private List<Question> questions;
	
	public Marchand() {}
	
	//La liste de questions n'est plus chargée dans le constructeur du marchand
	public Marchand(String nom, int solde, List<Item> inventaire, String nomMagasin, int affinite) {
		super(nom, solde, inventaire);
		this.nomMagasin = nomMagasin;
		if(affinite>100) affinite=100;
		else if (affinite<0) affinite=0;
		this.affinite = affinite;
		this.modPrix = 0.1;
	}
	public Marchand(String nom, int solde, List<Item> inventaire, String nomMagasin, int affinite, Double modPrix) {
		super(nom, solde, inventaire);
		this.nomMagasin = nomMagasin;
		if(affinite>100) affinite=100;
		else if (affinite<0) affinite=0;
		this.affinite = affinite;
		if(modPrix>1)modPrix=1.0;
		else if (modPrix<0)modPrix=0.0;
		this.modPrix=modPrix;
	}
	
	public Marchand(int id, String nom, int solde, List<Item> inventaire, String nomMagasin, int affinite) {
		super(id,nom, solde, inventaire);
		this.nomMagasin = nomMagasin;
		if(affinite>100) affinite=100;
		else if (affinite<0) affinite=0;
		this.affinite = affinite;
		this.modPrix = 0.1;
	}
	
	public String getNomMagasin() {
		return nomMagasin;
	}
	
	public void setNomMagasin(String nomMagasin) {
		this.nomMagasin = nomMagasin;
	}
	
	public int getAffinite() {
		return affinite;
	}
	//l'affinite est un pourcentage compris entre 0 et 100
	public void setAffinite(int affinite) {
		if(affinite>100) affinite=100;
		else if (affinite<0) affinite=0;
		this.affinite = affinite;
	}
	
	public Double getModPrix() {
		return modPrix;
	}

	//un prix ne peut pas être vendu plus du double et le modificateur ne peut pas être negatif
	public void setModPrix(Double modPrix) {
		if(modPrix>1)modPrix=1.0;
		else if (modPrix<0)modPrix=0.0;
		this.modPrix = modPrix;
	}

	public List<Question> getQuestions() {
		return questions;
	}
	
	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

	@Override
	public String toString() {
		return id + " - " + nomMagasin +" de "+  nom ;
	}

	
	
}

