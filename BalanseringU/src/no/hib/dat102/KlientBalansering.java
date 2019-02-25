package no.hib.dat102;

import java.util.Scanner;

import no.hvl.dat102.*;

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
