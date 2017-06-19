import java.util.Arrays;

public class MyQueue_Arrays {

	int array[];
	int first;
	int last;
	int size;

	public MyQueue_Arrays() {
		array = new int[5];
		first = -1;
		last = -1;
		size = 0;
	}

	public void enQueue(int element) {
		if (first == array.length-1) {
			int arrayIncrement[] = new int[array.length * 2];
			System.arraycopy(array, 0, arrayIncrement, 0, array.length);
			array = arrayIncrement;
		}

		array[++first] = element;
		size++;
	}

	public int deQueue() throws Exception {
		if (size == 0) {
			throw new Exception("No element to remove...!!!");

		}

		int temp = array[++last];
		array[last] = 0;
		size--;
		return temp;
	}

	public int peek() throws Exception {
		if (size == 0) {
			throw new Exception("No element to remove...!!!");

		}
		return array[first];
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public String toString() {

		return Arrays.toString(array);
	}

	public static void main(String[] args) throws Exception {
		
		MyQueue_Arrays mq = new MyQueue_Arrays();
		
		System.out.println(mq.isEmpty());
		System.out.println(mq.toString());
		mq.enQueue(9);
		mq.enQueue(5);
		mq.enQueue(7);
		mq.enQueue(3);
		System.out.println(mq.toString());
		mq.deQueue();
		System.out.println(mq.toString());
		mq.deQueue();
		System.out.println(mq.toString());
		mq.enQueue(9);
		System.out.println(mq.toString());
		mq.enQueue(99);
		System.out.println(mq.toString());
		mq.enQueue(999);
		System.out.println(mq.toString());
		mq.enQueue(9999);
		System.out.println(mq.toString());
		System.out.println(mq.peek());
		System.out.println(mq.isEmpty());
		

	}

}
