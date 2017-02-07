import java.util.*;

/**
 * Created by michaelzhang on 2/6/17.
 */
public class WordBreak {
    public static boolean wordBreak(String s, Set<String> wordDict){
//sanity check
        //List<String> result = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return false;
        }
        boolean[] canSegment = new boolean[s.length() + 1];
        canSegment[0] = true;
        int maxLength = getMaxLength(wordDict);

// DP in two loops
        for (int i = 1; i < s.length() + 1; i++) {
            for (int testWordLength = 1; testWordLength <= i && testWordLength <= maxLength; testWordLength++) {
                int start = i - testWordLength;
                if (!canSegment[start]) {
                    continue;
                }
                String word = s.substring(start, i);
                if (wordDict.contains(word)){
                    canSegment[i] = true;
                    break;
                }
            }
        }
        return canSegment[s.length()];
    }
    public static int getMaxLength(Set<String> dict) {
        int max = 0;
        for (String word : dict) {
            max = Math.max(max, word.length());
        }
        return max;
    }





    public static List<String> wordBreak2(String s, Set<String> wordDict) {
        List<String> result = new ArrayList<String>();
//Sanity check
        if (s == null || s.length() == 0) {
            return result;
        }
        Map<String, List<String>> subToPartMap = new HashMap<>();
        result = helper(s, wordDict, subToPartMap);
        return result;
    }
    public static List<String> helper(String s, Set<String> wordDict, Map<String, List<String>> map){
        if (map.containsKey(s)) {
            return map.get(s);
        }
        List<String> result = new ArrayList<>();
        if (s.length() == 0) {
            return result;
        }

        for (int len = 1; len <= s.length(); len++) {
            String prefix = s.substring(0, len);
            if (!wordDict.contains(prefix)) {
                continue;
            }
            String suffix = s.substring(len);
            List<String> partition = helper(suffix, wordDict, map);
            if (len != s.length()) {
                for (String str : partition) {
                    str = prefix + " " + str;
                    result.add(str);
                }
            } else {
                result.add(prefix);
            }
        }
        map.put(s, result);
        return result;
    }

    public static void main(String[] args) {
        String str = "aaab";
        Set<String> set = new HashSet<>();
        set.add("b");
        set.add("aa");
        //set.add("co");
        //set.add("de");

        System.out.println(wordBreak2(str, set));

    }

}
