class Node {
	public Node next = null;
	public int data;
	
	public Node(int data) {
		this.data = data;
	}
	
	public void appendToTail(int data) {
		Node end = new Node(data);
		Node n = this;
		
		while (n.next != null) {
			n = n.next;
		}
		n.next = end;
	}
}

class Pair<T,U> {
	public T first;
	public U second; 
}

class Solution {
	public boolean isPalindrome(Node head) {
		Pair<Node, Boolean> pair = new Pair<>();
		int length = findLength(head);
		isPalindrome(head, length, pair);
		return pair.second;
	}
	
	public void isPalindrome(Node head, int length, Pair<Node,Boolean> pair) {
		if (length == 0) {
			pair.first = head;
			pair.second = true;
			return;
		}
		if (length == 1) {
			pair.first = head.next;
			pair.second = true;
			return;
		}
		
		isPalindrome(head.next, length - 2, pair);
		if (!pair.second) return;
		
		if (pair.first.data != head.data) {
			pair.second = false;
		}
		pair.first = pair.first.next;
	}
	
	private int findLength(Node head) {
		int length = 0;
		while (head != null) {
			length++;
			head = head.next;
		}
		return length;
	}
}

public class Main {
	public static void main(String[] args) {
		Node head = new Node(1);
		head.appendToTail(3);
		head.appendToTail(1);
		head.appendToTail(3);
		head.appendToTail(1);
		
		Solution so = new Solution();
		System.out.println(so.isPalindrome(head));
	}
}
