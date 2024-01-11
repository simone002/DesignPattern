// Stato astratto
interface StatoFormato {
    String getDimensione();
    int getCosto();
    int getNumeroPagine();
}

// Stati concreti
class FormatoTascabile implements StatoFormato {
    public String getDimensione() {
        return "A4";
    }

    public int getCosto() {
        return 45;
    }

    public int getNumeroPagine() {
        return 100;
    }
}

class FormatoGrande implements StatoFormato {
    public String getDimensione() {
        return "A3";
    }

    public int getCosto() {
        return 60;
    }

    public int getNumeroPagine() {
        return 150;
    }
}

// Contesto
class LibroContext {
    private StatoFormato stato;

    public LibroContext() {
        stato = new FormatoTascabile(); // Stato iniziale
    }

    public void setStato(StatoFormato nuovoStato) {
        stato = nuovoStato;
    }

    public String getDimensione() {
        return stato.getDimensione();
    }

    public int getCosto() {
        return stato.getCosto();
    }

    public int getNumeroPagine() {
        return stato.getNumeroPagine();
    }
}

// Classe client
class Client {
    public static void main(String[] args) {
        LibroContext libro = new LibroContext();

        System.out.println("Formato tascabile:");
        System.out.println("Dimensione: " + libro.getDimensione());
        System.out.println("Costo: " + libro.getCosto());
        System.out.println("Numero pagine: " + libro.getNumeroPagine());

        libro.setStato(new FormatoGrande());
        System.out.println("\nFormato grande:");
        System.out.println("Dimensione: " + libro.getDimensione());
        System.out.println("Costo: " + libro.getCosto());
        System.out.println("Numero pagine: " + libro.getNumeroPagine());
    }
}
