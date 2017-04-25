/**
 * Created by michaelzhang on 4/10/17.
 */
public class Child extends Parent {
    int field1 = 5;
    int field3 = 4;

    public static void main(String[] args) {
        Child c = new Child();
        System.out.println(((Parent)c).field1);
    }
}
