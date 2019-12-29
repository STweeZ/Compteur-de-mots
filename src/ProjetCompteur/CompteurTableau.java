package ProjetCompteur;

public class CompteurTableau extends Compteur {

    public final int TAILLE_INITIALE = 100;
    public int taille_actuelle;
    private Mot[] elements;
    private int nbElements;

    public CompteurTableau (String fichierTexte){
        super(fichierTexte);
    }

    public void addOccurrence(String mot) {
    	boolean alreadyIn=false;
        int place=0;
        if(getNbMots5()==0) {
        	elements = new Mot[TAILLE_INITIALE];
        	taille_actuelle=TAILLE_INITIALE;
        	nbElements=0;
        	}
        for(int i=0;i<nbElements;i++){
                if(elements[i].getMot().equals(mot)){
                    alreadyIn=true;
                    place=i;
                }
            }
        if(alreadyIn==false && nbElements==taille_actuelle){
        	redimensionTab(elements);
        	elements[nbElements]=new Mot(mot);
        	tabTri(nbElements);
        	nbElements++;
        }
        else if(alreadyIn==false) {
        	elements[nbElements]=new Mot(mot);
        	tabTri(nbElements);
        	nbElements++;
        }
        else if(alreadyIn) {
        	elements[place].nouvelleOccurrence();
        	tabTri(place);
        }
    }

    public void redimensionTab(Mot[] elts){
        taille_actuelle*=2;
        Mot[] temp = new Mot[taille_actuelle];
        for(int i=0;i<nbElements;i++){
            temp[i]=elts[i];
        }
        elements=temp;
    }
    
    public void tabTri(int place) {
    	int before=place-1;
        while(before!=-1 && elements[before].getOccurrence()<elements[place].getOccurrence()) {
        	Mot temp=elements[before];
        	elements[before]=elements[place];
        	elements[place]=temp;
        	place--;
        	before--;
        }
    }

    public void affichage10Premiers() {
    	int nb=10;
    	if(nbElements<10) nb=nbElements;
    	for(int i=0;i<nb;i++) System.out.println(elements[i].getOccurrence()+" "+elements[i].getMot());
    }

    public void affichageComplet(){
        System.out.println("Fichier : "+nomFichier);
        System.out.println("Nombre de mots : "+getNbMots());
        System.out.println("Nombre de mots de taille > 4 : "+getNbMots5());
        System.out.println("----------"+"\n"+"Mots les plus fréquents :");
        affichage10Premiers();
    }

    public static void main(String[] args){
        CompteurTableau c = new CompteurTableau("constitutionFrancaise2.txt");
        c.affichageComplet();
    }
    
    /*
    
    ***Second moyen :***
    
    
    private Mot[] tenPrems;
    private int nbMots10;
    
    public void addOccurrence(String mot) {
    	boolean alreadyIn=false;
        int place=0;
        if(getNbMots5()==0) {
        	elements = new Mot[TAILLE_INITIALE];
        	taille_actuelle=TAILLE_INITIALE;
        	nbElements=0;
        	}
        for(int i=0;i<nbElements;i++){
                if(elements[i].getMot().equals(mot)){
                    alreadyIn=true;
                    place=i;
                }
            }
        if(alreadyIn==false && nbElements==taille_actuelle){
        	redimensionTab(elements);
        	elements[nbElements]=new Mot(mot);
        	addTenPrems(elements[nbElements]);
        	nbElements++;
        }
        else if(alreadyIn==false) {
        	elements[nbElements]=new Mot(mot);
        	addTenPrems(elements[nbElements]);
        	nbElements++;
        }
        else if(alreadyIn) {
        	elements[place].nouvelleOccurrence();
        	addTenPrems(elements[place]);
        }
    }
    
    public void addTenPrems(Mot mot) {
    	if(getNbMots5()==0) {
    		tenPrems=new Mot[10];
    		nbMots10=0;
    	}
    	boolean in=false;
		for(int i=0;i<nbMots10;i++) {
			if(mot.getMot()==tenPrems[i].getMot()) {
				in=true;
			}
		}
    	if(nbMots10<10 && in==false) {
    		tenPrems[nbMots10]=mot;
    		nbMots10++;
    	}
    	else if(nbMots10==10 && in==false) {
        	int littleOcc=tenPrems[0].getOccurrence();
        	int place=0;
        	for(int i=1;i<10;i++) {
        		if(tenPrems[i].getOccurrence()<littleOcc) {
        			littleOcc=tenPrems[i].getOccurrence();
        			place=i;
        		}
        	}
        	if(littleOcc<mot.getOccurrence()) tenPrems[place]=mot;
    	}
    }

    public void affichage10Premiers() {
    	for(int i=0;i<9;i++) {
    		Mot temp;
    		for(int j=i+1;j<10;j++) {
    			if(tenPrems[i].getOccurrence()<tenPrems[j].getOccurrence()) {
    				temp=tenPrems[i];
    				tenPrems[i]=tenPrems[j];
    				tenPrems[j]=temp;
    			}
    		}
    	}
    	for(int i=0;i<tenPrems.length;i++) System.out.println(tenPrems[i].getOccurrence()+" "+tenPrems[i].getMot());
    }
    
    */
}
