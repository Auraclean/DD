package metier;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Marchand extends Personne{

	@Column(name="magasin", length = 100)
	private String nomMagasin;
	@Column(name="affinite")
	private int affinite;
	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(name="questions",joinColumns = @JoinColumn(name="idMarchand"),inverseJoinColumns = @JoinColumn(name="idQuestion"))
	private List<Question> questions;
	
	public Marchand() {}
	
	public Marchand(String nom, int solde, List<Item> inventaire, String nomMagasin, int affinite, List<Question> questions) {
		super(nom, solde, inventaire);
		this.nomMagasin = nomMagasin;
		this.affinite = affinite;
		this.questions = questions;
	}
	
	public Marchand(int id, String nom, int solde, List<Item> inventaire, String nomMagasin, int affinite, List<Question> questions) {
		super(id,nom, solde, inventaire);
		this.nomMagasin = nomMagasin;
		this.affinite = affinite;
		this.questions = questions;
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
		return "Marchand [nomMagasin=" + nomMagasin + ", affinite=" + affinite + ", questions=" + questions + ", id="
				+ id + ", nom=" + nom + ", solde=" + solde + ", inventaire=" + inventaire + "]";
	}
	
}

