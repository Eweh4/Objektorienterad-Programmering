//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        RatNum tester = new RatNum(10,8);
        System.out.printf(tester.toString());

        String strng = "a/2" ;
        RatNum parsedNum = new RatNum(strng);
        System.out.println(strng.toString());
        }
}
