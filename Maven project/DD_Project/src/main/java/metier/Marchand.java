package metier;

import java.util.List;

public class Marchand extends Personne{

	private String nomMagasin;
	private int affinite;
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

