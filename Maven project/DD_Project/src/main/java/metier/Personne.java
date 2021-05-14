package metier;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;


@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Personne {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected int id;
	@Column(name="nom", length = 25)
    protected String nom;
	@Column(name="solde")
    protected int solde;
	@ManyToMany(cascade = {CascadeType.MERGE,CascadeType.REMOVE})
	@JoinTable(name="inventaire",joinColumns = @JoinColumn(name="idPersonne"),inverseJoinColumns = @JoinColumn(name="idItem"))
    protected List<Item> inventaire;
    
    public Personne() {}
    
    public Personne(String nom, int solde, List<Item> inventaire) {
        this.nom = nom;
        this.solde = solde;
        this.inventaire = inventaire;
    }
    
    public Personne(int id, String nom, int solde, List<Item> inventaire) {
		this.id = id;
		this.nom = nom;
		this.solde = solde;
		this.inventaire = inventaire;
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
    
    public int getSolde() {
        return solde;
    }
    
    public void setSolde(int solde) {
        this.solde = solde;
    }
    
    public List<Item> getInventaire() {
        return inventaire;
    }
    
    public void setInventaire(List<Item> inventaire) {
        this.inventaire = inventaire;
    }
    
    @Override
	public String toString() {
		return "Personne [id=" + id + ", nom=" + nom + ", solde=" + solde + ", inventaire=" + inventaire + "]";
	}
    
}
