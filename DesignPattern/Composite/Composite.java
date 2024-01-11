package Composite;
/*Immagina di dover rappresentare una struttura gerarchica di un'organizzazione, composta da dipendenti e manager. Utilizza il design pattern Composite per gestire questa struttura in modo gerarchico.

    Definisci un'interfaccia ComponenteOrganizzazione con metodi comuni per tutti i componenti dell'organizzazione (dipendenti e manager), ad esempio getNome() e getPosizione().

    Crea una classe Dipendente che implementa ComponenteOrganizzazione. Questa classe rappresenterà un dipendente all'interno dell'organizzazione.

    Crea una classe Manager che estende Dipendente. I manager possono avere sottoposti, che saranno altri ComponenteOrganizzazione.

    Aggiungi metodi aggiungiSottoposto() e rimuoviSottoposto() alla classe Manager per gestire i sottoposti.

    Nel Main, crea una gerarchia di dipendenti e manager all'interno dell'organizzazione. Utilizza i metodi per aggiungere e rimuovere sottoposti dai manager. */

import java.util.ArrayList;
import java.util.List;

interface ComponenteOrganizzazione{//component

    public String getNome();
    public String getPosizione();
}

class Dipendente implements ComponenteOrganizzazione{ //leaf
    String nome;
    String posizione;

    Dipendente(String nome,String posizione){
        this.nome=nome;
        this.posizione=posizione;
    }

    public String getNome(){
        return nome;
    }

    public String getPosizione(){
        return posizione;
    }
}

class Manager extends Dipendente{ //composite

    List<ComponenteOrganizzazione>sottoposti;



    Manager(String nome,String posizione){
        super(nome, posizione);
        sottoposti=new ArrayList<>();
    }

    public void addSottoposto(ComponenteOrganizzazione c){
        sottoposti.add(c);
    }

    public void removeSottoposto(ComponenteOrganizzazione c){
        sottoposti.remove(c);
    }

    public List<ComponenteOrganizzazione> getSottoposti() {
        return sottoposti;
    }

}

class Client4{

    public static void main(String[]args){
        ComponenteOrganizzazione dipendente=new Manager("Fabrizione", "Sviluppatore");

        Manager m=new Manager("Giuseppe", "Ceo");

        m.addSottoposto(dipendente);

        Manager manager2 = new Manager("David", "Direttore Dipartimento");
        manager2.addSottoposto(m);

        stampaGerarchia(manager2, " ");


    }
    public static void stampaGerarchia(ComponenteOrganizzazione componente, String spazi) {
        System.out.println(spazi + componente.getNome() + " - " + componente.getPosizione());

        if (componente instanceof Manager) {
            for (ComponenteOrganizzazione sottoposto : ((Manager) componente).getSottoposti()) {
                stampaGerarchia(sottoposto, spazi + "  ");
            }
        }
    }
}