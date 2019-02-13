package no.hvl.dat102.mengde.kjedet;

public class LinearNode<T> {

    private T element;
    private LinearNode<T> neste;

    public LinearNode() {
        this(null);
    }

    public LinearNode(T elem) {
        element = elem;
        neste = null;
    }

    /**
     * @return the element
     */
    public T getElement() {
        return element;
    }

    /**
     * @param element the element to set
     */
    public void setElement(T element) {
        this.element = element;
    }

    /**
     * @return the neste
     */
    public LinearNode<T> getNeste() {
        return neste;
    }

    /**
     * @param neste the neste to set
     */
    public void setNeste(LinearNode<T> neste) {
        this.neste = neste;
    }
}
