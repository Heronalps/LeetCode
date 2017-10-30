import java.util.Iterator;
import java.util.List;

public class Vector2D implements Iterator<Integer> {

    Iterator<Integer> list;
    Iterator<List<Integer>> listList;

    public Vector2D(List<List<Integer>> vec2d) {
        // Initialize your data structure here
        listList = vec2d.iterator();
    }

    @Override
    public Integer next() {
        // Write your code here
        return list.next();

    }

    @Override
    public boolean hasNext() {
        // Write your code here
        while (list == null || (!list.hasNext() && listList.hasNext())){
            list = listList.next().iterator();
        }
        return list != null && list.hasNext();
    }

    @Override
    public void remove() {}
}


/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D i = new Vector2D(vec2d);
 * while (i.hasNext()) v[f()] = i.next();
 */