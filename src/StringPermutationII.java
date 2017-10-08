import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringPermutationII {

    public static List<String> stringPermutation2(String str) {
        // write your code here

        List<String> result = new ArrayList<>();
        StringBuffer buffer = new StringBuffer();
        boolean[] visited = new boolean[str.length()];
        char[] charArray = str.toCharArray();
        Arrays.sort(charArray);
        helper(charArray, visited , buffer, result);

        return result;
    }

    static void helper(char[] charArray,
                       boolean[] visited,
                       StringBuffer buffer,
                       List<String> result) {

        //base case
        if (buffer.length() == charArray.length) {
            result.add(new String(buffer));
            return;
        }

        for (int i = 0 ; i < charArray.length; i++) {
            if (visited[i]) {
                continue;
            }
            if (i != 0 && charArray[i - 1] == charArray[i] && !visited[i - 1]) {
                continue;
            }
            visited[i] = true;
            helper(charArray, visited, buffer.append(charArray[i]), result);
            visited[i] = false;
            buffer.deleteCharAt(buffer.length() - 1);
        }
    }
}
