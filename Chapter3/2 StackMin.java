package Chapter3;

import java.util.Arrays;

public class StackMin {

	int top;
	int array[];
	int size = 0;
	int min[] = new int[5];
	int minPtr = -1;

	public StackMin() {
		top = -1;
		size = 0;
		array = new int[5];
	}

	public void push(int element) {
		if (size == array.length) {
			int ArrayIncrement[] = new int[size * 2];
			System.arraycopy(array, 0, ArrayIncrement, 0, size);
			array = ArrayIncrement;
		}
		
		if(minPtr==min.length-1){
			int minIncrement[] = new int[min.length * 2];
			System.arraycopy(min, 0, minIncrement, 0, min.length);
			min = minIncrement;
		}
			
		if (size == 0) {
			min[++minPtr] = element;
		} else if (element < min[minPtr]) {
			min[++minPtr] = element;
		}
		
		array[++top] = element;
		size++;
	}

	public int pop() throws Exception {

		if (size == 0) {
			throw new Exception("Cannot pop elements out of an empty Stack...!!!");
		}

		int temp = array[top];
		
		if(temp==min[minPtr]){
			min[minPtr]=0;
			minPtr--;
		}
		top--;
		size--;
		return temp;

	}

	public int peak() throws Exception {
		if (size == 0) {
			throw new Exception("Cannot pea elements out of an empty Stack...!!!");
		}
		return array[top];
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public String toString() {
		return Arrays.toString(array);
	}
	
	
	public int getMinimum() {
		return min[minPtr];
	}

	public String toString1() {
		return Arrays.toString(min);
	}
	
	public static void main(String[] args) {

		StackMin sm = new StackMin();
		sm.push(5);
		sm.push(6);
		sm.push(7);
		System.out.println(sm);
		System.out.println(sm.getMinimum());
		sm.push(4);
		sm.push(9);
		sm.push(11);
		System.out.println(sm);
		System.out.println(sm.getMinimum());
		System.out.println(sm.min[0]);
		System.out.println(sm.min[1]);
		sm.push(3);
		System.out.println(sm.getMinimum());
		sm.push(2);
		System.out.println(sm.getMinimum());
		sm.push(1);
		System.out.println(sm.getMinimum());
		sm.push(0);
		sm.push(-1);
		System.out.println(sm);
		System.out.println(sm.min.length);
		System.out.println(sm.toString1());
	}

}
