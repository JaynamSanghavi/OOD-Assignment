/*
 * Using FIFO Cache Replacement Algorithm
 * 
 */
package syr.edu.hw5;

import java.util.List;
import java.util.ArrayList;

public class Rational {
    private int numer;
    private int denom;
    private List<Integer> g;
    public static Rational[] cache;
    public static int counter;
    private static final int ONE_CONSTANT = 1;
    private static final int NEGATIVE_ONE_CONSTANT = -1;
    private static final int CACHE_SIZE = 2;

    /*
     * Initializing cache and counter
     */
    static{
        counter = 0;
        cache = new Rational[CACHE_SIZE];
    }
    Rational(int n, int d,int g) {
        //cache = new Rational[5];
        this.g = new ArrayList<>();
        if (d == 0) {
            throw new IllegalArgumentException("Denominator can't be 0!");
        }
        this.g.add(g);
        this.numer = n;
        this.denom = d;
    }

    Rational(int n) {
        this(n, ONE_CONSTANT,ONE_CONSTANT);
    }

    /*
     * Add gcd in the list
     * Param: int
     * Return: void
     */

    public void addGCDInList(int g){
        this.g.add(g);
    }

    /*
     * Check in cache, if same numerator and denominator are same then return that object
     * Param: int, int
     * Return: Rational
     */

    public static Rational getInstance(int n,int d){
        int gcd = 0;
        if(n<0 && d <0){
            n = (n * NEGATIVE_ONE_CONSTANT);
            d = (d * NEGATIVE_ONE_CONSTANT);
        }
        if (d == 0) {
            throw new IllegalArgumentException("Denominator can't be 0!");
        }
        gcd = Rational.gcd(n, d);
        n = n/gcd;
        d = d/gcd;
        for (int z=0;z<cache.length;z++){
            Rational rational = cache[z];
            if(rational != null){
                if(rational.numer == n && rational.denom == d){
                    if(!rational.g.contains(gcd))
                        rational.addGCDInList(gcd);
                    return rational;
                }
            }
        }
        Rational r = new Rational(n,d,gcd);
        cache[(counter++)%CACHE_SIZE] = r;
        return r;
    }

    /*
     * Check in cache, if same numerator and denominator are same then return that object
     * Param: int
     * Return: Rational
     */
    public static Rational getInstance(int n){
        return Rational.getInstance(n,ONE_CONSTANT);
    }

    /*
     * Calculate gcd of n and d
     * Param: int, int
     * Return: int
     */

    private static int gcd(int n, int d) {
        return d==0 ? n : gcd(d, n%d);
    }

    private static void printCache(){
        for (Rational rational : cache) {
            System.out.println(rational + "--");
        }
    }

    @Override
    public String toString() {
        return denom==1 ? numer +"" : numer + "/" + denom;
    }

    /*
     * Adding 2 rational number
     * Param: Rational
     * Return: Rational
     */

    public Rational add(Rational that) {
        return Rational.getInstance(numer * that.denom + denom * that.numer, denom * that.denom);
    }

    /*
     * Adding a integer to rational number
     * Param: int
     * Return: Rational
     */

    public Rational add(int that) {
        return add(Rational.getInstance(that));
    }

    /*
     * Comparing 2 rational number, if calling one is less then called then true else false
     * Param: Rational
     * Return: Boolean
     */

    public boolean lessThan(Rational that) {
        return this.numer * that.denom < that.numer * this.denom;
    }

    /*
     * Comparing integer and rational number, if calling one is less then called then true else false
     * Param: int
     * Return: Boolean
     */

    public boolean lessThan(int that) {
        return lessThan(Rational.getInstance(that));
    }

    /*
     * Maximum of 2 rational number
     * Param: Rational
     * Return: Rational
     */

    public Rational max(Rational that) {
        return this.lessThan(that) ? that : this;
    }

    /*
     * Maximum of integer and rational number
     * Param: int
     * Return: Rational
     */

    public Rational max(int that) {
        return max(Rational.getInstance(that));
    }

    public static void main(String[] args) {
        Rational half = Rational.getInstance(1, 2);
        //printCache();
        // Rational half1 = Rational.getInstance(1, 2);
        // printCache();
        // System.out.println(half == half1);
        // Rational half3 = Rational.getInstance(1, 3);
        // printCache();
        // Rational half4 = Rational.getInstance(1, 5);
        // printCache();
        // Rational ha = Rational.getInstance(1,6);
        // printCache();
        // Rational ar = Rational.getInstance(5,5);
        // printCache();
        // Rational er = Rational.getInstance(1,10);
        // printCache();
        // Rational er1 = Rational.getInstance(1);
        // printCache();
        Rational third = Rational.getInstance(1, 3);
        //printCache();
        System.out.println(half.max(third)); // returns half; prints "1/2"
        System.out.println(third.max(half)); // returns half; prints "1/2"
        Rational result = half.add(third);
        //printCache();
        Rational fiveSixths = Rational.getInstance(5, 6);
        //printCache();
        System.out.println("are they the same object? " + (result == fiveSixths));
        System.out.println(fiveSixths.lessThan(result)); // false
        System.out.println(result.lessThan(fiveSixths)); // false
        Rational one = Rational.getInstance(1);
        Rational oneAndHalf = one.add(half);
        System.out.println(oneAndHalf); // prints "3/2";
        Rational fifteenOverTen = Rational.getInstance(15, 10);
        System.out.println(fifteenOverTen); // prints "3/2"
        Rational negHalf = Rational.getInstance(-1, -2);
        Rational negHalf1 = Rational.getInstance(-1, -3);
        //printCache();
    }
}
