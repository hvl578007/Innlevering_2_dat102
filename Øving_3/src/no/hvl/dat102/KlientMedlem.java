package no.hvl.dat102;

import no.hvl.dat102.mengde.kjedet.KjedetMengde;

/**
 * KlientMedlem
 */
public class KlientMedlem {

    //Berre for å teste medlem?
    public static void main(String[] args) {
        KjedetMengde<Hobby> h = new KjedetMengde<Hobby>();
        Medlem m1 = new Medlem("Stian", -1, h);
        m1.leggTilHobby("Anime");
        m1.leggTilHobby("Nintendo");
        skrivUtMedlem(m1);
    }

    public static void skrivUtMedlem(Medlem m) {
        System.out.println("Namn: " + m.getNamn());
        System.out.println("Status: " + m.getStatusIndeks()); //if-else eller noko her?
        System.out.println("Hobbyar:");
        System.out.println(m.getHobbyar().toString());
    }
}