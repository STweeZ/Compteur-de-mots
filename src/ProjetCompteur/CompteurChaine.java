package ProjetCompteur;

public class CompteurChaine extends Compteur {

	private MotChaine elements;
    private MotChaine[] tenPrems;
    private int nbMots10;

    public CompteurChaine (String fichierTexte) {
        super(fichierTexte);
    }
    public void addOccurrence(String mot) {
        if(getNbMots5()==0) {
            elements=new MotChaine(mot);
            addTenPrems(elements);
        }
        else {
            boolean alreadyIn=false;
            MotChaine actual=elements;
            MotChaine prev=actual;
            while(actual!=null){
                if(actual.getMot().equals(mot)){
                    alreadyIn=true;
                    actual.nouvelleOccurrence();
                    addTenPrems(actual);
                }
                prev=actual;
                actual=actual.getNext();
            }
            if(alreadyIn==false) {
                prev.setNext(new MotChaine(mot));
                addTenPrems(prev.getNext());
            }
        }
    }

    public void addTenPrems(MotChaine mot){
        if(getNbMots5()==0) {
    		tenPrems=new MotChaine[10];
            nbMots10=0;
        }
        boolean in=false;
        for(int i=0;i<nbMots10;i++){
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

    public void affichage10Premiers(){
    	for(int i=0;i<nbMots10-1;i++) {
    		for(int j=i;j<nbMots10;j++) {
    			if(tenPrems[j].getOccurrence()>tenPrems[i].getOccurrence()){
    				MotChaine temp=tenPrems[i];
    				tenPrems[i]=tenPrems[j];
    				tenPrems[j]=temp;
    			}
    		}
    	}
        for(int i=0;i<tenPrems.length;i++) System.out.println(tenPrems[i].getOccurrence()+" "+tenPrems[i].getMot());
    }

    public void affichageComplet(){
        System.out.println("Fichier : "+nomFichier);
        System.out.println("Nombre de mots : "+getNbMots());
        System.out.println("Nombre de mots de taille > 4 : "+getNbMots5());
        System.out.println("----------"+"\n"+"Mots les plus fréquents :");
        affichage10Premiers();
    }

    public static void main(String[] args){
        CompteurChaine c = new CompteurChaine("constitutionFrancaise2.txt");
        c.affichageComplet();
    }
    
    /*
    
    ***Second moyen :***
    
    public void addOccurrence(String mot) {
        if(getNbMots5()==0) {
            elements=new MotChaine(mot);
        }
        boolean alreadyIn=false;
        MotChaine actual=elements;
        MotChaine prev=actual;
        while(actual!=null){
        	if(actual.getMot().equals(mot)){
        		alreadyIn=true;
        		actual.nouvelleOccurrence();
        		tabTri(actual);
        	}
        	prev=actual;
        	actual=actual.getNext();
        }
        if(alreadyIn==false) {
        	prev.setNext(new MotChaine(prev,mot));
        	tabTri(prev.getNext());
        }
    }

    public void tabTri(MotChaine actual) {
    	String cas="petit";
    	if(actual.getPrevious()!=null && actual.getOccurrence()>actual.getPrevious().getOccurrence()) cas="grand";
    	if(cas=="grand") {
    		while(actual.getNext()!=null && actual.getOccurrence()>actual.getNext().getOccurrence()) {
    			MotChaine one=actual;
    			MotChaine sec=actual.getNext();
    			sec.setNext(one);
    			one.setPrevious(sec);
    			one.setNext(actual.getNext().getNext());
    			sec.setPrevious(actual.getPrevious());
    			actual.getNext().getNext().setPrevious(one);
        		actual.getPrevious().setNext(sec);
        		actual=one;
        	}
    	}
    	else if(cas=="petit") {
    		while(actual.getPrevious()!=null && actual.getOccurrence()<actual.getPrevious().getOccurrence()) {
    			MotChaine one=actual;
    			MotChaine prev=actual.getPrevious();
    			one.setNext(prev);
    			prev.setPrevious(one);
    			one.setPrevious(actual.getPrevious().getPrevious());
    			prev.setNext(actual.getNext());
    			actual.getPrevious().getPrevious().setNext(one);
    			actual.getNext().setPrevious(prev);
    			actual=one;
    		}
    	}
    }

    public void affichage10Premiers(){
    	MotChaine actual=elements;
    	while(actual.getNext()!=null) {
    		actual=actual.getNext();
    	}
    	int nb=0;
    	while(nb!=10 && actual!=null) {
    		System.out.println(actual.getOccurrence()+" "+actual.getMot());
    		actual=actual.getPrevious();
    		nb++;
    	}
    }

    public void affichageComplet(){
        System.out.println("Fichier : "+nomFichier);
        System.out.println("Nombre de mots : "+getNbMots());
        System.out.println("Nombre de mots de taille > 4 : "+getNbMots5());
        System.out.println("----------"+"\n"+"Mots les plus fréquents :");
        affichage10Premiers();
        MotChaine actual=elements;
        while(actual!=null) {
        	System.out.println(actual.getOccurrence());
        	actual=actual.getPrevious();
        }
    }
    
    */
}