package tc.wo.jeonghan.week4.assignment5;

import tc.wo.jeonghan.week4.assignment2.ListNode;

public class ListNodeQueue {
	private ListNode head;
	private ListNode tail;
	
	public void push(int v) {
		ListNode newData = new ListNode(v);
		if (tail == null) {
			tail = newData;
			head = newData;
		} else {
			tail.setNext(newData);
			newData.setPrev(tail);
			
			tail = newData;
		}
	}
	
	public int pop() {
		if (head == null) {
			return 0;
		}
		int returnValue = head.getValue();
		head = head.getNext();
		if (head == null) {
			tail = null;
		}
		return returnValue;
	}
}
