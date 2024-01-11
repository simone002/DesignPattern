package Decorator;
interface Gelato{ //Component

	public String getDescrizione();

	public double getCosto();

}

class GelatoBase implements Gelato{ //concrete Component

	
	public String getDescrizione(){
		return "Gelato base";
	}

	public double getCosto(){
	
		return 5.0;
	}
}


class GelatoPanna implements Gelato{//Concrete Component
	
	public String getDescrizione(){
		return "Gelato con panna";
	}

	public double getCosto(){
		return 7.0;
	}

}

abstract class IngredienteAggiuntivo implements Gelato{//Decorator
	
	protected Gelato gelato;

	
	public IngredienteAggiuntivo(Gelato g){
		this.gelato=g;
	}
	
	public String getDescrizione(){
		return gelato.getDescrizione();
	}

	public double getCosto(){
	
		return gelato.getCosto();
	}
	
}

 class GelatoFondente extends IngredienteAggiuntivo{ //Concrete Decorator

	public GelatoFondente(Gelato g){
		super(g);
	}

	public String getDescrizione(){
		return gelato.getDescrizione()+" Cioccolato Fondente";
	}

	public double getCosto(){

		return gelato.getCosto()+3.0;
	}
}





class GranellaNocciole extends IngredienteAggiuntivo{ //Concrete Decorator

	public GranellaNocciole(Gelato g){
		super(g);
	}

	public String getDescrizione(){
		return gelato.getDescrizione()+" Granella di Nocciole";
	}

	public double getCosto(){

		return gelato.getCosto()+3.0;
	}
}

class Client{

	public static void main(String[]args)
	{

		Gelato g1=new GelatoBase();
		Gelato g2=new GelatoPanna();

		Gelato gelatoPannaCioccolatto=new GelatoFondente(g2);
		Gelato gelatoGranella=new GranellaNocciole(g2);
		
		System.out.println("Descrizione g1:"+g1.getDescrizione() + "Costo: "+ g1.getCosto());

		System.out.println("Descrizione g2Cioccolato :"+gelatoPannaCioccolatto.getDescrizione() + " Costo: "+ 		gelatoPannaCioccolatto.getCosto());

		System.out.println(" Descrizione g2Granella:" +gelatoGranella.getDescrizione() + " Costo: "+ gelatoGranella.getCosto());
		

	}

 }
