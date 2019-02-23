package no.hvl.dat102;

import no.hvl.dat102.mengde.adt.MengdeADT;
import no.hvl.dat102.mengde.kjedet.KjedetMengde;
import no.hvl.dat102.mengde.tabell.TabellMengde;

/**
 * Medlem
 */
public class Medlem {

    private String namn;
    private KjedetMengde<Hobby> hobbyar; //evt tabell, evt. generell???
    private int statusIndeks;

    public Medlem() {
        this("", -1, new KjedetMengde<Hobby>());
    }

    public Medlem(String namn, int statusIndeks, KjedetMengde<Hobby> hobbyar) { //interface-referanse??
        this.namn = namn;
        this.hobbyar = hobbyar;
        this.statusIndeks = statusIndeks;
    }

    public String getNamn() {
        return this.namn;
    }

    public void setNamn(String namn) {
        this.namn = namn;
    }

    public int getStatusIndeks() {
        return this.statusIndeks;
    }

    public void setStatusIndeks(int status) {
        this.statusIndeks = status;
    } 

    public MengdeADT<Hobby> getHobbyar() { //evt kjedet/tabell-referanse?
        return hobbyar;
    }

    public void setHobby(MengdeADT<Hobby> hobbyar) {
        this.hobbyar = (KjedetMengde<Hobby>)hobbyar; // blir "feilkonvertering" om det er tabell...
    }

    public boolean passerTil(Medlem medlem2) {
        return hobbyar.equals(medlem2.getHobbyar());
    }

    public void leggTilHobby(String hobbynamn) { //???
        Hobby h = new Hobby(hobbynamn);
        hobbyar.leggTil(h);
    }
}