package Bridge;
interface Dispositivo { // astrazione

    public Boolean accendi();
    public Boolean spegni();

    public void impostaVolume(int volume);


}


class Televisore implements Dispositivo{ //refined abstraction

    boolean acceso;
    int volume;

    public Televisore(){
        this.acceso=false;
        this.volume=50;
    }

    public Boolean accendi(){
        if(!acceso){
            System.out.println("la tv è stata accesa");
            acceso=true;
            return true;
        }
        return false;
    }

    public Boolean spegni(){
        if(acceso){
            System.out.println("la tv è stata spenta");
            acceso=false;
            return true;
        }
        return false;
    }

    public void impostaVolume(int volume){
        if(volume>0 && volume<=100){
            this.volume=volume;
            System.out.println("volume: "+this.volume);
        }
        else{
            System.out.println("il volume deve essere compreso tra 0 e 100");
        }
    }

}

class Radio implements Dispositivo{ //refined abstraction

    boolean acceso;
    int volume;

    public Radio(){
        this.acceso=false;
        this.volume=50;
    }

    public Boolean accendi(){
        if(!acceso){
            System.out.println("la tv è stata accesa");
            acceso=true;
            return true;
        }
        return false;
    }

    public Boolean spegni(){
        if(acceso){
            System.out.println("la tv è stata spenta");
            acceso=false;
            return true;
        }
        return false;
    }

    public void impostaVolume(int volume){
        if(volume>0 && volume<=100){
            this.volume=volume;
            System.out.println("volume: "+this.volume);
        }
        else{
            System.out.println("il volume deve essere compreso tra 0 e 100");
        }
    }

}

interface Telecomando{ //implementator


    public void cambiaCanale(int canale);


}

class TelecomandoBase implements Telecomando{ //concreteImplementator


    Dispositivo dispositivo;

    public TelecomandoBase(Dispositivo dispositivo){
        this.dispositivo=dispositivo;
    }

    public void cambiaCanale(int canale){
        dispositivo.impostaVolume(canale);
        System.out.println("il canale è stato cambiato a: "+canale);
    }

}

class TelecomandoAvanzato extends TelecomandoBase{//Concrete Implementator

    int canalePreferiti[];

    public TelecomandoAvanzato(Dispositivo dispositivo){
        super(dispositivo);
        this.canalePreferiti=new int[5];
    }

    public void impostaCanalePreferito(int numero,int canale){
        if(numero>=1 && numero<=5){
            canalePreferiti[numero-1]=canale;
            System.out.println("canalpreferito n: "+numero+ " impostato a: "+canale);
        }
        else{
            System.out.println("inserire un numero compreso tra 1 e 5");
        }

    }

    public void chiamaCanalePreferito(int numero){
        if(numero>=1 && numero<=5){
            int canalePreferito=canalePreferiti[numero-1];
            dispositivo.impostaVolume(canalePreferito);
            System.out.println("canale cambiato a: "+canalePreferito);
        }
        else{
            System.out.println("inserire un numero compreso tra 1 e 5");
        }
    }
}

class Client{

    public static void main(String[]args){

        Dispositivo d=new Televisore(); // abstraction

        Telecomando t=new TelecomandoAvanzato(d);

        d.accendi();

        d.impostaVolume(12);
        d.spegni();

        t.cambiaCanale(3);

    }
}


