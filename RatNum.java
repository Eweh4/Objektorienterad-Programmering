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
        return num;
    }
    /**
     * Returns the denominator of this RatNum
     */
    public int getDenominator(){
        return denom;
    }
    /**
     * Converts RatNum object as a string
     * @return Returns numerator/denominator as a string
     */
    public String toString(){
        return this.num + "/" + this.denom;
    }
    /*static RatNum parse(String s){
        return ;
    }*/


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
     * @param a - the specified numerator
    */
    public RatNum(int a){
        num = a;
        denom = 1;
    }
    /**
     * Constructs a new RatNum whose specified as a/b
     * @param a - the specified numerator
     * @param b - the specified denominator
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
     * @param r - the RatNum from which to copy initial values to a newly constructed RatNum
    */
    public RatNum(RatNum r){
        num = r.getNumerator();
        denom = r.getDenominator();
    }

}

