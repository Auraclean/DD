package metier;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Joueur extends Personne {

	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name="job")
    private Archetype job;

    public Joueur() {}
    
    public Joueur(String nom, int solde, List<Item> inventaire, Archetype job) {
		super(nom, solde, inventaire);
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