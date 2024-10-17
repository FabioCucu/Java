import static utility.Tools.*;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final int MAXNUMERI = 100, LIMITERANDOM = 1000;
        Scanner tastiera = new Scanner(System.in), nRicerca = new Scanner(System.in), scelta = new Scanner(System.in);
        int numDaRicercare, posizioneNumero;
        String risposta;
        String[] opzioni = {"Menù", "Inserimento", "Ricerca", "Visualizzazione", "Cancellazione", "Raddoppia vettore", "Fine\n"};
        //int[] vettore; Dichiarazione di un array
        int[] vettore = null, vettoreOrdinato;
        //int[] nEstratti2 = new int[MAXNUMERI]; //avendo effettuato la new qui, non verrà effetttuata all'interno del metodo
        boolean esci = true;
        do {
            switch (Menu(opzioni, tastiera)){

                case 1 : System.out.println("\nInserimento\n");

                    vettore = GeneraNumeri3(MAXNUMERI, LIMITERANDOM);
                    break;

                case 2 : System.out.println("\nRicerca\n");

                    if (vettore != null)
                    {
                        System.out.println("Quale numero vuoi ricercare?\n");
                        numDaRicercare = nRicerca.nextInt();
                        posizioneNumero = Ricerca(numDaRicercare, vettore);

                        if (posizioneNumero == -1)
                        {
                            System.out.println("\nNumero non trovato\n");
                        }
                        else
                        {
                            System.out.println("Numero trovato a riga: \n" + posizioneNumero);
                        }
                    }
                    else
                    {
                        System.out.println("Non ci sono numeri all'interno dell'array\n");
                    }
                    break;

                case 3 : System.out.println("\nVisualizzazione\n");

                    if (vettore != null)
                    {
                        System.out.println("Vuoi visualizzare l'array ordinato?\n");
                        risposta = scelta.nextLine();
                        if (risposta.equalsIgnoreCase("si"))
                        {
                            vettoreOrdinato = Ordinamento(vettore);
                            Visualizza(vettoreOrdinato);
                        }
                        else
                        {
                            Visualizza(vettore);
                        }
                    }
                    else
                    {
                        System.out.println("Non ci sono numeri all'interno dell'array\n");
                    }
                    break;

                case 4 : System.out.println("\nCancellazione\n");

                    if (vettore != null)
                    {
                        System.out.println("Quale numero vuoi cancellare?\n");
                        numDaRicercare = nRicerca.nextInt();
                        posizioneNumero = Cancella(numDaRicercare, vettore, LIMITERANDOM);

                        if (posizioneNumero == -1)
                        {
                            System.out.println("Numero non trovato\n");
                        }
                        else
                        {
                            System.out.printf("Numero cancellato con successo nella posizione %d.\n", posizioneNumero);
                        }
                    }
                    else
                    {
                        System.out.println("Non ci sono numeri all'interno dell'array\n");
                    }
                    break;

                case 5 : System.out.println("\nRaddoppia Vettore\n");
                    if (vettore != null)
                    {
                        AumentaVettore(vettore);
                    }
                    else
                    {
                        System.out.println("Non ci sono numeri all'interno dell'array\n");
                    }
                    break;

                case 6 : System.out.println("\nFine\n");
                    esci = false;
                    break;

            }
        } while (esci);
    }

    /*Tutti i metodi sono corretti
    Condizione del programma che serve: int[] nGenerati;
    public static int[] GeneraNumeri(int nNumeri)
    {
        Random numeroRandom = new Random();
        int[] nGenerati = new int[nNumeri];
        for (int i = 0; i < nNumeri; i++)
        {
            nGenerati[i] = numeroRandom.nextInt(0, nNumeri)+1;
        }
        return nGenerati;
    }

    Condizione del programma che serve: int[] nGenerati = new int[MAXNUMERI];
    public static void GeneraNumeri2(int[] vettore) //vettore passa l'indirizzo, quindi modificandolo non serve il return. (Verrà contato come errore se si usa il return).
    {
        Random numeroRandom = new Random();

        for (int i = 0; i < vettore.length; i++)
        {
            vettore[i] = numeroRandom.nextInt(0, vettore.length)+1;
        }
    }

    Condizione del programma che serve: int[] nGenerati = null;
    public static void GeneraNumeri3(int[] vettore)
    {
        Random numeroRandom = new Random();

        for (int i = 0; i < vettore.length; i++)
        {
            vettore[i] = numeroRandom.nextInt(0, vettore.length)+1;
        }
    }*/

    public static int[] GeneraNumeri3(final int MAXNUMERI, final int LIMITERANDOM)
    {
        Random numeroRandom = new Random();
        int[] nGenerati = new int[MAXNUMERI];
        int numero, cont = 0;
        boolean presente;
        do {
            numero = numeroRandom.nextInt(0, LIMITERANDOM)+1;//Random da 0 a LIMITERANDOM (constante scelta dal programmatore).
            presente = false;
            for (int j : nGenerati) {
                if (numero == j)//Controllo se il numero estratto dal random è gia presente nell'array (per evitare doppioni).
                {
                    presente = true;
                    break;
                }
            }

            if (!presente)//Se il numero non è presente lo aggiungo all'array, in caso contrario non si aggiunge nulla e si genera un'altro numero random.
            {
                nGenerati[cont] = numero;
                cont++;
            }
        } while(cont != MAXNUMERI);
        return nGenerati;//Ritorno l'array generato.
    }

    public static void Visualizza(int[] nGenerati)
    {
        int cont = 0, fila = 1;
        for (int i = 0; i < 100; i++)
        {
            if (cont % 10 == 0)//Scrive il numero della fila all'inzio dei numeri
            {
                System.out.print("[ " + (fila) + " ]");
                fila++;
            }
            System.out.print(" - " + nGenerati[i]);//Scrive i numeri dell'array
            cont++;
            if (cont % 10 == 0 && cont != 0)//Va a capo ogni 10 numeri
            {
                System.out.println("\n");
            }
        }
    }

    public static int Ricerca(int numeroDaRicercare, int[] array)
    {

        int posizione = -1;
        for (int i = 0; i < array.length; i++)
        {
            if (array[i] == numeroDaRicercare)//Se il numero da ricercare è lo stesso della posizione 'i' dell'array, salvo la posizione.
            {
                posizione = i + 1;
            }
        }
        return posizione;//Ritorno la posizione (-1 se numero non trovato, altro numero se è stato trovato).
    }

    public static int Cancella(int numeroDaRicercare, int[] array, final int LIMITERANDOM)
    {
        int n,  nCancellato = -1;
        Random numeroRandom = new Random();
        boolean presente;
        for (int i = 0; i < array.length; i++)
        {
            if (array[i] == numeroDaRicercare)//Ricerco il numero che voglio cancellare
            {
                nCancellato = Ricerca(numeroDaRicercare, array);//Richiamo Ricerca(...) per ottenre la posizione del numero che verrà cancellato.
                for (int k = i; k < array.length - 1; k++)
                {
                    array[k] = array[k + 1];//dalla posizione 'k' (che è dove c'è il numero da cancellare) 'sposto' tutto l'array di una posizione.
                }
                do
                {
                    n = numeroRandom.nextInt(0, LIMITERANDOM)+1;//Estraggo un numero random da mettere nell'ultima posizione dell'array (per evitare buchi/doppioni).
                    presente = false;
                    for (int j : array) {
                        if (n == j)//Controllo se la posizione 'k' dell'array ha come valore il numero estratto (n).
                        {
                            presente = true;
                            break;
                        }
                    }
                    if (!presente)//se il numero estratto non è presente nell'array (presente == false), lo aggiungo nell'ultima posizione dell'array.
                    {
                        array[array.length - 1] = n;
                    }
                } while (!presente);
            }
        }
        return nCancellato;//ritorno un intero per dichiarare all'utente l'esito della cancellazione e la posizione del numero cancellato.
    }

    public static int[] Ordinamento(int[] array)
    {
        int swap;
        int[] arrayOrdinato = new int[array.length];

        for (int i = 0; i < array.length; i++)
        {
            arrayOrdinato[i] = array[i];
        }

        for (int i = 0; i < arrayOrdinato.length; i++)
        {
            for (int k = 0; k < arrayOrdinato.length; k++)
            {
                if (arrayOrdinato[i] < arrayOrdinato[k])
                {
                    swap = arrayOrdinato[k];
                    arrayOrdinato[k] = arrayOrdinato[i];
                    arrayOrdinato[i] = swap;
                }
            }
        }
        return arrayOrdinato;
    }

    public static int[] AumentaVettore(int[] array)
    {
        int[] vettoreAumentato = new int[array.length * 2];

        for(int i = 0; i < array.length; i++)
        {
            vettoreAumentato[i] = array[i];
        }
        for(int i = array.length; i < vettoreAumentato.length; i++)
        {
            vettoreAumentato[i] = 0;
        }
        return vettoreAumentato;
    }
}