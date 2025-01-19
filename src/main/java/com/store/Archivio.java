package com.store;

import java.util.*;
import java.util.stream.Collectors;

// Classe che rappresenta l'archivio
public class Archivio {
    // Mappa per memorizzare gli elementi del catalogo
    private Map<String, ElementoCtl> catalogo = new HashMap<>();

    // Metodo per aggiungere un elemento
    public void aggiungiElemento(ElementoCtl elemento) throws Exception {
        // Controlla se esiste già un elemento con lo stesso ISBN
        if (catalogo.containsKey(elemento.getCodiceISBN())) {
            throw new Exception("Elemento con lo stesso ISBN già presente");
        }
        // Aggiunge l'elemento al catalogo
        catalogo.put(elemento.getCodiceISBN(), elemento);
    }

    // Metodo per cercare un elemento per ISBN
    public ElementoCtl cercaPerISBN(String isbn) throws ElementoNonTrovatoException {
        // Controlla se l'elemento è presente nel catalogo
        if (!catalogo.containsKey(isbn)) {
            throw new ElementoNonTrovatoException("Elemento con ISBN " + isbn + " non trovato");
        }
        // Restituisce l'elemento trovato
        return catalogo.get(isbn);
    }

    // Metodo per rimuovere un elemento dal catalogo
    public void rimuoviElemento(String isbn) throws ElementoNonTrovatoException {
        // Controlla se l'elemento è presente nel catalogo
        if (!catalogo.containsKey(isbn)) {
            throw new ElementoNonTrovatoException("Elemento con ISBN " + isbn + " non trovato");
        }
        // Rimuove l'elemento
        catalogo.remove(isbn);
    }

    // Metodo per cercare gli elementi per anno di pubblicazione
    public List<ElementoCtl> cercaPerAnno(int anno) {
        // Filtra gli elementi per anno  Streams
        return catalogo.values().stream()
                .filter(elemento -> elemento.getAnnoPublicazione() == anno)
                .collect(Collectors.toList());
    }

    // Metodo per cercare i libri per autore
    public List<Libro> cercaPerAutore(String autore) {
        // Filtra i libri per autore utilizzando Java Streams
        return catalogo.values().stream()
                .filter(elemento -> elemento instanceof Libro)
                .map(elemento -> (Libro) elemento)
                .filter(libro -> libro.getAutore().equalsIgnoreCase(autore))
                .collect(Collectors.toList());
    }

    // Metodo per aggiornare un elemento esistente
    public void aggiornaElemento(ElementoCtl elemento) throws ElementoNonTrovatoException {
        // Controlla se l'elemento è presente
        if (!catalogo.containsKey(elemento.getCodiceISBN())) {
            throw new ElementoNonTrovatoException("Elemento con ISBN " + elemento.getCodiceISBN() + " non trovato");
        }
        // Aggiorna l'elemento
        catalogo.put(elemento.getCodiceISBN(), elemento);
    }

    // Metodo per ottenere statistiche
    public void stampaStatistiche() {
        // Calcola il numero di libri nel catalogo
        long numeroLibri = catalogo.values().stream().filter(elemento -> elemento instanceof Libro).count();
        // Calcola il numero di riviste nel catalogo
        long numeroRiviste = catalogo.values().stream().filter(elemento -> elemento instanceof Rivista).count();
        // Trova l'elemento con il maggior numero di pagine
        ElementoCtl elementoMaxPagine = catalogo.values().stream()
                .max(Comparator.comparingInt(ElementoCtl::getNumeroPagine))
                .orElse(null);
        // Calcola la media delle pagine di tutti gli elementi nel catalogo
        double mediaPagine = catalogo.values().stream()
                .mapToInt(ElementoCtl::getNumeroPagine)
                .average()
                .orElse(0);

        // Stampa le statistiche
        System.out.println("Numero totale di libri: " + numeroLibri);
        System.out.println("Numero totale di riviste: " + numeroRiviste);
        System.out.println("Elemento con maggior numero di pagine: " + (elementoMaxPagine != null ? elementoMaxPagine.getTitolo() : "Nessuno"));
        System.out.println("Media delle pagine di tutti gli elementi: " + mediaPagine);
    }

    // Eccezione personalizzata per gestire elementi non trovati
    public static class ElementoNonTrovatoException extends Exception {
        public ElementoNonTrovatoException(String message) {
            super(message);
        }
    }
}
