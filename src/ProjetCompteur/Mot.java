package ProjetCompteur;

public class Mot {

    private String mot;
    private int cpt;

    public Mot(String mot){
    	this.mot=mot;
        cpt=1;
    }
    public void nouvelleOccurrence(){
        cpt++;
    }
    public int getOccurrence(){
        return cpt;
    }
    public void setOccurrence(int cpt){
        this.cpt=cpt;
    }
    public String getMot(){
        return mot;
    }
    public void setMot(String mot){
        this.mot=mot;
    }
}