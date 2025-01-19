package com.store;

// Classe astratta che rappresenta un elemento del catalogo
public abstract class ElementoCtl {
    private String codiceISBN;
    private String titolo;
    private int annoPublicazione;
    private int numeroPagine;

    // Costruttore
    public ElementoCtl(String codiceISBN, String titolo, int annoPublicazione, int numeroPagine) {
        this.codiceISBN = codiceISBN;
        this.titolo = titolo;
        this.annoPublicazione = annoPublicazione;
        this.numeroPagine = numeroPagine;
    }

    // Getter e setter
    public String getCodiceISBN() {
        return codiceISBN;
    }

    public void setCodiceISBN(String codiceISBN) {
        this.codiceISBN = codiceISBN;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public int getAnnoPublicazione() {
        return annoPublicazione;
    }

    public void setAnnoPublicazione(int annoPublicazione) {
        this.annoPublicazione = annoPublicazione;
    }

    public int getNumeroPagine() {
        return numeroPagine;
    }

    public void setNumeroPagine(int numeroPagine) {
        this.numeroPagine = numeroPagine;
    }
}

