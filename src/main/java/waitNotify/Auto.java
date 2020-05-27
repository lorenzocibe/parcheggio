package waitNotify;

public class Auto extends Thread{
    private Parcheggio parking;

    //Costruttore
    public Auto(String nome, Parcheggio parcheggio) {
        super(nome);
        this.parking = parking;
        start(); //il thread inizia la sua esecuzione 
    }
    
    @Override
    public void run(){
        while(true) { //loop
            synchronized (parking){ //viene inserito nel synchronized per regolare l'accesso da 1 solo thread
                parking.ingresso(); //l'auto entra nel parcheggio
                System.out.println("L'auto " + super.getName() + " é entrata\n Posti disponibili: " + parking.getTotalePosti() + "\n");
            }          
            synchronized (parking){ //viene inserito nel synchronized per regolare l'accesso da 1 solo thread
                parking.uscita(); //l'auto esce dal parcheggio
                System.out.println("L'auto " + super.getName() + " é uscita\n Posti disponibili: " + parking.getTotalePosti() + "\n");
            }
        }
    } 
}
