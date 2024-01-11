package Command;
/*Immagina di dover creare un sistema di controllo remoto per vari dispositivi, come televisori e luci. Utilizza il design pattern Command per separare le richieste di controllo dai dispositivi stessi e consentire il controllo flessibile dei dispositivi tramite comandi.

    Definisci un'interfaccia Comando con un metodo esegui().

    Crea classi concrete che implementano l'interfaccia Comando, rappresentando varie azioni che possono essere eseguite su dispositivi (ad esempio, accensione, spegnimento, aumento volume, ecc.).

    Definisci classi per i dispositivi, come Televisore e Luce, con metodi che rappresentano le azioni che i dispositivi possono eseguire (ad esempio, accendi(), spegni(), aumentaVolume()).

    Crea una classe ControlloRemoto che abbia metodi per assegnare comandi ai pulsanti del telecomando e per eseguirli.

    Nel Main, crea istanze di dispositivi, comandi e del controllo remoto. Assegna i comandi ai pulsanti del controllo remoto e utilizzalo per eseguire azioni sui dispositivi. */



interface Comando{//command
    public void esegui();
}

class Accensione implements Comando{//concrete comand

    Televisore t;
    Accensione(Televisore televisore){
        this.t=televisore;
    }
    public void esegui(){
        t.accendi();
    }
}

class Spegnimento implements Comando{// concrete comand

    Televisore t;

    Spegnimento(Televisore t){
        this.t=t;
    }

    public void esegui(){
        t.spegni();
    }
}

class Televisore{//receiver

      public void accendi() {
        System.out.println("Televisore acceso.");
    }

    public void spegni() {
        System.out.println("Televisore spento.");
    }
}

class ControlloRemoto{//invoker

    Comando a;
    Comando b;

    public void setComandoA(Comando a){
        this.a=a;
    }

    public void setComandoB(Comando b){
        this.b=b;
    }

    public void premiPulsanteA(){
        a.esegui();
    }

    public void premiPulsanteB(){
        b.esegui();
    }
}

class Client7{

    public static void main(String[]args){
        Televisore t=new Televisore();
        Comando a= new Accensione(t);
        Comando b= new Spegnimento(t);

        ControlloRemoto remoto=new ControlloRemoto();

        remoto.setComandoA(a);
        remoto.setComandoB(b);

        remoto.premiPulsanteA();
        remoto.premiPulsanteB();
    }
}