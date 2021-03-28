package tc.wo.jeonghan.week4.assignment4;

import tc.wo.jeonghan.week4.assignment2.ListNode;

public class ListNodeStack {
	private ListNode tail;

	public void push(int data) {
		ListNode newData = new ListNode(data);
		if (tail == null) {
			tail = newData;
		} else {
			tail.setNext(newData);
			newData.setPrev(tail);
			
			tail = newData;
		}
	}
	public int pop() {
		if (tail == null) {
			return 0;
		}
		int tailValue = tail.getValue();
		ListNode prevNode = tail.getPrev();
		if (prevNode != null) {
			prevNode.setNext(null);
		}

		tail = prevNode;
		return tailValue;
	}
}
