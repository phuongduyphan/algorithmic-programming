public class Solution {
	/**
	 * @param {Node} head
	 * @param {Node} Head of the new linked list.
	 */
	public Node removeDupsFromSortedLinkedList(Node head) {
		Node currentNode = head;
    while (currentNode != null) {
    	while (currentNode.next != null && currentNode.val == currentNode.next.val) {
      	currentNode.next = currentNode.next.next;
      }
      currentNode = currentNode.next;
    }
    return head;
	}
	
	public void print(Node head) {
		Node currentNode = head;
		while (currentNode != null) {
			System.out.print(currentNode.val + " ");
			currentNode = currentNode.next;
		}
		System.out.println();
	}
}