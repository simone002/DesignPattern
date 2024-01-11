package FactoryMethod;


interface ModalitàConsegna{

    public void effetuaConsegna();
}

class ConsegnaStandard implements ModalitàConsegna{

    public void effetuaConsegna(){
        System.out.println("sto effettuando la consegna Standard");
    }
}

class ConsegnaRapida implements ModalitàConsegna{

    public void effetuaConsegna(){
        System.out.println("sto effettuando la consegna Rapida");
    }
}

class Cliente{

    public void inviaPacco(ModalitàConsegna m){
        m.effetuaConsegna();
    }
}

abstract class FattoriaConsegna{
    public abstract ModalitàConsegna creaModalitàConsegna();
}

class FattoriaConsegnaVeloce extends FattoriaConsegna{
    public ModalitàConsegna creaModalitàConsegna(){
        return new ConsegnaRapida();
    }
}

class FattoriaConsegnaStandard extends FattoriaConsegna{
    public ModalitàConsegna creaModalitàConsegna(){
        return new ConsegnaStandard();
    }
}

class Client{
    public static void main(String[]args){
        Cliente c=new Cliente();
        FattoriaConsegna f=new FattoriaConsegnaStandard();

        c.inviaPacco(f.creaModalitàConsegna());
    }
}

