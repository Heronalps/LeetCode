import java.util.HashMap;

/**
 * Created by michael.zhang on 8/11/2016.
 */
public class RomanToInt {
    public int romanToInt(String s) {
        char[] roman = s.toCharArray();
        HashMap<Character, Integer> dict = new HashMap<Character, Integer>();
        dict.put('I', 1);
        dict.put('V', 5);
        dict.put('X', 10);
        dict.put('L', 50);
        dict.put('C', 100);
        dict.put('D', 500);
        dict.put('M', 1000);
        int digit = 0;
        int result = 0;

        //Substractive Rules
        for (int i = 0; i < roman.length - 1; i++) {
            digit = dict.get(roman[i]);
            if (roman[i] == 'I' && (roman[i + 1] == 'V' || roman[i + 1] == 'X')) {
                digit = -digit;
            }
            if (roman[i] == 'X' && (roman[i + 1] == 'L' || roman[i + 1] == 'C')) {
                digit = -digit;
            }
            if (roman[i] == 'C' && (roman[i + 1] == 'D' || roman[i + 1] == 'M')) {
                digit = -digit;
            }
            result += digit;
        }
        //最后一位不用Substractive Rule，补位
        result += dict.get(roman[roman.length - 1]);

        return result;
    }

    public static void main(String[] args) {
        RomanToInt example = new RomanToInt();
        System.out.println(example.romanToInt("DCCCXC"));
    }
}
