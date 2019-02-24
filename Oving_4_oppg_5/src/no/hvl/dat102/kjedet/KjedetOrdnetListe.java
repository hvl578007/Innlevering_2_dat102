package no.hvl.dat102.kjedet;
import no.hvl.dat102.adt.*;
/**
 * 
 * @param <T>
 *            elementtypen
 */
public class KjedetOrdnetListe<T extends Comparable<T>> implements OrdnetListeADT<T> {
	private int antall;
	private LinearNode<T> foerste, siste;

	/**
	 * Lager en ny tom liste.
	 */
	public KjedetOrdnetListe() {
		antall = 0;
		foerste = null;
		siste = null;
	}

	@Override
	public T fjernFoerste() {
		T svar = null;

		if(!erTom()) {
			svar = foerste.getElement();
			foerste = foerste.getNeste();
			antall--;
		}
		
		return svar;
	}

	@Override
	public T fjernSiste() {
		T svar = null;
		
		if(!erTom()) {
			svar = siste.getElement();

			if(foerste == siste) {
				foerste = siste = null;
			} else {
				LinearNode<T> nestSiste = foerste;

				while(nestSiste.getNeste() != siste) {
					nestSiste = nestSiste.getNeste();
				}
				nestSiste.setNeste(null);
				siste = nestSiste;
			}
			antall--;
		}

		return svar;
	}

	@Override
	public T foerste() {
		T svar = null;
		if (!erTom()) {
			svar = foerste.getElement();
		}
		return svar;
	}

	@Override
	public T siste() {
		T svar = null;
		if (!erTom()) {
			svar = siste.getElement();
		}
		return svar;
	}

	@Override
	public boolean erTom() {
		return antall == 0;
	}

	@Override
	public int antall() {
		return antall;
	}

	@Override
	public void leggTil(T element) {
		LinearNode<T> nynode = new LinearNode<T>(element);

		if(foerste == null) {
			foerste = nynode;
			siste = nynode;
		} else {
			LinearNode<T> denne = foerste;
			LinearNode<T> forrige = null;

			while (denne != null && element.compareTo(denne.getElement()) > 0 ) {
				forrige = denne;
				denne = denne.getNeste();
			}

			if(denne == foerste) { //skal inn først i lista
				nynode.setNeste(foerste);
				foerste = nynode;
			} else if (denne == null) { //skal inn sist i lista
				siste.setNeste(nynode);
				siste = nynode;
			} else { //skal inn midt inni
				nynode.setNeste(denne);
				forrige.setNeste(nynode);
			}

		}
		antall++;
	}


	@Override
	public T fjern(T element) {
		T svar = null;
		LinearNode<T> forrige = null, denne = foerste;
		while (denne != null && element.compareTo(denne.getElement()) > 0) {
			forrige = denne;
			denne = denne.getNeste();
		}
		if (denne != null && element.equals(denne.getElement())) { // funnet
			antall--;
			svar = denne.getElement();
			if (forrige == null) {     // F�rste element
				foerste = foerste.getNeste();
				if (foerste == null) { // Tom liste
					siste = null;
				}
			} else { // Inni listen eller bak
				forrige.setNeste(denne.getNeste());
				if (denne == siste) { // bak
					siste = forrige;
				}
			}
		} // ikke-funn
		return svar;
	}

	@Override
	public boolean inneholder(T element) {
		LinearNode<T> denne = foerste;
		boolean resultat = false;
		while (denne != null && element.compareTo(denne.getElement()) > 0) {
			denne = denne.getNeste();
		}
		if (denne != null) {
			if (element.equals(denne.getElement())) {
				resultat = true;
			}
		} // ikke-funn
		return resultat;
	}

}// class
