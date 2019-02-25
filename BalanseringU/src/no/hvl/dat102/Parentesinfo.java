package no.hvl.dat102;

public class Parentesinfo{
 
 private int linjenr;
 private int posisjon;
 private char venstreparentes;
 
 public Parentesinfo(){
  linjenr  = -1;
  posisjon = -1;
  venstreparentes = ')';
 }

 public Parentesinfo(int linjenr, int posisjon, char venstreparentes) {
     this.linjenr = linjenr;
     this.posisjon = posisjon;
     this.venstreparentes = venstreparentes;
 }
 
 public void setLinjenr(int nyttLinjenr){
  linjenr = nyttLinjenr;
 }
 
 public void setPosisjon(int nyPosisjon){
  posisjon = nyPosisjon;
  
 }
 
 public void setVenstreparentes(char nyVenstreparentes){
  venstreparentes = nyVenstreparentes;
 }
 
 public int getLinjenr(){ return linjenr;}
 
 public int getPosisjon(){ return posisjon;}

 public char getVenstreparentes(){ return venstreparentes;}

 
}//class
