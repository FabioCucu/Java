package Screen;

import static Utility.Tools.*;

import Mensola.GenereLibro;
import Mensola.Libro;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class frontEnd {
    public static Libro AddLibro(ArrayList<Libro> mensola) throws Exception
    {
        Libro libro = new Libro();
        Scanner tastiera = new Scanner(System.in);
        System.out.println("Inserisci Autore:");
        libro.autore = tastiera.nextLine();
        System.out.println("Inserisci Titolo:");
        libro.titolo = tastiera.nextLine();

        if (Libro.Equals(libro, mensola))
        {
            throw new Exception("Libro già presente");
        }

        System.out.println("Inserisci Pagine:");
        libro.pagine = Integer.parseInt(tastiera.nextLine());

        SelectionTipoLibro(libro, tastiera);

        CheckData(libro, tastiera);

        return libro;
    }
    public static ArrayList<Libro> FindAll(ArrayList<Libro> mensola, String titolo, int contLibri) throws Exception
    {

        ArrayList<Libro> libriRicercati = new ArrayList<>();

        for (Libro libro : mensola) {
            if (libro.titolo.equalsIgnoreCase(titolo)) {
                libriRicercati.add(libro);
            }
        }
        return libriRicercati;
    }
    public static void Remove(ArrayList<Libro> mensola, String autore, String titolo)
    {
        mensola.removeIf(value -> value.autore.equalsIgnoreCase(autore) && value.titolo.equalsIgnoreCase(titolo));
    }
    public static void RemoveAll(ArrayList<Libro> mensola, String autore)
    {
        mensola.removeIf(value -> value.autore.equalsIgnoreCase(autore));
    }
    public static void ModificaLibro(ArrayList<Libro> mensola, String autore, String titolo)
    {
        String[] opzioniLibro = {"Scelte","Autore","Titolo", "Pagine", "Tipologia libro", "Data", "Fine"};
        Scanner tastiera = new Scanner(System.in);
        boolean esci = false;

        for (Libro value : mensola)
        {
            if (value.autore.equalsIgnoreCase(autore) && value.titolo.equalsIgnoreCase(titolo))
            {
                do {
                    switch (Menu(opzioniLibro, tastiera))
                    {
                        case 1 -> {
                            System.out.println("Inserisci l'autore con cui vuoi sostituire quello attuale.");
                            value.autore = tastiera.nextLine();
                        }

                        case 2 -> {
                            System.out.println("Inserisci il titolo con cui vuoi sostituire quello attuale.");
                            value.titolo = tastiera.nextLine();
                        }

                        case 3 -> {
                            System.out.println("Inserisci il numero di pagine con cui vuoi sostituire quello attuale.");
                            value.pagine = Integer.parseInt(tastiera.nextLine());
                        }

                        case 4 -> {
                            System.out.println("Inserisci la tipologia di libro con cui vuoi sostituire quello attuale.");
                            SelectionTipoLibro(value, tastiera);
                        }

                        case 5 -> {
                            CheckData(value, tastiera);
                        }

                        case 6 -> {
                            esci = true;
                        }

                        default -> System.out.println("Opzione non valida");
                    }
                }while (!esci);
            }
        }
    }
    private static void SelectionTipoLibro(Libro libro, Scanner tastiera) {
        boolean tipologialibro = true;
        String[] opzioni = {"Inserisci Tipologia:","Romanzo","Manuale", "Thriller", "Fantasy"};

        do{
            switch (Menu(opzioni, tastiera)){
                case 1 ->{
                    libro.tipologia = GenereLibro.Romanzo;
                    tipologialibro = false;
                }
                case 2 ->{
                    libro.tipologia = GenereLibro.Manuale;
                    tipologialibro = false;
                }
                case 3 ->{
                    libro.tipologia = GenereLibro.Thriller;
                    tipologialibro = false;
                }
                case 4 ->{
                    libro.tipologia = GenereLibro.Fantasy;
                    tipologialibro = false;
                }
                default -> System.out.println("Opzione non valida");
            }
        }while (tipologialibro);
    }
    private static void CheckData(Libro libro, Scanner tastiera) {
        LocalDate dataPubblicazione = null;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        do {
            try{
                System.out.println("Inserisci la data (dd-mm-yyyy).");
                String data = tastiera.nextLine();
                dataPubblicazione = LocalDate.parse(data, formatter);
                if (Libro.DataAccettabile(dataPubblicazione))
                {
                    libro.dataPubblicazione = dataPubblicazione;
                }
                else
                {
                    System.out.println("La data inserita non è accettabile.");
                    dataPubblicazione = null;
                }
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }while (dataPubblicazione == null);
    }
}
