package ChainOfResponsability;
/*Immagina di dover creare un sistema per l'approvazione di spese all'interno di un'azienda. Utilizza il design pattern Chain of Responsibility per creare una catena di approvatori che possono gestire le richieste di approvazione in ordine crescente di autorità.

    Definisci un'interfaccia Approvatore con un metodo approva(ImportoSpesa spesa).

    Crea diverse classi che implementano Approvatore, ognuna rappresentante un livello di autorità diverso. Ad esempio, Dirigente, Responsabile, e DirettoreGenerale.

    Ogni classe Approvatore deve avere un riferimento all'approvatore successivo nella catena.

    Quando viene chiesta l'approvazione di una spesa, ogni approvatore deve decidere se può approvarla o meno. Se può farlo, la gestisce; altrimenti, passa la richiesta all'approvatore successivo.

    Nel Main, crea una catena di approvatori e invia richieste di approvazione di spese attraverso la catena. */

interface Approvatore{ // handler

    void setSuccessivo(Approvatore successivo);
    public void approva(ImportoSpesa spesa);
}

class ImportoSpesa{
    int importo;

    ImportoSpesa(int importo){
        this.importo=importo;
    }

    public int getImporto(){
        return this.importo;
    }
}

class Dirigente implements Approvatore{
    Approvatore successivo;

    public void setSuccessivo(Approvatore a){
        this.successivo=a;
    }

    public void approva(ImportoSpesa spesa){
        if(spesa.getImporto()<=1000){
            System.out.println("Spesa approvata da Dirigente di euro: "+spesa.getImporto()+"€");
        }
        else{
            successivo.approva(spesa);
        }
    }
}

class Responsabile implements Approvatore{
    Approvatore successivo;

    public void setSuccessivo(Approvatore a){
        this.successivo=a;
    }

    public void approva(ImportoSpesa spesa){
        if(spesa.getImporto()<=500){
            System.out.println("Spesa approvata da Responsabile di euro: "+spesa.getImporto()+"€");
        }
        else{
            successivo.approva(spesa);
        }
    }
}

class DirettoreGenerale implements Approvatore{
    Approvatore successivo;

    public void setSuccessivo(Approvatore a){
        this.successivo=a;
    }

    public void approva(ImportoSpesa spesa){
        if(spesa.getImporto()<=2000){
            System.out.println("Spesa approvata da DirettoreGenerale di euro: "+spesa.getImporto()+"€");
        }
        else{
            successivo.approva(spesa);
        }
    }
}

class Client6{
    public static void main(String[]args){

        ImportoSpesa i=new ImportoSpesa(1001);
        Approvatore d=new Dirigente();
        Approvatore dg=new DirettoreGenerale();
        Approvatore r=new Responsabile();

        r.setSuccessivo(d);
        d.setSuccessivo(dg);

        r.approva(i);


    }
}