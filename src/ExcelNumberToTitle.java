import java.util.ArrayList;

/**
 * Created by michael.zhang on 8/2/2016.
 */
public class ExcelNumberToTitle {
    public static String convertToTitle(int n) {
        if (n == 0) {
            return null;
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

    public static void main(String[] args) {
        System.out.println(convertToTitle(26*26*27));
    }
}
