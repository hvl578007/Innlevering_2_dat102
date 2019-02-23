package no.hvl.dat102;

import java.util.Scanner;

import no.hvl.dat102.mengde.kjedet.KjedetMengde;

/**
 * Tekstgrensesnitt
 */
public class Tekstgrensesnitt {

    public static Scanner lesar = new Scanner(System.in);
    /**
     * Les opplysningane om eit medlem frå tastaturet
     */
    public static Medlem lesMedlem() {

        System.out.println("Skriv inn namnet til det nye medlemmet:");
        String namn = lesar.nextLine();

        KjedetMengde<Hobby> hobbyar = new KjedetMengde<Hobby>();
        boolean ferdig = false;
        do {
            System.out.println("\nSkriv inn namnet på hobbyen: (avslutt med zzz)");
            String hobbyNamn = lesar.nextLine();
            ferdig = hobbyNamn.equalsIgnoreCase("zzz");

            if(!ferdig) {
                hobbyar.leggTil(new Hobby(hobbyNamn));
            }

        } while (!ferdig);
        
        Medlem medlem = new Medlem(namn, -1, hobbyar);

        return medlem;
    }

    /**
     * Skriv ut hobbylista for eit medlem
     */
    public static void skrivHobbyListe(Medlem medlem) {
        System.out.println("\nAlle hobbyar til " + medlem.getNamn() + ":");
        System.out.println("<" + medlem.getHobbyar().toString() + ">");
    }

    /**
     * Skriv ut ei oversikt over medlem som er kopla til kvarandre, og antall par funne
     */
    public static void skrivParListe_finnPartner(Datakontakt arkiv) {
        int antPar = 0;
        Medlem[] tab = arkiv.getMedlemsTab();

        System.out.println("-----PARNAMN-----   " + "\t" + "-----HOBBYAR-----");
        //brukar finnPartner metoden
        for (int i = 0; i < arkiv.getAntallMedlemmar(); i++) {
            String namn = tab[i].getNamn();
            int partnerIndeks = arkiv.finnPartnerFor(namn);
            if(partnerIndeks != -1) {
                String pNamn = tab[partnerIndeks].getNamn();
                System.out.println(namn + " og " + pNamn + "\t<" + tab[i].getHobbyar().toString() + ">");
                antPar++;
            }
        }
        System.out.println("\nAntall par: " + antPar);
    }

    public static void skrivParListe(Datakontakt arkiv) {
        //brukar ikkje finnPartnerFor metoden... ???
        System.out.println("-----PARNAMN-----   " + "\t" + "-----HOBBYAR-----");
        int antPar = 0;
        Medlem[] tab = arkiv.getMedlemsTab();

        //blir ikkje fint dette her altså... sikkert ein annan måte som eg berre ikkje ser nå...
        boolean[] harPartner = new boolean[arkiv.getAntallMedlemmar()];

        for (int i = 0; i < arkiv.getAntallMedlemmar(); i++) {
            int partnerIndeks = tab[i].getStatusIndeks();
            if(partnerIndeks != -1 && !harPartner[partnerIndeks]) {
                harPartner[i] = true;
                harPartner[partnerIndeks] = true;
                System.out.println(tab[i].getNamn() + " og " + tab[partnerIndeks].getNamn() + "\t<" + tab[i].getHobbyar().toString() + ">");
                antPar++;
            }
        }
        System.out.println("\nAntall par: " + antPar);
    }
}