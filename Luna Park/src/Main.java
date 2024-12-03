import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;
import static Tools.Utility.*;

public class Main {
    public static void main(String[] args) {
        boolean esci = false;
        int nBiglietto = 0;
        int nPersone = 0;
        Scanner sc = new Scanner(System.in);
        final int MAXPERSONE = 10;
        ArrayList<Biglietto> lista = new ArrayList<>();
        String[] opzioni = {"GESTORE LUNAPARK", "Registra entrata", "Nuova giostra", "Lista giostre per biglietto", "Registra uscita", "Esci"};
        do {
            switch (Menu(opzioni, sc)) {
                case 1 -> {  //ingresso
                    try {
                        if (nPersone > MAXPERSONE)
                        {
                            throw new Exception();
                        }
                        nPersone++;
                        Biglietto p = metodoCreazioneBiglietto(++nBiglietto);
                        lista.add(p);
                        System.out.println("numero assegnato al cliente: " + nBiglietto);

                    } catch (Exception e) {
                        System.out.println("luna park pieno");
                    }
                }
                case 2 -> {  //nuova giostra
                    System.out.println("numero biglietto cliente: ");
                    int numeroB = Integer.parseInt(sc.nextLine());
                    if (metodoTrovaBiglietto(lista, numeroB)) {
                        Biglietto p = metodoNuovaGiostra(numeroB, sc);
                        lista.add(p);
                    } else {
                        System.out.println("numero non trovato");
                    }
                }
                case 3 -> {

                }
                case 4 -> esci = true;
            }
        } while(!esci);
    }
    public static Biglietto metodoCreazioneBiglietto(int nBiglietto){
        Biglietto cliente = new Biglietto();
        cliente.numeroBiglietto = nBiglietto;
        cliente.momentoEvento= LocalDateTime.now(); //momento dell'ingresso
        return cliente;
    }

    public static Biglietto metodoNuovaGiostra(int nBiglietto, Scanner sc){
        Biglietto cliente = new Biglietto();
        boolean esci;
        do {
            try {
                System.out.println("quale giostra vuoi provare?[tagada,ottovolante,ruotapanoramica, autoscontro]");
                cliente.giostreProvate=ListaGiostre.valueOf(sc.nextLine().toUpperCase());
                esci=true;
            } catch(Exception e) {
                System.out.println("giostra non valida");
                esci=false;
            }

        }while(!esci);
        cliente.numeroBiglietto = nBiglietto;
        cliente.momentoEvento= LocalDateTime.now(); //momento della nuova giostra
        return cliente;
    }


    public static boolean metodoTrovaBiglietto(ArrayList<Biglietto> gestore, int nBiglietto){
        for (Biglietto persona : gestore) {
            if (persona.numeroBiglietto == nBiglietto) {
                return true;
            }
        }
        return false;
    }
}