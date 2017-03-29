import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

class Pair{
    int key;
    int value;
    public Pair(int key, int value) {
        this.key = key;
        this.value = value;
    }
    @Override
    public boolean equals(Object obj) {
        Pair pair = (Pair) obj;
        if (this.key == pair.key && this.value == pair.value) {
            return true;
        }
        return false;
    }
}

public class LRUCache {
    LinkedList<Pair> list;
    int capacity;
    Map<Integer, Pair> map;

    // @param capacity, an integer
    public LRUCache(int capacity) {
        // write your code here
        map = new HashMap<>();
        list = new LinkedList<>();
        this.capacity = capacity;
    }

    // @return an integer
    public int get(int key) {
        // write your code here
        if (map.containsKey(key)){
            Pair current = map.get(key);
            list.remove(current);
            list.offer(current);
            return current.value;
        }

        return -1;
    }

    // @param key, an integer
    // @param value, an integer
    // @return nothing
    public void set(int key, int value) {
        // write your code here
        if (map.containsKey(key)) {
            Pair current = map.get(key);
            list.remove(current);
            current.value = value;
            list.offer(current);
            return;
        }

        if (list.size() == capacity) {
            Pair del = list.poll();
            map.remove(del.key);
        }

        Pair newPair = new Pair(key, value);
        list.offer(newPair);
        map.put(key, newPair);
    }
}