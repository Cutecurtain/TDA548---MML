package assignments.basics;

import static java.lang.System.*;

/*
 * Exercising methods with primitive types
 */
public class Methods {

    public static void main(String[] args) {
        new Methods().program();
    }


    void program() {
        // Testing the methods.
        // All output should print "true" (comment/uncomment as needed)

        out.println(sign(-100) == -1);
        out.println(sign(0) == 0);
        out.println(sign(14) == 1);

        out.println(factorial(0) == 1);
        out.println(factorial(1) == 1);
        out.println(factorial(2) == 2); // = 2
        out.println(factorial(3) == 6); // = 6

        out.println(gcd(24, 8) == 8);
        out.println(gcd(7, 2) == 1);
    }

    // ------------- Write your methods below this line --------------------

    // sign, factorial and gcd

    int sign(int a) {
        //Returns -1 if a < 100, 0 if a equals 0 and 1 if a > 0
        if (a < 0) return -1;
        else if (a > 0) return 1;
        else return 0;
    }

    int factorial(int a) {
        //Returns the factorial a
        int b = 1;
        for (int i = 1; i <= a; i++)
            b *= i;
        return b;
    }

    int gcd(int a, int b) {
        //Returns greatest common divider of a and b, following https://en.wikipedia.org/wiki/Euclidean_algorithm
        while (a != b) {
            if (a > b)
                a -= b;
            else b -= a;
        }
//        while (a != b && (a > b ? (a = a - b) : (b = a - b))!= 0);
        return a;
    }

}
