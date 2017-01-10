import java.util.*;

public class Heap{
	public static void main(String[] args) {
		PriorityQueue<Integer> heap = new PriorityQueue<>(
			new Comparator<Integer> () {
				public int compare(Integer a, Integer b) {
					return -1 * a.compareTo(b);
				}
			});
		heap.add(2);
		heap.add(1);
		heap.add(5);
		heap.add(3);
		System.out.println(heap.peek());
	}
}