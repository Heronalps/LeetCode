/**
 * Created by michaelzhang on 9/26/16.
 */

public class Rational {

    private int num;
    private int denom;

    /**
     greatest common divisor of a and b
     @param a first number
     @param b second number
     @return gcd of a and b
     */
    public static int gcd(int a, int b) {
        if (a==0)
            return b;
        else if (b==0)
            return a;
        else
            return gcd(b%a, a);
    }

    public Rational(int num, int denom) {
        if (denom== 0) {
            throw new IllegalArgumentException("denominator may not be zero");
        }
        this.num = num;
        this.denom = denom;
        if (num != 0) {
            int gcd = Rational.gcd(num,denom);
            if (gcd < 0 && num < 0) { gcd = -gcd;} //In order to make negative sign on numerator

            this.num /= gcd;
            this.denom /= gcd;
        }
    }

    public Rational() {
        this.num = 1;
        this.denom = 1;
    }

    public String toString() {
        if (denom == 1 || num == 0)
        return num + "/" + denom;
            return "" + num;
    }

    public int getNumerator() { return this.num; }
    public int getDenominator() { return this.denom; }

    /**
     For testing getters.
     @param args unused
     */

    public static void main (String [] args) {
        Rational r = new Rational(-5,7);
        System.out.println("r.getNumerator()=" + r.getNumerator());
        System.out.println("r.getDenominator()=" + r.getDenominator());
        System.out.println("r = " + r.toString());
        System.out.println(gcd(5,-6));
    }

}
