import java.util.Arrays;

/**
 * Created by michael.zhang on 8/11/2016.
 */
public class Test {
    public static void main(String[] args) {
        int[] result = Arrays.copyOfRange(new int[] {0,1,2,3},1,4);
        System.out.println(result.length);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
}
