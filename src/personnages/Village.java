package personnages;

public class Village {
	private String nom;
	private Chef chef;
	private int nbVillageois;
	private Gaulois[] villageois;
	private int nbVillageoisMaximum;
	
	
	this.nbVillageois = 0;
	
	public Village(String nom) {
		this.nom = nom;
	}
	
	public void setChef(Chef chef) {
		this.chef = chef;
	}
	
	public void setVillageois(Gaulois[] villageois) {
		if (villageois.length <= nbVillageoisMaximum) {
	        this.villageois = villageois;
	        this.nbVillageois = villageois.length;
	    } else {
	        System.out.println("Le nombre de villageois fourni dépasse le nombre maximum autorisé.");
	    }
	}
	public String getNom() {
		return nom;
	}

}


