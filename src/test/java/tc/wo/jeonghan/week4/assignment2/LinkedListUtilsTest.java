package tc.wo.jeonghan.week4.assignment2;

import static org.junit.Assert.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Before;
import org.junit.Test;

public class LinkedListUtilsTest {
	
	private List<ListNode> listNodeList;
	private ListNode head;
	private ListNode tail;
	private ListNode newListNode;
	
	@Before
	public void prepare() {
		listNodeList = makeList(0,1,2,3,4,5,6);
		head = listNodeList.get(0);
		tail = listNodeList.get(listNodeList.size() - 1);
		
		newListNode = new ListNode(-1);
	}
	
	@Test
	public void listCheck() {
		ListNode node = head;
		while (node.getNext() != null) {
			node = node.getNext();
		}
		
		assertEquals(tail, node);

		while (node.getPrev() != null) {
			node = node.getPrev();
		}
		assertEquals(head, node);
	}

	@Test
	public void add0Test() {
		LinkedListUtils.add(head, newListNode, 0);
		
		assertEquals(newListNode, head.getPrev());
		
		assertEquals(head, newListNode.getNext());
		assertEquals(head.getPrev(), newListNode);
	}
	
	@Test
	public void add1Test() {
		LinkedListUtils.add(head, newListNode, 1);
		
		assertEquals(newListNode, head.getNext());
		
		assertEquals(head, newListNode.getPrev());
	}
	
	@Test
	public void add2Test() {
		LinkedListUtils.add(head, newListNode, 2);
		assertEquals(newListNode, head.getNext().getNext());
		assertEquals(newListNode, head.getNext().getNext().getNext().getPrev());
	}
	
	@Test
	public void add3Test() {
		LinkedListUtils.add(head, newListNode, 3);
		assertEquals(newListNode, head.getNext().getNext().getNext());
		assertEquals(newListNode, head.getNext().getNext().getNext().getNext().getPrev());
		
		assertEquals(head.getNext().getNext(), newListNode.getPrev());
	}
	
	@Test
	public void remove0Test() {
		ListNode willHead = head.getNext();
		LinkedListUtils.remove(head, 0);
		assertEquals(null, willHead.getPrev());
	}
	
	@Test
	public void remove1Test() {
		ListNode willAt1 = head.getNext().getNext();
		LinkedListUtils.remove(head, 1);
		
		assertEquals(willAt1, head.getNext());
		assertEquals(head, willAt1.getPrev());
	}
	
	@Test
	public void removeLastTest() {
		ListNode willLastNode = tail.getPrev();
		LinkedListUtils.remove(head, listNodeList.size() - 1);
		
		assertEquals(null, willLastNode.getNext());
	}
	
	@Test
	public void containsNotTest() {
		ListNode at1 = head.getNext();
		assertFalse(LinkedListUtils.contains(at1, head));
	}

	@Test
	public void containsHeadTest() {
		assertTrue(LinkedListUtils.contains(head, head));
	}

	@Test
	public void containsNodeTest() {
		assertTrue(LinkedListUtils.contains(head, head.getNext()));
	}

	@Test
	public void containsTailTest() {
		assertTrue(LinkedListUtils.contains(head, tail));
	}
	
	private static List<ListNode> makeList(Integer... lis) {
		List<ListNode> listNodes = Stream.of(lis)
			.map(ListNode::new)
			.collect(Collectors.toList());
		
		if (listNodes.size() == 0) {
			return null;
		}
		
		ListNode last = null;
		for (ListNode listNode : listNodes) {
			if (last == null) {
				last = listNode;
			} else {
				LinkedListUtils.add(last, listNode, 1);
				last = listNode;
			}
		}
		
		return listNodes;
	}
}
