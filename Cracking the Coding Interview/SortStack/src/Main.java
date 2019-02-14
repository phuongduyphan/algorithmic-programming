import java.util.Stack;

class Solution {
	public <T extends Comparable<T>> Stack<T> sort(Stack<T> stack) {
		Stack<T> tempStack = new Stack<>();

		while (!stack.isEmpty()) {
			T curElement = stack.pop();
			while (!tempStack.isEmpty() && tempStack.peek().compareTo(curElement) < 0) {
				stack.push(tempStack.pop());
			}
			tempStack.push(curElement);
		}
		return tempStack;
	}
}

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack<Integer> stack = new Stack<>();
		stack.push(4);
		stack.push(2);
		stack.push(3);
		stack.push(6);
		stack.push(1);
		stack.push(9);
		stack.push(7);

		Solution so = new Solution();
		Stack<Integer> sortedStack = so.sort(stack);
		while (!sortedStack.isEmpty()) {
			System.out.println(sortedStack.pop());
		}
	}

}
