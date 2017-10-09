import java.util.HashMap;
import java.util.Map;

public class PermutationIndexII {

    public long permutationIndexII(int[] A) {
        // write your code here

        long result = 1;
        double factorial = 1.0;
        int max = Integer.MIN_VALUE;
        for (int aA : A) {
            if (aA > max) {
                max = aA;
            }
        }
        for (int i = A.length - 1; i >= 0; i--) {
            int rank = 0;
            int[] visited = new int[max + 1];
            visited[A[i]]++;
            for (int j = i + 1; j < A.length; j++) {
                visited[A[j]]++;
                if (A[i] > A[j]) {
                    rank++;
                }
            }
            double temp = factorial;
            for (int repeat : visited) {
                if (repeat != 0) {
                    int fac = 1;
                    while (repeat != 1){
                        fac *= repeat;
                        repeat--;
                    }
                    temp /= fac;
                    //System.out.println("temp1 : " + temp);
                }
            }
            System.out.println("rank : " + rank);
            System.out.println("Factorial : " + factorial);
            System.out.println("temp : " + temp);
            result += temp * rank;
            factorial *= A.length - i;
        }
        return result;
    }

    public long permutationIndexII2(int[] A) {
        // write your code here
        // Version of hashmap

        long result = 1, factorial = 1;
        int multifact = 1;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = A.length - 1; i >= 0; i-- ) {
            if (map.containsKey(A[i])) {
                map.put(A[i], map.get(A[i]) + 1);
                multifact *= map.get(A[i]);
            }
            else {
                map.put(A[i], 1);
            }
            int rank = 0;
            for (int j = i + 1; j < A.length ; j++) {
                if (A[i] > A[j]) {
                    rank++;
                }
            }
            result += factorial * rank / multifact;
            factorial *= (A.length - i);
        }
        return result;
    }
}
