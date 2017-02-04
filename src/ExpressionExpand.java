import java.util.Stack;

/**
 * Created by michaelzhang on 2/4/17.
 */
public class ExpressionExpand {
    public static String expessionExpand(String s) {
        Stack<String> str = new Stack<String>();
        Stack<Integer> num = new Stack<Integer>();
        Stack<String> temp = new Stack<>();
        int number = 0;
        for (Character ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                number = number * 10 + ch - '0';
            } else if (ch == '[') { // Current number is over
                str.push("[");
                num.push(number);
                number = 0;
            } else if (ch == ']') {
                while (!str.isEmpty()) {
                    String current = str.pop();
                    if (current.equals("[")) {
                        StringBuilder sb = new StringBuilder();
                        while (!temp.isEmpty()) {
                            sb.append(temp.pop());
                        }
                        StringBuilder substr = new StringBuilder();
                        int times = num.pop();
                        for (int i = 0; i < times; i++) {
                            substr.append(sb.toString());
                        }
                        str.push(substr.toString());
                        break;
                    }
                    temp.push(current);
                }
            } else {
                str.push(String.valueOf(ch));
            }
        }

        Stack<String> reverse = new Stack<>();
        while (!str.isEmpty()) {
            reverse.push(str.pop());
        }
        StringBuilder result = new StringBuilder();
        while (!reverse.isEmpty()) {
            result.append(reverse.pop());
        }
        return result.toString();
    }

    public static void main(String[] args) {

        System.out.println(expessionExpand("3[2[ad]3[pf]]xyz"));

    }
}
