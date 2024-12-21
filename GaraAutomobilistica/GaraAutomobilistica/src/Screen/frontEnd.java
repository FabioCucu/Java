package Screen;

import PilotiGara.Cronometro;
import PilotiGara.Gara;
import PilotiGara.Scuderia;
import PilotiGara.Pilota;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class frontEnd {

    public static void Inserimento(Scanner tastiera, Gara gara) {
        Pilota p1 = null;
        Scuderia auto = null;
        String nome, cognome, nazionalità, nomeScuderia = "";
        int cilindrata = 0, nAuto = 0;
        boolean fine = false;

        do {
            try {//Controllare Scuderia non sia null, cilindrata = 0 o già esistente
                System.out.println("Inserisci il nome della scuderia");
                nomeScuderia = tastiera.nextLine();
                System.out.println("Inserisci il numero indentificativo dell'auto");
                nAuto = Integer.parseInt(tastiera.nextLine());
                System.out.println("Inserisci la cilindrata dell'auto");
                cilindrata = Integer.parseInt(tastiera.nextLine());
                fine = true;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (!fine);

        fine = false;

        do {
            try {//Controllo sui dati del pilota
                System.out.println("Inserisci il nome del pilota");
                nome = tastiera.nextLine();
                System.out.println("Inserisci il cognome del pilota");
                cognome = tastiera.nextLine();
                System.out.println("Insersici la nazionalità del pilota");
                nazionalità = tastiera.nextLine();
                p1 = new Pilota(nome, cognome, nazionalità);
                fine = true;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (!fine);

        auto = new Scuderia(nomeScuderia, p1, cilindrata, nAuto);
        gara.addGriglia(auto);
    }

    public static void VisualizzaPartecipanti(ArrayList<Scuderia> partecipanti) {
        for (Scuderia scuderia : partecipanti) {
            System.out.println(scuderia.toString());
        }
    }

    public static void StartGara(Gara gara) {
        Random rn = new Random();
        int tempo;

        for (int i = 0; i < gara.getGriglia().size(); i++) {
            tempo = rn.nextInt(100, 500);
            Cronometro cr = new Cronometro(tempo);
            gara.getGriglia().get(i).setTempoGiro(cr.getTempoGiro());
        }

        gara.sortGriglia();

        System.out.println("==================\nCLASSIFICA FINE GARA\n==================");
        for (int i = 0; i < gara.getPartecipantiMax(); i++) {
            System.out.printf("[%d] - %s\n", i + 1, gara.getGriglia().get(i).getPilota());
        }
    }
}
