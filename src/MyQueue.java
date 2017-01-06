import java.util.Stack;


public class MyQueue{
	private Stack<Integer> stackA = new Stack<>();
	private Stack<Integer> stackB = new Stack<>();
	
	public void push(int x) {
		stackA.push(x);
	}	

	public void pop() throws Exception {
		peek();
		stackB.pop();
	}

	public int peek() throws Exception {
		if (!this.empty()) {	
			if (stackB.empty()) {
				while(!stackA.empty()){
					stackB.push(stackA.pop());
				}
			}
			return stackB.peek();
		} else {
			throw new Exception("Empty Queue!");
		}
	}

	public boolean empty() {
		return stackA.empty() && stackB.empty();
	}

	public static void main(String[] args) throws Exception {
		MyQueue queue = new MyQueue();
		for (int i = 0; i < 10; i++) {
			queue.push(i);
			System.out.println("push: " + queue.peek());
		}
		for (int i = 0; i < 10; i++) {
			System.out.println("pop: " + queue.peek());
			queue.pop();
		}
		
		//queue.pop();
		//queue.peek();
		
	}
}