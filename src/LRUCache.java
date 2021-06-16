import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

class DLNode {
    DLNode prev;
    DLNode next;
    int key, val;
    public DLNode(int key, int val) {
        this.key = key;
        this.val = val;
    }
    public void link(DLNode node) {
        this.next = node;
        node.prev = this;
    }
    public void remove() {
        if (this.prev != null) {
            this.prev.next = this.next;
        }
        if (this.next != null) {
            this.next.prev = this.prev;
        }
    }
    public void addToHead(DLNode head) {
        this.remove();
        DLNode next = head.next;
        head.link(this);
        this.link(next);
    }
    public static int popFromTail (DLNode tail) {
        if (tail.prev.prev == null) {
            return -1;
        }
        int key = tail.prev.key;
        tail.prev.remove();
        return key;
    }
}

class LRUCache {

    Map<Integer, DLNode> map;
    DLNode head, tail;
    int capacity, currLen;
    public LRUCache(int capacity) {
        map = new HashMap<>();
        head = new DLNode(-1, -1);
        tail = new DLNode(-1, -1);
        head.link(tail);
        this.capacity = capacity;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            DLNode n = map.get(key);
            n.addToHead(head);
            return map.get(key).val;
        }
        return -1;
    }

    public void put(int key, int value) {
        DLNode node = map.getOrDefault(key, new DLNode(key, value));
        if (map.containsKey(key)) {
            node.val = value;
        } else {
            currLen++;
            map.put(key, node);
            if (currLen > capacity) {
                map.remove(DLNode.popFromTail(tail));
                currLen--;
            }
        }
        node.addToHead(head);
    }
    public static void main(String[] args) {
        LRUCache l = new LRUCache(2);
        l.put(2,1);

        l.put(1,1);
        l.put(2,3);
        l.put(4,1);

        l.get(1);
        l.get(2);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */