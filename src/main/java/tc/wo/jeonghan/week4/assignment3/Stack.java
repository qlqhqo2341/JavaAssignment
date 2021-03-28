package tc.wo.jeonghan.week4.assignment3;

public class Stack {
	private int[] array;
	private int size;
	
	public Stack() {
		this.array = new int[1];
		this.size = 0;
	}
	
	public void push(int v) {
		if (this.array.length == this.size) {
			this.extendsArray();
		}
		this.array[this.size] = v;
		this.size++;
	}
	
	public int pop() {
		if (this.size == 0) {
			return 0;
		}
		this.size--;
		return this.array[this.size];
	}
	
	private void extendsArray(){
		int newSize = this.size * 2;
		int[] newArray = new int[newSize];
		for (int i = 0 ; i < this.size ; i++) {
			newArray[i] = this.array[i];
		}
		array = newArray;
	}
}
