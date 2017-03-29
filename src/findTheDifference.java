import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;


/**
 * Created by michaelzhang on 9/4/16.
 */
public class findTheDifference{
    public char findTheDifference(String s, String t) {
        char[] searchIt = s.toCharArray();
        char[] target = t.toCharArray();
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < searchIt.length; i++ ) {
            if (!map.containsKey(searchIt[i])) {
                map.put(searchIt[i], 1);
            } else {
                map.put(searchIt[i], map.get(searchIt[i]) + 1);
            }
        }

        for (int j = 0; j < target.length ; j++ ) {
            if (!map.containsKey(target[j]) || map.get(target[j]) == 0) {
                return target[j];
            } else {
                map.put(target[j], map.get(target[j]) - 1);
            }
        }

        throw new IllegalArgumentException("No difference found!");
    }

    /*
    public char findTheDifference2(String s, String t) {
        return (char) (s + t).chars().reduce(0, (x, y) -> x ^ y);
    }
    */
    //运用Java8中IntStream新特性

    public char findTheDifference3(String s, String t) {
        //把s和t中所有的char做XOR运算,剩下的就是t中的新element
        char result = 0;
        for (int i = 0; i < s.length(); i++) {
            result ^= s.charAt(i);
            result ^= t.charAt(i);
        }
        result ^= t.charAt(t.length() - 1);
        return result;
    }

    public static void main(String[] args) {
        String s = "abbcd";
        String t = "bdbbca";
        findTheDifference myApp = new findTheDifference();
        System.out.println(myApp.findTheDifference3(s, t));

    }
}
