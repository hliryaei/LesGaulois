package personnages;

public class Romain {
	private String nom;
	private int force;
	private boolean vivant = true;

	public Romain(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}

	public String getNom() {
		return nom;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "« " + texte + "»");
	}

	private String prendreParole() {
		return "Le romain " + nom + " : ";
	}

	public boolean getVivant() {
		return vivant;
	}

	public void recevoirCoup(int forceCoup) {
		force -= forceCoup;
		if (force <= 0) {
			vivant = false;
		}
		
		if (vivant) {
			parler("Aïe");
		} else {
			parler("J'abandonne...");
		}
	}
}
