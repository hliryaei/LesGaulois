package histoire;

import personnages.Gaulois;
import personnages.Romain;
import personnages.Druide;

public class Scenario {

	public static void main(String[] args) {

		Gaulois asterix = new Gaulois("Astérix", 8);
		Gaulois obelix = new Gaulois("Obélix", 25);
		Romain minus = new Romain("Minus", 6);
		Druide panoramix = new Druide("Panoramix", 5, 10);

		/*
		 * asterix.parler(" « Bonjour à tous»");
		 * minus.parler("« UN GAU... UN GAUGAU...»"); for (int i = 0 ; i < 3 ; i++){
		 * asterix.frapper(minus); }
		 */
		panoramix.booster(obelix);
		panoramix.booster(asterix);

		asterix.parler("Bonjour");
		minus.parler("UN GAU... UN GAUGAU...");
		for (int i = 0; i < 3; i++) {
			asterix.frapper(minus);
		}
	}
}
