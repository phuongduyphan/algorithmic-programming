public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MinStack<Integer> stack = new MinStack<>();
		stack.push(4);
		stack.push(2);
		stack.push(3);
		stack.push(7);
		stack.push(9);
		stack.push(5);
		stack.push(1);
		stack.push(6);
		
		System.out.println(stack.min());
	}

}
