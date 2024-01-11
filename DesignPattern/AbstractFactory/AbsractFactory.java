/*Immagina di dover creare un sistema per la produzione di mobili, come sedie e tavoli. Utilizza il design pattern Abstract Factory per consentire la creazione di famiglie di oggetti correlati, come famiglie di mobili in stili diversi.

    Definisci un'interfaccia Sedia con un metodo descrizione().

    Crea sottoclassi concrete di Sedia, come SediaLegno e SediaMetallo, che implementano l'interfaccia.

    Definisci un'interfaccia Tavolo con un metodo descrizione().

    Crea sottoclassi concrete di Tavolo, come TavoloLegno e TavoloMetallo, che implementano l'interfaccia.

    Definisci un'interfaccia FabbricaMobili con metodi per creare sia sedie che tavoli.

    Crea classi concrete che implementano FabbricaMobili, come FabbricaMobiliLegno e FabbricaMobiliMetallo, ciascuna restituisce una famiglia specifica di mobili.

    Nel Main, crea istanze delle fabbriche e utilizzale per creare sia sedie che tavoli. */

interface Sedia{
    public void descrizione();
}

class SediaLegno implements Sedia{

    public void descrizione(){
        System.out.println("Sedia di legno");
    }
}

class SediaMetallo implements Sedia{

    public void descrizione(){
        System.out.println("Sedia di Metallo");
    }
}

interface Tavolo{
    public void descrizione();
}

class TavoloLegno implements Tavolo{
    public void descrizione(){
        System.out.println("Tavolo di legno");
    }
}

class TavoloMetallo implements Tavolo{
    public void descrizione(){
        System.out.println("Tavolo di metallo");
    }
}

interface FabricaMobili{
    public Tavolo createTavolo();
    public Sedia createSedia();
}

class FabbricaMobiliLegno implements FabricaMobili{
    public Tavolo createTavolo(){
        return new TavoloLegno();
    }

    public Sedia createSedia(){
        return new SediaLegno();
    }
}

class FabbricaMobiliMetallo implements FabricaMobili{
    public Tavolo createTavolo(){
        return new TavoloMetallo();
    }

    public Sedia createSedia(){
        return new SediaMetallo();
    }
}

class Client9{
    public static void main(String[]args){
        FabricaMobili fabricaMobiliLegno=new FabbricaMobiliLegno();
        Sedia sediaLegno=fabricaMobiliLegno.createSedia();
        Tavolo tavoloLegno=fabricaMobiliLegno.createTavolo();

        sediaLegno.descrizione();
        tavoloLegno.descrizione();
    }
}

