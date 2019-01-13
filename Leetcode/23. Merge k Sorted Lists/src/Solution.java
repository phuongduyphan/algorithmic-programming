import java.util.Comparator;
import java.util.PriorityQueue;

class myComparator implements Comparator<ListNode> {
	@Override
	public int compare(ListNode o1, ListNode o2) {
		// TODO Auto-generated method stub
		if (o1.val == o2.val) return 0;
		return o1.val < o2.val ? -1 : 1;
	}
}

public class Solution {
	public ListNode mergeKLists(ListNode[] lists) {
		ListNode resultList = new ListNode(0);
		ListNode firstNode = resultList;
		PriorityQueue<ListNode> pq = new PriorityQueue<>(11,new myComparator());
		this.initialize(lists, pq);
		
		while (pq.size() > 0) {
			ListNode curList = pq.poll();
			resultList.next = new ListNode(curList.val);
			resultList = resultList.next;
			if (curList.next != null) pq.add(curList.next);
		}
		return firstNode.next;
	}
	
	public void initialize(ListNode[] lists, PriorityQueue<ListNode> pq) {
		for (ListNode iList : lists) {
			if (iList != null) pq.add(iList);
		}
	}
}
