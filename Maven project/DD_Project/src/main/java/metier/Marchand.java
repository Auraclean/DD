package metier;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Marchand extends Personne{

	@Column(name="magasin", length = 100)
	private String nomMagasin;
	@Column(name="affinite")
	private int affinite;
	private Double modPrix;
	//Plusieurs marchands ne peuvent pas être affectés à une même question, pas de cascade avec mappedBy
	@OneToMany(mappedBy = "marchand")
	//@JoinTable(name="questions",joinColumns = @JoinColumn(name="idMarchand"),inverseJoinColumns = @JoinColumn(name="idQuestion"))
	private List<Question> questions;
	@Column(name="phrase_acceuil", length = 150)
	private String bonjour;
	@Column(name="phrase_depart", length = 150)
	private String aurevoir;
	@Column(name="bonne_reponse", length = 150)
	private String bonneReponse;
	@Column(name="mauvaise_reponse", length = 150)
	private String mauvaiseReponse;
	@Column(name="vente_reussie", length = 150)
	private String venteOk;
	@Column(name="vente_echec", length = 150)
	private String venteNope;
	@Column(name="affichage_stock", length = 150)
	private String stock;
	@Column(name="achat_realise", length = 150)
	private String achatOk;
	@Column(name="achat_impossible", length = 150)
	private String achatNope;
	
	public Marchand() {}
	
	//La liste de questions n'est plus chargée dans le constructeur du marchand
	public Marchand(String nom, int solde, List<Item> inventaire, String nomMagasin, int affinite) {
		super(nom, solde, inventaire);
		this.nomMagasin = nomMagasin;
		if(affinite>100) affinite=100;
		else if (affinite<0) affinite=0;
		this.affinite = affinite;
		this.modPrix = 0.1;
	}
	public Marchand(String nom, int solde, List<Item> inventaire, String nomMagasin, int affinite, Double modPrix) {
		super(nom, solde, inventaire);
		this.nomMagasin = nomMagasin;
		if(affinite>100) affinite=100;
		else if (affinite<0) affinite=0;
		this.affinite = affinite;
		if(modPrix>1)modPrix=1.0;
		else if (modPrix<0)modPrix=0.0;
		this.modPrix=modPrix;
	}
	
	public Marchand(int id, String nom, int solde, List<Item> inventaire, String nomMagasin, int affinite) {
		super(id,nom, solde, inventaire);
		this.nomMagasin = nomMagasin;
		if(affinite>100) affinite=100;
		else if (affinite<0) affinite=0;
		this.affinite = affinite;
		this.modPrix = 0.1;
	}
	
	public String getNomMagasin() {
		return nomMagasin;
	}
	
	public void setNomMagasin(String nomMagasin) {
		this.nomMagasin = nomMagasin;
	}
	
	public int getAffinite() {
		return affinite;
	}
	//l'affinite est un pourcentage compris entre 0 et 100
	public void setAffinite(int affinite) {
		if(affinite>100) affinite=100;
		else if (affinite<0) affinite=0;
		this.affinite = affinite;
	}
	
	public Double getModPrix() {
		return modPrix;
	}

	//un prix ne peut pas être vendu plus du double et le modificateur ne peut pas être negatif
	public void setModPrix(Double modPrix) {
		if(modPrix>1)modPrix=1.0;
		else if (modPrix<0)modPrix=0.0;
		this.modPrix = modPrix;
	}

	public List<Question> getQuestions() {
		return questions;
	}
	
	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

	public String getBonjour() {
		return bonjour;
	}

	public void setBonjour(String bonjour) {
		this.bonjour = bonjour;
	}

	public String getAurevoir() {
		return aurevoir;
	}

	public void setAurevoir(String aurevoir) {
		this.aurevoir = aurevoir;
	}

	public String getBonneReponse() {
		return bonneReponse;
	}

	public void setBonneReponse(String bonneReponse) {
		this.bonneReponse = bonneReponse;
	}

	public String getMauvaiseReponse() {
		return mauvaiseReponse;
	}

	public void setMauvaiseReponse(String mauvaiseReponse) {
		this.mauvaiseReponse = mauvaiseReponse;
	}

	public String getVenteOk() {
		return venteOk;
	}

	public void setVenteOk(String venteOk) {
		this.venteOk = venteOk;
	}

	public String getVenteNope() {
		return venteNope;
	}

	public void setVenteNope(String venteNope) {
		this.venteNope = venteNope;
	}

	public String getStock() {
		return stock;
	}

	public void setStock(String stock) {
		this.stock = stock;
	}

	public String getAchatOk() {
		return achatOk;
	}

	public void setAchatOk(String achatOk) {
		this.achatOk = achatOk;
	}

	public String getAchatNope() {
		return achatNope;
	}

	public void setAchatNope(String achatNope) {
		this.achatNope = achatNope;
	}

	@Override
	public String toString() {
		return id + " - " + nomMagasin ;
	}

	
	
}

