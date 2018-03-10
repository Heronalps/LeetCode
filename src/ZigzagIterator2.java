import java.util.Iterator;
import java.util.List;

public class ZigzagIterator2 {
    List<Iterator> itList;
    int turn;
    /*
    * @param vecs: a list of 1d vectors
    */public ZigzagIterator2(List<List<Integer>> vecs) {
        // do intialization if necessary
        for (List<Integer> list : vecs) {
            Iterator it = list.iterator();
            itList.add(it);
        }
        turn = 0;
    }

    /*
     * @return: An integer
     */
    public int next() {
        // write your code here
        int total = itList.size();
        Iterator curr = itList.get(turn % total);
        while (!curr.hasNext()) {
            turn++;
            curr = itList.get(turn % total);
        }
        turn++;
        return (int) curr.next();
    }

    /*
     * @return: True if has next
     */
    public boolean hasNext() {
        // write your code here
        for (Iterator it : itList){
            if (it.hasNext()){
                return true;
            }
        }
        return false;
    }
}

/**
 * Your ZigzagIterator2 object will be instantiated and called as such:
 * ZigzagIterator2 solution = new ZigzagIterator2(vecs);
 * while (solution.hasNext()) result.add(solution.next());
 * Output result
 */
