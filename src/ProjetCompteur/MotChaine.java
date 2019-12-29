package ProjetCompteur;

public class MotChaine extends Mot {

    private MotChaine next;

    public MotChaine(String m, MotChaine n){
        super(m);
        next = n;
    }
    public MotChaine(String m){
        this(m, null);
    }
    public void setNext(MotChaine next){
        this.next=next;
    }
    public MotChaine getNext(){
        return next;
    }
    
    /*
    
    ***Second moyen :***
    
    private MotChaine previous;
    public MotChaine(MotChaine p, String m, MotChaine n){
        super(m);
        previous = p;
        next = n;
    }
    public MotChaine(MotChaine p, String m){
        super(m);
        previous = p;
    }
    public MotChaine(String m, MotChaine n){
        super(m);
        next = n;
    }
    public MotChaine(String m){
        this(null, m, null);
    }
    public void setPrevious(MotChaine previous){
        this.previous=previous;
    }
    public MotChaine getPrevious(){
        return previous;
    }
    
    */
}
