import java.util.*;

/**
 * Created by michael.zhang on 8/11/2016.
 */
public class LongestSubWith3Char {
    private static String result = "";

    public static String longestSub(String str) {
        //Sanity Check
        if (str == null || str.length() == 0) {
            return null;
        }
        // char -> last appearing idnex map
        Map<Character, Integer> map = new HashMap<>();
        int index = 0;
        StringBuilder stringBuilder = new StringBuilder();
        while(index < str.length()) {
            char current = str.charAt(index);
            map.put(current, index);

            if (map.size() > 3) {
                index = getNextIndex(map);
                String temp = stringBuilder.toString();
                if (temp.length() > result.length()) {
                    result = temp;
                }
                stringBuilder.delete(0, stringBuilder.length());
                map.clear();
                continue;
            }
            stringBuilder.append(current);
            index++;
        }
        return result;
    }


    public static int getNextIndex(Map<Character, Integer> map) {
        int min = Integer.MAX_VALUE;
        for (Map.Entry<Character, Integer> entry : map.entrySet()){
            if (entry.getValue() < min) {
                min = entry.getValue();
            }
        }
        return min + 1;
    }


    public static void main(String[] args) {
        String str = "abcabcddddeef";//abcabcabcddddcbcbeaf
        System.out.println(longestSub(str)); //

    }
}



