package metier;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

@Entity
public class Question {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name="libelle", length = 100)
	private String libelle;
	@OneToMany(cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
	@JoinTable(name="reponses",joinColumns = @JoinColumn(name="idQuestion"),inverseJoinColumns = @JoinColumn(name="idReponse"))
	private List<Reponse> reponses;
	
	public Question() {}
	
	public Question(String libelle, List<Reponse> reponses) {
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
