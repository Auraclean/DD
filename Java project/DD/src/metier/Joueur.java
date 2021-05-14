package metier;

import java.util.List;

public class Joueur extends Personne {

    private Archetype job;

    public Joueur() {}
    
    public Joueur(int id, String nom, int solde, List<Item> inventaire, Archetype job) {
		super(id,nom, solde, inventaire);
		this.job = job;
	}

    public Archetype getJob() {
		return job;
	}

	public void setJob(Archetype job) {
		this.job = job;
	}

	@Override
	public String toString() {
		return "Joueur [job=" + job + ", nom=" + nom + ", solde=" + solde + ", inventaire=" + inventaire + "]";
	} 
	
}