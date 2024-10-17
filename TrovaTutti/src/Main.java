import java.util.Scanner;

public class Main {
    public static  void main(String[] args) {
        int[] valori = {1,2,1,4,1,7,10,1};
        int[] ricorrenze = null;
        int nDaRicercare;
        Scanner tastiera = new Scanner(System.in);

        System.out.println("Che numero vuoi ricercare?");
        nDaRicercare = tastiera.nextInt();
        ricorrenze = FindAll(valori, nDaRicercare);

        if (ricorrenze != null)
        {
            System.out.println("Numero trovato in posizione:");

            for (int i = 0; i < ricorrenze.length; i++) {
                System.out.printf("[%d]\n", ricorrenze[i] + 1);
                if (ricorrenze[i] > ricorrenze[i + 1])
                {
                    break;
                }
            }
        }
        else
        {
            System.out.println("Numero non trovato.");
        }
    }

    public static int[] FindAll(int[] valori, int nDaRicercare) {
        int[] ricorrenze = new int[valori.length];
        int cont = 0;

        for (int i = 0; i < valori.length; i++)
        {
            if (nDaRicercare == valori[i])
            {
                ricorrenze[cont] = i;
                cont++;
            }
        }

        if (cont == 0)
        {
            return null;
        }
        return ricorrenze;
    }
}
