package PilotiGara;

public class Pilota {
    private String nome;
    private String cognome;
    private String nazionalita;

    public Pilota(String nome, String cognome, String nazionalita) throws Exception {
        if (nome != null || cognome != null || nazionalita != null) {
            this.nome = nome;
            this.cognome = cognome;
            this.nazionalita = nazionalita;
        } else {
            throw new Exception("Dati inseriti non corretti.");
        }
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public String getNazionalita() {
        return nazionalita;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Pilota) {
            return this.nome.equals(((Pilota) obj).nome) && this.cognome.equals(((Pilota) obj).cognome);
        }
        return false;
    }

    @Override
    public String toString() {
        return String.format("Nome: " + getNome() + "\nCognome: " + getCognome() + "\nNazionalità: " + getNazionalita());
    }
}
