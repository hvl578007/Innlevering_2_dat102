package no.hvl.dat102;

import java.util.Scanner;

import no.hvl.dat102.kjedet.*;
import no.hvl.dat102.tabell.*;

/**
 * PersonKlientListe
 */
public class PersonKlientListe {

    private static Scanner lesar = new Scanner(System.in);
    private static final int ANT_PERSONAR = 5;

    public static void main(String[] args) {
        //KjedetOrdnetListe<Person> pListe = new KjedetOrdnetListe<Person>();
        TabellOrdnetListe<Person> pListe = new TabellOrdnetListe<Person>();

        for (int i = 0; i < ANT_PERSONAR; i++) {
            pListe.leggTil(lesPerson());
        }

        while (!pListe.erTom()) {
            System.out.println(pListe.fjernFoerste());
        }

        lesar.close();
    }

    public static Person lesPerson() {
        Person p = null;

        System.out.println("Skriv inn fornamn:");
        String fornamn = lesar.nextLine();
        System.out.println("Skriv inn etternamn:");
        String etternamn = lesar.nextLine();
        System.out.println("Skriv inn fødselsår:");
        int fodselsaar = lesar.nextInt();
        lesar.nextLine(); //? fungerer det ?

        p = new Person(fornamn, etternamn, fodselsaar);
        return p;
    }
}