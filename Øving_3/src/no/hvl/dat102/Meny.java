package no.hvl.dat102;

import java.util.Scanner;
/**
 * Meny
 */
public class Meny {

    private Datakontakt arkiv;
    private Scanner lesar;
    private boolean ferdig;

    public Meny(Datakontakt arkiv) {
        this.arkiv = arkiv;
        lesar = Tekstgrensesnitt.lesar;
        ferdig = false;
    }

    public void start() {
        skrivUtValalterantiv();
        //valalternativ -> utfører metoder basert på valet
        do {
            System.out.println("\nSkriv inn eit tal mellom 1 - 7. 0 for å avslutte, og eit anna tal for valalternativa");
            try {
                int verdi = Integer.parseInt(lesar.nextLine());

                System.out.println();
                
                val(verdi);
            } catch (NumberFormatException e) {
                System.out.println("Ikkje eit nummer!");
            }
        } while (!ferdig);
    }

    private void val(int alternativ) {
        String namn;
        int indeks;
        Medlem m;
        switch (alternativ) {
            case 0:
                System.out.println("Programmet avsluttar");
                lesar.close();
                ferdig = true;
                break;
            case 1:
                m = Tekstgrensesnitt.lesMedlem();
                arkiv.leggTilMedlem(m);
                break;
            case 2:
                System.out.println("Skriv inn medlemsnamnet:");
                namn = lesar.nextLine();
                int partnerIndeks = arkiv.finnPartnerFor(namn);
                if(partnerIndeks != -1) {
                    String pNamn = arkiv.finnMedlem(partnerIndeks).getNamn();
                    System.out.println("Fann ein partner, " + pNamn + ", for " + namn);
                } else {
                    System.out.println("Fann ingen partner for " + namn);
                }
                break;
            case 3:
                System.out.println("Skriv inn medlemsnamnet:");
                namn = lesar.nextLine();
                indeks = arkiv.finnMedlemsIndeks(namn);
                if(indeks != -1) {
                    System.out.println(namn + " finst i arkivet på indeks " + indeks);
                } else {
                    System.out.println(namn + " finst ikkje i arkivet");
                }
                //ikkje så veldig nyttig då
                break;
            case 4:
                System.out.println("Skriv inn medlemsnamnet:");
                namn = lesar.nextLine();
                indeks = arkiv.finnMedlemsIndeks(namn);
                m = arkiv.finnMedlem(indeks);
                if(m == null) {
                    System.out.println(namn + " finst ikkje i arkivet");
                } else {
                    Tekstgrensesnitt.skrivHobbyListe(m);
                }
                break;
            case 5:
                Tekstgrensesnitt.skrivParListe_finnPartner(arkiv);
                break;
            case 6:
                Tekstgrensesnitt.skrivParListe(arkiv);
                break;
            case 7:
                System.out.println("Skriv inn medlemsnamnet:");
                namn = lesar.nextLine();
                arkiv.tilbakestillStatusIndeks(namn);
                //vil ikkje gje melding om det er blitt gjort eller ikkje -> returnere boolean i Datakontakt?
                System.out.println("Statusindeksen har blit tilbakestilt om medlemmet blei funne");
                break;
            default:
                skrivUtValalterantiv();
                break;
        }
    }

    private void skrivUtValalterantiv() {
        System.out.println("----- VALALTERNATIV -----");
        System.out.println("1 - legg til medlem");
        System.out.println("2 - finn partner for eit medlem med eit gitt namn");
        System.out.println("3 - sjekk om det er eit medlem med eit gitt namn"); //unødvendig sikkert...
        System.out.println("4 - skriv ut hobbyliste for eit medlem med eit gitt namn");
        System.out.println("5 - finn partnere for alle i arkivet om det finst og skriv ut parlista (vil ikkje fungere rett etter bruk av val 2)");
        System.out.println("6 - skriv ut den nåverande parlista (NB: må ha brukt val 2)");
        System.out.println("7 - tilbakestill statusindeksen til eit medlem med eit gitt namn");
        System.out.println("0 - avslutte");
    }
}