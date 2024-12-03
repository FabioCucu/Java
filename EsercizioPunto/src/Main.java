import FigureGeometriche.Rettangolo;
import Rette.Punto;
import Rette.Segmento;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Punto p1;
        String coordinate, regex = "[,.;:()\\s]";;
        int x, y;
        boolean fine = false;

        /*
        System.out.println("Inserisci la coordinata del punto x");
        x = Integer.parseInt(sc.nextLine());
        System.out.println("Inserisci la coordinata del punto y");
        y = Integer.parseInt(sc.nextLine());

        Punto p1 = new Punto(x, y);

        System.out.printf("Il punto inserito %s si trova %s quadrante\n", p1.toString(), p1.controlloQuadrante());
        */

        do {
            try
            {
                System.out.println("Inserisci le coordinate di 2 vertici opposti. [X:(x,y) - Y:(x,y)]");
                coordinate = sc.nextLine();
                String[] coordinateSplit = coordinate.split(regex);
                fine = true;
            }
            catch (Exception e)
            {
                System.out.println("Errore nell'inserimento dei vertici.");
            }

        } while (!fine);

        for (int i = 0; i < co)
    }
}