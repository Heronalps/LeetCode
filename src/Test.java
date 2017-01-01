import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Created by michael.zhang on 8/11/2016.
 */
public class Test {

    public static int degreeCoeffsHighToLow(int [] coeffsHighToLow) {

        // start at the low end, where leading zeros might be,
        // and work our way down to the first non zero, and return
        // the length, minus that coefficient.
        // e.g. {0, 0, 0, 0, 10, 0, 20, 0, 30, 0 } => 5

        return 0;
    }

    public static String subsequencesAfter(String partialSubsequence, String word) {
        if (word.isEmpty()) {
            // base case
            return partialSubsequence;
        } else {
            // recursive step
            return subsequencesAfter(partialSubsequence, word.substring(1))
                    + ","
                    + subsequencesAfter(partialSubsequence + word.charAt(0), word.substring(1));
        }
    }

    public static void main(String[] args) {
        int counter = 0;
        counter += 1;
        System.out.println(counter);


    }

}
