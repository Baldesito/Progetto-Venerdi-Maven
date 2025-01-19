package com.store;

// Classe che rappresenta un libro nel catalogo, estende ElementoCtl
public class Libro extends ElementoCtl {
    private String autore;
    private String genere;

    // Costruttore
    public Libro(String titolo, String isbn, int anno, int pagine, String autore, String genere) {
        super(isbn, titolo, anno, pagine);
        this.autore = autore;
        this.genere = genere;
    }

    // Getter e setter
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
