import static Utility.Tools.*;
import Mensola.Libro;
import Screen.frontEnd;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner tastiera = new Scanner(System.in);
        int contLibri = 0;
        boolean esci = true;
        final int MAXLIBRI = 3;

        Libro[] mensola = new Libro[MAXLIBRI];
        String[] opzioni = {"Menù","Inserimento","Visualizza", "Fine"};

        do{
            switch (Menu(opzioni, tastiera)){
                case 1 ->{
                    System.out.println("Inserimento.");
                    if (contLibri < 3)
                    {
                        try
                        {
                            contLibri = frontEnd.Inserimento(mensola, contLibri);
                        }
                        catch (Exception e)
                        {
                            System.out.println(e.getMessage());
                        }
                    }
                    else
                    {
                        System.out.println("Errore, mensola piena.");
                    }
                }
                case 2 ->{
                    System.out.println("Visualizza.");
                    frontEnd.Visualizza(mensola, contLibri);
                }
                case 3 ->{
                    System.out.println("Fine programma.");
                    esci = false;
                }
                default ->  System.out.println("Opzione non valida.");
            }
        }while (esci);
    }
}