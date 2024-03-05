package personnages;

public class Romain {
	private String nom;
	private int force;
	//private boolean vivant = true;
	private Equipement[] equipements = new Equipement[2];
	private int nbEquipement = 0;
	
		
	
	
	public Romain(String nom, int force) {
		this.nom = nom;
		if (force > 0) {
            this.force = force;
        } else {
            System.out.println("La force d'un Romain doit être positive. Force définie à 1.");
            this.force = 1;
        }
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

	/*public boolean getVivant() {
		return vivant;
	}*/

	/*public void recevoirCoup(int forceCoup) {
		
		assert force > 0 : "La force doit être positive avant de recevoir un coup";

        int forceAvantCoup = this.force; 

        force -= forceCoup;
        if (force <= 0) {
            force = 0; 
            vivant = false;
        }

        
        assert force < forceAvantCoup : "La force après avoir reçu un coup doit être inférieure à la force avant le coup";

        if (vivant) {
            parler("Aïe");
        } else {
            parler("J'abandonne...");
        }
    }*/
	
	public void sEquiper(Equipement nouvelEquipement) {
		switch (nbEquipement) {
			case 0:
				ajouterEquipement(nouvelEquipement);
				break;
			case 1:
				if (equipements[0] == nouvelEquipement) {
					System.out.println("Le soldat " + nom + " possède déjà un " + nouvelEquipement + "!");
                } else {
                    ajouterEquipement(nouvelEquipement);
                }
                break;
            case 2:
            	System.out.println("Le soldat " + nom + " est déjà bien protégé !");
                break;
            default:
            	break;
		
		}
	}
	private void ajouterEquipement(Equipement equipement) {
        equipements[nbEquipement] = equipement;
        nbEquipement++;
        System.out.println("Le soldat " + nom + " s'équipe avec un " + equipement + ".");
    }
		
	
	
	public Equipement[] recevoirCoup(int forceCoup) {
        Equipement[] equipementEjecte = null;
        // précondition
        assert force > 0;
        int oldForce = force;
        
        forceCoup = calculResistanceEquipement(forceCoup);
        force -= forceCoup;
        if (force > 0) {
       	parler("Aïe");
        }else {
       	equipementEjecte = ejecterEquipement();
            parler("J'abandonne...");
        }
        if (force == 0) {
        	parler("Aïe");
        }else{
        	equipementEjecte = ejecterEquipement();
            parler("J'abandonne...");
        }
        // post condition la force a diminuée
        assert force < oldForce;
        return equipementEjecte;
        }
	
	private int calculResistanceEquipement(int forceCoup) {
        String texte;
        texte = "Ma force est  de " + this.force + ", et la force du coup est de " + forceCoup;
        int resistanceEquipement = 0;
        if (nbEquipement != 0) {
             texte += "\nMais heureusement, grace à mon équipement sa force est diminué de ";
             int i = 0;
             while (i< nbEquipement) {
                  if ((equipements[i] != null && equipements[i].equals(Equipement.BOUCLIER))) {
                       resistanceEquipement += 8;
                  } else {
                       System.out.println("Equipement casque");
                       resistanceEquipement += 5;
                  }
                  i++;
		}
            texte += resistanceEquipement + "!";
        }
        parler(texte);
        forceCoup -= resistanceEquipement;
        return forceCoup;
	}
	private Equipement[] ejecterEquipement() {
		Equipement[] equipementEjecte = new Equipement[nbEquipement]; 
		System.out.println("L'équipement de " + nom.toString() + "s'envole sous la force du coup.");
        int nbEquipementEjecte = 0;
        for (int i = 0; i < nbEquipement; i++) {
            if (equipements[i] != null) {
            	equipementEjecte[nbEquipementEjecte] = equipements[i];
                nbEquipementEjecte++;
                equipements[i] = null;
           }
        }
      return equipementEjecte;
 }
	
        	
    public static void main(String[] args) {
		Romain minus = new Romain("Minus", 6);

	    minus.sEquiper(Equipement.CASQUE);
	    minus.sEquiper(Equipement.CASQUE);
	    minus.sEquiper(Equipement.BOUCLIER);
	    minus.sEquiper(Equipement.CASQUE);
	}

	public int getForce() {
		return force;
	}
}