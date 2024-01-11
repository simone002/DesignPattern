package Command;

interface Command{ 

    public void esegui();

}

class OrdineChef implements Command{ // concrete command

    Chef c;
    String piatto;

    public OrdineChef(Chef c, String piatto){
        this.c=c;
        this.piatto=piatto;
    }



    public void esegui(){

        c.preparaPiatto(piatto);
    }
}

class PreparazionePiatto implements Command{ //concrete command

    String piatto;
    Chef c;

    public PreparazionePiatto(Chef c,String piatto){
        this.piatto=piatto;
        this.c=c;
    }

    public void esegui(){
        c.piattoPronto(piatto);
    }
}


class Chef{ // recever

    public void preparaPiatto(String piatto){
        System.out.println("Sto preparando il piatto: "+piatto);
        Command c=new PreparazionePiatto(this,piatto);
        c.esegui();
    }

    public void piattoPronto(String piatto){
        System.out.println("il piatto: "+piatto+" è pronto");
    }
}

class Cliente{// Invoker
    public Command effetuaOrdine(Cameriere c,String piatto){
        return new OrdineChef(c.getChef(), piatto);
    }
}

class Cameriere{ // recever
    Chef c;
    
    public Cameriere(Chef c){
        this.c=c;
    }

    public Chef getChef(){
        return this.c;
    }

    public Command prendiOrdine(Cliente c,String piatto){
        return c.effetuaOrdine(this, piatto);
    }

    public void serviPiatto(String piatto){
        System.out.println("Il cameriere serve il piatto: "+piatto);
    }
}

class ServizioTavolo implements Command{

    Cameriere c;
    String piatto;

    public ServizioTavolo(Cameriere c,String piatto){
        this.c=c;
        this.piatto=piatto;
    }

    public void esegui(){
        c.serviPiatto(piatto);
    }

}

class Client1{

    public static void main(String[] args) {
        Chef c=new Chef();
        Cameriere cameriere=new Cameriere(c);
        Cliente client=new Cliente();

        Command Ordine= cameriere.prendiOrdine(client,"Spaghetti");
        Ordine.esegui();
    }
}