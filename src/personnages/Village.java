package personnages;

import com.apple.eawt.ApplicationBeanInfo;

public class Village {  
    private String nom;
    private Chef chef;
    private int nbVillageois = 1;
    private Gaulois[] villageois;
    
    public Village(String nom, int nbVillageoisMaximum) { 
        this.nom = nom;
        this.villageois = new Gaulois[nbVillageoisMaximum];
    }
    public void ajouterHabitant(Gaulois gaulois) {
    	if (nbVillageois < villageois.length) {
    		villageois[nbVillageois]= gaulois;
    		nbVillageois++;
    	}else {
    		System.out.println("Le village est plein. Impossible d'ajouter " + gaulois.getNom());
    	}
    }
    
    public Gaulois trouverHabitant(int numeroHabitant) {
    	
    	if (numeroHabitant >= 0 && numeroHabitant < nbVillageois) {
            return villageois[numeroHabitant];
            }
    	return null;
    }
    
    
    public void setChef(Chef chef) {
		this.chef = chef;
	}
    public String getNom() { 
        return nom;
    } 
    
    public void afficherVillageois() {
    	if (chef != null && nbVillageois > 1) {
    		System.out.println("Dans village du chef " + chef.getNom() + " vivent les légendaires gaulois : \n");
    		for ( int i = 1 ; i < nbVillageois ; i++) {
    			if (villageois[i] != null) {
                    System.out.println("-" + villageois[i].getNom()); 
                }
    	}
    }
    }
    
    public static void main(String[] args) {
        Village village = new Village("Village des Irréductibles", 30);

        
        Chef abraracourcix = new Chef("Abraracourcix", 6, village);
        village.setChef(abraracourcix);

        Gaulois asterix = new Gaulois("Astérix", 8);
        village.ajouterHabitant(asterix);

        Gaulois obelix = new Gaulois("obélix", 25);
        village.ajouterHabitant(obelix);

        village.afficherVillageois();
        
        Gaulois gaulois = village.trouverHabitant(1);
        System.out.println(gaulois);
        }
        
}
