package frontScreen;

import java.time.LocalDate;
import java.util.Scanner;

import static utility.Tools.*;

import mensola.*;

public class frontEnd {
    public static Libro leggiLibro(Scanner keyboard) {
        String[] opzioni = {"SCEGLI TIPO", "ROMANZO", "MANUALE", "THRILLER"};
        Libro l = new Libro();
        System.out.println("Inserisci l'autore");
        l.autore = keyboard.nextLine();
        System.out.println("Inserisci il titolo");
        l.titolo = keyboard.nextLine();
        System.out.println("Inserisci il tipo");
        switch (Menu(opzioni, keyboard)) {
            case 1 -> l.tipo = Genere.ROMANZO;
            case 2 -> l.tipo = Genere.MANUALE;
            case 3 -> l.tipo = Genere.THRILLER;
        }
        System.out.println("Inserisci la data di pubblicazione");
        l.dataDiPubblicazione = LocalDate.parse(keyboard.nextLine());
        return l;
    }
}
