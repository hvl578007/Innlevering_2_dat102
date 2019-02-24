package no.hvl.dat102;
/**
 * Person
 */
public class Person implements Comparable<Person> {

    private String fornamn;
    private String etternamn;
    private int fodselsaar;

    public Person() {
        this("", "", 2019);
    }

    public Person(String fornamn, String etternamn, int fodselsaar) {
        this.fornamn = fornamn;
        this.etternamn = etternamn;
        this.fodselsaar = fodselsaar;
    }

    public void setFornamn(String fornamn) {
        this.fornamn = fornamn;
    }

    public String getFornamn() {
        return fornamn;
    }

    public void setEtternamn(String etternamn) {
        this.etternamn = etternamn;
    }

    public String getEtternamn() {
        return etternamn;
    }

    public void setFodselsaar(int fodselsaar) {
        this.fodselsaar = fodselsaar;
    }

    public int getFodselsaar() {
        return fodselsaar;
    }

    @Override
    public String toString() {
        return fodselsaar + "  " + etternamn + ", " + fornamn;
    }

    @Override
    public int compareTo(Person p) {
        int svar = this.fodselsaar - p.fodselsaar; //eller p.get...()
        if(svar == 0) { //likt fodselsaar
            svar = this.etternamn.compareTo(p.etternamn);
            if(svar == 0) { //like etternamn
                svar = this.fornamn.compareTo(p.fornamn);
            }
        }
        return svar;
    }
    
}