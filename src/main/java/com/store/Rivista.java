package com.store;

public class Rivista extends ElementoCtl {
    private Periodico periodico;

    public Periodico getPeriodico() {
        return periodico;
    }

    public void setPeriodico(Periodico periodico) {
        this.periodico = periodico;
    }

    // Enum che definisce i tipi di periodic..

    public enum Periodico {
        SETTIMANALE, MENSILE, SEMESTRALE
    }
}