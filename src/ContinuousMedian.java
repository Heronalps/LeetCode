import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.TreeMap;

/**
 * Created by michaelzhang on 3/9/17.
 */
public class ContinuousMedian {
    public static double[] findMedian(int[] array) {
        double[] answer = new double[array.length];
        PriorityQueue<Integer> lowers = new PriorityQueue<>(1, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        }
        );
        PriorityQueue<Integer> highers = new PriorityQueue<>();
        for (int i = 0; i < answer.length; i++) {
            addNumber(array[i], lowers, highers);
            rebalance(lowers, highers);
            answer[i] = getMedian(lowers, highers);
        }
        return answer;
    }

    public static void addNumber(int number, PriorityQueue<Integer> lowers, PriorityQueue<Integer> highers) {
        if(lowers.size() == 0 || number < lowers.peek()) {
            lowers.add(number);
        } else {
            highers.add(number);
        }
    }

    public static void rebalance(PriorityQueue<Integer> lowers, PriorityQueue<Integer> highers) {
        PriorityQueue<Integer> biggerHeap = lowers.size() > highers.size() ? lowers : highers;
        PriorityQueue<Integer> smallerHeap = lowers.size() > highers.size() ? highers : lowers;
        if (biggerHeap.size() - smallerHeap.size() >= 2) {
            smallerHeap.add(biggerHeap.poll());
        }
    }

    public static double getMedian(PriorityQueue<Integer> lowers, PriorityQueue<Integer> highers) {
        PriorityQueue<Integer> biggerHeap = lowers.size() > highers.size() ? lowers : highers;
        PriorityQueue<Integer> smallerHeap = lowers.size() > highers.size() ? highers : lowers;
        if (biggerHeap.size() == smallerHeap.size()) {
            return (double) (biggerHeap.peek() + smallerHeap.peek()) / 2;
        } else {
            return (double) biggerHeap.peek();
        }
    }

    public static void main(String[] args) {
        int[] array = {1,2,3,4,5};
        System.out.println(findMedian(array));
    }
}


