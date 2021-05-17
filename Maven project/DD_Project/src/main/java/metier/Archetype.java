package metier;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

@Entity
public class Archetype {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Enumerated(EnumType.STRING)
	private Role nom;
	// Eager permet d'aller chercher la liste des objectifs en même temps que la classe
	@OneToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	@JoinTable(name="objectifs")
	private List<Item> objectifs;
	
	public Archetype() {}
	
	public Archetype(Role nom, List<Item> objectifs) {
		this.nom = nom;
		this.objectifs = objectifs;
	}

	public Archetype(int id, Role nom, List<Item> objectifs) {
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

	public Role getNom() {
		return nom;
	}
	
	public void setNom(Role nom) {
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
		return id + " - " + nom;
	}
}



