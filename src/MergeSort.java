/**
 * Created by michaelzhang on 2/9/17.
 */
public class MergeSort {
    public void sortIntegers(int[] A) {
        //Sanity check
        if (A == null || A.length == 0) {
            return;
        }
        int[] temp = new int[A.length];
        mergeSort(A, 0, A.length - 1, temp);
    }

    public static void mergeSort(int[] A, int start, int end, int[] temp) {
        //Base Case
        if (start >= end) {
            return;
        }
        mergeSort(A, start, (start + end) / 2, temp);
        mergeSort(A, (start + end) / 2 + 1, end, temp);
        merge(A, start, end, temp);
    }

    public static void merge(int[] A, int start, int end, int[] temp) {
        int mid = (start + end) / 2;
        int index = start;
        int leftIndex = start;
        int rightIndex = mid + 1;
        while(leftIndex <= mid && rightIndex <= end) {
            if (A[leftIndex] <= A[rightIndex]) {
                temp[index++] = A[leftIndex++];
            } else {
                temp[index++] = A[rightIndex++];
            }
        }
        System.arraycopy(A, leftIndex, temp, index, mid - leftIndex + 1);
        System.arraycopy(A, rightIndex, temp, index, end - rightIndex + 1);
        System.arraycopy(temp, start, A, start, end - start + 1);
    }
}
