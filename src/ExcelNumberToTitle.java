import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by michael.zhang on 8/2/2016.
 */
public class ExcelNumberToTitle {
    public static String convertToTitle(int n) {
        if (n <= 0) {
            return "";
        }
        ArrayList num_list = new ArrayList();//ArrayList不加Generic，存储类型是Object

        while(n != 0){
            int remainder = n % 26;
            if (remainder == 0) {
                n = n - 1;
                remainder = 26;
            }
            n = n / 26;
            num_list.add(remainder);
        }
        int size = num_list.size();
        char[] title = new char[size];
        for (int i = 0; i < size; i++) {
            int num = (int) num_list.get(i); //Java.lang.Integer 不能直接cast成Java.Lang.Character,需要用int进行过渡
            title[size - 1 - i] = (char) (num + 64);
        }
        return String.valueOf(title);
    }

    public static String convertToTitle2(int n) {
        if (n <= 26) return (char)('A' + n - 1) + "";
        if (n % 26 != 0) return convertToTitle2((n / 26)) + (char)('A' + (n % 26) - 1);
        else return convertToTitle2((n / 26) - 1) + "Z";
    }


    public static String convertToTitle3(int n) {

        //这道题的本质就是26进制用1-26来表示，而通常26进制应该是0-25。所以处理每一位之前，先减一，就可以按照正常进制转换进行处理了。

        StringBuilder result = new StringBuilder();
        while(n>0){
            n--;
            result.insert(0, (char)('A' + n % 26)); //先取余，后自除，标准进制转换。
            n /= 26;
        }

        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(convertToTitle3(26*26*27));
        System.out.println(convertToTitle2(26*26*27));
        System.out.println(convertToTitle(26*26*26));
    }
}
