package FrontEnd;

public class Frase {
    private String frase;

    public Frase(String frase) {
        this.frase = frase;
    }

    public String getFrase() {
        return frase;
    }

    public int lunghezzaFrase() {
        return frase.length();
    }

    public boolean ricercaParola(String parolaDaRicercare) {
        return frase.contains(parolaDaRicercare);
    }

    public boolean sostituzioneParola(String parolaDaRicercare, String parolaDaSostituire) {
        if (frase.contains(parolaDaRicercare)) {
            frase = frase.replace(parolaDaRicercare, parolaDaSostituire);
            return true;
        }
        return false;
    }

    public int[] conteggioVocaliConsonanti() {
        int[] conteggio = {0, 0};
        char c;
        for (int i = 0; i < frase.length(); i++) {
            c = Character.toLowerCase(frase.charAt(i));
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                conteggio[0]++;
            } else if (Character.isLetter(c)) {
                conteggio[1]++;
            }

        }
        return conteggio;
    }

    public String inversioneFrase() {
        StringBuilder fraseInvertita = new StringBuilder();
        for (int i = frase.length() - 1; i >= 0; i--) {
            fraseInvertita.append(frase.charAt(i));
        }
        return fraseInvertita.toString();
    }

    public String estrazionePorzione(int inizio, int fine) {
        if (inizio < 0 || fine > frase.length() || inizio >= fine) {
            return null;
        }
        return frase.substring(inizio, fine);
    }
}
