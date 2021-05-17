package metier;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Marchand extends Personne{

	@Column(name="magasin", length = 100)
	private String nomMagasin;
	@Column(name="affinite")
	private int affinite;
	//Plusieurs marchands ne peuvent pas être affectés à une même question
	@OneToMany(cascade = {CascadeType.MERGE, CascadeType.REMOVE}, mappedBy = "marchand")
	//@JoinTable(name="questions",joinColumns = @JoinColumn(name="idMarchand"),inverseJoinColumns = @JoinColumn(name="idQuestion"))
	private List<Question> questions;
	
	public Marchand() {}
	
	//La liste de questions n'est plus chargée dans le constructeur du marchand
	public Marchand(String nom, int solde, List<Item> inventaire, String nomMagasin, int affinite) {
		super(nom, solde, inventaire);
		this.nomMagasin = nomMagasin;
		this.affinite = affinite;
	}
	
	public Marchand(int id, String nom, int solde, List<Item> inventaire, String nomMagasin, int affinite) {
		super(id,nom, solde, inventaire);
		this.nomMagasin = nomMagasin;
		this.affinite = affinite;
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
	
	public void setAffinite(int affinite) {
		this.affinite = affinite;
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

