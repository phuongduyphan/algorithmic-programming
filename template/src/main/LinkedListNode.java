package main;

public class LinkedListNode<T> {
	public LinkedListNode<T> next = null;
	public T data;

	public LinkedListNode(T data) {
		this.data = data;
	}

	public void appendToTail(T data) {
		LinkedListNode<T> end = new LinkedListNode<>(data);
		LinkedListNode<T> n = this;

		while (n.next != null) {
			n = n.next;
		}
		n.next = end;
	}

	public void appendToTail(LinkedListNode<T> end) {
		LinkedListNode<T> n = this;

		while (n.next != null) {
			n = n.next;
		}
		n.next = end;
	}
	
	public LinkedListNode<T> deleteNode(LinkedListNode<T> head, T data) {
		LinkedListNode<T> n = head;
		
		if (n.data.equals(data)) {
			LinkedListNode<T> newHead = head.next;
			head.next = null;
			return newHead;
		}
		
		while (n.next != null) {
			if (n.next.data.equals(data)) {
				n.next = n.next.next;
				return head;
			}
			n = n.next;
		}
		return null;
	}
}
