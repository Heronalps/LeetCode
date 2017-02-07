import java.util.ArrayList;
import java.util.List;

/**
 * Created by michaelzhang on 2/6/17.
 */
public class PartitionPalindrome {
    public static List<List<String>> partition(String s) {
        //Sanity check
        List<List<String>> result = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return result;
        }
        List<String> part = new ArrayList<>();
        helper(result, part, 0, s);
        return result;
    }

    public static void helper(List<List<String>> result,
                              List<String> part,
                              int startIndex,
                              String str){
        //Base case to do
        if (startIndex == str.length()) {
            result.add(new ArrayList(part));
            return;
        }

        for(int i = startIndex; i < str.length(); i++) {
            String current = str.substring(startIndex, i + 1);
            if (!isPalindrome(current)){
                continue;
            }
            part.add(current);
            helper(result, part, i + 1, str);
            part.remove(part.size() - 1);
        }
    }

    public static boolean isPalindrome(String str) {
        for (int start = 0, end = str.length() - 1; start < end; start++, end--){
            if (str.charAt(start) != str.charAt(end)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(partition("aab"));
    }
}
