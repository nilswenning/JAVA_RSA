/**
  *
  * Beschreibung
  *
  * @version 1.0 vom 15.01.2018
  * @author 
  */
  import java.math.BigInteger;
import java.security.SecureRandom;

public class eea {
  
  // Anfang Attribute
  private int p;
  private int q;
  private int r;
  private static final BigInteger ZERO = BigInteger.valueOf(0);

    private static final BigInteger ONE = BigInteger.valueOf(1);

    private static final BigInteger TWO = BigInteger.valueOf(2);
  // Ende Attribute
  
  public eea() {
    this.r = 0;
    this.q = 0;
    this.p = 0;
  }

  // Anfang Methoden
    public static int extGCD(int a, int b)
    {
        BigInteger ba = BigInteger.valueOf(a);
        BigInteger bb = BigInteger.valueOf(b);
        BigInteger[] bresult = extgcd(ba, bb);
        int[] result = new int[3];
        int temp = 0;

        result[1] = bresult[1].intValue();
 
        return result[1];
    }
    public static BigInteger[] extgcd(BigInteger a, BigInteger b)
    {
        BigInteger u = ONE;
        BigInteger v = ZERO;
        BigInteger d = a;
        if (b.signum() != 0)
        {
            BigInteger v1 = ZERO;
            BigInteger v3 = b;
            while (v3.signum() != 0)
            {
                BigInteger[] tmp = d.divideAndRemainder(v3);
                BigInteger q = tmp[0];
                BigInteger t3 = tmp[1];
                BigInteger t1 = u.subtract(q.multiply(v1));
                u = v1;
                d = v3;
                v1 = t1;
                v3 = t3;
            }
            v = d.subtract(a.multiply(u)).divide(b);
        }
        return new BigInteger[]{d, u, v};
    }
  // Ende Methoden
} // end of eea
