public class Frazione {
    private int numeratore;
    private int denominatore;
    public Frazione(String frazione) throws Exception {
        String[] frazioneSplit = frazione.split("/");
        if (frazioneSplit.length != 2) {
            throw new Exception("Numero argomenti frazione non valido.");
        }
        this.numeratore = Integer.parseInt(frazioneSplit[0]);
        this.denominatore = Integer.parseInt(frazioneSplit[1]);
        if (this.denominatore == 0) {
            throw new Exception("Il denominatore non può essere zero.");
        }
    }
    public int getNumeratore() {
        return numeratore;
    }
    public void setNumeratore(int numeratore) {
        this.numeratore = numeratore;
    }
    public int getDenominatore() {
        return denominatore;
    }
    public void setDenominatore(int denominatore) {
        this.denominatore = denominatore;
    }
    public String sommaFrazioni(Frazione f2) {
        boolean fine = false;
        int i = 2;
        int numeratoreResult = this.numeratore * f2.denominatore + f2.numeratore * this.denominatore;
        int denominatoreResult = this.denominatore * f2.denominatore;

        if (denominatoreResult % numeratoreResult != 0)
        {
            do {
                if (numeratoreResult % i == 0 && denominatoreResult % i == 0)
                {
                    numeratoreResult /= i;
                    denominatoreResult /= i;
                    i = 2;
                }
                else
                {
                    i++;
                }
            }while (!fine);
        }
        return numeratoreResult + "/" + denominatoreResult;
    }
    public double sommaFrazioniDecimali(Frazione f2) {
        double risultato1 = (double) this.numeratore / this.denominatore;
        double risultato2 = (double) f2.numeratore / f2.denominatore;
        return risultato1 + risultato2;
    }
}
