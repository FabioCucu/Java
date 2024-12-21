package PilotiGara;

import java.time.LocalTime;

public class Cronometro {
    private LocalTime startTime;
    private LocalTime endTime;
    private int tempoGiro;

    public Cronometro(int tempo) {
        setStartTime();
        setEndTime(tempo);
    }

    void setStartTime() {
        startTime = LocalTime.now();
    }

    void setEndTime(int tempoGiro) {
        endTime = LocalTime.now().plusSeconds(tempoGiro);
    }

    public int getTempoGiro() {
        try {
            calcolaIntTimer();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return tempoGiro;
    }

    void calcolaIntTimer() throws Exception {
        int tempoGiro;
        tempoGiro = this.endTime.toSecondOfDay() - this.startTime.toSecondOfDay();
        if (tempoGiro == 0)
            throw new Exception("PilotiGara.Cronometro stop");
        this.tempoGiro = tempoGiro;
    }

    @Override
    public String toString() {
        return String.format("Tempo: %d", tempoGiro);
    }
}