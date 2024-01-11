package Bridge;
/*    Definisci un'interfaccia SistemaOperativo con metodi per monitorare le performance del sistema.

    Crea classi concrete che implementano l'interfaccia SistemaOperativo,
    rappresentando diversi sistemi operativi, come Windows e Linux.

    Definisci un'interfaccia ArchitetturaProcessore con metodi per ottenere 
    informazioni sul processore.

    Crea classi concrete che implementano l'interfaccia ArchitetturaProcessore, 
    rappresentando diverse architetture di processori, come x86 e ARM.

    Definisci una classe astratta MonitorPerformance che ha un riferimento
    sia a un oggetto SistemaOperativo che a un oggetto ArchitetturaProcessore, e metodi per monitorare le performance.

    Crea classi concrete che estendono MonitorPerformance, utilizzando
     diverse combinazioni di sistemi operativi e architetture di processori. */
interface SistemaOperativo{ // implementator
    public void operation();
}

interface ArchitetturaProcessore{//implementator
    public void operation();
}

class Windows implements SistemaOperativo{ //concrete implementator

    public void operation(){
        System.out.println("questo è un sistema windows");
    }
}

class Linux implements SistemaOperativo{ //concrete implementator

    public void operation(){
        System.out.println("questo è un sistema linux");
    }
}

class X86 implements ArchitetturaProcessore{// concrete implementator
    public void operation(){
        System.out.println("questo sistema ha un architettura x86");
    }
}

class ARM implements ArchitetturaProcessore{
    public void operation(){
        System.out.println("questo sistema ha un architettura ARM");
    }
}

abstract class MonitorPerformance{ // astrazione
    SistemaOperativo sistema;
    ArchitetturaProcessore processore;

    public MonitorPerformance(SistemaOperativo sistema, ArchitetturaProcessore processore){
        this.sistema=sistema;
        this.processore=processore;
    }

    abstract public void avvioMonitoraggio();
}

class MonitorWindowsX86 extends MonitorPerformance{  // refined abstraction

    

    public MonitorWindowsX86(){
        super(new Windows(), new X86());
    }

    @Override
    public void avvioMonitoraggio(){
       this.sistema.operation();
       this.processore.operation();
    }

}

class Client1{
    static public void main(String[]args){
        MonitorPerformance monitor=new MonitorWindowsX86();

        monitor.avvioMonitoraggio();
    }
}
