package FactoryMethod;
/*Immagina di dover creare un sistema per la creazione di vari tipi di veicoli, come automobili e biciclette. Utilizza il design pattern Factory Method per delegare la creazione di oggetti a sottoclassi specifiche.

    Definisci un'interfaccia Veicolo con metodi comuni per tutti i tipi di veicoli.

    Crea sottoclassi concrete di Veicolo, come Automobile e Bicicletta, che implementano l'interfaccia.

    Definisci un'interfaccia FabbricaVeicoli con un metodo creaVeicolo().

    Crea classi concrete che implementano FabbricaVeicoli, come FabbricaAutomobili e FabbricaBiciclette, ciascuna restituisce un tipo specifico di veicolo.

    Nel Main, crea istanze delle fabbriche e utilizzale per creare veicoli. */

interface Veicolo{ //

    public void guida();
}

class Automobile implements Veicolo{

    public void guida(){
        System.out.println("Sto guidando un automobile");
    }
}

class Bicicletta implements Veicolo{
    public void guida(){
        System.out.println("Sto guidando una bicicletta");
    }
}

interface FabbricaVeicoli{
    public Veicolo creaVeicolo();
}

class FabbricaAutomobili implements FabbricaVeicoli{

    public Veicolo creaVeicolo(){
        return new Automobile();
    }

}

class FabbricaBiciclette implements FabbricaVeicoli{

    public Veicolo creaVeicolo(){
        return new Bicicletta();
    }

}

class Client8{

    public static void main(String[]args){
        FabbricaVeicoli fabricaAutomobili=new FabbricaAutomobili();

        Veicolo automobile=fabricaAutomobili.creaVeicolo();

        automobile.guida();
    }
}
