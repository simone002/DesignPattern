package javaStream;


import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;



public class eserciziTutorato {
    public record Persona(String name, int age, String role) {}
    public record Prodotto(String nome, double prezzo) {}
    public record Utente(String nome, List<Commento> commenti) {}
    public record Commento(String testo, LocalDate data) {}
    public record Figura(int l1, int l2, int l3, int l4,
                     int a1, int a2, int a3, int a4) {}
    public record   Triangolo(int l1,int l2,int l3,int a1,int a2,int a3){}
    public record   TriangIso(int base,int vertice,int altezza){}
    public record Persona1(String nome, int eta, String nazione) {}


    public static List<Persona> es1(){

        //Data una lista di persone, trovare i nomi dei programmatori con età minore di 30 anni.


    List<Persona> l = List.of(new Persona("Kent", 29, "CTO"),
                          new Persona("Luigi", 25, "Programmer"),
                          new Persona("Andrea", 26, "GrLeader"),
                          new Persona("Sofia", 26, "Programmer"),
                          new Persona("Alfio", 63, "Programmer"));
        return l.stream().filter(s->s.age<30).filter(s->s.role.equals("Programmer")).toList();
    }

    public static List<String> es2() {
        // Data una lista di istanze di Persona trovare i diversi ruoli.
        List<Persona> l = List.of(new Persona("Kent", 29, "CTO"),
                new Persona("Luigi", 25, "Programmer"),
                new Persona("Andrea", 26, "GrLeader"),
                new Persona("Sofia", 26, "Programmer"));
        return l.stream().map(s->s.role).distinct().toList();

    }

    public static List<String> es3(String prefix) {
        // Data una lista di stringhe, produrre una lista che contiene solo le stringhe
        // che cominciano con un certo prefisso noto.

        List<String> l = List.of("author", "auto",
                "autocorrect", "begin",
                "big", "bigger", "biggish");

        return l.stream().filter(s->s.startsWith(prefix)).toList();
    }

    public static String es4(){
        List<String> l = List.of("to", "speak", "the", "truth",
                          "and", "pay", "your", "debts");
        return l.stream().map(s->s.substring(0,1)).reduce("", (acc,i)->acc+i);
    }

    public static List<Integer>es5(){
        /*Data una lista di terne di numeri interi, per ciascuna terna verificare se essa costituisce un triangolo. Restituire la lista dei perimetri per le terne che rappresentano triangoli.
        In un triangolo, ciascun lato è minore della somma degli altri due.
        Si può rappresentare la terna come un array di tre elementi interi*/

        List<List<Integer>> l = List.of(List.of(3, 4, 5), List.of(3, 4, 6),
                                        List.of(3, 4, 7), List.of(3, 4, 8)); 
        return l.stream().
        filter(s->s.get(0)<=s.get(1)+s.get(2))
        .filter(s->s.get(1)<=s.get(0)+s.get(2))
        .filter(s->s.get(2)<=s.get(0)+s.get(1))
        .map(s->s.get(1)+s.get(2)+s.get(0)).toList();
    }

    public static void es6(){
        //verificare se la lista è ordinata 

        List<Integer>l=List.of(1,2,3,4,5,6,7);

        Boolean i=l.stream().reduce(0,(x,y)->(x==null|| x>y)? null:y)!=null;

        System.out.println("Is Ordered: "+i);
    }

    

    public static double es7(){
        //Data una lista di prodotti, restituire il costo totale dei prodotti che hanno un prezzo maggiore di 10.
        
        List<Prodotto> l = List.of(new Prodotto("p1", 5.0), new Prodotto("p2", 10.0),
                                    new Prodotto("p3", 15.0), new Prodotto("p4", 20.0));

        return l.stream().filter(s->s.prezzo>10).map(s->s.prezzo).reduce(0.0, (acc,i)->acc+i);
    }

    public static List<Integer>es8(){

        //Produrre una lista contenente i primi n multipli di 7.

        return Stream.iterate(7, i->i+7).limit(10).toList();
    }

    public static List<Commento>es9(){
        //Data una lista di utenti, restituire tutti i loro commenti ordinati per data.
        List<Utente> l = List.of(
        new Utente("u1",
                List.of(new Commento("c2", LocalDate.of(2021, 1, 2)),
                        new Commento("c1", LocalDate.of(2021, 1, 1)),
                        new Commento("c5", LocalDate.of(2021, 1, 5)))),
        new Utente("u2",
                List.of(new Commento("c4", LocalDate.of(2021, 1, 4)),
                        new Commento("c3", LocalDate.of(2021, 1, 3)))));

                       return l.stream().flatMap(s->s.commenti().stream()).sorted(Comparator.comparing(s->s.data)).toList();
    }

    public static List<Utente>es10(){
        //Restituire gli utenti che hanno pubblicato almeno un commento prima di una certa data

        List<Utente> l = List.of(
        new Utente("u1",
                List.of(new Commento("c2", LocalDate.of(2021, 1, 2)),
                        new Commento("c1", LocalDate.of(2021, 1, 1)),
                        new Commento("c5", LocalDate.of(2021, 1, 5)))),
        new Utente("u2",
                List.of(new Commento("c4", LocalDate.of(2021, 1, 4)),
                        new Commento("c3", LocalDate.of(2021, 1, 3)))));

        return l.stream().filter(s->s.commenti.stream().anyMatch(commento->commento.data.isBefore(LocalDate.of(2021,1,3)))).toList();
    }

    public static Utente es11(){

        //Restituire l'utente che ha pubblicato il commento più recente

        List<Utente> l = List.of(
        new Utente("u1",
                List.of(new Commento("c2", LocalDate.of(2021, 1, 2)),
                        new Commento("c1", LocalDate.of(2021, 1, 1)),
                        new Commento("c5", LocalDate.of(2021, 1, 5)))),
        new Utente("u2",
                List.of(new Commento("c4", LocalDate.of(2021, 1, 4)),
                        new Commento("c3", LocalDate.of(2021, 1, 3)))));

        return l.stream().max(Comparator.comparing(s->s.commenti.stream().max(Comparator.comparing(commento->commento.data)).map(commento->commento.data).orElse(null))).orElse(null);
       

    }

    public static Prodotto es12(){
        //Restituire il prodotto più economico

        List<Prodotto> l = List.of(new Prodotto("p1", 80), new Prodotto("p2", 50),
                           new Prodotto("p3", 10), new Prodotto("p4", 20));

        return l.stream().min(Comparator.comparing(Prodotto::prezzo)).orElse(null);
    }

    public List<Figura> es13(){

        //Restituire tutte le figure che siano rettangoli o quadrati (tutti gli angoli uguali)

        List<Figura> l = List.of(new Figura(12, 12, 12, 12, 45, 45, 135, 135),
                         new Figura(2, 2, 2, 2, 90, 90, 90, 90),
                         new Figura(1, 2, 1, 2, 90, 90, 90, 90));
        
        return l.stream().filter(figura->figura.a1==figura.a2&&figura.a3==figura.a4).toList();
    }

    public static List<Integer>es14(){
        List<Figura> l = List.of(new Figura(12, 12, 12, 12, 45, 45, 135, 135),
                         new Figura(2, 2, 2, 2, 90, 90, 90, 90),
                         new Figura(1, 2, 1, 2, 90, 90, 90, 90));

        return l.stream().map(s->Math.min(Math.min(s.l1, s.l2), Math.min(s.l3, s.l4))).toList();
    }

    public static Integer es15(){

        //Restituire il perimetro minore tra tutte le figure

        List<Figura> l = List.of(new Figura(12, 12, 12, 12, 45, 45, 135, 135),
                         new Figura(2, 2, 2, 2, 90, 90, 90, 90),
                         new Figura(1, 2, 1, 2, 90, 90, 90, 90));
        List<Integer>b= l.stream().map(s->s.l1+s.l2+s.l3+s.l4).toList();

        return b.stream().min(Comparator.comparing(s->s)).orElse(null);

    }

    public static Integer es16(){
        //Ottenere la somma del valore dell'area di tutte le figure

        List<Figura> l = List.of(new Figura(12, 12, 12, 12, 45, 45, 135, 135),
                         new Figura(2, 2, 2, 2, 90, 90, 90, 90),
                         new Figura(1, 2, 1, 2, 90, 90, 90, 90));

        return l.stream().map(s->s.l1*s.l2).reduce(0,(acc,i)->acc+i);
    }

    public static double es17(){

        //Restituire la somma totale dei costi dei 2 prodotti meno cari
        List<Prodotto> l = List.of(new Prodotto("p1", 80),
                           new Prodotto("p2", 40),
                           new Prodotto("p3", 10),
                           new Prodotto("p4", 90));

        double a=l.stream().map(s->s.prezzo).min(Comparator.comparing(s->s)).orElse(null);
        List<Prodotto>copy=l.stream().filter(s->s.prezzo>a).toList();
        double b=copy.stream().map(s->s.prezzo).min(Comparator.comparing(s->s)).orElse(null);
        return a+b;
    }

    public static List<Integer>es18(){
        //Restituire la lista di lati maggiori dei triangoli.

        List<Triangolo> l = List.of(new Triangolo(3, 4, 5, 30, 60, 90),
                            new Triangolo(4, 5, 4, 30, 30, 120),
                            new Triangolo(13, 5, 12, 30, 60, 90),
                            new Triangolo(17, 15, 8, 30, 60, 90));

        return l.stream().map(s->Math.max(Math.max(s.l1,s.l2),s.l3)).toList();
            
    }

    public static List<TriangIso> es19(){

         //restituire lista di triangoli isosceli a partire da una lista di Triangolo

        List<Triangolo> l = List.of(new Triangolo(3, 4, 5, 30, 60, 90),
                            new Triangolo(4, 5, 4, 30, 30, 120),
                            new Triangolo(13, 5, 12, 30, 60, 90),
                            new Triangolo(17, 15, 8, 30, 60, 90));

        List<Triangolo>triangIsosceli=l.stream().filter(s->s.l1==s.l2 || s.l2==s.l3 || s.l1==s.l3).toList();


        return triangIsosceli.stream().map(s->new TriangIso(s.l1,calculateVertice(s.l1,s.a2), calculateAltezza(s.l1, calculateVertice(s.l1,s.a2), s.a2))).toList();
    }

    public static int calculateVertice(int base, int angolo) {
        return (int) (2 * base * Math.sin(Math.toRadians(angolo / 2)));
    }

    // Metodo per calcolare l'altezza in base all'angolo dato
    public static int calculateAltezza(int base, int vertice, int angolo) {
        return (int) (vertice * Math.sin(Math.toRadians(angolo)));
    }

    public static List<Persona1>es20(){
        /*Creare un metodo che prende in ingresso due parametri, min e max, e restituisce una lista di istanze di persona costituita da elementi di gente che hanno età compresa fra min e max. */

        int min=20; int max=40;
        List<Persona1> l = List.of(new Persona1("p1", 10, "n1"),
                          new Persona1("p2", 20, "n1"),
                          new Persona1("p3", 30, "n2"),
                          new Persona1("p4", 40, "n3"),
                          new Persona1("p5", 50, "n3"));
        
        return l.stream().filter(s->s.eta>=min && s.eta<=max).toList();

    }

    public static Integer es21(){
        //Calcolare la somma delle età di tutte le persone nella lista.
        List<Persona1> l = List.of(new Persona1("p1", 10, "n1"),
                          new Persona1("p2", 20, "n1"),
                          new Persona1("p3", 30, "n2"),
                          new Persona1("p4", 40, "n3"),
                          new Persona1("p5", 50, "n3"));

        return l.stream().map(s->s.eta).reduce(0, (eta,i)->eta+i);
    }

    public static List<String>es22(){
        //Restituire la lista di nazioni senza ripetizioni presenti in una lista di gente.

        List<Persona1> l = List.of(new Persona1("p1", 10, "n1"),
                          new Persona1("p2", 20, "n1"),
                          new Persona1("p3", 30, "n2"),
                          new Persona1("p4", 40, "n3"),
                          new Persona1("p5", 50, "n3"));

        return l.stream().map(s->s.nazione).distinct().toList();
    }

    public static Map<String,String> es23(){
        //Restituire una mappa contenente le coppie (nome persone - nazione).
        List<Persona1> l = List.of(new Persona1("p1", 10, "n1"),
                          new Persona1("p2", 20, "n1"),
                          new Persona1("p3", 30, "n2"),
                          new Persona1("p4", 40, "n3"),
                          new Persona1("p5", 50, "n3"));
        return l.stream().collect(Collectors.toMap(s->s.nome,s->s.nazione));

    }


    public static void main(String[]args){
        System.out.println(es19());
        es23().forEach((nome,nazione)->{
            System.out.println(nome+nazione);
        });
        es6();
    }

    
}
