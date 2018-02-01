/**
  *
  * Beschreibung
  *
  * @version 1.0 vom 15.01.2018
  * @author 
  */
import java.math.*;
public class verschluesselung {
  
  // Anfang Attribute
  private String m;
  private int n;
  private int r;
  // Ende Attribute
  
  public verschluesselung() {
    this.r = 0;
    this.n = 0;
    this.m = "";
  }
  
  // Anfang Methoden
  
  public String ver(int n, int r, String m) {
    BigInteger bn = BigInteger.valueOf(n);
    BigInteger br = BigInteger.valueOf(r);
    char[] x = m.toCharArray();
    String a = "";
    for (int i = 0;i != x.length ; i++) {
      int temp = (int)x[i];
      BigInteger bm = BigInteger.valueOf(temp);
      BigInteger tmp = bm.modPow(br,bn);
      a = a+ tmp;
      a = a+";" ; 
    } // end of for
    
    return a;
  }

  // Ende Methoden
} // end of verschluesselung
