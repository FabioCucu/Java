package mensola;

import java.time.LocalDate;

public class Libro {
    public String autore;
    public String titolo;
    final double COSTOPAGINA = 0.05;
    public int pagine;
    public Genere tipo;
    public LocalDate dataDiPubblicazione;

    @Override
    public String toString() {
        return String.format("Autore: %s Titolo: %s Prezzo libro %f mensola.Genere: %s Data: %s", autore, titolo, COSTOPAGINA * pagine, tipo, dataDiPubblicazione);
    }
}