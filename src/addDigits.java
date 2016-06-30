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
            if (num == 0 && counter > 9) { //把递归改写成迭代,就是把base case变成边界条件,写到循环体里面
                num = counter;
                counter = 0; //记住清零
            }
        }
        return counter;
    }

    public static int addDigits3(int num) {
//        if (num == 0) {
//            return num;
//        }
//        else if (num % 9 == 0) {
//            return 9;
//        }
//        else {
//            return (num % 9);
//        }
        return 1 + (num - 1) % 9;

    }

    public static void main(String[] args) {
        System.out.println(addDigits(456));
        System.out.println(addDigits2(456));
        System.out.println(addDigits3(456));
    }
}
