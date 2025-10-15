/*
Esercizio: Gestore di Testi
Scopo: Creare un programma che permetta all'utente di inserire e manipolare una frase,
dimostrando la conoscenza delle principali funzioni della classe String di Java.

Struttura del progetto:
- Main.java: Gestisce il menu e il flusso principale del programma.
- Package Tools:
- GestoreTesti.java: Contiene tutti i metodi per le operazioni sulle stringhe.
- Utility.java: Contiene i metodi di servizio (menu, pulizia schermo, etc.).

Obiettivi:
- Organizzare il codice in classi e pacchetti separati per responsabilità.
- Metodi String: Utilizzare metodi come .length(), .contains(), .replaceAll(), .substring(), .split(), etc.
- Gestione Input: Usare lo Scanner e gestire input validi e non validi.
- Controllo del Flusso: Utilizzare cicli (do-while) e strutture condizionali (switch).

GestoreTesti deve fare le seguenti cose:
-verificare la lunghezza della frase;
-verificare se è presente una parola (es. "Ciao mondo", cerca mondo);
-sostituire di una parola (es. "Ciao mondo", sostituisci mondo con Luca);
-conteggio vocali e consonanti;
-invertire una frase (es. "ciao", "oaic");
-estrarre una porzione di frase (.subString());
-tornare al menu principale;
-uscire dal programma.
*/

import FrontEnd.*;
import Utility.Tools;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner tastiera = new Scanner(System.in);

        boolean esci = false;
        String[] input = new String[2];
        int[] conteggio = new int[2];

        System.out.println("Inserisci la frase con cui lavorare");

        Frase frase = new Frase(tastiera.nextLine());

        String[] opzioni = {"==============\nMenù\n==============", "verificare la lunghezza della frase", "verificare se è presente una parola", "sostituire di una parola", "conteggio vocali e consonanti", "invertire una frase", "estrarre una porzione di frase", "Esci"};

        do {
            switch (Tools.Menu(opzioni, tastiera)) {

                case 1 -> {

                    System.out.println("La frase è lunga: " + frase.lunghezzaFrase());
                }

                case 2 -> {

                    System.out.println("Inserisci una parola da ricerca nella frase.");

                    input[0] = tastiera.nextLine();

                    if (frase.ricercaParola(input[0])) {
                        System.out.println("Parola trovata");
                    } else {
                        System.out.println("Parola non trovata");
                    }
                }

                case 3 -> {

                    do {
                        System.out.println("Inserisci la parola da sostituire nella frase.");

                        input[0] = tastiera.nextLine();

                        System.out.println("Inserisci la parola con cui sostituire quella precedentemente inserita.");

                        input[1] = tastiera.nextLine();
                    } while (input[0] == null || input[1] == null);


                    if (frase.sostituzioneParola(input[0], input[1])) {
                        System.out.println("Parola sostituita.\nFrase: " + frase.getFrase());
                    } else {
                        System.out.println("Parola non trovata");
                    }

                }

                case 4 -> {

                    conteggio = frase.conteggioVocaliConsonanti();

                    System.out.println("Vocali: " + conteggio[0] + "\nConsonanti: " + conteggio[1]);
                }

                case 5 -> {

                    System.out.println("Inversione della frase.");

                    String fraseInvertita = frase.inversioneFrase();

                    System.out.println("Frase originale: " + frase.getFrase());

                    System.out.println("Frase invertita: " + fraseInvertita);

                }


                case 6 -> {
                    System.out.println("Estrazione porzione di frase.");

                    System.out.println("Frase attuale: " + frase.getFrase());

                    System.out.println("Lunghezza frase: " + frase.lunghezzaFrase() + " caratteri");

                    System.out.println("Inserisci l'indice di inizio (0 a " + (frase.lunghezzaFrase() - 1) + "):");

                    int inizio = Integer.parseInt(tastiera.nextLine());

                    System.out.println("Inserisci l'indice di fine (" + (inizio + 1) + " a " + frase.lunghezzaFrase() + "):");

                    int fine = Integer.parseInt(tastiera.nextLine());

                    String porzione = frase.estrazionePorzione(inizio, fine);

                    if (porzione != null) {
                        System.out.println("Porzione estratta: " + porzione);
                    } else {
                        System.out.println("Indici non validi!");
                    }
                }

                case 7 -> {
                    esci = true;
                }


                default -> System.out.println("Opzione non valida.");
            }

            Tools.clrScr();

        } while (!esci);
    }
}