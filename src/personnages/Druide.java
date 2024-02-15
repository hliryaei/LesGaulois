package personnages;

import java.util.Random;

public class Druide {
	private String nom;
	private int effetPotionMin;
	private int effetPotionMax;
	private int forcePotion = 1;

	public Druide(String nom, int effetPotionMin, int effetPotionMax) {
		this.nom = nom;
		this.effetPotionMin = effetPotionMin;
		this.effetPotionMax = effetPotionMax;
		parler("Bonjour, je suis le druide " + nom + " et ma potion peut aller d'une force " + effetPotionMin + " à "
				+ effetPotionMax + ".");
	}

	public String getNom() {
		return nom;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "« " + texte + "»");
	}

	private String prendreParole() {
		return "Le druide " + nom + " : ";
	}

	public void preparerPotion() {
		Random random = new Random();
		this.forcePotion = effetPotionMin + random.nextInt(effetPotionMax - effetPotionMin + 1);
		if (this.forcePotion > 7) {
			parler("« J'ai préparé une super potion de force : " + this.forcePotion);
		} else {
			parler(" Je n'ai pas trouvé tous les ingrédients, ma potion est seulement de force : " + this.forcePotion);
		}
	}

	public void booster(Gaulois gaulois) {

		if (gaulois != null && gaulois.getnom().equals("Obélix")) {
			parler("Non, Obélix !... Tu n'auras pas de potion magique !");
			gaulois.parler("Par Bélénos, ce n'est pas juste !");
		} else {
			preparerPotion();
			gaulois.boirePotion(this.forcePotion);
		}
	}

	/*
	 * public static void main(String[] args) { Druide Panoramix = new
	 * Druide("Panoramix" , 5 ,10); Panoramix.preparerPotion(); }
	 */
}
