import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
public class KClosest {
    /**
     * @param points a list of points
     * @param origin a point
     * @param k an integer
     * @return the k closest points
     */
    public Point[] kClosest(Point[] points, final Point origin, int k) {
        Point[] result = new Point[k];
        Queue<Point> heap = new PriorityQueue<>(1, new Comparator<Point>(){
            public int compare(Point a, Point b) {
                int delta = distance(origin, b) - distance(origin, a);
                //Max Heap
                if (delta != 0.0){
                    return delta;
                } else if (a.x != b.x) {
                    return b.x - a.x;
                }
                return b.y - a.y;
            }
        });
        for (int i = 0; i < points.length; i++) {
            heap.add(points[i]);
            if(heap.size() > k) {
                heap.poll();
            }
        }
        //result = heap.toArray(new Point[0]);
        for (int j = 0; j < k; j++) {
            result[k - j - 1] = heap.poll();
        }
        return result;
    }

    private static int distance(Point a, Point b) {
        return (int) (Math.pow((a.x - b.x), 2) + Math.pow((a.y - b.y), 2));
    }
}