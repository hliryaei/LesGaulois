package personnages;

public class Romain {
	private String nom;
	private int force;
	private boolean vivant;

	public Romain(String nom, int force) {
		this.nom = nom;
		this.force = force;
		this.vivant = true;
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
		if (force > 0) {
			parler("Aïe");
		} else if (vivant) {
			parler("J'abandonne...");
			vivant = false;
		}
	}
}
