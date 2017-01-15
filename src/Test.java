import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Created by michael.zhang on 8/11/2016.
 */
public class Test {

    public static void fizzBuzz(int n) {
        for(int i = 0; i < n + 1; i++) {
            if(n % 3 == 0 && n % 5 == 0) {
                System.out.println("FizzBuzz");
            } else if (n % 3 == 0) {
                System.out.println("Fizz");
            } else if (n % 5 == 0) {
                System.out.println("Buzz");
            } else {
                System.out.println(i);
            }
        }
    }

    public static void main(String[] args) {
        fizzBuzz(20);
    }

}
