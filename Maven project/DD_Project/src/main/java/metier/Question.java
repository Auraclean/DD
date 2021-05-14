package metier;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Question {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name="libelle")
	private String libelle;
	@Column(name="reponse")
	private List<Reponse> reponses;
	
	public Question() {}
	
	public Question(int id, String libelle, List<Reponse> reponses) {
		this.id = id;
		this.libelle = libelle;
		this.reponses = reponses;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getLibelle() {
		return libelle;
	}
	
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	
	public List<Reponse> getReponses() {
		return reponses;
	}
	
	public void setReponses(List<Reponse> reponses) {
		this.reponses = reponses;
	}

	@Override
	public String toString() {
		return "Question [id=" + id + ", libelle=" + libelle + ", reponses=" + reponses + "]";
	}
	
}
