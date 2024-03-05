package personnages; 

public class Musee {
    private Trophee[] trophees = new Trophee[200]; 
    private int nbTrophee = 0; 

   
    public void donnerTrophees(Gaulois gaulois, Equipement equipement) {
        if (nbTrophee < 200) { 
            trophees[nbTrophee] = new Trophee(gaulois, equipement); 
            nbTrophee++; 
        } else {
            System.out.println("Le musée est plein, impossible d'ajouter plus de trophées.");
        }
    }


    public String extraireInstructionsOCaml() {
        StringBuilder instructionsOcaml = new StringBuilder("let musee = [\n");
        for (int i = 0; i < nbTrophee; i++) {
            if (trophees[i] != null) { 
                
                String nomGaulois = trophees[i].getGaulois().getNom();
                String nomEquipement = trophees[i].getEquipement().toString().toLowerCase(); 
                instructionsOcaml.append("    \"").append(nomGaulois).append("\", \"").append(nomEquipement).append("\"");
                if (i < nbTrophee - 1) {
                    instructionsOcaml.append(";\n");
                }
            }
        }
        instructionsOcaml.append("\n]"); 
        return instructionsOcaml.toString();
    }

}
