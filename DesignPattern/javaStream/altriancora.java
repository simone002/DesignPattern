package javaStream;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class eserciziboh {

    record Person(String name, int age, String profession) {}
    record Product(String name, double price, double discountPercentage) {}
    enum TransactionType { INCOME, EXPENSE }
    record Transaction(String description, double amount, TransactionType type) {}
    record Student(String name, int score) {}


    public void es1(){
        // filtrare le persone che hanno un'età maggiore di 30 anni e
        // sono ingegneri. Infine, stampa i nomi delle persone che soddisfano questi criteri.
        List<Person> people = List.of(
                new Person("Alice", 28, "Doctor"),
                new Person("Bob", 35, "Engineer"),
                new Person("Charlie", 40, "Engineer"),
                new Person("David", 25, "Teacher"));

                people.stream()
                .filter(s->s.age>30 && s.profession.equals("Engineer"))
                .map(s->s.name)
                .toList().forEach(System.out::println);
    }

    public void es2() {
        //calcolare il prezzo scontato di ciascun prodotto, applicando lo sconto corrispondente
        //, e stampa il nome e il prezzo scontato di ciascun prodotto.
        List<Product> products = List.of(
                new Product("Laptop", 1000.0, 10.0),
                new Product("Phone", 500.0, 15.0),
                new Product("Tablet", 300.0, 8.0));
        products.stream()
        .map(s->new Product("Laptop",(s.price*s.discountPercentage)/100,10.0)).toList().forEach(System.out::println);

    }

    public void es3() {

        //calcolare la somma totale delle entrate (transazioni di tipo "entrata")
        // e stampa il risultato.
        List<Transaction> transactions = List.of(
                new Transaction("Salary", 2000.0, TransactionType.INCOME),
                new Transaction("Rent", 800.0, TransactionType.EXPENSE),
                new Transaction("Groceries", 150.0, TransactionType.EXPENSE),
                new Transaction("Bonus", 500.0, TransactionType.INCOME));

                Double a=transactions.stream()
                .filter(s->s.type.equals(TransactionType.INCOME)).map(s->s.amount).reduce(0.0,(acc,i)->acc+i);
        System.out.println(a);
    }

    public void es4() {

        //unisci i record
        List<Student> list1 = List.of(
                new Student("Alice", 85),
                new Student("Bob", 92),
                new Student("Charlie", 78));

        List<Student> list2 = List.of(
                new Student("David", 88),
                new Student("Eva", 95),
                new Student("Frank", 70));

        List<Student> listUnited= Stream.concat(list1.stream(),list2.stream())
        .toList();

        listUnited.stream().forEach(System.out::println);

    }
    
    record Order(String customerName, double amount, LocalDate date) {
    }

    public void es5() {

        //raggruppare gli ordini per cliente e calcolare il totale degli importi per ciascun cliente.
        List<Order> orders = List.of(
                new Order("Alice", 120.0, LocalDate.of(2023, 8, 15)),
                new Order("Bob", 220.0, LocalDate.of(2023, 8, 16)),
                new Order("Alice", 90.0, LocalDate.of(2023, 8, 16)),
                new Order("Charlie", 150.0, LocalDate.of(2023, 8, 17)));

        
        Map<String, Double> totalAmountsByCustomer = orders.stream()
            .collect(Collectors.groupingBy(Order::customerName, Collectors.summingDouble(Order::amount)));

         totalAmountsByCustomer.forEach((customer, totalAmount) ->
            System.out.println(customer + ": $" + totalAmount));

    }

    record Book(String title, String author, int pageCount) {}
    record BookSummary(String title,String author){}

    public void es6() {
         //filtrare i libri che hanno più di 300 pagine, trasformandoli in un nuovo record
         // che include solo titolo e autore, e infine stampa i titoli dei libri selezionati.
        List<Book> books = List.of(
                new Book("Book1", "Author1", 250),
                new Book("Book2", "Author2", 400),
                new Book("Book3", "Author3", 180),
                new Book("Book4", "Author4", 500));

        books.stream().filter(book->book.pageCount>300)
        .map(book->new BookSummary(book.author,book.title));
    }

    public void es7() {
            // media degli studenti
            List<Student> students = List.of(
                            new Student("Alice", 85),
                            new Student("Bob", 92),
                            new Student("Charlie", 78),
                            new Student("David", 95),
                            new Student("Eva", 88));
        Double A= students.stream()
                .mapToInt(stu->stu.score)
                .average()
                .orElse(0.0);
        System.out.println(A);
    }

    static public void es8() {

        //ordine alfabetico libri autore
            List<BookSummary> books = List.of(
                            new BookSummary("Book1", "Ciccio"),
                            new BookSummary("Book2", "Aurora"),
                            new BookSummary("Book3", "Simone"),
                            new BookSummary("Book4", "Battiato"),
                            new BookSummary("Book5", "Author2"));

        books.stream()
        .sorted(Comparator.comparing(BookSummary::author))
        .toList()
        .forEach(System.out::println);
        
    }

    static public void es9(){

        List<String> words = List.of("Hello", "world", "Java", "streaming", "is", "fun");

       String s= words.stream()
                        .reduce("",(acc,i) ->acc+" "+i);
                                System.out.println(s);
    }

    record Movie(String title, String genre, double rating) {}

    static public void es10() {
        // filtrare i film del genere "Azione" con una valutazione superiore
        // a 8 e stampare il titolo di ciascun film risultante.
            List<Movie> movies = List.of(
                            new Movie("Movie1", "Azione", 7.5),
                            new Movie("Movie2", "Drammatico", 8.2),
                            new Movie("Movie3", "Azione", 9.0),
                            new Movie("Movie4", "Commedia", 7.8),
                            new Movie("Movie5", "Azione", 8.5));

                            movies.stream()
                            .filter(s->s.genre.equals("Azione") && s.rating>8)
                            .map(s->s.title)
                            .toList()
                            .forEach(System.out::println);
    }

    record TemperatureData(String day, double maxTemperature) {}

    static public void es11() {
            List<TemperatureData> temperatureDataList = List.of(
                            new TemperatureData("Lunedì", 28.5),
                            new TemperatureData("Martedì", 26.8),
                            new TemperatureData("Mercoledì", 30.2),
                            new TemperatureData("Giovedì", 29.3),
                            new TemperatureData("Venerdì", 25.6));

        TemperatureData Giornomax = temperatureDataList.stream()
                                        .max(Comparator.comparing(TemperatureData::maxTemperature))
                                        .orElse(null);
        TemperatureData Giornomin= temperatureDataList.stream()
                                                .min(Comparator.comparing(TemperatureData::maxTemperature))
                                                .orElse(null);
        System.out.println("giorno max: "+ Giornomax + "giorno min: "+Giornomin);
    }

    static public void es12() {
            List<Integer> list1 = List.of(5, 2, 8, 3, 5, 1, 2);
            List<Integer> list2 = List.of(9, 2, 5, 7, 1);

            Stream.concat(list1.stream(), list2.stream())
            .distinct()
            .sorted(Comparator.naturalOrder())
            .toList()
            .forEach(System.out::println);

    }

    static public void es13(){
        String text = "Questo è un testo di prova. Un testo semplice per fare esempi.";

        Map<String, Long> tex= Arrays.stream(text.split(" ")) //splitto le parole
                                .map(word->word.toUpperCase())// le rendo tutte grandi
                                .collect(Collectors.groupingBy( // li raggruppo per stringa e numeroCOmparse
                                    word->word,
                                    Collectors.counting()
                                ));
        tex.forEach((Stringa,numero)->System.out.println("Stringa: "+Stringa+ " numero: "+numero));

    }
    record Persona(String name, int age) {}

    static public void es14() {

        //unire le due fonti di dati, rimuovere eventuali duplicati e stampare l'elenco di 
        //persone con le loro età in ordine alfabetico.
        List<Persona> source1 = List.of(
                new Persona("Alice", 28),
                new Persona("Bob", 35),
                new Persona("Charlie", 40));

        List<Persona> source2 = List.of(
                new Persona("David", 25),
                new Persona("Alice", 28),
                new Persona("Eva", 32));

                Stream.concat(source1.stream(),source2.stream())
                        .distinct().forEach(System.out::println);


    }

    record Transactio(String customerName, double amount, LocalDate date) {}
    
    static public void es15() {
        // calcolare la somma totale degli importi per ciascun mese
        // e stampare le statistiche mensili.

        List<Transactio> transactions = List.of(
                new Transactio("Alice", 120.0, LocalDate.of(2023, 8, 15)),
                new Transactio("Bob", 220.0, LocalDate.of(2023, 8, 16)),
                new Transactio("Alice", 90.0, LocalDate.of(2023, 9, 16)),
                new Transactio("Charlie", 150.0, LocalDate.of(2023, 9, 17)));
        
                Map<YearMonth, Double>transactionMonth=transactions.stream()
                .collect(Collectors
                .groupingBy(transaction->YearMonth.from(transaction.date),
                Collectors.summingDouble(Transactio::amount)));

                transactionMonth.forEach((month,amount)->System.out.println("month: "+month+ " amount: "+amount));
    }

    record Persone(String name, double height, double weight) {}

    static public void es16() {
        //calcolare il BMI
        List<Persone> people = List.of(
                new Persone("Alice", 1.65, 60.0),
                new Persone("Bob", 1.80, 75.0),
                new Persone("Charlie", 1.70, 70.0),
                new Persone("David", 1.75, 80.0));

        Map<String,Double>indicemassa=people.stream()
        .collect(Collectors.toMap(Persone::name,s->s.weight/(s.height*s.height)));
    }
    record Transactione(double foreignAmount, double exchangeRate) {}

    static public void es17() {

        // convertire gli importi in dollari e calcolare il totale
        // in dollari per ciascuna valuta straniera.

        List<Transactione> foreignTransactions = List.of(
                new Transactione(100.0, 0.85),
                new Transactione(150.0, 0.92),
                new Transactione(200.0, 0.76),
                new Transactione(120.0, 1.10));

                Map<String,Double>foreign=foreignTransactions.stream()
                .collect(Collectors.groupingBy(s->String.format("%.2f", s.exchangeRate()),
                Collectors.summingDouble(trans->trans.exchangeRate*trans.foreignAmount)));
    }

    record Books(String title, String author, String genre, int pageCount, int year) {}

    static public void es18() {

        List<Books> books = List.of(
                new Books("Book1", "Author1", "Fantasy", 300, 2000),
                new Books("Book2", "Author2", "Mystery", 400, 2010),
                new Books("Book3", "Author3", "Fantasy", 250, 2015),
                new Books("Book4", "Author4", "Science Fiction", 350, 2020),
                new Books("Book5", "Author5", "Mystery", 280, 2012));

                //calcolare il numero medio di pagine per genere e stampare le statistiche.

                Map<String,Double> numeroMedio=books.stream()
                .collect(Collectors.groupingBy(Books::genre,Collectors.averagingInt(Books::pageCount)));

                numeroMedio.forEach((genre,numpag)->System.out.println("genre: "+genre+ " numpag: "+numpag));
    }

    record WeatherData(LocalDate date, double maxTemperature, double humidity) {}

    static public void es19() {

        //calcolare la temperatura media e l'umidità media per ciascun mese 
        //e stampare le statistiche mensili.
        List<WeatherData> weatherDataList = List.of(
                new WeatherData(LocalDate.of(2023, 8, 15), 28.5, 75.0),
                new WeatherData(LocalDate.of(2023, 8, 16), 26.8, 80.0),
                new WeatherData(LocalDate.of(2023, 9, 16), 30.2, 65.0),
                new WeatherData(LocalDate.of(2023, 9, 17), 29.3, 70.0));

        Map<YearMonth,Double> temperaturaMedia=weatherDataList.stream()
        .collect(Collectors.groupingBy(wea->YearMonth.from(wea.date),
        Collectors.averagingDouble(WeatherData::maxTemperature)));

        Map<YearMonth,Double> umiditàMedia=weatherDataList.stream()
        .collect(Collectors.groupingBy(wea->YearMonth.from(wea.date),
        Collectors.averagingDouble(WeatherData::humidity)));
    }






    public static void main(String[]args){
        //es9();
       // es12();
       //es13();
       es18();
    }
}
