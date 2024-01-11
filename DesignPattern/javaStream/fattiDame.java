package javaStream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/*ato il seguente record creare i seguenti metodi:
    *
    * a) Creare due Liste a1 e a2 di tipo Auto messe come attributo della classe;
    * b) Creare un metodo che ritorni la lista di auto contenente le macchine delle due liste che hanno lo stesso colore; 
    * c) Creare un metodo che, avendo un parametro String col, ritorni le macchine che hanno lo stesso colore di col;
    * d) Creare un metodo che ritorni il numero di macchine presenti sia in a1 che in a2;
    
    public record Auto(String categoria, int costo, String Colore){}
     */
record Auto(String categoria, int costo, String Colore){}
record Studente(String nome, double voto) {}
record Libro(String titolo, String autore, int annoPubblicazione, int numeroPagine) {}
record Transazione(String data, double ammontare) {}



class Soluzioni{
    
    List<Auto> a1;
    List<Auto> a2;

    public Soluzioni(List<Auto> a1, List<Auto>a2){
        this.a1=new ArrayList<>(a1);
        this.a2=new ArrayList<>(a2);

    }

    public List<Auto> sameColor(){
        return a1.stream().flatMap(auto1->a2.stream().filter(auto2->auto2.Colore().equals(auto1.Colore()))).toList();
    }

    public List<Auto>colorParamter(String col){
        return a1.stream().filter(s->s.Colore().equals(col)).toList();
    }

    public Long numMacchine(){
        return a1.stream().filter(auto1->a2.stream().anyMatch(auto2->auto2.equals(auto1))).count();
    }


    
}

class StringManager{

    /*   aggiungiStringa(String stringa): Aggiunge una stringa all'elenco.

    getStringheContenenti(String sottostringa): Restituisce una lista di stringhe che contengono 
    la sottostringa specificata.

    getStringheMaiuscole(): Restituisce una lista di stringhe trasformate in maiuscolo.

    getLunghezzaMedia(): Restituisce la lunghezza media delle stringhe nell'elenco. */

    List<String> l;

    public StringManager(List<String>l){
        this.l=new ArrayList<>(l);
    }

    public void aggiungiStringa(String stringa){l.add(stringa);}

    public List<String> getStringheContenenti(String subString){
        return l.stream().filter(s->s.contains(subString)).toList();
    }

    public List<String> maiscole(){
        return l.stream().map(s->s.toUpperCase()).toList();
    }

    public double lunghezzamedia(){
        return l.stream().mapToInt(s->s.length()).average().orElse(0.0);
    }
}

class StudentManager{

    /*    aggiungiStudente(Studente studente): Aggiunge uno studente all'elenco.

    getStudentiConVotoMaggiore(double voto): Restituisce una lista di studenti con un
     voto maggiore o uguale a quello specificato.

    getMediaVoti(): Restituisce la media dei voti di tutti gli studenti.


    getStudenteMigliore(): Restituisce lo studente con il voto più alto.

    getStudentiOrdinatiPerNome(): Restituisce una lista di studenti ordinati per nome. */

    List<Studente>l;
    public StudentManager(List<Studente>l){
        this.l=new ArrayList<>(l);
    }

    public void aggiungiStudente(Studente s){
        l.add(s);
    }

    public List<Studente> getStudentiConVotoMaggiore(double voto){
        return l.stream().filter(s->s.voto()>voto).toList();
    }

    public double getMediaVoti(){
        return l.stream().mapToDouble(s->s.voto()).average().orElse(0.0);
    }

    public Studente studenteMigliore(){
        return l.stream().max(Comparator.comparing(Studente::voto)).orElse(null);
    }

    public List<Studente>OrdinatiPerNome(){

        return l.stream().sorted(Comparator.comparing(Studente::nome)).toList();
    }



}

class LibroManager{


    List<Libro> l;

    public LibroManager(List<Libro>l){
        this.l=new ArrayList<>(l);
    }

    public void addLibro(Libro l){
        this.l.add(l);
    }

    public List<Libro> getLibriDiAutore(String autore){
        return l.stream().filter(s->s.autore().equals(autore)).toList();
    }

    public List<Libro>getPubblicatiDopo(int anno){
        return l.stream().filter(s->s.annoPubblicazione()>anno).toList();
    }

    public Integer getNumeroTotPagineLibri(){
        return l.stream().map(s->s.numeroPagine()).reduce(0,(acc, i)->acc+i);
    }

    public Libro getLibroConPagMinime(int numeroPag){
        return l.stream().filter(s->s.numeroPagine()==numeroPag).findFirst().orElse(null);
    }


}

class TransazioneManager{
    /*    aggiungiTransazione(Transazione transazione): Aggiunge una transazione all'elenco.

    getTransazioniInData(String data): Restituisce una lista di transazioni
     avvenute nella data specificata.

    getTotaleAmmontareInData(String data): Restituisce il totale dell'ammontare 
    delle transazioni avvenute nella data specificata.

    getMediaAmmontare(): Restituisce la media dell'ammontare di tutte le transazioni.

    getTransazioniPiuAlte(int n): Restituisce le prime n transazioni con l'ammontare più alto. */
    List<Transazione>t;

    public TransazioneManager(List<Transazione>t){
        this.t=new ArrayList<>(t);
    }

    public void addTransazione(Transazione t){
        this.t.add(t);
    }

    public List<Transazione> getTransazioneData(String data){
        return t.stream().filter(s->s.data().equals(data)).toList();
    }

    public Double getAmmontareInData(String data){
        return t.stream().filter(s->s.data().equals(data)).map(s->s.ammontare()).reduce(0.0,(acc,i)->acc+i);
    }


    public List<Transazione>getTransazionePiùAlte(int n){
        return t.stream().sorted(Comparator.comparingDouble(Transazione::ammontare).reversed()).limit(n).toList();
    }

}


public class fattiDame {
    public static void main(String[]args){

    }

}
