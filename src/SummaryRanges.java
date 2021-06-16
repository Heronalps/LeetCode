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
        Integer lowKey = map.floorKey(val);
        Integer highKey = map.ceilingKey(val);
        if (lowKey != null && highKey != null &&
                map.get(lowKey).end == val - 1 && map.get(highKey).start == val + 1) {

            map.get(lowKey).end = map.get(highKey).end;
            map.remove(highKey);
        }
        else if (lowKey != null && map.get(lowKey).end >= val - 1) { // 等于val - 1时左链接
            map.get(lowKey).end = Math.max(val, map.get(lowKey).end);
        }
        else if (highKey != null && map.get(highKey).start <= val + 1) { // 等于val + 1时右链接
            map.get(highKey).start = Math.min(val,map.get(highKey).start);
        }
        else {
            map.put(val, new Interval(val, val));
        }
    }

    public List<Interval> getIntervals() {
        return new ArrayList<>(map.values());
    }

}