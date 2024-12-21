/*Creare classe "Pilota" che contiene nome , cognome, nazionalità, età;
Creare classe "Auto" che contiene una scuderia(stringa), il pilota, cilindrata;
Creare le classi definite con metodi ed i costruttori considerando che le classi devono implementare i metodi toString ed il metodo Equals, gestendo eventuali eccezioni che si potrebbero generare.
Verificare la funzionalità delle classi considerando che non possono esistere due piloti con lo stesso nome, cognome ed età*/

/*Creare la classe gara considerando una gara è composta dal nome della gara, da un risultato e da una collezione di auto.
Definire il metodo corriGara che permette di correre una gara e determinarne il risultato (nome del pilota vincitore).
Considerando gli attributi delle classi create determinare un soluzione per il metodo corriGara.
Testare il codice realizzato.*/

import static Utility.Tools.*;

import PilotiGara.*;
import Screen.frontEnd;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner tastiera = new Scanner(System.in);
        boolean esci = false;
        String nomeGara, nazione;
        int nSquadre, nPartecipanti = 0;

        Gara gara = null;

        do {
            try {
                System.out.println("Inserisci il nome della gara.");
                nomeGara = tastiera.nextLine();
                System.out.println("Inserisci la nazione dove la gara si svolge.");
                nazione = tastiera.nextLine();
                System.out.println("Inserisci il numero di squadre partecipanti.");
                nSquadre = Integer.parseInt(tastiera.nextLine());
                gara = new Gara(nomeGara, nazione, nSquadre);
                esci = true;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (!esci);

        esci = false;

        String[] opzioni = {"==============\n" + gara.getNome() + "\n==============", "Inserisci piloti partecipanti", "Visualizza piloti", "Inizia la gara"};

        do {
            switch (Menu(opzioni, tastiera)) {

                case 1 -> {
                    if (nPartecipanti < gara.getPartecipantiMax())//Controllo che il numero di partecipanti sia minore delle squadre max (e quindi accetti ulteriori partecipanti)
                    {
                        frontEnd.Inserimento(tastiera, gara);
                        nPartecipanti++;
                    } else {
                        System.out.println("Il numero di partecipanti ha raggiunto il numero massimo deciso per la gara.");
                    }
                }

                case 2 -> {
                    if (nPartecipanti != 0)//Controllo che ci sia almeno un pilota inserito per la visualizzazione
                    {
                        frontEnd.VisualizzaPartecipanti(gara.getGriglia());
                    }
                }
                case 3 -> {
                    try {
                        if (nPartecipanti == gara.getPartecipantiMax()) {
                            frontEnd.StartGara(gara);
                            esci = true;
                        } else {
                            System.out.println("Non hai inserito tutti i piloti che parteciperanno alla gara.");
                        }
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }

                default -> System.out.println("Opzione non valida.");
            }

            clrScr();

        } while (!esci);
    }
}