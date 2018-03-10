import java.util.*;

public class MaxStack {
    TreeMap<Integer, LinkedList<Integer>> map;
    List<Integer> stack;
    int addIndex;
    int popIndex;

    public MaxStack() {
        map = new TreeMap<>((a, b) -> Integer.compare(b, a));
        stack = new ArrayList<>();
        addIndex = 0;
        popIndex = 0;
    }
    public void push(int x) {
        if (map.containsKey(x)) {
            map.get(x).add(addIndex);
        } else {
            LinkedList<Integer> indices = new LinkedList<>();
            indices.add(addIndex);
            map.put(x, indices);
        }
        stack.add(x);
        addIndex++;
        popIndex = addIndex - 1;
    }
    public int pop() {
        int head = backtrackPopIndex();
        map.get(head).removeLast();
        popIndex--;
        return head;
    }
    public int top() {
        return backtrackPopIndex();
    }
    public int peekMax() {
        int max = map.firstKey();
        while (map.get(max).size() == 0) {
            max = map.ceilingKey(max - 1);
        }
        return max;
    }
    public int popMax() {
        int max = peekMax();
        int index = map.get(max).pollLast();
        if (index == popIndex) {
            popIndex--;
        }
        return max;
    }
    private int backtrackPopIndex (){
        int head = stack.get(popIndex);
        while (!map.get(head).contains(popIndex)) {
            head = stack.get(--popIndex);
        }
        return head;
    }
}
