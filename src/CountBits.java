/**
 * Created by michaelzhang on 6/26/16.
 */
public class CountBits {

    public static int[] countBits(int num) {
        int[] result = new int[num + 1];
        for(int i = 0; i <= num; i++) {
            result[i] = countOnes(i);
        }
        return result;
    }

    public static int countOnes(int number) {
        int counter = 0;

        while(number != 0){
            number = number & (number - 1); //直击最尾的1，只留之前的各位有效数字
            counter++;
        }
        return counter;
    }

    public static int[] countBits2(int num) {

        int[] cnt = new int[num+1];
        cnt[0] = 0;
        int i = 1;
        int step = 1;

        if(num == 0) {
            return cnt;
        }
        while(i < num + 1){
            for(int j = 0; j < step; j++){
                cnt[i++] = 1 + cnt[j];
                if(i == num+1)
                    break; //控制非2整数次,提前跳出
            }
            step += step; //翻倍
        }
        return cnt;
    }
    public static void main(String[] args) {

        int num = 17;
        int[] arr = new int[num];
        arr = countBits2(num);
        for (int i : arr) {
            System.out.println(i);
        }
    }
}
