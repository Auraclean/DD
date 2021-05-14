package metier;

import java.util.List;

public abstract class Personne {

	protected int id;
    protected String nom;
    protected int solde;
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
