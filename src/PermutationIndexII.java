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
}
