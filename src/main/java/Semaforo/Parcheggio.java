package Semaforo;

import java.util.concurrent.Semaphore;

public class Parcheggio {
    private int totPosti  = 10;
    private Semaphore semaforoDisponibili;
    private Semaphore semaforoOccupati;
    
    //Costruttore
    public Parcheggio() {
        semaforoDisponibili = new Semaphore(totPosti, true); //semaforo per i posti liberi
        semaforoOccupati = new Semaphore(0, true); //semaforo per i posti occupati
    }
    
    public int getTotalePosti() {
        return totPosti;
    }
    
    public void ingresso()
    {
        try
        {
            semaforoDisponibili.acquire(); //blocca l'accesso dalle altre auto
            totPosti--;
        } catch (InterruptedException e) {}       
        semaforoOccupati.release(); //      
    }
    
    public  void uscita()
    {
        try
        {
            semaforoOccupati.acquire(); //
            totPosti++;
        } catch (InterruptedException e) {}      
        semaforoDisponibili.release(); //
    }
}
