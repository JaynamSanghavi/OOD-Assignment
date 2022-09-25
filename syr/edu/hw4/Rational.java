package syr.edu.hw4;

/* Adapted from Programming in Scala, Odersky */
public class Rational {
    private int numer;
    private int denom;
    private int g;
    private static final int ONE_CONSTANT = 1;
    private static final int NEGATIVE_ONE_CONSTANT = -1;

    /*
     * Find the gcd between n and d and set numer, denom and g.
     * Param: int, int
     * 
     */

    public Rational(int n, int d) {
        if(d == 0){
            throw new ArithmeticException("Denominator cant be 0");
        }
        g = gcd(n, d);
        if(n>0 || d >0){
            this.numer = (n/g);
            this.denom = (d/g);
        }else{
            this.numer = (n * NEGATIVE_ONE_CONSTANT)/g;
            this.denom = (d * NEGATIVE_ONE_CONSTANT)/g;
        }
    }

    public Rational(int n) {
        this(n,ONE_CONSTANT);
    }

    /*
     * Display in format n/d
     * Param: none
     * Return: String  
     * 
     */

    @Override
    public String toString() {
        return this.numer + "/" + this.denom;
    }

    /*
     * Greatest common divisor between the 2 number
     * Param: int,int
     * Return: int
     * 
     */

    private int gcd(int n1,int n2){
        if (n2 == 0) {
            return n1;
        }
        return gcd(n2, n1 % n2);
    }

    /*
     * Calculated the numerator with LCM
     * Formula: (numerator* (lcm/denominator))
     * Param: int, int, int
     * Return: int
     */

    private int calculateNumberWithLCM(int numer,int lcm, int denom){
        return (numer *(lcm/denom));
    }

    /*
     * Add 2 rational number and return new rational number
     * Param: Rational
     * Return: Rational
     */

    public Rational add(Rational that) {
        if(this.denom == that.denom){
            return new Rational((this.numer + that.numer),this.denom);
        }
        int lcm = (this.denom * that.denom)/gcd(this.denom,that.denom);
        return new Rational((calculateNumberWithLCM(this.numer, lcm, this.denom) + calculateNumberWithLCM(that.numer,lcm,that.denom)), lcm);
    }

    /*
     * Add 1 rational number with an integer and return new rational number
     * Param: int
     * Return: Rational
     */

    public Rational add(int that) {
        return add(new Rational(that));
    }

    /*
     * Compare if calling rational number is less then called rational number
     * Param: Rational
     * Return: boolean
     */

    public boolean lessThan(Rational that) {
        if(this.denom == that.denom){
            return (this.numer < that.numer);
        }
        int lcm = (this.denom * that.denom)/gcd(this.denom,that.denom);
        return (calculateNumberWithLCM(this.numer, lcm, this.denom) < calculateNumberWithLCM(that.numer,lcm,that.denom));
    }

    /*
     * Compare if calling rational number is less then called integer number
     * Param: int
     * Return: boolean
     */

    public boolean lessThan(int that) {
        return lessThan(new Rational(that));
    }

    /*
     * Return the max rational number between the called and calling.
     * Param: Rational
     * Return: Rational
     */

    public Rational max(Rational that) {
        return (this.lessThan(that)) ? that : this;
    }

    /*
     * Return the max rational number between the called and calling.
     * Param: int
     * Return: Rational
     */

    public Rational max(int that) {
        return new Rational(that);
    }

    public static void main(String[] args) {
        Rational half = new Rational(2, 4);
        Rational third = new Rational(1, 3);
        System.out.println(half.max(third)); // returns half; prints "1/2"
        System.out.println(third.max(half)); // returns half; prints "1/2"
        Rational result = half.add(third);
        Rational fiveSixths = new Rational(5, 6);
        System.out.println("are they the same object? " + (result == fiveSixths));
        System.out.println(fiveSixths.lessThan(result)); // false
        System.out.println(result.lessThan(fiveSixths)); // false
        Rational one = new Rational(1);
        Rational oneAndHalf = one.add(half);
        System.out.println(oneAndHalf); // prints "3/2";
        Rational fifteenOverTen = new Rational(15, 10);
        System.out.println(fifteenOverTen); // prints "3/2"

        Rational r = new Rational(7,-7);
        System.out.println(r);
        System.out.println(r.add(1));
    }
}
