package personnages;

public enum Equipement {

	CASQUE("casque"), BOUCLIER("bouclier");
	
	private final String nom;

    Equipement(String nom) {
        this.nom = nom;
    }

    @Override
    public String toString() {
        return nom;
    }
}
	

