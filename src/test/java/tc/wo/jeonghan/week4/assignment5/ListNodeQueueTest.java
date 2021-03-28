package tc.wo.jeonghan.week4.assignment5;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ListNodeQueueTest {
	private ListNodeQueue queue;
	
	@Before
	public void prepare() {
		queue = new ListNodeQueue();
	}

	@Test
	public void oneTest() {
		queue.push(1);
		assertEquals(1, queue.pop());
	}

	@Test
	public void twoTest() {
		queue.push(1);
		queue.push(2);
		assertEquals(1, queue.pop());
		assertEquals(2, queue.pop());
	}
	
	@Test
	public void largeTest() {
		queue.push(1);
		queue.push(2);
		queue.push(3);
		queue.push(4);
		queue.push(5);
		queue.push(6);
		queue.push(7);
		queue.push(8);
		queue.push(9);
		assertEquals(1, queue.pop());
		assertEquals(2, queue.pop());
		assertEquals(3, queue.pop());
		assertEquals(4, queue.pop());
		assertEquals(5, queue.pop());
		assertEquals(6, queue.pop());
		assertEquals(7, queue.pop());
		assertEquals(8, queue.pop());
		assertEquals(9, queue.pop());
	}

	@Test
	public void mixTest() {
		queue.push(1);
		queue.push(2);
		queue.pop();
		queue.pop();
		queue.push(3);
		queue.push(4);
		queue.push(5);
		queue.push(6);
		queue.pop();
		queue.push(7);
		queue.push(8);
		queue.push(9);
		assertEquals(4, queue.pop());
		assertEquals(5, queue.pop());
		assertEquals(6, queue.pop());
		assertEquals(7, queue.pop());
		assertEquals(8, queue.pop());
		assertEquals(9, queue.pop());
	}
}
