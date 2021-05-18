package metier;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class Joueur extends Personne {

	@OneToOne//(cascade = CascadeType.MERGE)
    private Archetype job;
	@Column(name="solde_final")
	private int objectif;

    public Joueur() {}
    
    public Joueur(String nom, int solde, List<Item> inventaire, Archetype job) {
		super(nom, solde, inventaire);
		this.job = job;
		this.objectif = 0;
	}

    public Archetype getJob() {
		return job;
	}

	public void setJob(Archetype job) {
		this.job = job;
	}

	public int getObjectif() {
		return objectif;
	}

	public void setObjectif(int objectif) {
		if(objectif<0) objectif=0;
		this.objectif = objectif;
	}

	@Override
	public String toString() {
		return "Joueur [job=" + job + ", nom=" + nom + ", solde=" + solde + ", inventaire=" + inventaire + "]";
	} 
	
}