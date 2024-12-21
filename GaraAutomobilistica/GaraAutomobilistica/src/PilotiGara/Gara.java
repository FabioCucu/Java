package PilotiGara;

import java.util.Collections;
import java.util.ArrayList;

public class Gara {
    private String nome;
    private String nazione;
    private int partecipantiMax;
    private ArrayList<Scuderia> griglia;

    public Gara(String nome, String nazione, int partecipantiMax) throws Exception {
        if (nome == null || nazione == null || partecipantiMax <= 1) {
            throw new Exception("Dati inseriti non corretti.");
        }
        this.nome = nome;
        this.nazione = nazione;
        this.partecipantiMax = partecipantiMax;
        griglia = new ArrayList<>();
    }

    public String getNome() {

        return nome;
    }

    public String getNazione() {

        return nazione;
    }

    public int getPartecipantiMax() {
        return partecipantiMax;
    }

    public void addGriglia(Scuderia sc) {
        griglia.add(sc);
    }

    public void sortGriglia() {
        Collections.sort(griglia);
    }

    public ArrayList<Scuderia> getGriglia() {
        return griglia;
    }
}

