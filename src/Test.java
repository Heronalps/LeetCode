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

        int degree = coeffsHighToLow.length - 1;
        for (int i=0; i<coeffsHighToLow.length; i++) {
            if (coeffsHighToLow[i]!=0) {
                return degree;
            }
            degree--;
        }
        return 0;
    }
    public static void main(String[] args) {

        System.out.println(degreeCoeffsHighToLow(new int[] {0, 0, 0, 0, 10, 0, 20, 0, 30, 0 }));
    }

}
