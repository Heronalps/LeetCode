/**
 * Created by michael.zhang on 6/28/2016.
 */
public class addDigits {
    public static int addDigits(int num) {
        if (num < 10) {
            return num;
        }

        int counter = 0;
        while(num > 0) {
            int digit = num % 10;
            num = num / 10;
            counter += digit;
        }

        int result = addDigits(counter);
        return result;
    }

    public static int addDigits2(int num) {
        int counter = 0;
        while(num > 0) {
            int digit = num % 10;
            num = num / 10;
            counter += digit;
            if (num == 0 && counter > 9) {
                num = counter;
                counter = 0;
            }
        }
        return counter;
    }

    public static void main(String[] args) {
        System.out.println(addDigits(456));
        System.out.println(addDigits2(456));
    }
}
