import java.util.ArrayList;
import java.util.List;

public class IntervalSort {

    static class Interval
    {
        Interval(Integer start, Integer end)
        {
            this.start = start;
            this.end = end;
        }

        @Override
        public String toString()
        {
            return "[" + this.start + ", " + this.end + "]";
        }

        Integer start;
        Integer end;
    }

    /**
     * Given K sorted list of intervals, return the merged sorted list.
     *
     * eg.
     * list 1: [1, 2], [7,8]
     * list 2: [4, 5], [9, 11], [12, 15], [25, 27]
     *
     * result: [1,2] [4,5] [7, 8] [9, 11] [12, 15] [25, 27]
     *
     */
    static List<Interval> mergeSortedIntervals(List<List<Interval>> sortedIntervals) {
        List<Interval> result = new ArrayList<>();
        int k = sortedIntervals.size();
        int[] indexArray = new int[k];
        Interval next = new Interval(0, 0);

        while(next.start != Integer.MAX_VALUE){
            next = new Interval(Integer.MAX_VALUE, Integer.MAX_VALUE);
            int nextIndex = 0;
            for (int i = 0; i < k; i++) {
                if (indexArray[i] >= sortedIntervals.get(i).size()) {
                    continue;
                }
                if (sortedIntervals.get(i).get(indexArray[i]).start < next.start) {
                    next = sortedIntervals.get(i).get(indexArray[i]);
                    nextIndex = i;
                }
            }
            if (next.start != Integer.MAX_VALUE) {
                result.add(next);
                indexArray[nextIndex]++;
            }
        }
        return result;
    }

    public static void main(String[] args)
    {
        List<Interval> i1 = new ArrayList<>();
        i1.add(new Interval(1, 2));
        i1.add(new Interval(7, 8));

        List<Interval> i2 = new ArrayList<>();
        i2.add(new Interval(4, 5));
        i2.add(new Interval(9, 11));
        i2.add(new Interval(12, 15));
        i2.add(new Interval(25, 27));

        List<List<Interval>> sortedIntervalList = new ArrayList<>();
        sortedIntervalList.add(i1);
        sortedIntervalList.add(i2);
        List<Interval> result = mergeSortedIntervals(sortedIntervalList);
        System.out.println("Result of merged sorted intervals");
        for (Interval i : result)
        {
            System.out.print(i);
            System.out.print(" ");
        }
        System.out.println();

    }
}
/*
Hi, Vijay!
  Are you still there?
  I think there is a mistake in the main function!
  you added all Interval to i1
  That's why the output is not right!
  hey yea
  let me know once u finish it
  cool
  talk to u later.
  Thank you
  Now, it's done!
  */