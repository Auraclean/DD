package metier;

public class Reponse {

	private int id;
	private String libelle;
	private boolean valid;
	
	public Reponse() {}
	
	public Reponse(int id, String libelle) {
		this.id = id;
		this.libelle = libelle;
	}
	
	public Reponse(int id, String libelle, boolean valid) {
		this.id = id;
		this.libelle = libelle;
		this.valid = valid;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getLibelle() {
		return libelle;
	}
	
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	
	public boolean isValid() {
		return valid;
	}
	public void setValid(boolean valid) {
		this.valid = valid;
	}

	@Override
	public String toString() {
		return "Reponse [id=" + id + ", libelle=" + libelle + ", valid=" + valid + "]";
	}
	
	
	
}