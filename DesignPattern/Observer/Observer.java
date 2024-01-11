package Observer;
/*a) Definire una classe DatiMeteo che rappresenta il soggetto con cui gli osservatori si registrano per ricevere le notifiche sugli aggiornamenti.
b) Creare un'interfaccia Visualizzatore con un metodo aggiorna(float temperatura, float umidita, float pressione) per essere implementata dai visualizzatori che vogliono ricevere gli aggiornamenti.
c) Implementare diverse classi concrete che implementano l'interfaccia Visualizzatore per rappresentare diversi tipi di visualizzatori (ad esempio, visualizzatore per temperatura, visualizzatore per umidità, visualizzatore per pressione, ecc.).
d) Nella classe DatiMeteo, definire metodi per registrare osservatori (registraVisualizzatore(Visualizzatore visualizzatore)) e annullare la registrazione (rimuoviVisualizzatore(Visualizzatore visualizzatore)).
e) Implementare i metodi per aggiornare i dati meteorologici nella classe DatiMeteo (setDatiMeteo(float temperatura, float umidita, float pressione)) e notificare automaticamente tutti i visualizzatori registrati ogni volta che i dati vengono aggiornati.
f) Creare una classe Main che dimostri l'utilizzo del pattern Observer creando una istanza di DatiMeteo, registrando alcuni visualizzatori e aggiornando i dati meteorologici.
g) Aggiungi ulteriori visualizzatori o nuovi tipi di dati meteorologici se lo desideri e testa le notifiche automatiche nei visualizzatori registrati.*/

import java.util.ArrayList;
import java.util.List;

abstract class DatiMeteo{//soggetto

	List<Visualizzatore>v;

	public DatiMeteo(){
		v=new ArrayList<>();
	}

	public void registraVisualizzatore(Visualizzatore v){
		this.v.add(v);
	}

	public void rimuoviVisualizzatore(Visualizzatore v){
		this.v.remove(v);
	}

	public void notifyALL(){
		for(Visualizzatore visualizzatore:v){
			visualizzatore.update(temperatura(),umidita(),pressione());
		}
	}

	public abstract float temperatura();
    public abstract float umidita();
    public abstract float pressione();

}

class ConcreteDatiMeteo extends DatiMeteo{ //concrete subject

	float temperatura;
	float umidita;
	float pressione;

	public void setDatiMeteo(float temperatura,float umidita,float pressione){
		this.temperatura=temperatura;
		this.pressione=pressione;
		this.umidita=umidita;
		notifyALL();
	}
	
	public void getDatiMeteo(){
		System.out.println("Temperatura: "+temperatura+ " umidità: "+umidita+" pressione: "+pressione);
	}

	@Override
	public float temperatura(){
		return temperatura;
	}

	@Override 
	public float umidita(){
		return umidita;
	}

	@Override
	public float pressione(){
		return pressione;
	}


}

interface Visualizzatore{//observer 
	public void update(float temperatura, float umidita,float pressione);
}

class concreteVisualizzatore implements Visualizzatore{ //concrete observer

	float temperatura;
	float umidita;
	float pressione;

	public void update(float temperatura,float umidita,float pressione){
		this.temperatura=temperatura;
		this.umidita=umidita;
		this.pressione=pressione;
		display();
	}

	public void display(){
		System.out.println("Temperatura: "+ temperatura+" umidità: "+umidita+" pressione: "+pressione);
	}

}

class Client1 {
    public static void main(String[] args) {
        // Dichiarazione di d come oggetto ConcreteDatiMeteo
        ConcreteDatiMeteo d = new ConcreteDatiMeteo();

        Visualizzatore v = new concreteVisualizzatore();
		Visualizzatore b=new concreteVisualizzatore();

        // Registra il visualizzatore con l'oggetto d
        d.registraVisualizzatore(v);
		d.registraVisualizzatore(b);

        // Chiamata a setDatiMeteo sull'oggetto d (che è di tipo ConcreteDatiMeteo)
        d.setDatiMeteo(12.0f, 10.0f, 11.0f);

    }
}



