package personnages;

public class Gaulois {

	private String nom;
	private int force;
	private int effetPotion = 1;

	public Gaulois(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}

	public String getnom() {
		return nom;

	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "« " + texte + "»");
	}

	private String prendreParole() {
		return "Le gaulois " + nom + " : ";
	}

	public void frapper(Romain romain) {
		if (romain.getVivant()) {
			System.out.println(nom + " envoie un grand coup dans la mâchoire de " + romain.getNom());
			romain.recevoirCoup((force / 3) * effetPotion);
		}
	}

	@Override
	public String toString() {
		return "Gaulois [nom=" + nom + ", force=" + force + ", effetPotion=" + effetPotion + "]";

	}

	public void boirePotion(int forcePotion) {
		this.effetPotion = forcePotion;
		parler("Merci Druide, je sens que ma force est " + this.effetPotion + " fois décuplée.");
	}
	/*
	 * public static void main(String[] args) { Gaulois asterix = new
	 * Gaulois("Astérix", 8); System.out.println(asterix); }
	 */

	/*
	 * public static void main(String[] args) { Gaulois asterix = new
	 * Gaulois("Astérix", 8); Druide panoramix = new Druide("Panoramix", 5, 10);
	 * Romain cesar = new Romain("César", 10);
	 * 
	 * panoramix.preparerPotion();
	 * 
	 * asterix.boirePotion(3);
	 * 
	 * asterix.frapper(cesar); }
	 */

}
