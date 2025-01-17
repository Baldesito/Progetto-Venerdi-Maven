package com.store;

public class Libro extends ElementoCtl {
    private String autore;
    private String genere;

    // Costruttori, getter e setter

    public String getAutore() {
        return autore;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }

    public String getGenere() {
        return genere;
    }

    public void setGenere(String genere) {
        this.genere = genere;
    }
}