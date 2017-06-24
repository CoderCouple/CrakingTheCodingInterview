import java.util.Arrays;

public class MyQueue_LinkedList {

	Node head;
	Node tail;
	int size;

	public MyQueue_LinkedList() {
		head = null;
		tail = null;
		size = 0;
	}

	public void addAtHead(int data) {
		Node newNode = new Node(data);

		if (head == null && tail == null) {
			head = newNode;
			tail = newNode;
			size++;
		}

		newNode.next = head;
		head = newNode;
		size++;
	}

	public void addAtTail(int data) {
		Node newNode = new Node(data);

		if (head == null && tail == null) {
			head = newNode;
			tail = newNode;
			size++;
		}

		tail.next = newNode;
		tail = newNode;
		size++;
	}

	public int removeFromHead() throws Exception {

		if (head == null && tail == null) {
			throw new Exception("No node to remove");
		}

		if (size == 1) {
			tail = null;
			head = null;
			return head.data;
		}

		Node ptr = head;
		int temp = head.data;
		head = head.next;
		ptr.next = null;
		size--;
		return temp;

	}

	public int removeFromTail() throws Exception {

		if (head == null && tail == null) {
			throw new Exception("No node to remove");
		}

		Node curr_ptr = head;
		Node prev_ptr = null;

		while (curr_ptr.next != null) {
			prev_ptr = curr_ptr;
			curr_ptr = curr_ptr.next;

		}

		if (size == 1) {
			head = null;
			tail = null;
			return tail.data;
		}

		int temp = tail.data;
		tail = prev_ptr;
		prev_ptr.next = null;
		size--;
		return temp;
	}

	public void enQueue(int element) {
		addAtTail(element);
	}

	public int deQueue() throws Exception {
		int result = removeFromHead();
		return result;
	}

	public int peek() throws Exception {

		if (head == null && tail == null) {
			throw new Exception("No node to peek at ...!!!");
		}

		return tail.data;

	}

	public boolean isEmpty() {
		return size == 0;

	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		Node ptr = head;

		while (ptr != null) {
			sb.append(ptr.data);
			sb.append(" ");
			ptr = ptr.next;
		}

		return sb.toString();
	}

	public static void main(String[] args) throws Exception {
		
		MyStack_LinkedList msl= new MyStack_LinkedList();
		msl.push(1);
		msl.push(5);
		msl.push(3);
		System.out.println(msl);
		msl.pop();
		System.out.println(msl);
		System.out.println(msl.peek());
		msl.push(9);
		msl.push(99);
		msl.push(999);
		System.out.println(msl);
		

}

}
