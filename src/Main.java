//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        RatNum tester = new RatNum(2,3);
        RatNum res = null;
        RatNum sting = new RatNum("1/4");
        System.out.println(sting.getNumerator());
        System.out.println(sting.getDenominator());

        res = tester.add(sting);
        System.out.println(res.toString());
        res = tester.sub(sting);
        System.out.println(res.toString());
        res = tester.mul(sting);
        System.out.println(res.toString());
        res = tester.div(sting);
        System.out.println(res.toString());

//        String strng = "a/2" ;
//        RatNum parsedNum = new RatNum(strng);
//        System.out.println(strng.toString());
        }
}
