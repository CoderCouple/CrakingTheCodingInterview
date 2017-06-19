import java.util.Arrays;
import java.util.Stack;

class MyStack_Arrays {

	public int array[];
	public int top;
	public int size;

	public MyStack_Arrays() {
		array = new int[5];
		top = -1;
		size = 0;
	}

	public void push(int element) {

		if (size == array.length) {
			int arrayIncrement[] = new int[size * 2];
			System.arraycopy(array, 0, arrayIncrement, 0, size);
			array = arrayIncrement;
		}

		array[++top] = element;
		size++;
	}

	public int pop() throws Exception {

		if (size == 0) {
			throw new Exception("No element to remove...!!!");
		}
		int temp=array[top];
		array[top]=0;
		size--;
		top--;
		return temp;
	}

	public int peek() throws Exception {

		if (size == 0) {
			throw new Exception("No element to remove...!!!");
		}

		return array[top];
	}

	public boolean isEmpty() {

		return size == 0;
	}

	public String toString(){
	
			return Arrays.toString(array);
	
	}
	
	public static void main(String[] args) throws Exception {

		/*
		 * Stack s = new Stack(); s.add(5); s.add(3); s.add(2);
		 * System.out.println(s.peek());
		 */
		
		MyStack_Arrays ms = new MyStack_Arrays();
		System.out.println(ms.isEmpty());
		System.out.println(ms.toString());
		ms.push(1);
		ms.push(4);
		ms.push(3);
		ms.push(99);
		ms.push(999);
		System.out.println(ms.toString());
		System.out.println(ms.pop());
		System.out.println(ms.toString());
		System.out.println(ms.pop());
		System.out.println(ms.toString());
		ms.push(3);
		ms.push(99);
		ms.push(999);
		ms.push(9999);
		System.out.println(ms.toString());
		System.out.println(ms.peek());
		System.out.println(ms.toString());
		System.out.println(ms.isEmpty());
		System.out.println(ms.toString());

	}

}
