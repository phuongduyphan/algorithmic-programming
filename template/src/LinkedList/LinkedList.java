package LinkedList;

public class LinkedList<T> {
	public LinkedListNode<T> head = null;
	public int size = 0;
	
	public void add(T data) {
		if (this.head == null) {
			this.head = new LinkedListNode<T>(data);
			this.size++;
			return;
		}
		
		head.appendToTail(data);
		this.size++;
	}
	
	public void add(LinkedListNode<T> end) {
		if (this.head == null) {
			this.head = end;
			this.size++;
			return;
		}
		
		head.appendToTail(end);
		this.size++;
	}
	
	public void remove(T data) {
		LinkedListNode<T> returnHead = head.deleteNode(head, data);
		if (returnHead != null) {
			this.head = returnHead;
			this.size--;
		}
	}
	
	public void print() {
		LinkedListNode<T> curNode = head;
		while (curNode != null) {
			System.out.print(curNode.data + " ");
			if (curNode.next != null) System.out.print("-> ");
			curNode = curNode.next;
		}
		System.out.println();
	}
}
