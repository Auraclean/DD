package metier;

public class Item {

	private int id;
	private String nom;
    private String description;
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
