import static Utility.Tools.*;
import Mensola.Libro;
import Screen.FrontEnd;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner tastiera = new Scanner(System.in);
        String ricercaAutore, ricercaTitolo;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        final int MAXLIBRI = 3;
        boolean esci = false;

        ArrayList<Libro> mensola = new ArrayList<>();
        ArrayList<Libro> libriRicercati;
        String[] opzioni = {"==============\nMenù\n==============","Inserimento","Visualizza", "Find All", "Remove", "Remove All", "Modifica libro", "Sort List", "Scorrimento", "Fine"};

        do {
            switch (Menu(opzioni, tastiera)) {

                case 1 -> {

                    System.out.println("Inserimento.");
                    if (mensola.size() < MAXLIBRI) {
                        try {
                            mensola.add(FrontEnd.AddLibro(mensola));
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                    }
                }

                case 2 -> {

                    System.out.println("Visualizza.");
                    if (!mensola.isEmpty()) {
                        mensola.forEach(m-> System.out.println(m.FormattaDati()));
                    }
                    else
                    {
                        System.out.println("Devi inserire almeno un libro.");
                    }
                }

                case 3 ->{

                    if (!mensola.isEmpty()) {
                        System.out.println("Find All.");
                        System.out.println("Inserisci il titolo del libro che vuoi ricercare.");
                        ricercaTitolo = tastiera.nextLine();
                        try
                        {
                            libriRicercati = FrontEnd.FindAll(mensola, ricercaTitolo);
                            if (!libriRicercati.isEmpty())
                            {
                                libriRicercati.forEach(m-> System.out.println(m.FormattaDati()));
                            }
                            else
                            {
                                throw new Exception("Nessun libro trovato.");
                            }
                        }
                        catch (Exception e)
                        {
                            System.out.println(e.getMessage());
                        }
                    }
                    else
                    {
                        System.out.println("Devi inserire almeno un libro.");
                    }

                }

                case 4 -> {

                    if (!mensola.isEmpty()) {
                        System.out.println("Remove.");
                        System.out.println("Inserisci l'autore del libro che vuoi ricercare.");
                        ricercaAutore = tastiera.nextLine();
                        System.out.println("Inserisci il titolo del libro che vuoi ricercare.");
                        ricercaTitolo = tastiera.nextLine();
                        FrontEnd.Remove(mensola, ricercaAutore, ricercaTitolo);
                        System.out.println("Cancellazione eseguita.");
                    }
                    else
                    {
                        System.out.println("Devi inserire almeno un libro.");
                    }
                }

                case 5 -> {

                    if (!mensola.isEmpty()) {
                        System.out.println("Remove all.");
                        System.out.println("Inserisci l'autore del libro che vuoi ricercare.");
                        ricercaAutore = tastiera.nextLine();
                        FrontEnd.RemoveAll(mensola, ricercaAutore);
                        System.out.println("Cancellazione eseguita.");}
                    else
                    {
                        System.out.println("Devi inserire almeno un libro.");
                    }

                }

                case 6 -> {

                    if (!mensola.isEmpty()) {
                        System.out.println("Modifica.");
                        System.out.println("Inserisci l'autore del libro che vuoi ricercare.");
                        ricercaAutore = tastiera.nextLine();
                        System.out.println("Inserisci il titolo del libro che vuoi ricercare.");
                        ricercaTitolo = tastiera.nextLine();
                        FrontEnd.ModificaLibro(mensola, ricercaAutore, ricercaTitolo);
                    }
                    else
                    {
                        System.out.println("Devi inserire almeno un libro.");
                    }
                }

                case 7 -> {
                    if (!mensola.isEmpty()) {
                        System.out.println("Sort List.");
                        FrontEnd.SortArrayList(mensola, tastiera);
                    }
                    else
                    {
                        System.out.println("Devi inserire almeno un libro.");
                    }
                }

                case 8 -> {

                    FrontEnd.Scorrimento(mensola);
                }

                case 9 -> {

                    System.out.println("Fine programma.");
                    esci = true;
                }

                default ->  System.out.println("Opzione non valida.");
            }

            clrScr();

        }while (!esci);
    }
}