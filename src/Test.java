import java.util.Arrays;
import java.util.Collections;

/**
 * Created by michael.zhang on 8/11/2016.
 */
public class Test {
    public static void main(String[] args) {
        Integer[] result = {0,1,2,3};
        Arrays.sort(result, Collections.reverseOrder());
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
}
