import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

public class App {

    /**
     * 1. Filtro per Elementi Specifici:
     * Scrivi un programma in Java che utilizza lambda e stream per filtrare una
     * lista di stringhe, selezionando solo quelle che iniziano con la lettera 'A' e
     * le stampa a schermo.
     * 
     * 2. Conversione e Mappatura:
     * Dato un elenco di numeri interi, usa lambda e stream per convertire ogni
     * numero nella sua rappresentazione quadrata e crea una nuova lista con questi
     * valori. Stampare la lista risultante.
     * 
     * 3. Ricerca di Elementi:
     * Utilizza lambda e stream per trovare il primo numero pari in una lista di
     * interi. Se esiste, stampa questo numero; altrimenti, stampa un messaggio che
     * dice "Nessun numero pari trovato".
     * 
     * 4. Aggregazione di Valori:
     * Scrivi un programma che utilizza lambda e stream per calcolare la somma degli
     * elementi in una lista di numeri decimali (double). Stampa il risultato.
     * 
     * 5. Ordinamento e Raccolta:
     * Dato un elenco di nomi, usa lambda e stream per ordinarli in ordine
     * alfabetico inverso e poi raccoglili in una nuova lista. Stampa la lista
     * ordinata.
     */
    public static void main(String[] args) throws Exception {
        // es1();
        // es2();
        es3();
        // es4();
        // es5();
    }

    public static void es1(){
        List<String> valueStrings = new ArrayList<>();
        valueStrings.add("qwerty");
        valueStrings.add("ancora");
        valueStrings.add("parole a caso");
        valueStrings.add("anche questa stringa bellissima");
        System.out.println("la tua lista iniziale contiene: " + valueStrings.size() + " stringhe\n ----------------------------------------------");
        valueStrings.stream()
        .filter(v -> v.startsWith("a"))
        .forEach(System.out::println);
    }

    public static void es2(){
        List<Integer> values = new ArrayList<>();
        Random rnd = new Random();

        for(int i = 0; i < 10; i++){
            int value = rnd.nextInt(51);
            values.add(value);
        }
        System.out.println("questa è la lista iniziale di numeri interi (casuali): " + values + "\n---------------------------------------------------");

       List<Integer> newValuesToTheSecond = values.stream()
        .map(v -> v * v)
        .collect(Collectors.toList());

        System.out.println("questa è la lista iniziale di numeri interi (casuali) elevati alla seconda: \" + values" + newValuesToTheSecond);
    }

    public static void es3(){
        List<Integer> values = new ArrayList<>();
        Random rnd = new Random();
        for(int i = 0; i < 3; i++){
            int value = rnd.nextInt(101);
            values.add(value);
        }
        System.out.println("questa è la mia lista iniziale di interi (casuali): " + values + "\n---------------------------------------------------");

        Optional<Integer> newValue = values.stream()
        .filter(v -> v % 2 == 0)
        .findFirst();

        if(newValue.isPresent()){
            int singleValue = newValue.get();
            System.out.println("il primo numero pari trovato è: " + singleValue);
        }else{
            System.out.println("non è presente nessun numero pari");
        }
    }

    public static void es4(){
        List<Double> values = new ArrayList<>();
        Random rnd = new Random();
        for(int i = 0; i < 10; i++){
            Double value = rnd.nextDouble(101.0);
            values.add(value);
        }
        System.out.println("questa è la lista iniziale di numeri decimali: " + values + "\n-----------------------------------------------------");
    
        

        Double sum = values.stream()
        .reduce(0.0, Double::sum);
        
        System.out.println("La somma di tutti i valori è: " + sum);
    }

    public static void es5(){
        List<String> valuesStrings = new ArrayList<>();
        valuesStrings.add("Marco");
        valuesStrings.add("Andrea");
        valuesStrings.add("Giulia");
        valuesStrings.add("Sara");
        System.out.println("questa è la mia ista iniziale di nomi: " + valuesStrings + "\n--------------------------------------------------");

        List<String> newValuesStrings = valuesStrings.stream()
        .sorted((s1, s2) -> s2.compareTo(s1))
        .collect(Collectors.toList());

        System.out.println("questa è la lista di nomi in ordine alfabetico inverso: " + newValuesStrings);
    }
}