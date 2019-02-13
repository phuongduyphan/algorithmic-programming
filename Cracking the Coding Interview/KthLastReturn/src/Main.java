
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

class Index {
	public int value;
}

class Solution {
	public Node findElement(Node head, int k) {
		Index idx = new Index();
		return findElement(head, k, idx);
	}
	
	public Node findElement(Node head, int k, Index idx) {
		if (head == null) {
			idx.value = 0;
			return null;
		}
		
		Node result = findElement(head.next, k, idx);
		idx.value++;
		if (idx.value == k) {
			result = head;
		}
		
		return result;
	}
}

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node head = new Node(3);
		head.appendToTail(1);
		head.appendToTail(2);
		head.appendToTail(4);
		head.appendToTail(3);
		head.appendToTail(5);
		
		Solution so = new Solution();
		Node result = so.findElement(head, 2);
		System.out.println(result.data);
	}

}
