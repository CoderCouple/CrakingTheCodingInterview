package Chapter3;

import java.util.Stack;

public class SortStack {

	public Stack<Integer> getSortedStack(Stack<Integer> original) {
		Stack<Integer> tempStack = new Stack<Integer>();

		while (!original.isEmpty()) {
			int tempData = original.pop();

			while (!tempStack.isEmpty() && tempStack.peek() > tempData) {
				original.push(tempStack.pop());
			}
			tempStack.push(tempData);
		}

		while (!tempStack.isEmpty()) {
			original.push(tempStack.pop());

		}

		return original;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Stack<Integer> s = new Stack<Integer>();

		s.add(3);
		s.add(5);
		s.add(7);
		s.add(9);
		s.add(5);
		s.add(-1);

		System.out.println(s);
		SortStack ss = new SortStack();
		Stack<Integer> output = ss.getSortedStack(s);
		System.out.println(output);

	}

}
