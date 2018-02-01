/**
  *
  * Beschreibung
  *
  * @version 1.0 vom 15.01.2018
  * @author 
  */
import java.math.*;
public class entschluesselung {
  
  // Anfang Attribute
  private int m;
  private int d;
  private int x;
  // Ende Attribute
  
  public entschluesselung() {
    this.x = 0;
    this.d = 0;
    this.m = 0;
  }

  // Anfang Methoden

  public String ent(int d, int n, String m) {
    BigInteger bd = BigInteger.valueOf(d);
    BigInteger bn = BigInteger.valueOf(n);
    String [] t = m.split(";"); 
    String a = "";
    for (int i = 0;i != t.length ; i++) {
      int temp = Integer.parseInt(t[i]);
      BigInteger bm = BigInteger.valueOf(temp);
      BigInteger tmp = bm.modPow(bd,bn);
      a = a+ String.valueOf((char)tmp.intValue());
    } // end of for
    
    return a;
  }

  // Ende Methoden
} // end of entschluesselung
