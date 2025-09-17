import java.lang.Math;
/**
 * A RatNum specifies a Rational number in the form numerator/denominator
 * @author Edvin Hågård
 */
public class RatNum {
    //Attributes
    /**
     Numerator - Täljare
     */
    private int num;
    /**
     Denominator - Nämnare
     */
    private int denom;

    //Methods
    /**
     *Returns the Greatest Common Divisor of two elements
     * @param m element 1
     * @param n element 2
     */
    static int gcd(int m, int n){

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
    /**
     *  Returns the numerator of this Ratnum
     */
    public int getNumerator(){
        return this.num;
    }
    /**
     * Returns the denominator of this RatNum
     */
    public int getDenominator(){
        return this.denom;
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
        return this.num == p.num && this.denom == p.denom;
    }

    /**
     * Checks if this RatNum is less RatNum r
     * @param r - the RatNum being compared to this one
     * @return True if RatNum r is greater than this one, otherwise returns false
     */
    public boolean lessThan(RatNum r){
        if(Math.multiplyExact(this.num,r.denom)<Math.multiplyExact(r.num,this.denom))
        {return true;}
        else{return false;}
    }

    /**
     * Adds RatNum r to this one
     * @param r - the RatNum added to this one.
     * @return the summation of the two RatNum.
     */
    public RatNum add(RatNum r){
        int a = Math.multiplyExact(this.num,r.denom)+Math.multiplyExact(r.num,this.denom);
        int b = Math.multiplyExact(this.denom,r.denom);
        return new RatNum(a, b);
    }

    /**
     * Subtracts RatNum r from this one
     * @param r - the RatNum subtracted.
     * @return the difference.
     */
    public RatNum sub(RatNum r){
        return new RatNum(  Math.multiplyExact(this.num,r.denom) - Math.multiplyExact(r.num,this.denom), Math.multiplyExact(this.denom,r.denom));
    }

    /**
     * Multiplies this one with Ratnum r
     * @param r - the RatNum multiplied
     * @return the product.
     */
    public RatNum mul(RatNum r){
        return new RatNum(Math.multiplyExact(this.num,r.num),Math.multiplyExact(this.denom,r.denom));
    }

    /**
     * Divides the active rational number with the r
     * @param r a rational number
     * @return a rational number
     */
    public RatNum div(RatNum r){
        return new RatNum(Math.multiplyExact(this.num,r.denom), Math.multiplyExact(this.denom,r.num));
    }

    /**
     * Rounds down the active rational number to an integer and returns it as a String
     * @return a string representation of an integer
     */
    public String toIntString(){
        Integer a = this.num/this.denom;
        return String.valueOf(a);
    }

    //Constructors
    /**
     * Constructs a new RatNum whose specified as 0/1
     */
    public RatNum(){
        num = 0;
        denom = 1;
    }
    /**
     * Constructs a new RatNum whose specified as a/1
     * @param a the specified numerator
    */
    public RatNum(int a){
        num = a;
        denom = 1;
    }
    /**
     * Constructs a new RatNum whose specified as a/b
     * @param a the specified numerator
     * @param b the specified denominator
     */
    public RatNum(int a, int b){
        if(b == 0){
            throw new NumberFormatException("Denominator = 0");
        }
        else if(b < 0){
            num = -a/gcd(a,b);
            denom = -b/gcd(a,b);
        }else {
            num = a/gcd(a,b);
            denom = b/gcd(a,b);
        }
    }
    /**
     * Constructs a new RatNum, initialized to match the values of the specified RatNum
     * @param r the RatNum from which to copy initial values to a newly constructed RatNum
    */
    public RatNum(RatNum r){
        num = r.getNumerator();
        denom = r.getDenominator();

    }

    /**
     * Constructs a new RatNum from a string
     * @param s is a string with the form of "a/b", where a and b are both integers
     * @throws NumberFormatException - if the string does not contain a parsable rational number
     */
    public RatNum(String s){
         num = RatNum.parse(s).getNumerator();
         denom = RatNum.parse(s).getDenominator();
    }

}

