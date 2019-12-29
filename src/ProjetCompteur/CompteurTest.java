package ProjetCompteur;

public class CompteurTest extends Compteur {

    public void addOccurrence(String mot) {
        System.out.println(mot);
    }

    public CompteurTest(String s) {
        super(s);
    }

    public static void main(String[] args){
        CompteurTest c = new CompteurTest("test.txt");
    }
}
