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
		if (size == array.length) {
			int arrayIncrement[] = new int[size * 2];
			System.arraycopy(array,first+1, arrayIncrement,0, array.length-first-1);
			//System.out.println("check this one:"+Arrays.toString(arrayIncrement));
			System.arraycopy(array,0, arrayIncrement,array.length-first-1,last-0+1);
			//System.out.println("check this two:"+Arrays.toString(arrayIncrement));
			array = arrayIncrement;
			first=size-1;
			last=0;
		}
		first=++first%array.length;
		array[first] = element;
		size++;
	}

	public int deQueue() throws Exception {
		if (size == 0) {
			throw new Exception("No element to remove...!!!");

		}
		last=++last%array.length;
		System.out.println("last :"+last);
		int temp = array[last];
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
		//System.out.println(mq.first);
		//System.out.println(mq.last);
		mq.enQueue(9);
		mq.enQueue(5);
		mq.enQueue(7);
		mq.enQueue(3);
		mq.enQueue(5);
		System.out.println(mq.toString());
		//System.out.println(mq.first);
		//System.out.println(mq.last);
		mq.deQueue();
		System.out.println(mq.toString());
		//System.out.println(mq.first);
		//System.out.println(mq.last);
		mq.enQueue(90);
		System.out.println(mq.toString());
		//System.out.println(mq.first);
		//System.out.println(mq.last);
		mq.deQueue();
		mq.deQueue();
		mq.deQueue();
		System.out.println("this :"+mq.toString());
		//System.out.println(mq.first);
		//System.out.println(mq.last);
		mq.deQueue();
		System.out.println(mq.toString());
		//System.out.println(mq.first);
		//System.out.println(mq.last);
		mq.enQueue(9);
		System.out.println(mq.toString());
		//System.out.println(mq.first);
		//System.out.println(mq.last);
		mq.enQueue(99);
		System.out.println(mq.toString());
		//System.out.println(mq.first);
		//System.out.println(mq.last);
		mq.enQueue(999);
		System.out.println(mq.toString());
		//System.out.println(mq.first);
		//System.out.println(mq.last);
		mq.enQueue(9999);
		System.out.println(mq.toString());
		System.out.println(mq.first);
		System.out.println(mq.last);
		System.out.println(mq.peek());
		System.out.println(mq.isEmpty());
		System.out.println(mq.first);
		System.out.println(mq.last);
		
	}

}
