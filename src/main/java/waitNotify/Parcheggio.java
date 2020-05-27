package waitNotify;

public class Parcheggio {
    private int totPosti = 10;

    public int getTotalePosti() {
        return totPosti;
    }
    
    //Metodo per regolare l'igresso delle auto
    public void ingresso(){
        while (totPosti == 0) { //se non ci sono posti disponibili
            try{
                wait(); //prova a mettere il thread in attesa             
            } catch (InterruptedException e) {}
        } 
        totPosti--;
    }
    
    //L'auto esce dal parcheggio
    public void uscita()
    {
        totPosti++; //viene aggiunto il posto che è appena stato liberato
        notifyAll();
    }
}
