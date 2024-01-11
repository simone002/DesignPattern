package Mediator;
/*Immagina di dover creare una chat room in cui più utenti possono inviare messaggi agli altri utenti della chat. Utilizza il design pattern Mediator per gestire le interazioni tra gli utenti nella chat.

    Definisci un'interfaccia Mediatore con metodi per registrare utenti e inviare messaggi.

    Crea una classe ChatMediatore che implementa Mediatore. Questa classe gestirà la registrazione degli utenti e l'invio dei messaggi.

    Definisci una classe Utente che rappresenta un utente della chat. Ogni utente avrà un nome e un riferimento al mediatore.

    Implementa un metodo inviaMessaggio() nella classe Utente. Quando un utente invia un messaggio, verrà utilizzato il mediatore per distribuire il messaggio agli altri utenti.

    Nel Main, crea un'istanza del mediatore e più istanze di utenti. Registra gli utenti presso il mediatore e fai in modo che inviino messaggi tra di loro. */

import java.util.ArrayList;
import java.util.List;



interface Mediator{
    public void regUser(Utente u);
    public void sendMessage(Utente u,String m);
}

class ChatMediatore implements Mediator{

    List<Utente>utenti;

    ChatMediatore(){
        utenti=new ArrayList<>();
    }

    public void regUser(Utente u){
        utenti.add(u);
    }

    public void sendMessage(Utente mittente,String m){
        for(Utente utente:utenti){
            if(utente!=mittente){
                utente.recvMessage(m);
            }
        }
    }
}

class Utente{

    String nome;
    Mediator m;

    Utente(String nome,Mediator m){
        this.nome=nome;
        this.m=m;
    }

    public void sendMessage(String message){
        System.out.println(nome+ " Invia il messaggio: "+message);
        m.sendMessage(this, message);
    }

    public void recvMessage(String m){
        System.out.println(nome+" Riceve il messaggio: "+m);
    }
}

class Client5{
    public static void main(String[]args){
        Mediator m=new ChatMediatore();


        Utente u=new Utente("Pippo",m);
        Utente a=new Utente("giacomo", m);

        m.regUser(u);
        m.regUser(a);

        u.sendMessage("ciao giacomo");



    }
}
