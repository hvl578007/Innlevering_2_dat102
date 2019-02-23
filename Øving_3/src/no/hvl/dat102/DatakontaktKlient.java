package no.hvl.dat102;

import java.util.Scanner;
/**
 * DataKlient
 */
public class DatakontaktKlient {

    public static Scanner lesar = new Scanner(System.in);

    public static void main(String[] args) {
        Datakontakt arkiv = new Datakontakt();
        System.out.println("----- Datakontakt-program startar -----\n");
        Meny meny = new Meny(arkiv);
        meny.start();
    }
}