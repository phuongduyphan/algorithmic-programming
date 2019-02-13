class Node {
	Node next = null;
	int data;
	
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
	
	public void appendToTail(Node end) {
		Node n = this;

		while (n.next != null) {
			n = n.next;
		}
		n.next = end;
	}
}

class Solution {
	public Node findIntersection(Node head1, Node head2) {
		int length1 = findLength(head1);
		int length2 = findLength(head2);
		
		Node shorter = length1 < length2 ? head1 : head2;
		Node longer = length1 < length2 ? head2 : head1;
		
		int diff = Math.abs(length1 - length2);
		for (int i = 0; i < diff; i++) {
			longer = longer.next;
		}
		
		while (shorter != null) {
			if (shorter == longer) {
				return shorter; 
			}
			shorter = shorter.next;
			longer = longer.next;
		}
		return null;
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
		// TODO Auto-generated method stub
		Node intersection = new Node(4);
		intersection.appendToTail(9);
		intersection.appendToTail(6);
		
		Node head1 = new Node(3);
		head1.appendToTail(1);
		head1.appendToTail(2);
		head1.appendToTail(intersection);
		
		Node head2 = new Node(5);
		head2.appendToTail(2);
		head2.appendToTail(intersection);
		
		Solution so = new Solution();
		Node result = so.findIntersection(head1, head2);
		System.out.println(result.data);
	}

}
