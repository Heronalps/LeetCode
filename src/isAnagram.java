import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by michael.zhang on 8/4/2016.
 */
public class isAnagram {
    public static boolean isAnagram(String s, String t) {

        if (s.length() != t.length()) {
            return false;
        }

        int[] alpha = new int[26]; //这其实就是一种简单的Hashtable，和其原理一样
        int[] bet = new int[26];
        char[] source = s.toCharArray();
        char[] target = t.toCharArray();

        for (int i = 0; i < source.length; i++) {
            int index1 = (int) (source[i] - 'a');
            int index2 = (int) (target[i] - 'a');
            alpha[index1]++;
            bet[index2]++;
        }

        return Arrays.equals(alpha, bet);
    }

    public static boolean isAnagram2(String s, String t) {

        if (s.length() != t.length()) {
            return false;
        }

        int[] counter = new int[26];
        char[] source = s.toCharArray();
        char[] target = t.toCharArray();

        for (int i = 0; i < source.length; i++) {
            counter[source[i] - 'a']++;
        }

        for (int j = 0; j < target.length; j++) { //一个counter即可，只要反减小于零，返回False
            counter[target[j] - 'a']--;
            if (counter[target[j] - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isAnagram3(String s, String t) {

        if (s.length() != t.length()) {
            return false;
        }

        HashMap<Character, Integer> counter = new HashMap<Character, Integer>();
        char[] source = s.toCharArray();
        char[] target = t.toCharArray();

        for (int i = 0; i < source.length; i++) {
            if (counter.containsKey(source[i])) {
                counter.put(source[i], (counter.get(source[i]) + 1));
            } else {
                counter.put(source[i], 1);
            }
        }

        for (int j = 0; j < target.length; j++) {
            if (!counter.containsKey(target[j]) || counter.get(target[j]) == 0){

                //这个判断条件是正确的。因为之前已经确认两个String的长度一致。
                // 如果Target中某个字母少于Source而没有被减到零，则必有另一个字母被减到小于零。

                return false;
            } else {
                counter.put(target[j], (counter.get(target[j]) - 1));
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isAnagram("bad", "bde"));
        System.out.println(isAnagram2("bad", "bde"));
        System.out.println(isAnagram3("beed", "bedd"));

    }
}
