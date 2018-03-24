import java.util.EmptyStackException;
import java.util.Stack;

public class QueueByStack {
    Stack<Integer> stack;
    public QueueByStack() {
        stack = new Stack();
    }
    public void enqueue(int value) {
        stack.push(value);
    }
    public int dequeue() {
        if (stack.empty()) {
            throw new EmptyStackException();
        }
        if (stack.size() == 1) {
            return stack.pop();
        }
        int currVal = stack.pop();
        int result = dequeue();
        stack.push(currVal);
        return result;
    }
    public static void main(String[] args) {
        QueueByStack q = new QueueByStack();
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(4);
        q.enqueue(5);
        System.out.println(q.dequeue());
    }
}
