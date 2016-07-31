/**
 * Created by michael.zhang on 7/27/2016.
 */
public class ExcelTitleToNumber {
    public static int titleToNumber(String s) {
        char[] title = s.toCharArray();
        int answer = 0;

        for (int i = 0; i < title.length; i++ ) {
            int temp = (int) (title[i] - 'A' + 1);
            answer += temp * (Math.pow(26,(title.length - i - 1)));
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(titleToNumber("CA"));
        /*char[] test = "ABCD".toCharArray();
        System.out.println(test[0]);*/

    }
}
