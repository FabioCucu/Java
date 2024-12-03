package FigureGeometriche;

import Rette.Punto;
import Rette.Segmento;

public class Rettangolo {
    private Punto verticeAltoSinistra;
    private Punto verticeBassoDestra;
    private String colore;
    private int base;
    private int altezza;
    Segmento diagonale;

    public Rettangolo(Punto verticeAltoSinistra, Punto verticeBassoDestra, String colore, int base, int altezza) //Construttore Master
    {
        this.verticeAltoSinistra = verticeAltoSinistra;
        this.verticeBassoDestra = verticeBassoDestra;
        this.colore = colore;
        this.base = base;
        this.altezza = altezza;
    }
    public Rettangolo(Punto verticeAltoSinistra, Punto verticeBassoDestra, int base, int altezza)
    {
        this(verticeAltoSinistra, verticeBassoDestra, null, base, altezza);
    }
    public Rettangolo(Punto verticeAltoSinistra, Punto verticeBassoDestra)
    {
        this(verticeAltoSinistra, verticeBassoDestra, null, 0, 0);
    }
    public Punto getVerticeAltoSinistra() {
        return verticeAltoSinistra;
    }
    public void setVerticeAltoSinistra(Punto verticeAltoSinistra) {
        this.verticeAltoSinistra = verticeAltoSinistra;
    }
    public Punto getVerticeBassoDestra() {
        return verticeBassoDestra;
    }
    public void setVerticeBassoDestra(Punto verticeBassoDestra) {
        this.verticeBassoDestra = verticeBassoDestra;
    }
    public String getColore() {
        return colore;
    }
    public void setColore(String colore) {
        this.colore = colore;
    }
    public int getBase() {
        return base;
    }
    public void setBase(int base) {
        this.base = base;
    }
    public int getAltezza() {
        return altezza;
    }
    public void setAltezza(int altezza) {
        this.altezza = altezza;
    }
    public int[] calcoloBaseAltezza()
    {
        if (verticeAltoSinistra.getX() > verticeBassoDestra.getX())
        {
            base = verticeAltoSinistra.getX() - verticeBassoDestra.getX();
            altezza = verticeAltoSinistra.getY() - verticeBassoDestra.getY();
        }
        else
        {
            base = verticeBassoDestra.getX() - verticeAltoSinistra.getX();
            altezza = verticeBassoDestra.getY() - verticeAltoSinistra.getY();
        }

        return new int[]{base, altezza};
    }
    public boolean isRettangolo()
    {
        int[] lati = calcoloBaseAltezza();

        return lati[0] != lati[1];
    }
    @Override
    public boolean equals(Punto verticeAS2, Punto verticeBD2)
    {
        if (verticeAltoSinistra == verticeAS2 && verticeBassoDestra == verticeBD2)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    public String toString()
    {
        if (colore == null)
        {
            return String.format("Base: " + base + "\nAltezza: " + altezza + "\nColore: Non Assegnato");
        }
        else
        {
            return String.format("Base: " + base + "\nAltezza: " + altezza + "\nColore: " + colore);
        }
    }
}
