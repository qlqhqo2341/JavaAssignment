package tc.wo.jeonghan.week4.assignment2;

public class LinkedListUtils {

	public static ListNode add(ListNode head, ListNode nodeToAdd, int position) {
		if (head == null || nodeToAdd == null) {
			return null;
		}
		ListNode prevTarget = head.getPrev();
		ListNode currentTarget = head;
		int remainPositions = position;
		while(remainPositions > 0 && currentTarget != null) {
			prevTarget = currentTarget;
			currentTarget = currentTarget.getNext();
			remainPositions--;
		}
		
		// connect prevTarget - nodeToAdd
		if (prevTarget != null) {
			prevTarget.setNext(nodeToAdd);
		}
		nodeToAdd.setPrev(prevTarget);

		// connect nodeToAdd - target
		if (currentTarget != null)
			currentTarget.setPrev(nodeToAdd);
		nodeToAdd.setNext(currentTarget);
		
		return nodeToAdd;
	}

	public static ListNode remove(ListNode head, int positionToRemove) {
		if (head == null) {
			return null;
		}
		ListNode target = head;
		int remainPositions = positionToRemove;
		while(remainPositions > 0 && target.getNext() != null) {
			target = target.getNext();
			remainPositions--;
		}
		
		if (remainPositions > 0) {
			return null;
		}
		
		ListNode currentPrevNode = target.getPrev();
		ListNode currentNextNode = target.getNext();
		
		if (currentPrevNode != null) {
			currentPrevNode.setNext(currentNextNode);
		}
		
		if (currentNextNode != null) {
			currentNextNode.setPrev(currentPrevNode);
		}
		
		return target;
	}
	
	public static boolean contains(ListNode head, ListNode nodeTocheck){
		ListNode target = head;
		while (target != null){
			if (target == nodeTocheck) {
				return true;
			}
			target = target.getNext();
		};
		return false;
	}
	
}

