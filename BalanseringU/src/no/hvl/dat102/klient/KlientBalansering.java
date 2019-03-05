package no.hvl.dat102.klient;

import no.hvl.dat102.Balansering;
import java.util.Scanner;

public class KlientBalansering{
     public static void main(String[] args){
        //final String filnavn = "data.txt";
         Scanner lesar = new Scanner(System.in);
         System.out.println("Skriv inn filnamn:");
         String filnavn = lesar.nextLine();
         lesar.close();

         //Leser inn en tekst fra fil
         Balansering balansering = new Balansering();
         balansering.lesFraFil(filnavn);
 }//main

}//class
