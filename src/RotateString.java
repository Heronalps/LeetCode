/**
 * Created by michaelzhang on 2/9/17.
 */
public class RotateString {
    public static void rotateString(char[] str, int offset) {
        if (str == null || str.length == 0) {
            return;
        }
        offset = offset % str.length;
        int len = str.length - offset; // length of prefix
        char[] prefix = new char[len];
        char[] suffix = new char[offset];
        for (int i = 0; i < str.length; i++) {
            if (i < len) {
                prefix[i] = str[i];
            } else {
                suffix[i - len] = str[i];
            }
        }
        reverse(prefix);
        reverse(suffix);
        for (int i = 0; i < str.length; i++) {
            if (i < len) {
                str[i] = prefix[i];
            } else {
                str[i] = suffix[i - len];
            }
        }
        reverse(str);
        //return str;
    }
    public static void reverse(char[] str){
        for (int i = 0, j = str.length - 1; i < j; i++, j--) {
            char tmp = str[i];
            str[i] = str[j];
            str[j] = tmp;
        }
    }

    public static void main(String[] args) {
        char[] str = {'a','b','c','d','e','f','g'};
        int offset = 2;
        //System.out.println(rotateString(str, offset));
    }
}
