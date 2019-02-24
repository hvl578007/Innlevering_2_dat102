package no.hvl.dat102.sirkulaer;

import no.hvl.dat102.adt.KoeADT;
import no.hvl.dat102.exception.EmptyCollectionException;

public class SirkulaerKoe<T> implements KoeADT<T> {

    private static final int STD = 100;
    private int front, bak, antall;
    private T[] koe;

    public SirkulaerKoe(int storrelse) {
        koe = (T[])(new Object[storrelse]);
        front = bak = antall = 0;
    }

    public SirkulaerKoe() {
        this(STD);
    }

    @Override
    public void innKoe(T element) {
        if (antall() == koe.length) {
            utvid();
        }

        koe[bak] = element;
        bak = (bak+1) % koe.length;
        antall++;
    }

    @Override
    public T utKoe() {
        if(erTom()) {
            throw new EmptyCollectionException("Kø");
        }
        T resultat = koe[front];
        koe[front] = null;
        front = (front+1) % koe.length;
        antall--;
        return resultat;
    }

    @Override
    public T foerste() {
        if(erTom()) {
            throw new EmptyCollectionException("Kø");
        }
        return koe[front];
    }

    @Override
    public boolean erTom() {
        return (antall() == 0);
    }

    @Override
    public int antall() {
        return antall;
    }

    private void utvid() {
        T[] hjelpetab = (T[])(new Object[koe.length * 2]);

        for (int i = 0; i < koe.length; i++) {
            hjelpetab[i] = koe[front];
            front = (front+1) % koe.length;
        }

        front = 0;
        bak = antall;
        koe = hjelpetab;
    }

}
