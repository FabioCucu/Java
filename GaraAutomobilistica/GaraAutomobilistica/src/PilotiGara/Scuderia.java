package PilotiGara;

public class Scuderia implements Comparable<Scuderia> {
    private String squadra;
    private Pilota pilota;
    private int cilindrata;
    private Integer nAuto;
    private Integer tempoGiro;

    public Scuderia(String squadra, Pilota pilota, int cilindrata, int nAuto) {
        this.squadra = squadra;
        this.pilota = pilota;
        this.cilindrata = cilindrata;
        this.nAuto = nAuto;
    }

    public void setSquadra(String squadra) {
        this.squadra = squadra;
    }

    public void setPilota(Pilota pilota) {
        this.pilota = pilota;
    }

    public void setCilindrata(int cilindrata) {
        this.cilindrata = cilindrata;
    }

    public void setnAuto(int nAuto) {
        this.nAuto = nAuto;
    }

    public String getSquadra() {
        return squadra;
    }

    public String getPilota() {
        return String.format(pilota.getNome() + " " + pilota.getCognome() + " , " + squadra);
    }

    public int getCilindrata() {
        return cilindrata;
    }

    public int getnAuto() {
        return nAuto;
    }

    public int getTempoGiro() {
        return tempoGiro;
    }

    public void setTempoGiro(int tempoGiro) {
        this.tempoGiro = tempoGiro;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Scuderia) {
            return this.squadra.equals(((Scuderia) obj).squadra);
        }
        return false;
    }

    @Override
    public int compareTo(Scuderia s) {
        return this.tempoGiro.compareTo(s.tempoGiro);
    }

    @Override
    public String toString() {
        return String.format("Squadra: %s\n" + pilota.toString() + "\nNumero auto: %d\n==============================", squadra, nAuto);
    }
}
