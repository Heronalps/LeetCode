import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

class MedianFinder {
    Queue<Double> minHeap;
    Queue<Double> maxHeap;
    /** initialize your data structure here. */
    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    }

    public void addNum(int num) {
        minHeap.offer((double) num);
        balance();
    }

    public double findMedian() {
        if (minHeap.size() < maxHeap.size()) {
            return maxHeap.peek();
        }
        return (minHeap.peek() + maxHeap.peek()) / 2.0;
    }

    private void balance() {
        maxHeap.offer(minHeap.poll());
        if (maxHeap.size() - minHeap.size() > 1) {
            minHeap.offer(maxHeap.poll());
        }
    }


    public static void main(String[] args) {
        MedianFinder finder = new MedianFinder();
        finder.addNum(1);
        finder.addNum(2);
        finder.findMedian();
        finder.addNum(3);
        System.out.println(finder.findMedian());
//        finder.addNum(-3);
//        finder.findMedian();
//        finder.addNum(-4);
//        finder.findMedian();
//        finder.addNum(-5);
//        finder.findMedian();
    }
}