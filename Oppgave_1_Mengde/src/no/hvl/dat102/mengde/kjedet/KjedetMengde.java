package no.hvl.dat102.mengde.kjedet;

import no.hvl.dat102.mengde.adt.MengdeADT;
import java.util.Random;
import java.util.Iterator;

/**
 * KjedetMengde
 */
public class KjedetMengde<T> implements MengdeADT<T> {

    private final static Random tilf = new Random();
    private int antall;
    private LinearNode<T> start;

    public KjedetMengde() {
        antall = 0;
        start = null;
    }

    @Override
    public int antall() {
        return antall;
    }

    @Override
    public boolean erTom() {
        return antall == 0;
    }

    @Override
    public void leggTil(T element) {
        if(!inneholder(element)) {
            LinearNode<T> nynode = new LinearNode<T>(element);
            nynode.setNeste(start);
            start = nynode;
            antall++;
        }
    }

    @Override
    public void leggTilAlle(MengdeADT<T> m2) {
        Iterator<T> teljar = m2.oppramser();
        while (teljar.hasNext()) {
            leggTil(teljar.next());
        }
    }

    @Override
    public T fjernTilfeldig() {
        LinearNode<T> forgjenger, aktuell;
        T resultat = null;
        if(!erTom()) {
            int val = tilf.nextInt(antall) + 1;
            if(val == 1) {
                resultat = start.getElement();
                start = start.getNeste();
            } else {
                forgjenger = start;
                for (int nr = 2; nr < val; nr++) {
                    forgjenger = forgjenger.getNeste();
                }
                aktuell = forgjenger.getNeste();
                resultat = aktuell.getElement();
                forgjenger.setNeste(aktuell.getNeste());
            }
            antall--;
        }
        return resultat;
    }

    // Oppgåve 1 a)
    @Override
    public T fjern(T element) {
        boolean funne = false;
        LinearNode<T> forgjenger, aktuell;
        T resultat = null;

        if(!erTom()) {
            forgjenger = null;
            aktuell = start;

            while(!funne && aktuell != null) {
                if(aktuell.getElement().equals(element)) {
                    funne = true;
                    resultat = aktuell.getElement();
                    antall--;
                } else {
                    forgjenger = aktuell;
                    aktuell = aktuell.getNeste();
                }
            }

            if(aktuell == start) {
                start = start.getNeste();
            } else {
                forgjenger.setNeste(aktuell.getNeste());
            }
        }

        return resultat;
    }

    // Oppgåve 1 a)
    @Override
    public boolean equals(MengdeADT<T> m2) {
        boolean likeMengder = true;

        if(antall == m2.antall()) { //like store
            Iterator<T> teljar = m2.oppramser();

            while (likeMengder && teljar.hasNext()) {

                if(!inneholder(teljar.next())) {
                    likeMengder = false;
                }
            }
        } else {
            likeMengder = false;
        }
        return likeMengder;
    }

    // Oppgåve 1 b) i)
    @Override
    public MengdeADT<T> union(MengdeADT<T> m2) {
        MengdeADT<T> begge = new KjedetMengde<T>();
        LinearNode<T> aktuell = start;
        T element = null;

        while(aktuell != null) { //evt iterator her også
            element = aktuell.getElement();
            aktuell = aktuell.getNeste();
            ((KjedetMengde<T>) begge).settInn(element);
        }

        Iterator<T> teljar = m2.oppramser();
        while(teljar.hasNext()) {
            element = teljar.next();
            if(!inneholder(element)) {
                ((KjedetMengde<T>) begge).settInn(element);
            }
        }

        return begge;
    }

    private void settInn(T element) {
        LinearNode<T> nynode = new LinearNode<T>(element);
        nynode.setNeste(start);
        start = nynode;
        antall++;
    }

    // Oppgåve 1 b) ii)
    @Override
    public MengdeADT<T> snitt(MengdeADT<T> m2) {
        MengdeADT<T> snittM = new KjedetMengde<T>();
        T element;

        Iterator<T> teljar = m2.oppramser();

        while(teljar.hasNext()) {
            element = teljar.next();
            if(inneholder(element)) {
                ((KjedetMengde<T>) snittM).settInn(element);
            }
        }

        return snittM;
    }

    // Oppgåve 1 b) iii)
    @Override
    public MengdeADT<T> differens(MengdeADT<T> m2) {
        MengdeADT<T> differensM = new KjedetMengde<T>();
        T element;
        
        Iterator<T> teljar = this.oppramser();

        while(teljar.hasNext()) {
            element = teljar.next();
            if(!m2.inneholder(element)) {
                ((KjedetMengde<T>) differensM).settInn(element);
            }
        }

        return differensM;
    }

    // Oppgåve 1 b) iv)
    @Override
    public boolean undermengde(MengdeADT<T> m2) {
        boolean erUnderMengde = true;
        
        Iterator<T> teljar = m2.oppramser();

        while(erUnderMengde && teljar.hasNext()) {
            if(!inneholder(teljar.next())) {
                erUnderMengde = false;
            }
        }
        
        return erUnderMengde;
    }

    @Override
    public boolean inneholder(T element) {
        boolean funne = false;
        LinearNode<T> aktuell = start;
        while(!funne && aktuell != null) {
            if(aktuell.getElement().equals(element)) {
                funne = true;
            } else {
                aktuell = aktuell.getNeste();
            }
        }
        return funne;
    }

    @Override
    public Iterator<T> oppramser() {
        return new KjedetIterator<T>(start);
    }

}