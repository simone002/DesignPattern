package Decorator;

interface Cafè{ // component

    public double getCosto();

    public String getDesc();
}

class CaffèNorm implements Cafè{ //concrete component

    public double getCosto(){
        return 1.00;
    }

    public String getDesc(){
        return "Caffè Norm";
    }
}

abstract class IngredienteAggiunto implements Cafè{ // decorator

    Cafè c;

    public IngredienteAggiunto(Cafè c){
        this.c=c;
    }

    public double getCosto(){
        return this.c.getCosto();
    }

    public String getDesc(){
        return this.c.getDesc();
    }


}

class CaffèLatte extends IngredienteAggiunto{ // concrete decorator

    public CaffèLatte(Cafè c){
        super(c);
    }

    public double getCosto(){
        return this.c.getCosto()+0.50;
    }

    public String getDesc(){
        return this.c.getDesc()+" a Latte";
    }
}

class Client1{

    public static void main(String[] args) {
        Cafè c = new CaffèNorm();

        Cafè clatte = new CaffèLatte(c);

        System.out.println(clatte.getDesc());
        System.out.println(clatte.getCosto());
    }
}