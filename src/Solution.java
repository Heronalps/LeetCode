import java.util.*;

public class Solution {

    public static void main(String[] args) {
        int[] src = {1,2,3,4,5,6,7,8,9};
        int[] dst = new int[9];
        test(3, 2, dst, src);
    }

    public static void test(int n, int blocksize, int[] dst, int[] src) {
        // write your code here
        for (int i = 0; i < n; i += blocksize) {
            System.out.println("i : " + i);
            for (int x = i; x < i + blocksize && x < n; x++) {
                System.out.println("x : " + x);
                for (int j = 0; j < n; j += blocksize) {
                    System.out.println("j : " + j);
                    for (int y = j; y < j + blocksize && y < n; y++) {
                        System.out.println("y : " + y);
                        dst[y + x * n] = src[x + y * n];
                    }
                }
            }
        }
    }
}