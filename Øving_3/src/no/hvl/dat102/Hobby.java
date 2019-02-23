package no.hvl.dat102;

/**
 * Hobby
 */
public class Hobby {

    private String hobbyNamn;

    public Hobby(String hobby) {
        this.hobbyNamn = hobby;
    }

    /**
     * @param hobbyNamn hobbyNamnet ein skal setje
     */
    public void setHobbyNamn(String hobbyNamn) {
        this.hobbyNamn = hobbyNamn;
    }

    /**
     * @return Hobbynamnet
     */
    public String getHobbyNamn() {
        return hobbyNamn;
    }

    @Override
    public String toString() {
        return hobbyNamn; //skal ein hobby bli skreve ut på formen <hobbynamn> ??? eller ved fleire hobbyar <h1, h2, h3> ???
    }

    @Override
    public boolean equals(Object obj) {
        Hobby hobbyDenAndre;
        if(obj instanceof Hobby) { //sjekker om det er eit hobby-objekt
            hobbyDenAndre = (Hobby) obj;
            return hobbyNamn.equals(hobbyDenAndre.getHobbyNamn());
        }
        return false;
    }
}