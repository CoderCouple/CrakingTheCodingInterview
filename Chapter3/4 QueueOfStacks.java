package Chapter3;

import java.util.Stack;

public class QueueOfStacks {

	Stack<Integer> s1 = new Stack<Integer>();
	Stack<Integer> s2 = new Stack<Integer>();
	int size;

	public QueueOfStacks() {
		size = 0;

	}

	public void push(int element) {

		s1.push(element);
		size++;
	}

	public int pop() {
		reverseStack(s1, s2);
		int popvalue = s2.pop();
		reverseStack(s2, s1);
		size--;
		return popvalue;
	}

	public void reverseStack(Stack original, Stack reversed) {
		while (!original.isEmpty()) {
			reversed.push(original.pop());
		}

	}

	public int size() {
		return size;
	}

	public int peek() {
		reverseStack(s1, s2);
		int peekValue = s2.peek();
		reverseStack(s1, s2);
		return peekValue;
	}

	public String toString() {

		StringBuilder sb = new StringBuilder();
		while (!s1.isEmpty()) {
			sb.append(s1.pop());
			sb.append(" ");
		}
		return sb.toString();
	}

	public static void main(String[] args) {

		QueueOfStacks qs = new QueueOfStacks();
		qs.push(1);
		qs.push(2);
		qs.push(3);
		// qs.pop();
		// System.out.println(qs);
		System.out.println(qs.pop());
		qs.push(9);
		System.out.println(qs.pop());
		System.out.println(qs.pop());
		qs.push(99);
		qs.push(999);
		qs.push(9999);
		System.out.println(qs.peek());
		System.out.println(qs.size());
		// System.out.println(qs);

	}

}
