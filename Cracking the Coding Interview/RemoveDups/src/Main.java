
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
}

class Solution {
	public Node removeDups(Node head) {
		Node currentNode = head;
		
		while (currentNode != null) {
			Node runnerNode = currentNode;
			
			while (runnerNode.next != null) {
				if (runnerNode.next.data == currentNode.data) {
					runnerNode.next = runnerNode.next.next;
				}
				else runnerNode = runnerNode.next;
			}
			currentNode = currentNode.next;
		}
		
		return head;
	}
}

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node head = new Node(1);
		head.appendToTail(3);
		head.appendToTail(4);
		head.appendToTail(4);
		head.appendToTail(5);
		
		Solution so = new Solution();
		head = so.removeDups(head);
		while (head != null) {
			System.out.print(head.data + " " );
			head = head.next;
		}
	}

}
