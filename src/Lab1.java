public class Lab1 {

    public static void main(String[] args) {

        // rader som denna är kommentarer

        // vi deklarar en array som heter a
        int[] a = { 21, 19, 3,  15, 53, 33, 239, 233, 14, 97,
                9,  8,  45, 35, 73, 55, 731,  81, 51, 49 };

        // skriver ut en hälsning och sedan element 1 av array a (dvs värdet 19)
        System.out.println("Hello!");
        System.out.println(a[1]);

        // lösning för del 1
        System.out.println("Del 1:");
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }


        // lösning för del 2
        System.out.println("Del 2:");
        // din kod här
        int k =a[0];
        for (int j = 0; j < 20; j++) {
            if(k < a[j]){
                k = a[j];
            }
        }
        System.out.println(k);
        // lösning för del 3
        System.out.println("Del 3:");
        // din kod här
        int m = 0;
        for (int l = 0; l < 20; l++) {
            if (a[l] % 2 == 0) {
                m += a[l];
            }
        }
        System.out.println(m);
        for (int n = 0; n < 20; n++) {
            if (a[n] > m){
                System.out.println(a[n]);
            }
        }
        // frivilligt: lösning för del 4
        System.out.println("Del 4:");
        // din kod här

    }

}