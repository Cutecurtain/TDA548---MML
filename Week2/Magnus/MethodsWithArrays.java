package assignments.basics;

import java.util.Arrays;

import static java.lang.System.*;

/**
 * Exercising methods with array parameters (using only integer arrays)
 */
public class MethodsWithArrays {

    public static void main(String[] args) {
        new MethodsWithArrays().program();
    }


    void program() {
        int[] arr = {1, 4, 3, 8, 4, 9, 2, -1};
        out.println(Arrays.toString(arr));  // Use Arrays.toString() to get a nice print out
        // Testing the methods.
        // All output should print "true" (uncomment as needed)
        out.println(sumArray(arr) == 30);
        out.println(maxIndex(arr) == 5);
        out.println(countN(arr, 4) == 2);
    }

    // ------------- Write methods below this line --------------------
    int sumArray(int[] arr) {
        int sum = 0;
        for (int i : arr)
            sum += i;
        return sum;
    }

    int maxIndex(int[] arr) {
        //Returns the index of the greatest value in an integer array
        int index = 0;
        for (int i = 1; i < arr.length; i++)
            if (arr[i] > arr[index])
                index = i;
        return index;
    }

    int countN(int[] arr, int n) {
        //Returns the number of occurrences of "n" in array "arr"
        int num = 0;
        for (int i : arr)
            if (i == n)
                num++;
        return num;
    }
    // sumArr, maxIndex and countN

}
