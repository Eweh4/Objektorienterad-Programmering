import java.lang.Math;
import java.math.BigInteger;

/**
 * A RatNum specifies a Rational number in the form numerator/denominator
 * @author Edvin Hågård
 */
public class RatNum {
    //Attributes
    /**
     Numerator - Täljare
     */
    private BigInteger num;
    /**
     Denominator - Nämnare
     */
    private BigInteger denom;

    //Methods
    /*
    /**
     *Returns the Greatest Common Divisor of two elements
     * @param m element 1
     * @param n element 2
     */
    /* static int gcd(int m, int n){

        if(m == 0 && n == 0){
            throw new IllegalArgumentException();
        }
        int i;
        if (m < n){
            if( n < 0){
                i = -n;
            }else {
                i = n;
            }
        }
        else {
            if( m < 0){
                i = -m;
            }else {
                i = m;
            }
        }

        for (; i > 1; i--) {
            if (m % i == 0 && n % i == 0){
                return i;
            }
        }
        return 1;
    }

     */
    /**
     *  Returns the numerator of this Ratnum
     * @return Returns numerator as an int
     */
    public int getNumerator(){
        return this.num.intValue();
    }
    /**
     * Returns the denominator of this RatNum
     * @return Returns denominator as an int
     */
    public int getDenominator(){
        return this.denom.intValue();
    }
    /**
     * Converts RatNum object as a string
     * @return Returns numerator/denominator as a string
     */
    public String toString(){
        return this.num + "/" + this.denom;
    }

    /**
     * Parses the string argument as a rational number.
     * @param s - a String containing the rational number representation to be parsed
     * @return the RatNum value represented by the argument
     */
    static RatNum parse(String s) {

        String[] a;
        if (s.contains("/")) {
            //s.split("/");
            String regex = "/";
            a = s.split(regex);
            if (a.length == 1){
                throw  new NumberFormatException();
            }
            return new RatNum(Integer.parseInt(a[0]), Integer.parseInt(a[1]));
        }
        else {
            return new RatNum(Integer.parseInt(s));
        }
    }

    /**
     * Indicates whether some other object is equal to this one
     * @param r   the reference object with which to compare.
     * @return true if this object is the same as the obj argument; false otherwise.
     */
    public boolean equals(Object r){
        if(r == null) { return false;}
        if(r.getClass() != this.getClass()){ return false;}
        RatNum p = (RatNum) r;
        return this.num.equals(p.num) && this.denom.equals(p.denom);
    }

    /**
     * Checks if this RatNum is less RatNum r
     * @param r - the RatNum being compared to this one
     * @return True if RatNum r is greater than this one, otherwise returns false
     */
    public boolean lessThan(RatNum r){
        return (this.num.multiply(r.denom)).compareTo(r.num.multiply(this.denom)) < 0;
    }

    /**
     * Adds RatNum r to this one
     * @param r - the RatNum added to this one.
     * @return the summation of the two RatNum.
     */
    public RatNum add(RatNum r){
        BigInteger a = (this.num.multiply(r.denom)).add(r.num.multiply(this.denom));
        BigInteger b = this.denom.multiply(r.denom);
        return new RatNum(a, b);
    }

    /**
     * Subtracts RatNum r from this one
     * @param r - the RatNum subtracted.
     * @return the difference.
     */
    public RatNum sub(RatNum r){
        BigInteger a = this.num.multiply(r.denom).subtract(r.num.multiply(this.denom));
        BigInteger b = this.denom.multiply(r.denom);
        return new RatNum(a, b);
    }

    /**
     * Multiplies this one with Ratnum r
     * @param r - the RatNum multiplied
     * @return the product.
     */
    public RatNum mul(RatNum r){
        BigInteger a = this.num.multiply(r.num);
        BigInteger b = this.denom.multiply(r.denom);
        return new RatNum(a,b);
    }

    /**
     * Divides the active rational number with the r
     * @param r a rational number
     * @return a rational number
     */
    public RatNum div(RatNum r){
        BigInteger a = this.num.multiply(r.denom);
        BigInteger b = this.denom.multiply(r.num);
        return new RatNum(a,b);
    }

    /**
     * Multiplies a RatNum a number of times equal to the exponent
     * @param k - the exponent
     * @return a RatNum
     */
    public RatNum pow(int k) {
        if(k<0){
            throw new NumberFormatException();
        }
        if(k == 0){
            return new RatNum(1,1);
        }

        BigInteger num = this.num;
        BigInteger denom = this.denom;

        for (int i = 0; i < k-1; i++) {
            num = this.num.multiply(num);
            denom = this.num.multiply(denom);
        }
        return new RatNum(num,denom);
    }

    /**
     * Rounds down the active rational number to an integer and returns it as a String
     * @return a string representation of an integer
     */
    public String toIntString(){
        Integer a = this.num.intValue()/this.denom.intValue();
        return String.valueOf(a);
    }

    //Constructors
    /**
     * Constructs a new RatNum whose specified as 0/1
     */
    public RatNum(){
        this(BigInteger.valueOf(0),
             BigInteger.valueOf(1));
    }
    /**
     * Constructs a new RatNum whose specified as a/1
     * @param a the specified numerator
    */
    public RatNum(int a){
        this(BigInteger.valueOf(a),
             BigInteger.valueOf(1));

    }
    /**
     * Constructs a new RatNum whose specified as a/b
     * @param a the specified numerator
     * @param b the specified denominator
     */
    public RatNum(int a, int b){
        this(BigInteger.valueOf(a),
             BigInteger.valueOf(b));
    }
    /**
     * Constructs a new RatNum, initialized to match the values of the specified RatNum
     * @param r the RatNum from which to copy initial values to a newly constructed RatNum
    */
    public RatNum(RatNum r){
        num = BigInteger.valueOf(r.getNumerator());
        denom = BigInteger.valueOf(r.getDenominator());


    }
    /**
     * Constructs a new RatNum from a string
     * @param s is a string with the form of "a/b", where a and b are both integers
     * @throws NumberFormatException - if the string does not contain a parsable rational number
     */
    public RatNum(String s){
         num = RatNum.parse(s).num;
         denom = RatNum.parse(s).denom;
    }

    private RatNum(BigInteger a,BigInteger b){
        if(b.compareTo(BigInteger.valueOf(0)) == 0){
            throw new NumberFormatException("Denomintor = 0");
        }else if(b.compareTo(BigInteger.valueOf(0)) < 0){
            num = (a.negate()).divide(a.gcd(b));
            denom = (b.negate()).divide(a.gcd(b));
        }else {
            num = a.divide(a.gcd(b));
            denom = b.divide(a.gcd(b));
        }
    }
}

