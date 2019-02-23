package no.hvl.dat102;

/**
 * Datakontakt
 */
public class Datakontakt {

    private static final int STDK = 100;

    private Medlem[] medlemsTab;
    private int antallMedlemmar;

    public Datakontakt(int storrelse) {
        medlemsTab = new Medlem[storrelse];
        antallMedlemmar = 0;
    }

    public Datakontakt() {
        this(STDK);
    }

    public void leggTilMedlem(Medlem person) {
        if(person == null) {
            return;
        }
        
        if(medlemsTab.length == antallMedlemmar) {
            utvid();
        }

        medlemsTab[antallMedlemmar] = person;
        antallMedlemmar++;
    }

    public int finnMedlemsIndeks(String medlemsnamn) {
        int res = -1;
        int i = 0;
        while(i < antallMedlemmar && res == -1) {
            if(medlemsnamn.equals(medlemsTab[i].getNamn())) {
                res = i;
            }
            i++;
        }

        return res;
    }

    public int finnPartnerFor(String medlemsnamn) {
        int indeks = finnMedlemsIndeks(medlemsnamn); //skal finne ein partner for
        int indeksPartner = -1;

        if(indeks != -1 && medlemsTab[indeks].getStatusIndeks() == -1) { //om den finst eller ikkje og om den er "kopla" eller ikkje
            
            int i = 0;

            while(indeksPartner == -1 && i < antallMedlemmar) {
                if(i != indeks && medlemsTab[i].getStatusIndeks() == -1 && medlemsTab[indeks].passerTil(medlemsTab[i])) {
                    //sjekker om at den ikkje er den samme, at den ikkje er "kopla" og så om dei to medlemma passar
                    indeksPartner = i;
                }
                i++;
            }

            if(indeksPartner != -1) {
                medlemsTab[indeks].setStatusIndeks(indeksPartner);
                medlemsTab[indeksPartner].setStatusIndeks(indeks);
            }

        }

        return indeksPartner;

        //denne skal oppdatere begge indeksane???
    }

    public void tilbakestillStatusIndeks(String medlemsnamn) {
        int indeks = finnMedlemsIndeks(medlemsnamn);

        if(indeks != -1 && medlemsTab[indeks].getStatusIndeks() != -1) { //om den finst og om den er "kopla"
            int indeksPartner = medlemsTab[indeks].getStatusIndeks();
            medlemsTab[indeksPartner].setStatusIndeks(-1);
            medlemsTab[indeks].setStatusIndeks(-1);
        }

        //return ???
    }

    public Medlem finnMedlem(int indeks) {
        Medlem m = null;
        if(indeks != -1) {
            m = medlemsTab[indeks];
        }
        return m;
    }

    public Medlem[] getMedlemsTab() {
        return medlemsTab;
    }

    public int getAntallMedlemmar() {
        return antallMedlemmar;
    }

    private void utvid() {
        Medlem[] nyTab = new Medlem[medlemsTab.length * 2];

        for(int i = 0; i < medlemsTab.length; i++) {
            nyTab[i] = medlemsTab[i];
        }

        medlemsTab = nyTab;
    }

}