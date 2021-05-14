package metier;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
	@OneToMany(cascade = CascadeType.MERGE)
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
		return "Archetype [id=" + id + ", nom=" + nom + ", objectifs=" + objectifs + "]";
	}
}



