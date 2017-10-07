import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PermutationIndex {

    public static long permutationIndex(int[] A) {
        // write your code here
        long result = 1;
        if (A == null || A.length == 0){
            return result;
        }

        List<Integer> replica = new ArrayList();
        for (int i = 0; i < A.length; i++) {
            replica.add(A[i]);
        }
        Collections.sort(replica);

        int factorial = 1;
        for (int j = 1; j <= A.length; j++) {
            factorial *= j;
        }

        for (int k = A.length; k > 0; k--) {
            int startIndex = A.length - k;
            int foundIndex = indexFinder(replica, A[startIndex]);
            result += factorial / k * foundIndex;
            factorial /= k;
            replica.remove(foundIndex);
        }
        return result;
    }

    public static int indexFinder(List<Integer> array, int element) {

        for (int i = 0; i < array.size(); i++) {
            if (array.get(i) == element) {
                return i;
            }
        }
        return -1;
    }
}
