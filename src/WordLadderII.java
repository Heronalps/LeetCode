import java.util.*;

/**
 * Created by michaelzhang on 2/7/17.
 */
public class WordLadderII {
    public static List<List<String>> findLadders(String start, String end, Set<String> dict) {
        List<List<String>> result = new ArrayList<>();
        //Sanity Check
        if(dict.size() == 0){
            return result;
        }
        if (start.equals(end)){
            List<String> path = new ArrayList<>();
            path.add(start);
            result.add(path);
            return result;
        }
        dict.add(end);
        ArrayList<String> path = new ArrayList<>();
        path.add(start);
        Map<String, Integer> lengthMap = bfs(end, start, dict);
        dfs(start, end, dict, lengthMap, path, result);
        return result;
    }

    public static Map<String, Integer> bfs(String start, String end, Set<String> dict) {
        Map<String, Integer> lengthMap = new HashMap<>();
        int length = 0;
        Queue<String> queue = new LinkedList<>();
        Set<String> hash = new HashSet<>();
        queue.offer(start);
        hash.add(start);
        lengthMap.put(start, 0);
        while(!queue.isEmpty()) {
            int size = queue.size();
            length++;
            while(size > 0){
                String current = queue.poll();
                for (String next : getNextWords(current, dict)) {
                    if (hash.contains(next)) {
                        continue;
                    }
                    if (next.equals(end)){
                        return lengthMap;
                    }
                    queue.offer(next);
                    hash.add(next);
                    lengthMap.put(next, length);
                }
                size--;
            }
        }
        return lengthMap;
    }

    public static void dfs(String start, String end, Set<String> dict, Map<String, Integer> lengthMap, List<String> path, List<List<String>> result) {
        //Base case to dp
        if (start.equals(end)) {
            result.add(new ArrayList<String>(path));
            return;
        }
        List<String> nextWords = getNextWords(start, dict);
        int shortest = getShortest(nextWords, lengthMap);
        for (String next : nextWords) {
            if (!lengthMap.containsKey(next) || lengthMap.get(next) > shortest) {
                continue;
            }
            path.add(next);
            dfs(next, end, dict, lengthMap, path, result);
            path.remove(path.size() - 1);
        }
    }
    public static int getShortest(List<String> nextWords, Map<String, Integer> lengthMap) {
        int shortest = Integer.MAX_VALUE;
        for (String str : nextWords) {
            if (lengthMap.containsKey(str)) {
                shortest = Math.min(shortest, lengthMap.get(str));
            }
        }
        return shortest;
    }

    public static List<String> getNextWords(String word, Set<String> dict){
        List<String> list = new ArrayList<>();
        for (int ch = 'a'; ch <= 'z'; ch++) {
            for (int i = 0; i < word.length(); i++) {
                if (word.charAt(i) == ch) {
                    continue;
                }
                String newWord = replace(word, i, ch);
                if (dict.contains(newWord)) {
                    list.add(newWord);
                }
            }
        }
        return list;
    }
    public static String replace(String word, int index, int ch) {
        String newWord = word.substring(0, index) + (char) ch + word.substring(index + 1);
        return newWord;
    }
    public static void main(String[] args){
        /*String start = "hit";
        String end = "cog";
        Set<String> dict = new HashSet<>();
        dict.add("hot");
        dict.add("dot");
        dict.add("dog");
        dict.add("lot");
        dict.add("log");
        */
        String start = "a";
        String end = "c";
        Set<String> dict = new HashSet<>();
        dict.add("a");
        dict.add("b");
        dict.add("c");
        System.out.println(findLadders(start, end, dict));
    }
}
