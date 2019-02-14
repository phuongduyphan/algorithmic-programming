import java.util.EmptyStackException;
import java.util.NoSuchElementException;

public class MinStack<T extends Comparable<T>> extends Stack<T> {
	private Stack<T> minStack = new Stack<>();
	
	public T pop() {
		if (top == null) throw new EmptyStackException();
		T item = top.data;
		if (item.compareTo(this.min()) == 0) {
			minStack.pop();
		}
		top = top.next;
		return item;
	}
	
	public void push(T item) {
		if ((!this.isEmpty() && item.compareTo(this.min()) <= 0) || this.isEmpty()) {
			minStack.push(item);
		}
		
		StackNode<T> temp = new StackNode<>(item);
		temp.next = top;
		top = temp;
	}
	
	public T min() {
		if (minStack.isEmpty()) throw new NoSuchElementException();
		else return minStack.peek();
	}
}
