package Chapter3;

import java.util.Stack;

public class StackOfPlates {

	Stack<Stack> listOfStacks = new Stack<Stack>();
	int size;
	int totalelemnt=0;
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
		totalelemnt++;
	}

	public void pop() {
		if (!stkptr.isEmpty()) {
			stkptr.pop();
			size--;
			totalelemnt--;
		} else {
			listOfStacks.pop();
			size = threshold;
			stkptr = listOfStacks.peek();
			stkptr.pop();
			size--;
			totalelemnt--;
		}

	}

	
	
	public int popAtindex(int index) throws Exception {
		Stack mystkptr = null;
		int result = -1;
		int listPop = (int) Math.ceil(index / (float)threshold);
		
		System.out.println(listPop);
		int stkPop = index % threshold;
		System.out.println(stkPop);
		
		if(index>totalelemnt)
		throw new Exception("No element to remove at this index...!!!");
		
		for (int i = 0; i < listPop; i++) {
			System.out.println("Element Removed: "+i);
			mystkptr = listOfStacks.pop();
			System.out.println(mystkptr);
		}

		if (stkPop == 0) {
			while (!mystkptr.isEmpty()) {
				result = (int) mystkptr.pop();
			}
		} else
			for (int j = 0; j < stkPop; j++) {
				result = (int) mystkptr.pop();
			}

		return result;
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

	public static void main(String[] args) throws Exception {

		StackOfPlates sp = new StackOfPlates(2);
		sp.push(5);
		sp.push(6);
		sp.push(7);
		sp.push(8);
		sp.push(9);
		sp.push(10);
		// sp.tomyString();
		System.out.println(sp.listOfStacks);
		sp.pop();
		sp.pop();
		sp.pop();
		sp.pop();
		System.out.println(sp.listOfStacks);
		System.out.println(sp.popAtindex(2));
		sp.tomyString();
	}

}
