package dd.javafunc;

import java.math.BigInteger;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// http://rosettacode.org/wiki/Pi#Java
// http://web.comlab.ox.ac.uk/people/jeremy.gibbons/publications/spigot.pdf
public class Ex12_PiDigits {
    final BigInteger TWO = BigInteger.valueOf(2) ;
    final BigInteger THREE = BigInteger.valueOf(3) ;
    final BigInteger FOUR = BigInteger.valueOf(4) ;
    final BigInteger SEVEN = BigInteger.valueOf(7) ;

    BigInteger q = BigInteger.ONE ;
    BigInteger r = BigInteger.ZERO ;
    BigInteger t = BigInteger.ONE ;
    BigInteger k = BigInteger.ONE ;
    BigInteger n = BigInteger.valueOf(3) ;
    BigInteger l = BigInteger.valueOf(3) ;

    private Integer nextDigit() {
        BigInteger nn, nr;
        Integer digit = null;
        while (digit == null) {
            if (FOUR.multiply(q).add(r).subtract(t).compareTo(n.multiply(t)) == -1) {
                digit = n.intValue();
                nr = BigInteger.TEN.multiply(r.subtract(n.multiply(t)));
                n = BigInteger.TEN.multiply(THREE.multiply(q).add(r)).divide(t).subtract(BigInteger.TEN.multiply(n));
                q = q.multiply(BigInteger.TEN);
                r = nr;
            } else {
                nr = TWO.multiply(q).add(r).multiply(l);
                nn = q.multiply((SEVEN.multiply(k))).add(TWO).add(r.multiply(l)).divide(t.multiply(l));
                q = q.multiply(k);
                t = t.multiply(l);
                l = l.add(TWO);
                k = k.add(BigInteger.ONE);
                n = nn;
                r = nr;
            }
        }
        return digit;
    }

    public Stream<Integer> calcPiDigits() {
        return Stream.generate(this::nextDigit);
    }

    public static void main(String[] args) {
        Ex12_PiDigits p = new Ex12_PiDigits() ;

        //1.0 zliczmy wystąpienia każdej cyfry w pierwszych 5000 cyfrach liczby PI
    }
}
