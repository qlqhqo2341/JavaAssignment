package tc.wo.jeonghan.week4.assignment5;

public class Queue {
	private int[] array;
	private int front;
	private int back;

	public Queue() {
		this.array = new int[1];
		this.front = 0;
		this.back = 0;
	}
	
	public int pop() {
		if (front >= back) {
			return 0;
		} else {
			int returnValue = array[front];
			front++;
			return returnValue;
		}
	}
	
	public void push(int v) {
		if (array.length == back) {
			extendsArray();
		}
		array[back] = v;
		back++;
	}
	
	private void extendsArray() {
		int gap = (back - front);
		int newSize = (gap == 0) ? 1 : gap * 2;
		int[] newArray = new int[newSize];
		for(int prevI=front, newI=0 ; prevI<back ; prevI++,newI++) {
			newArray[newI] = array[prevI];
		}
		array = newArray;
		front = 0;
		back = gap;
	}
}
