package ProjetCompteur;

import java.io.*;
import java.util.Scanner;

public abstract class Compteur {

    protected String nomFichier;
    private int nbMots;
    private int nbMots5;
    public abstract void addOccurrence(String mot);

    public Compteur(String fichierTexte) {
        try {
        	nbMots=0;
        	nbMots5=0;
            nomFichier=fichierTexte;
            Scanner in = new Scanner(new File(fichierTexte),"UTF-8");

            in.useDelimiter("\n");

            while (in.hasNextLine()) {
                String ligne = in.nextLine();
                String[] line = ligne.split("\\s+|,|\\(|\\)|\\.+|\"|\\!+|\\'", -1);

                for (int i = 0; i < line.length; i++) {
                    line[i] = line[i].toLowerCase();
                    if(line[i].length()>4) {
                        addOccurrence(line[i]);
                        nbMots5++;
                    }
                    nbMots++;
                }
            }
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    public int getNbMots() {
        return nbMots;
    }

    public int getNbMots5() {
        return nbMots5;
    }
}
