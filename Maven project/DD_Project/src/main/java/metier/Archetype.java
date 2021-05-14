package metier;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Archetype {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name="nom")
	private String nom;
	@Column(name="objectifs")
	private List<Item> objectifs;
	
	public Archetype() {}
	
	public Archetype(String nom, List<Item> objectifs) {
		this.nom = nom;
		this.objectifs = objectifs;
	}
	
	public Archetype(int id, String nom, List<Item> objectifs) {
		this.id = id;
		this.nom = nom;
		this.objectifs = objectifs;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public List<Item> getObjectifs() {
		return objectifs;
	}
	
	public void setObjectifs(List<Item> objectifs) {
		this.objectifs = objectifs;
	}
	
	@Override
	public String toString() {
		return "Archetype [id=" + id + ", nom=" + nom + ", objectifs=" + objectifs + "]";
	}
}



