
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node head = new Node(1);
		head.next = new Node(1);
		head.next.next = new Node(1);
		head.next.next.next = new Node(1);
		head.next.next.next.next = new Node(2);
		head.next.next.next.next.next = new Node(2);
		head.next.next.next.next.next.next = new Node(3);
		head.next.next.next.next.next.next.next = new Node(3);
		head.next.next.next.next.next.next.next.next = new Node(3);
		
		Solution so = new Solution();
		so.removeDupsFromSortedLinkedList(head);
		so.print(head);
	}

}
