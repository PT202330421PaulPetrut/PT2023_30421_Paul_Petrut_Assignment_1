import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
       // Polinome polinome = new Polinome();
        // Create two polynomials represented as HashMaps
   /*     HashMap<Integer, Float> poly1 = new HashMap<Integer, Float>();
        poly1.put(2, 2.0f);
        poly1.put(1, 3.0f);
        poly1.put(0, 1.0f);

        HashMap<Integer, Float> poly2 = new HashMap<Integer, Float>();
        poly2.put(3, 4.0f);
        poly2.put(2, 1.0f);
        poly2.put(1, -1.0f);
        poly2.put(0, 2.0f);

        // Call the addPolynomials method and print the result
        HashMap<Integer, Float> result = polinome.addPolynomials(poly1, poly2);
        System.out.println("Result of addition: " + result);

        // Call the subPolynomials method and print the result
        result = polinome.subPolynomials(poly1, poly2);
        System.out.println("Result of subtraction: " + result);
        */

/*        HashMap<Integer, Float> poly1 = new HashMap<>();
        poly1.put(2, 3.0f);
        //poly1.put(1, 4.0f);
        poly1.put(0, 5.0f);
        HashMap<Integer, Float> poly2 = new HashMap<>();

        Polinome polinome = new Polinome();


        HashMap<Integer, Float> result = polinome.derivate(poly1);
        boolean ceva = polinome.isZeroPolynomial(poly2);
        System.out.println(result);
        System.out.println(ceva);*/
            // create the two polynomials to divide
            Polinome polinome = new Polinome();
            HashMap<Integer, Float> dividend = new HashMap<>();
            HashMap<Integer, Float> divisor = new HashMap<>();
            dividend.put(3, 3.0f);
            dividend.put(2, -3.0f);
            dividend.put(1, 1.0f);
            dividend.put(0, -2.0f);

            divisor.put(2, 3.0f);
            divisor.put(1, 1.0f);
            divisor.put(0, -1.0f);

            // create the hashmaps for the quotient and remainder
            HashMap<Integer, Float> quotient = new HashMap<>();
            HashMap<Integer, Float> remainder = new HashMap<>();

            // perform the division
            boolean divZero= true;
            DivisionResult div = polinome.division(dividend, divisor);
            quotient = div.getCat();
            remainder = div.getRest();
            divZero = div.getDivZero();

            // print the results
            System.out.println("Dividend: " + dividend);
            System.out.println("Divisor: " + divisor);
            System.out.println("Quotient: " + quotient);
            System.out.println("Remainder: " + remainder);
            System.out.println("Divide by zero: " + divZero);


    }
}
