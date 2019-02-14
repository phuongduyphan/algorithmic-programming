import java.util.EmptyStackException;

public class Stack<T> {
	public static class StackNode<T> {
		protected T data;
		protected StackNode<T> next;
		
		public StackNode(T data) {
			this.data = data;
		}
	}
	
	protected StackNode<T> top;
	
	public T pop() {
		if (top == null) throw new EmptyStackException();
		T item = top.data;
		top = top.next;
		return item;
	}
	
	public void push(T item) {
		StackNode<T> temp = new StackNode<>(item);
		temp.next = top;
		top = temp;
	}
	
	public T peek() {
		if (top == null) throw new EmptyStackException();
		return top.data;
	}
	
	public boolean isEmpty() {
		return top == null;
	}
}