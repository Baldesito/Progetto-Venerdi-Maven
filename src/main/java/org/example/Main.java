package org.example;

import com.store.Archivio;
import com.store.ElementoCtl;
import com.store.Libro;
import com.store.Rivista;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Archivio archivio = new Archivio();
        Scanner scanner = new Scanner(System.in);

        try {
            while (true) {
                System.out.println("Seleziona un'opzione: ");
                   System.out.println("1. Aggiungi Libro,");
                      System.out.println("2. Aggiungi Rivista,");
     System.out.println("3. Cerca ISBN,");
      System.out.println( "4. Rimuovi Elemento,");
                System.out.println("5. Cerca per Anno,");
                System.out.println("6. Cerca per Autore,");
                System.out.println("7. Aggiorna Elemento,");
                System.out.println("8. Stampa Statistiche,");
                System.out.println("9. Esci");
                int scelta;
                scelta = scanner.nextInt();
                scanner.nextLine(); // Consuma la nuova linea
                switch (scelta) {
                    case 1:
                        // Aggiungi un nuovo libro
                        System.out.println("Inserisci Titolo:");
                        String titolo = scanner.nextLine();
                        System.out.println("Inserisci ISBN:");
                        String isbn = scanner.nextLine();
                        System.out.println("Inserisci Anno Pubblicazione:");
                        int anno = scanner.nextInt();
                        scanner.nextLine(); // Consuma la nuova linea
                        System.out.println("Inserisci Numero Pagine:");
                        int pagine = scanner.nextInt();
                        scanner.nextLine(); // Consuma la nuova linea
                        System.out.println("Inserisci Autore:");
                        String autore = scanner.nextLine();
                        System.out.println("Inserisci Genere:");
                        String genere = scanner.nextLine();
                        Libro libro = new Libro(titolo, isbn, anno, pagine, autore, genere);
                        archivio.aggiungiElemento(libro);
                        break;
                    case 2:
                        // Aggiungi una nuova rivista
                        System.out.println("Inserisci ISBN:");
                        isbn = scanner.nextLine();
                        System.out.println("Inserisci Titolo:");
                        titolo = scanner.nextLine();
                        System.out.println("Inserisci Anno Pubblicazione:");
                        anno = scanner.nextInt();
                        scanner.nextLine(); // Consuma la nuova linea
                        System.out.println("Inserisci Numero Pagine:");
                        pagine = scanner.nextInt();
                        scanner.nextLine(); // Consuma la nuova linea
                        System.out.println("Inserisci Periodicità (1. SETTIMANALE, 2. MENSILE, 3. SEMESTRALE):");
                        int periodicitaScelta = scanner.nextInt();
                        scanner.nextLine(); // Consuma la nuova linea
                        Rivista.Periodico periodico = null;
                        switch (periodicitaScelta) {
                            case 1:
                                periodico = Rivista.Periodico.SETTIMANALE;
                                break;
                            case 2:
                                periodico = Rivista.Periodico.MENSILE;
                                break;
                            case 3:
                                periodico = Rivista.Periodico.SEMESTRALE;
                                break;
                            default:
                                System.out.println("Scelta non valida.");
                        }
                        if (periodico != null) {
                            Rivista rivista = new Rivista(titolo, isbn, anno, pagine, periodico);
                            archivio.aggiungiElemento(rivista);
                        }
                        break;
                    case 3:
                        // Cerca un elemento per ISBN
                        System.out.println("Inserisci ISBN:");
                        isbn = scanner.nextLine();
                        try {
                            ElementoCtl elemento = archivio.cercaPerISBN(isbn);
                            System.out.println("Elemento trovato: " + elemento.getTitolo());
                        } catch (Archivio.ElementoNonTrovatoException e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    case 4:
                        // Rimuove un elemento
                        System.out.println("Inserisci ISBN:");
                        isbn = scanner.nextLine();
                        try {
                            archivio.rimuoviElemento(isbn);
                            System.out.println("Elemento rimosso.");
                        } catch (Archivio.ElementoNonTrovatoException e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    case 5:
                        // Cerca elementi per anno di pubblicazione
                        System.out.println("Inserisci Anno Pubblicazione:");
                        anno = scanner.nextInt();
                        scanner.nextLine(); // Consuma la nuova linea
                        List<ElementoCtl> elementiAnno = archivio.cercaPerAnno(anno);
                        elementiAnno.forEach(elemento -> System.out.println(elemento.getTitolo()));
                        break;
                    case 6:
                        // Cerca libri per autore
                        System.out.println("Inserisci Autore:");
                        autore = scanner.nextLine();
                        List<Libro> libriAutore = archivio.cercaPerAutore(autore);
                        libriAutore.forEach(libroAutore -> System.out.println(libroAutore.getTitolo()));
                        break;
                    case 7:
                        // Aggiorna un elemento esistente
                        System.out.println("Inserisci ISBN dell'elemento da aggiornare:");
                        isbn = scanner.nextLine();
                        try {
                            ElementoCtl elemento = archivio.cercaPerISBN(isbn);
                            System.out.println("Elemento trovato. Inserisci i nuovi dati.");
                            System.out.println("Inserisci Titolo:");
                            titolo = scanner.nextLine();
                            System.out.println("Inserisci Anno Pubblicazione:");
                            anno = scanner.nextInt();
                            scanner.nextLine(); // Consuma la nuova linea
                            System.out.println("Inserisci Numero Pagine:");
                            pagine = scanner.nextInt();
                            scanner.nextLine(); // Consuma la nuova linea
                            elemento.setTitolo(titolo);
                            elemento.setAnnoPublicazione(anno);
                            elemento.setNumeroPagine(pagine);
                            archivio.aggiornaElemento(elemento);
                            System.out.println("Elemento aggiornato.");
                        } catch (Archivio.ElementoNonTrovatoException e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    case 8:
                        // Stampa statistiche
                        archivio.stampaStatistiche();
                        break;
                    case 9:
                        // Esci
                        System.out.println("Grazie, alla prossima.");
                        System.exit(0);
                    default:
                        System.out.println("Scelta no valida.");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
