package Strategy;
/*Immagina di dover creare un sistema per elaborare pagamenti online. Utilizza il design pattern Strategy per consentire l'utilizzo di diverse strategie di pagamento, come pagamento con carta di credito e pagamento con PayPal.

    Definisci un'interfaccia StrategiaPagamento con un metodo effettuaPagamento(importo).

    Crea classi concrete che implementano StrategiaPagamento, rappresentanti diverse strategie di pagamento, come PagamentoCartaCredito e PagamentoPayPal.

    Definisci una classe Utente che ha un attributo strategiaPagamento e un metodo per impostare la strategia di pagamento.

    Utilizza la strategia di pagamento selezionata dall'utente per elaborare un pagamento.
     */

interface Strategy{

    public void effettuaPagamento(int importo);

}

class PagamentoCartaCredito implements Strategy{
    public void effettuaPagamento(int importo){

        System.out.println("pagamento di euro: "+importo +" con carta di credito");
    }
}

class PagamentoPayPal implements Strategy{
    public void effettuaPagamento(int importo){

        System.out.println("pagamento di euro: "+importo +" con Paypal");
    }
}

class Utente1{
    Strategy s;

    public void setS(Strategy s) {
        this.s = s;
    }

    public void execute(int importo){
        s.effettuaPagamento(importo);
    }
}


class Client10{
    public static void main(String[]args){
        Utente1 u=new Utente1();
        

        u.setS(new PagamentoCartaCredito());

        u.execute(100);
    }
}