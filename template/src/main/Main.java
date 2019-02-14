package main;

import LinkedList.LinkedList;
import LinkedList.LinkedListNode;

public class Main {

	public static void main(String[] args) {
		// LinkedList test
		LinkedList<Integer> list = new LinkedList<>();
		list.add(4);
		list.add(5);
		list.add(3);
		list.add(3);
		list.add(2);
		list.add(1);
		list.add(new LinkedListNode<Integer>(6));
		System.out.println(list.size);
		list.print();
		
		list.remove(3);
		list.remove(6);
		System.out.println(list.size);
		list.print();
	}

}
