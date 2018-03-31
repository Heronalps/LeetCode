import java.math.BigInteger;
import java.util.*;

class Solution {

    public boolean isValidSerialization(String preorder) {
        Stack<String> stack = new Stack<>();
        String[] array = preorder.split(",");
        for (String curr : array) {
            while (curr.equals("#") && !stack.empty() && stack.peek().equals("#")) {
                stack.pop();
                if (stack.empty()) return false; // 如果两个#之前没有node，false
                stack.pop();
            }
            stack.push(curr);
        }
        return stack.size() == 1 && stack.peek().equals("#"); // 只剩一个#
    }





    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        System.out.println(oddEvenList(head));
    }

}

