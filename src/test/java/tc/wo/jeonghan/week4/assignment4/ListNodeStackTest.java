package tc.wo.jeonghan.week4.assignment4;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ListNodeStackTest {
	private ListNodeStack s;

	@Before
	public void prepare() {
		s = new ListNodeStack();
	}

	@Test
	public void oneTest() {
		s.push(1);
		assertEquals(1, s.pop());
	}

	@Test
	public void twoTest() {
		s.push(1);
		s.push(2);
		assertEquals(2, s.pop());
		assertEquals(1, s.pop());
	}

	@Test
	public void largeTest() {
		s.push(1);
		s.push(2);
		s.push(3);
		s.push(4);
		s.push(5);
		s.push(6);
		s.push(7);
		s.push(8);
		s.push(9);
		assertEquals(9, s.pop());
		assertEquals(8, s.pop());
		assertEquals(7, s.pop());
		assertEquals(6, s.pop());
		assertEquals(5, s.pop());
		assertEquals(4, s.pop());
		assertEquals(3, s.pop());
		assertEquals(2, s.pop());
		assertEquals(1, s.pop());
	}

	@Test
	public void mixTest() {
		s.push(1);
		s.pop();
		s.push(2);
		s.push(3);
		s.push(4);
		s.push(5);
		s.push(6);
		s.push(7);
		s.push(8);
		s.push(9);
		assertEquals(9, s.pop());
		assertEquals(8, s.pop());
		assertEquals(7, s.pop());
		assertEquals(6, s.pop());
		assertEquals(5, s.pop());
		assertEquals(4, s.pop());
		assertEquals(3, s.pop());
		assertEquals(2, s.pop());
	}
}
