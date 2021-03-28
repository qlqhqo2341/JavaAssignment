package tc.wo.jeonghan.week4.assignment2;

import java.util.StringJoiner;

public class ListNode {
	private int value;
	private ListNode prev, next;

	public ListNode(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}
	
	public void setValue(int value) {
		this.value = value;
	}

	public ListNode getPrev() {
		return prev;
	}

	public void setPrev(ListNode prev) {
		this.prev = prev;
	}

	public ListNode getNext() {
		return next;
	}

	public void setNext(ListNode next) {
		this.next = next;
	}

	@Override
	public String toString() {
		return new StringJoiner(", ", ListNode.class.getSimpleName() + "[", "]")
			.add("value=" + value)
			.toString();
	}
}
