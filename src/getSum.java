/**
 * Created by michaelzhang on 9/2/16.
 */
public class getSum {

    public int getSum(int a, int b) {

        int maxLength = Math.max(signFigure(a), signFigure(b));
        int sum = 0;
        int carryover = 0;
        int result = 0;

        for (int i = 0; i < maxLength; i++) {
            int a_digit = get(a, i);
            int b_digit = get(b, i);
            result = a_digit ^ b_digit ^ carryover;
            carryover = CarryOver(a_digit, b_digit, carryover);
            sum += result * Math.pow(2, i);

        }
        sum += carryover * Math.pow(2, maxLength);

        return sum;
    }

    public int get(int num, int pos) {
        //Position starts at 0
        int mask = 1 << pos;
        int result = (num & mask) >> pos;
        return result;
    }

    public int signFigure(int num) {
        int length = 0;
        while(num != 0) {
            num = num >> 1;
            length++;
        }
        return length;
    }

    public int CarryOver(int a, int b, int c) {
        //为了表达三个数中至少有两个是1就要进位,把000,100和110,111分开
        //以下位操作返回值恰好为进位值。
        int and = a & b & c;
        int or = a | b | c;
        int xor = a ^ b ^ c;
        return and ^ or ^ xor;
    }

    public static void main(String[] args) {
        getSum myExample = new getSum();
        System.out.println(myExample.getSum(29, 5));
    }

}
