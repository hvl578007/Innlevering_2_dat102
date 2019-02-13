package no.hvl.dat102.mengde.tabell;

import no.hvl.dat102.mengde.adt.MengdeADT;
import java.util.Iterator;
import java.util.Random;

public class TabellMengde<T> implements MengdeADT<T>  {

    private final static Random tilf = new Random();
    private final static int STDK = 100;
    private int antall;
    private T[] tab;

    public TabellMengde() {
        this(STDK);
    }

    public TabellMengde(int storrelse) {
        antall = 0;
        tab = (T[]) (new Object[storrelse]);
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
            if(antall == tab.length) {
                utvidKapasitet();
            }
            tab[antall] = element;
            antall++;
        }
    }

    private void utvidKapasitet() {
        T[] nyTab = (T[]) (new Object[tab.length*2]);

        for(int i = 0; i < tab.length; i++) {
            nyTab[i] = tab[i];
        }

        tab = nyTab;
    }

    @Override
    public boolean inneholder(T element) {
        boolean funne = false;
        int i = 0;
        while(!funne && i < antall) {
            if(tab[i].equals(element)) {
                funne = true;
            } else {
                i++;
            }
        }
        return funne;
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
        T svar = null;
        if (antall > 0) {
            int indeks = tilf.nextInt(antall);
            svar = tab[indeks];
            antall--;
            tab[indeks] = tab[antall];
            tab[antall] = null; //ikkje nødvendig
        }
        return svar;
    }

    // Oppgåve 1 a)
    @Override
    public T fjern(T element) {
        T svar = null;
        int i = 0;
        while(svar == null && i < antall) {
            if(tab[i].equals(element)) {
                svar = tab[i];
            } else {
                i++;
            }
        }

        if(svar != null) {
            antall--;
            tab[i] = tab[antall];
            tab[antall] = null;
        }
        return svar;
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

    @Override
    public MengdeADT<T> union(MengdeADT<T> m2) {
        //TODO
        return null;
    }

    private void settInn(T element) {
        if (antall == tab.length) {
            utvidKapasitet();
        }
        tab[antall] = element;
        antall++;
    }

    @Override
    public MengdeADT<T> snitt(MengdeADT<T> m2) {
        //TODO
        return null;
    }

    @Override
    public MengdeADT<T> differens(MengdeADT<T> m2) {
        //TODO
        return null;
    }

    @Override
    public boolean undermengde(MengdeADT<T> m2) {
        //TODO
        boolean erUnderMengde = true;
        return false;
    }

    @Override
    public Iterator<T> oppramser() {
        return new TabellIterator<T>(tab, antall);
    }
}
