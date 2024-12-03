package Rette;

public class Segmento {
    private Punto p1;
    private Punto p2;

    public Segmento(Punto p1, Punto p2)
    {
        this.p1 = p1;
        this.p2 = p2;
    }

    public Punto getP1() {
        return p1;
    }

    public Punto getP2() {
        return p2;
    }
    public double distanzaTra2Punti()
    {
        return java.lang.Math.sqrt(java.lang.Math.pow((p2.getX() - p1.getX()), 2) + java.lang.Math.pow((p2.getY() - p1.getY()), 2));
    }
}
