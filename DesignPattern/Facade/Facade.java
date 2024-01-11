package Facade;
/*Immagina di dover creare un sistema di prenotazione viaggi che coinvolge diverse componenti, come prenotazione di voli, prenotazione di hotel e noleggio di auto. Utilizza il design pattern Facade per semplificare l'interazione con il sistema di prenotazione viaggi.

    Definisci le classi PrenotazioneVoli, PrenotazioneHotel e NoleggioAuto, ognuna con metodi per gestire le rispettive prenotazioni.

    Crea una classe SistemaPrenotazioneViaggiFacade che offra un'interfaccia semplificata per i clienti del sistema. Questa classe conterrà un'istanza di ciascuna delle classi sopra e fornirà metodi pubblici per prenotare un viaggio completo.

    Implementa metodi all'interno di SistemaPrenotazioneViaggiFacade che combinino le operazioni di prenotazione di voli, prenotazione di hotel e noleggio di auto. Ad esempio, potresti avere un metodo prenotaViaggioCompleto() che chiama internamente i metodi delle altre classi.

    Nel Main, crea un'istanza di SistemaPrenotazioneViaggiFacade e utilizzala per prenotare un viaggio completo. Questo semplificherà l'interazione con il sistema di prenotazione, nascondendo la complessità delle singole operazioni.
     */

class PrenotazioneVoli{
    public void PrenotaVolo(String destinazione){
        System.out.println("volo prenotato: "+destinazione);
    }
}

class PrenotazioneHotel{
    public void PrenotaHotel(String destinazione, int notti){
        System.out.println("hotel prenotato: "+destinazione+ " Notti: "+notti);
    }
}

class NoleggioAuto {
    public void NoleggiaAuto(String destinazione, int giorni){
        System.out.println("Auto noleggiata: "+destinazione+" Giorni: "+giorni);
    }
}

class SistemaPrenotazioneViaggiFacade{
    PrenotazioneHotel h;
    PrenotazioneVoli v;
    NoleggioAuto n;

    SistemaPrenotazioneViaggiFacade(){
        this.h=new PrenotazioneHotel();
        this.v=new PrenotazioneVoli();
        this.n=new NoleggioAuto();
    }

    public void prenotaViaggioCompleto(String destinazione,int notti, int giorni){
        h.PrenotaHotel(destinazione,notti);
        v.PrenotaVolo(destinazione);
        n.NoleggiaAuto(destinazione,giorni);
    }
}

class Client3{
    public static void main(String []args){
        SistemaPrenotazioneViaggiFacade s=new SistemaPrenotazioneViaggiFacade();
        s.prenotaViaggioCompleto("Madrid",3,4);
    }
}