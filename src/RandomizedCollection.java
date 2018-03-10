import java.util.*;

public class RandomizedCollection {

    Map<Integer, Set<Integer>> map;
    List<Integer> list;
    Random rand = new Random();

    /** Initialize your data structure here. */
    public RandomizedCollection() {
        map = new HashMap<>();
        list = new ArrayList<>();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (map.containsKey(val)) {
            if (val == 4) {
                System.out.println("list.size() : " + list.size());
            }
            map.get(val).add(list.size());
            list.add(val);
            return false;
        } else {
            Set<Integer> set = new LinkedHashSet<>();
            set.add(list.size());
            map.put(val, set);
            list.add(val);
            return true;
        }
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }
        int index = map.get(val).iterator().next();
        if (val == 4) {
            System.out.println("index : " + index);
        }
        if (index != list.size() - 1){
            int lastElement = list.get(list.size() - 1);
            list.set(index, lastElement);
            map.get(lastElement).remove(list.size() - 1);
            map.get(lastElement).add(index);
        }
        list.remove(list.size() - 1);
        map.get(val).remove(index);
        if (map.get(val).isEmpty()) {
            map.remove(val);
        }
        System.out.println("size : " + list.size());
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }
}