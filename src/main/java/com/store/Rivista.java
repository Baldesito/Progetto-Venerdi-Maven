package com.store;

// Classe che rappresenta una rivista nel catalogo, estende ElementoCtl
public class Rivista extends ElementoCtl {
    private Periodico periodico;

    // Costruttore
    public Rivista(String titolo, String isbn, int anno, int pagine, Periodico periodico) {
        super(isbn, titolo, anno, pagine);
        this.periodico = periodico;
    }

    // Getter e setter
    public Periodico getPeriodico() {
        return periodico;
    }

    public void setPeriodico(Periodico periodico) {
        this.periodico = periodico;
    }

    // Enum che definisce i tipi di periodicità
    public enum Periodico {
        SETTIMANALE, MENSILE, SEMESTRALE
    }
}
