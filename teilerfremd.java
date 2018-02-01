/**
  *
  * Beschreibung
  *
  * @version 1.0 vom 15.01.2018
  * @author 
  */

public class teilerfremd {
  
  // Anfang Attribute
  private int x;
  // Ende Attribute
  
  public teilerfremd() {
    this.x = 0;
  }

  // Anfang Methoden
   private int ggt(int zahl1, int zahl2) {
   while (zahl2 != 0) {
     if (zahl1 > zahl2) {
       zahl1 = zahl1 - zahl2;
     } else {
       zahl2 = zahl2 - zahl1;
     }
   }
   return zahl1;
 }
 
  public int getr(int x) {
    int zweiteZahl  = (int)(Math.random()*(x/4));
    int ergebnis = ggt(x, zweiteZahl);
    while (ergebnis != 1) { 
    zweiteZahl  = (int)(Math.random()*(x)); 
    ergebnis = ggt(x, zweiteZahl);  
    } // end of while
    return zweiteZahl;
  }

  public boolean prüf(int z1,int z2){
    if (ggt(z1,z2) == 1) {
      return true;
    } // end of if
    else {
      return false;
    } // end of if-else
    } 
  // Ende Methoden
} // end of teilerfremd
