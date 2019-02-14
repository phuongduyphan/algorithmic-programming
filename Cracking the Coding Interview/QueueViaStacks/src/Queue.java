import java.util.NoSuchElementException;

public class Queue<T> {
	private Stack<T> stackOldest = new Stack<>();
	private Stack<T> stackNewest = new Stack<>();
	
	// O(1)
	public void add(T item) {
		stackNewest.push(item);
	}
	
	public void shiftStack() {
		if (stackOldest.isEmpty()) {
			while (!stackNewest.isEmpty()) {
				stackOldest.push(stackNewest.pop());
			}
		}
	}
	
	// O(n)
	public T remove() {
		if (this.isEmpty()) throw new NoSuchElementException();
		shiftStack();
		return stackOldest.pop();
	}
	
	// O(n)
	public T peek() {
		if (this.isEmpty()) throw new NoSuchElementException();
		shiftStack();
		return stackOldest.peek();
	}
	
	public boolean isEmpty() {
		return stackOldest.isEmpty() && stackNewest.isEmpty();
	}
}
