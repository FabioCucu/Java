package Mensola;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Libro {

    public String autore;
    public String titolo;
    final double prezzoPerPagine = 0.05;
    public int pagine;
    public GenereLibro tipologia;
    public LocalDate dataPubblicazione;
    final private DateTimeFormatter dataFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    public static boolean LibroEsistente (Libro libro, ArrayList<Libro> mensola)
    {
        if (!mensola.isEmpty()) {
            for (Libro value : mensola) {
                if (value.autore.equalsIgnoreCase(libro.autore) && value.titolo.equalsIgnoreCase(libro.titolo)) {
                    return true;
                }
            }
        }
        return false;

    }
    public static boolean DataAccettabile(LocalDate dataInserita)
    {
        LocalDate dataOggi = LocalDate.now();
        return dataInserita.getYear() <= dataOggi.getYear();
    }
    public String FormattaDati()
    {
        return String.format("autore: %s , titolo: %s , Prezzo: %.2f€, Pagine: %d, Tipologia: %s, Data: %s", autore, titolo, prezzoPerPagine * pagine, pagine, tipologia, dataPubblicazione.format(dataFormat));
    }
    public String getAutore()
    {
        return autore;
    }
    public String getTitolo()
    {
        return titolo;
    }
    public int getPagine()
    {
        return pagine;
    }
    public double getPrezzo()
    {
        return prezzoPerPagine * pagine;
    }

    public LocalDate getDataPubblicazione()
    {
        return dataPubblicazione;
    }

}