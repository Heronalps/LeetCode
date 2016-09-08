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

    public int getSum2(int a, int b) {
        //基本思想是把当前位和进位分别计算,然后递归调用

        if (b == 0) {
            return a;
        } //不仅是Base Case, 也是边界检查, 妙!
        else {
            int sum = a ^ b;
            int carryover = (a & b) << 1;
            return getSum2(sum, carryover);
        }
    }

    public int getSum3(int a, int b) {
        int mask = 1;//bit mask to get every bit of a,b
        int result = 0;
        int carryBit = 0;
        for (int i = 0; i < 32; i++)
        {
            int num1 = a & mask;
            int num2 = b & mask;
            result |= num1 ^ num2 ^ carryBit;
            //每次Result和当前异或结果做"与运算"

            if ((num1 & num2) !=0 || (num1 & carryBit)!=0 || (num2 & carryBit)!=0)
                //if two of three numbers(num1,num2,carryBit) in current bit are 1,that makes a carry,
                // for example,0010+0010+00010 makes a carry in 2th bit
                carryBit |= (num1 == 1 ? num1 : num2);
            else
                carryBit = 0;
            mask = mask << 1;
            //mask每次左移一位,实现了按位取值

            carryBit = carryBit << 1;
        }
        return result;
    }

    public static void main(String[] args) {
        getSum myExample = new getSum();
        System.out.println(myExample.getSum3(13, 15));
    }

}
