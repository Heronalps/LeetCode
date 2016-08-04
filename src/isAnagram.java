import java.util.Arrays;

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

    public static void main(String[] args) {
        System.out.println(isAnagram("bad", "bde"));
        System.out.println(isAnagram2("bad", "bde"));
    }
}
