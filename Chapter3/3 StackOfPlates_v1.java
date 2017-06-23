package Chapter3;

import java.util.Stack;

public class StackOfPlates {

	Stack<Stack> listOfStacks = new Stack<Stack>();
	int size;
	int threshold;
	Stack stkptr;

	public StackOfPlates(int threshold) {
		Stack s = new Stack();
		size = 0;
		this.threshold = threshold;
		listOfStacks.push(s);
		stkptr = s;
	}

	public void push(int element) {
		// System.out.println(threshold);

		if (size == threshold) {
			Stack newStack = new Stack();
			listOfStacks.push(newStack);
			stkptr = newStack;
			size = 0;

		}
		stkptr.push(element);
		size++;
	}

	public void pop() {
		if(!stkptr.isEmpty()){
			stkptr.pop();
			size--;
		}
		else{
			listOfStacks.pop();
			size=threshold;
			stkptr=listOfStacks.peek();
			stkptr.pop();
			size--;
		}
		
	
	

	}

	public void tomyString() {

		while (!listOfStacks.isEmpty()) {
			System.out.println("*" + listOfStacks.peek());
			Stack test = listOfStacks.pop();
			while (!test.isEmpty()) {

				System.out.println(test.pop());
			}
		}

	}

	public static void main(String[] args) {

		StackOfPlates sp = new StackOfPlates(2);
		sp.push(5);
		sp.push(6);
		sp.push(7);
		sp.push(8);
		sp.push(9);
		sp.push(10);
		//sp.tomyString();
		System.out.println(sp.listOfStacks);
		sp.pop();
		sp.pop();
		sp.pop();
		sp.pop();
		System.out.println(sp.listOfStacks);
		//sp.tomyString();
	}

}
