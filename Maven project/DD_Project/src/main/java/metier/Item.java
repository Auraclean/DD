package metier;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Item {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name="nom", length = 50)
	private String nom;
	@Column(name="description", length = 100)
    private String description;
	@Column(name="valeur_item")
    private int valeur;

    public Item() {}

    public Item(String nom, String description, int valeur) {
        this.nom = nom;
        this.description = description;
        this.valeur = valeur;
    }
    
    public Item(int id, String nom, String description, int valeur) {
        this.id=id;
    	this.description = description;
        this.nom = nom;
        this.valeur = valeur;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getValeur() {
        return valeur;
    }

    public void setValeur(int valeur) {
        this.valeur = valeur;
    }

    @Override
    public String toString() {
        return "Item [id=" + id + ", nom=" + nom + ", description=" + description + ", valeur=" + valeur + "]";
    }

}
