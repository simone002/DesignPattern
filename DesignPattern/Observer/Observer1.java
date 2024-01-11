package Observer;

import java.util.ArrayList;
import java.util.List;

abstract class SubjectBorsa{

    List<Investitore> Investitori;

    public SubjectBorsa(){
        this.Investitori=new ArrayList<>();
    }

    public void addObserver(Investitore i){
        this.Investitori.add(i);
    }

    public void removeObserver(Investitore i){
        this.Investitori.remove(i);
    }

    public void notifyALL1(){
        for (Investitore i : Investitori) {
            i.update(getNomeAzione(),getNuovoPrezzo());
        }
    }

    public abstract String getNomeAzione();
    public abstract double getNuovoPrezzo();

}

class Azione extends SubjectBorsa{
    String nomeAzione;
    double nuovoPrezzo;

    public void setNuovoPrezzoAzione(String nomeAzione,double prezzo){
        this.nomeAzione=nomeAzione;
        this.nuovoPrezzo=prezzo;
        notifyALL1();
    }

    @Override
    public String getNomeAzione(){
        return nomeAzione;
    }
    
    @Override
    public double getNuovoPrezzo(){
        return nuovoPrezzo;
    }
}

interface Investitore{
    public void update(String nomeAzione, double nuovoPrezzo);
}

class ConcreteInvestitore implements Investitore{
    String nomeAzione;
    double nuovoPrezzo;

    public void update(String nomeAzione,double nuovoPrezzo){
        this.nomeAzione=nomeAzione;
        this.nuovoPrezzo=nuovoPrezzo;
    }

    public void display(){
        System.out.println("Nome azione: "+nomeAzione+ " Prezzo: "+nuovoPrezzo);
    }

}

class Client{

    public static void main(String[]args){
        Azione a=new Azione();

        ConcreteInvestitore i1=new ConcreteInvestitore();
        ConcreteInvestitore i2=new ConcreteInvestitore();

        a.addObserver(i1);
        a.addObserver(i2);

        a.setNuovoPrezzoAzione("scarpe",80.0);
        i1.display();
        a.setNuovoPrezzoAzione("scarpe", 90.0);
        i1.display();
    }
}