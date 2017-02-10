/**
 * Created by michaelzhang on 2/9/17.
 */
public class QuickSort {
    public static void sortIntegers2(int[] A) {
        //Sanity Check
        if (A == null || A.length == 0) {
            return;
        }
        quickSort(A, 0, A.length - 1);
    }
    public static void quickSort(int[] A, int start, int end) {
        //Base case to do
        if (start >= end) {
            return;
        }
        int index = partition(A, start, end);
        quickSort(A, start, index - 1);
        quickSort(A, index, end);
    }
    public static int partition(int[] A, int start, int end) {
        int left = start, right = end;
        int pivot = A[(start + end) / 2];
        while (left <= right) {
            while(A[left] < pivot) {
                left++;
            }
            while(A[right] > pivot) {
                right--;
            }
            if (left <= right) {
                int tmp = A[left];
                A[left] = A[right];
                A[right] = tmp;
                left++;
                right--;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] A = {3,2,1,4,5};
        sortIntegers2(A);
        for (int n : A){
            System.out.println(n);
        }
    }
}
