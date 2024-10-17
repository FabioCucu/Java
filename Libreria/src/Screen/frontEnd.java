package Screen;

import Mensola.GenereLibro;
import Mensola.Libro;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class frontEnd {
    public static int Inserimento(Libro[] mensola , int contatore) throws Exception
    {
        boolean ver = true;
        Libro libro = new Libro();
        Scanner tastiera = new Scanner(System.in);
        LocalDate dataPubblicazione = null;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        System.out.println("Inserisci Autore:");
        libro.autore = tastiera.nextLine();
        System.out.println("Inserisci Titolo:");
        libro.titolo = tastiera.nextLine();

        if (Libro.Equals(libro, mensola, contatore))
        {
            throw new Exception("Libro già presente");
        }

        System.out.println("Inserisci Pagine:");
        libro.pagine = Integer.parseInt(tastiera.nextLine());
        System.out.println("Inserisci Tipologia: [1] Romanzo - [2] Manuale - [3] Thriller");
        do{
            switch (Integer.parseInt(tastiera.nextLine())){
                case 1 ->{
                    libro.tipologia = GenereLibro.Romanzo;
                    ver = false;
                }
                case 2 ->{
                    libro.tipologia = GenereLibro.Manuale;
                    ver = false;
                }
                case 3 ->{
                    libro.tipologia = GenereLibro.Thriller;
                    ver = false;
                }
                default -> System.out.println("TIPOLOGIA NON VALIDA!!");
            }
        }while (ver);
        /*do {
            try{
                System.out.println("Inserisci Data:");
                String in = tastiera.nextLine();
                dataPubblicazione = LocalDate.parse(in, formatter);
                if (Libro.DataAccettabile(dataPubblicazione))
                {
                    libro.dataPubblicazione = dataPubblicazione;
                }
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }while (dataPubblicazione == null);*/

        System.out.println("Inserisci Data:");
        String in = tastiera.nextLine();
        dataPubblicazione = LocalDate.parse(in, formatter);
        libro.dataPubblicazione = dataPubblicazione;
        mensola[contatore] = libro;

        contatore++;
        return contatore;
    }
    public static void Visualizza(Libro[] mensola, int contatore)
    {
        for (int i = 0; i < contatore; i++){
            System.out.println(mensola[i].FormattaDati());
        }
    }
}
