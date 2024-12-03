import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner tastiera = new Scanner(System.in);
        try {
            System.out.println("Inserisci la prima frazione (N/D)");
            Frazione frazione1 = new Frazione(tastiera.nextLine());
            Frazione frazione2 = new Frazione(tastiera.nextLine());

            System.out.println("Somma frazioni: " + frazione1.sommaFrazioni(frazione2));
            System.out.println("Somma frazioni in decimale: " + frazione1.sommaFrazioniDecimali(frazione2));

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
