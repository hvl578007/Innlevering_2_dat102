package no.hvl.dat102;

import no.hvl.dat102.mengde.tabell.*;
import no.hvl.dat102.mengde.adt.MengdeADT;
import org.junit.*;
import static org.junit.Assert.*;

/**
 * TestTabellMengde
 */
public class TestTabellMengde {

    private MengdeADT<Integer> m1;
    private MengdeADT<Integer> m2;
    private MengdeADT<Integer> m3;
    private MengdeADT<Integer> fasit;

    private Integer e0 = 0;
    private Integer e1 = 1;
    private Integer e2 = 2;
    private Integer e3 = 3;
    private Integer e4 = 4;
    private Integer e5 = 5;
    private Integer e6 = 6;
    private Integer e7 = 7;
    private Integer e8 = 8;
    private Integer e9 = 9;

    @Before
    public final void setup() {
        m1 = new TabellMengde<Integer>();
        m2 = new TabellMengde<Integer>();
        fasit = new TabellMengde<Integer>();
    }

    @Test
    public final void testUnionFelles() {
        m1.leggTil(e0);
        m1.leggTil(e1);
        m1.leggTil(e2);
        m1.leggTil(e3);
        m1.leggTil(e4);

        m2.leggTil(e2);
        m2.leggTil(e3);
        m2.leggTil(e4);
        m2.leggTil(e7);
        m2.leggTil(e9);

        m3 = m1.union(m2);
        
        fasit.leggTil(e0);
        fasit.leggTil(e1);
        fasit.leggTil(e2);
        fasit.leggTil(e3);
        fasit.leggTil(e4);
        fasit.leggTil(e7);
        fasit.leggTil(e9);

        assertTrue(m3.equals(fasit));
    }

    @Test
    public final void testUnionDisjunkte() {
        m1.leggTil(e0);
        m1.leggTil(e1);
        m1.leggTil(e2);
        m1.leggTil(e3);
        m1.leggTil(e4);

        m2.leggTil(e5);
        m2.leggTil(e6);
        m2.leggTil(e7);
        m2.leggTil(e8);
        m2.leggTil(e9);

        m3 = m1.union(m2);

        fasit.leggTil(e0);
        fasit.leggTil(e1);
        fasit.leggTil(e2);
        fasit.leggTil(e3);
        fasit.leggTil(e4);
        fasit.leggTil(e5);
        fasit.leggTil(e6);
        fasit.leggTil(e7);
        fasit.leggTil(e8);
        fasit.leggTil(e9);

        assertTrue(m3.equals(fasit));
    }

    @Test
    public final void testSnittFelles() {
        m1.leggTil(e1);
        m1.leggTil(e6);
        m1.leggTil(e3);
        m1.leggTil(e5);
        m1.leggTil(e6);

        m2.leggTil(e3);
        m2.leggTil(e4);
        m2.leggTil(e5);
        m2.leggTil(e6);
        m2.leggTil(e7);

        m3 = m1.snitt(m2);

        fasit.leggTil(e3);
        fasit.leggTil(e5);
        fasit.leggTil(e6);

        assertTrue(m3.equals(fasit));
    }

    @Test
    public final void testSnittDisjunkt() {
        m1.leggTil(e0);
        m1.leggTil(e1);
        m1.leggTil(e2);
        m1.leggTil(e3);
        m1.leggTil(e4);

        m2.leggTil(e5);
        m2.leggTil(e6);
        m2.leggTil(e7);
        m2.leggTil(e8);
        m2.leggTil(e9);
        
        m3 = m1.snitt(m2);

        assertTrue(m3.equals(fasit));
    }

    @Test
    public final void testDifferensFelles() {
        m1.leggTil(e1);
        m1.leggTil(e2);
        m1.leggTil(e3);
        m1.leggTil(e5);
        m1.leggTil(e7);

        m2.leggTil(e3);
        m2.leggTil(e5);
        m2.leggTil(e7);
        m2.leggTil(e8);
        m2.leggTil(e9);

        m3 = m1.differens(m2);
        
        fasit.leggTil(e1);
        fasit.leggTil(e2);

        assertTrue(m3.equals(fasit));
    }

    @Test
    public final void testDifferensDisjunkt() {
        m1.leggTil(e0);
        m1.leggTil(e1);
        m1.leggTil(e2);
        m1.leggTil(e3);
        m1.leggTil(e4);

        m2.leggTil(e5);
        m2.leggTil(e6);
        m2.leggTil(e7);
        m2.leggTil(e8);
        m2.leggTil(e9);

        m3 = m1.differens(m2);
        
        fasit.leggTil(e0);
        fasit.leggTil(e1);
        fasit.leggTil(e2);
        fasit.leggTil(e3);
        fasit.leggTil(e4);

        assertTrue(m3.equals(fasit));
    }
}