import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

class SummaryRanges {
    TreeMap<Integer, Interval> map;
    /** Initialize your data structure here. */
    public SummaryRanges() {
        map = new TreeMap<>();
    }

    public void addNum(int val) {
        Integer lowKey = map.lowerKey(val + 1);
//        System.out.println("val : " + val);
//        System.out.println("low : " + map.lowerKey(val));
//        System.out.println("high : " + map.higherKey(val));
        Integer highKey = map.higherKey(val - 1);
        if (lowKey != null && highKey != null && map.get(lowKey).end == val - 1 && map.get(highKey).start == val + 1) {
            map.get(lowKey).end = map.get(highKey).end;
            map.remove(highKey);
        }
        else if (lowKey != null && map.get(lowKey).end >= val - 1) {
            //System.out.println(Math.max(val, map.get(lowKey).end));
            map.get(lowKey).end = Math.max(val, map.get(lowKey).end);
        }
        else if (highKey != null && map.get(highKey).start <= val + 1) {
            map.get(highKey).start = Math.min(val,map.get(highKey).start);
            //System.out.println(Math.min(val,map.get(highKey).start));
        }
        else {
            map.put(val, new Interval(val, val));
        }
    }

    public List<Interval> getIntervals() {
        return new ArrayList<>(map.values());
    }
}