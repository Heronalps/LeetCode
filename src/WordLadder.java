import java.util.*;

/**
 * Created by michaelzhang on 2/7/17.
 */
public class WordLadder {
    public static int ladderLength(String start, String end, Set<String> dict){
        //Sanity Check
        if (dict.size() == 0) {
            return 0;
        }
        if (start.equals(end)) {
            return 1;
        }
//BFS
        dict.add(end);
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.offer(start);
        visited.add(start);
        int length = 1;
        while(!queue.isEmpty()) {
            int size = queue.size();
            length++;
            while (size > 0) {
                String current = queue.poll();
                List<String> nextWords = getNextWords(current, dict);
                for (String next : nextWords) {
                    if (visited.contains(next)) {
                        continue;
                    }
                    if (next.equals(end)){
                        return length;
                    }
                    queue.offer(next);
                    visited.add(next);
                }
                size--;
            }
        }
        return 0;
    }

    public static List<String> getNextWords(String str, Set<String> dict) {
        List<String> result = new ArrayList<>();
        Iterator it = dict.iterator();
        while (it.hasNext()) {
            String current = (String) it.next();
            if (isOneLetterDiff(str, current)) {
                result.add(current);
            }
        }
        return result;
    }
    public static boolean isOneLetterDiff(String str1, String str2) {
        if (str1.equals(str2)) {
            return false;
        }
        int num = 0;
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) == str2.charAt(i)) {
                continue;
            } else if (num > 1) {
                break;
            } else {
                num++;
            }
        }
        return num == 1;
    }

    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("hot");
        set.add("dot");
        set.add("dog");
        set.add("lot");
        set.add("log");
        System.out.println(ladderLength("hit", "cog", set));

    }
}
