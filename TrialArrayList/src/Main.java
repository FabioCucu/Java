import java.util.*;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> integerList = new ArrayList<>();
        // add
        integerList.add(10);
        integerList.add(20);
        integerList.add(30);
        integerList.add(40);

        // forEach
        integerList.forEach(System.out::println);
        System.out.println("==============================================================\nRemove 10\n");

        // remove
        integerList.remove(0);

        integerList.forEach(System.out::println);
        System.out.println("==============================================================\nAdd\n");

        // add (
        integerList.add(0, 10);

        // addFirst
        integerList.addFirst(0);

        // addLast
        integerList.add(50);

        integerList.forEach(System.out::println);
        System.out.println("==============================================================\nRicerca\n");

        // contains
        System.out.println("Inserisci un numero da ricercare.");
        Scanner tastiera = new Scanner(System.in);

        if(integerList.contains(Integer.parseInt(tastiera.nextLine())))
        {
            System.out.println("Il numero è presente.");
        }
        else
        {
            System.out.println("Il numero è mancante.");
        }

        // getFirst (Restituisce il valore nella prima posizione della lista)
        Integer first = integerList.getFirst();
        System.out.printf("Primo elemento della lista: %d\n", first);

        // getLast (Restituisce il valore nell'ultima posizione della lista)
        Integer last = integerList.getLast();
        System.out.printf("Ultimo elemento della lista: %d\n", last);

        // indexOf (Restituisce l'indice del valore che ricerco)
        int index = integerList.indexOf(20);
        System.out.printf("Index of 20: %d\n", index);

        // lastIndexOf (Restituisce l'indice dell'ULTIMO valore che ricerco)
        int lastIndex = integerList.lastIndexOf(20);
        System.out.printf("Last index of 20: %d\n", index);

        // clear
        integerList.clear();

        // isEmpty
        if (integerList.isEmpty())
        {
            System.out.println("La lista è stata correttamente svuotata.\n");
        }
        else
        {
            System.out.println("La lista non è stata svuotata.\n");
        }

        // removeFirst
        if (!integerList.isEmpty()) {
            integerList.remove(0);
        }

        // removeLast
        if (!integerList.isEmpty()) {
            integerList.remove(integerList.size() - 1);
        }

        System.out.println("==============================================================\nInserisco numeri all'interno della lista\n");
        integerList.add(10);
        integerList.add(20);
        integerList.add(30);
        integerList.add(40);
        integerList.forEach(System.out::println);
        System.out.println("==============================================================\nSet 15 nella posizione 1 (al posto di 20)");
        // set
        integerList.set(1, 15);
        integerList.forEach(System.out::println);
        System.out.println("==============================================================");
        // equals
        boolean equals = integerList.equals(new ArrayList<>(List.of(15)));

        // size
        int size = integerList.size();
        System.out.println("La lista è grande: " + size);

        //==========================================================================================================\\

        System.out.println("==============================================================\n");

        ArrayList<Monitor> labInfo1 = new ArrayList<>();
        Monitor m1 = new Monitor();
        m1.marca = "BenQ";
        m1.modello = "EX240N";
        m1.Hz = 165;
        m1.size = 24;
        labInfo1.add(m1);

    }
}