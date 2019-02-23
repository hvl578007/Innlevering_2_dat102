package no.hvl.dat102.mengde.kjedet;

import java.util.Iterator;
import java.util.NoSuchElementException;
/**
 * KjedetIterator
 */
public class KjedetIterator<T> implements Iterator<T> {

    private LinearNode<T> aktuell;

    public KjedetIterator(LinearNode<T> samling) {
        aktuell = samling;
    }

    @Override
    public boolean hasNext() {
        return aktuell != null;
    }

    @Override
    public T next() {
        T resultat = null;
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        resultat = aktuell.getElement();
        aktuell = aktuell.getNeste();
        return resultat;
    }

    /**
     * Ikkje implementert
     */
    @Override
    public void remove() {
        System.out.println("Ikkje implementert.");
    }
}