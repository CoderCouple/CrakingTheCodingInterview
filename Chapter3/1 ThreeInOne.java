package Chapter3;

import java.util.Arrays;

public class ThreeInOne {

	int stackCount = 3;
	int stackCapacity;
	int stack[];
	int size[];

	public ThreeInOne(int stackSize) {
		stackCapacity = stackSize;
		stack = new int[stackCapacity * stackCount];
		size = new int[stackCount];

	}

	public void push(int stackNumber, int element) throws Exception {

		if (isFull(stackNumber)) {
			int newStack [] = new int [stack.length*3];
			System.arraycopy(stack, 0*stack.length/3, newStack, 0*stack.length, stack.length/3);
			System.arraycopy(stack, 1*stack.length/3, newStack, 1*stack.length, stack.length/3);
			System.arraycopy(stack, 2*stack.length/3, newStack, 2*stack.length, stack.length/3);
			stackCapacity=stack.length;
			stack=newStack;
		}

		size[stackNumber]++;
		//System.out.println(" * "+indexOfTop(stackNumber));
		stack[indexOfTop(stackNumber)] = element;


	}

	public int pop(int stackNumber) throws Exception {
		if (isEmpty(stackNumber)) {
			throw new Exception("Stack is Empty...!!!");
		}
		int index = indexOfTop(stackNumber);
		int value = stack[index];
		stack[index] = 0;
		size[stackNumber]--;
		return value;
	}

	public int peek(int stackNumber) throws Exception {
		if (isEmpty(stackNumber)) {
			throw new Exception("Stack is Empty...!!!");
		}

		return stack[indexOfTop(stackNumber)];

	}

	private boolean isEmpty(int stackNumber) {
		
		return size[stackNumber]==0;
	}

	private int indexOfTop(int stackNumber) {
		
		int offset=stackNumber*stackCapacity;
		int sizes=size[stackNumber];
		//System.out.println("this 0 "+stackCapacity);
		//System.out.println("this 1 "+offset);
		//System.out.println("this 2 "+sizes);
		return offset+sizes-1;
	}

	private boolean isFull(int stackNumber) {

		return size[stackNumber]==stackCapacity;
	}

	public String toString(){
		
		return Arrays.toString(stack);
	}
	
	public static void main(String[] args) throws Exception {

		ThreeInOne stack = new ThreeInOne(2);
		stack.push(0, 15);
		stack.push(1, 25);
		stack.push(2, 35);
		
		System.out.println(stack);
		
		stack.push(0, 16);
		stack.push(1, 26);
		stack.push(2, 36);
		
		System.out.println(stack);
		
		stack.push(0, 17);
		stack.push(1, 27);
		stack.push(2, 37);
		
		System.out.println(stack);
		
		
		
	}

}
