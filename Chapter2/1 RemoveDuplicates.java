package Chapter2;

public class MyLinkedList {

	Node head;
	Node tail;
	int size;

	public MyLinkedList() {
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

	public void add(int data) {
		Node newNode = new Node(data);

		if (head == null && tail == null) {
			head = newNode;
			tail = newNode;
			size++;
			return;
		}

		tail.next = newNode;
		tail = newNode;
		size++;
	}

	public void add(int index, int data) throws Exception {
		if (index < 0 || index > size)
			throw new Exception("Invalid Index");

		if (index == 0) {
			addAtHead(data);
			return;
		}
		if (index == size) {
			addAtTail(data);
			return;
		}

		Node curr_ptr = head;
		Node next_ptr = head.next;
		int count = 0;
		Node newNode = new Node(data);

		while (count != index) {
			curr_ptr = next_ptr;
			next_ptr = next_ptr.next;
			count++;
		}

		curr_ptr.next = newNode;
		newNode.next = next_ptr;
		size++;
	}

	public void removeFromHead() throws Exception {

		if (head == null && tail == null) {
			throw new Exception("No node to remove");
		}

		if (size == 1) {
			tail = null;
			head = null;
			return;
		}

		Node ptr = head;
		head = head.next;
		ptr.next = null;
		size--;

	}

	public void removeFromTail() throws Exception {

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
			return;
		}

		tail = prev_ptr;
		prev_ptr.next = null;
		size--;

	}

	public void remove(int index) throws Exception {
		if (index < 0 || index >= size)
			throw new Exception("Invalid index");
		if (head == null && tail == null) {
			throw new Exception("There is no element to remove...!!!");
		}
		size--;

		Node curr_ptr = head;
		Node prev_ptr = null;

		if (index == 0) {
			removeFromHead();
			return;
		}

		for (int i = 0; i <= index; i++) {
			prev_ptr = curr_ptr;
			curr_ptr = curr_ptr.next;
		}

		if (index == size) {
			removeFromTail();
			return;
		}

		prev_ptr.next = curr_ptr.next;

	}

	public void removeElement(int data) throws Exception {

		Node curr_ptr = head;
		Node prev_ptr = null;
		int count = 0;

		while (curr_ptr != null) {
			prev_ptr = curr_ptr;
			curr_ptr = curr_ptr.next;
			if (curr_ptr.data == data) {
				prev_ptr.next = curr_ptr.next;
				size--;
				return;
			}
		}

		throw new Exception("No such element to remove...!!!");

	}

	public int size() {
		int count = 0;
		Node ptr = head;

		while (ptr.next != null) {
			ptr = ptr.next;
			count++;
		}

		return count;
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

	public void removeDuplicates() {

		Node ptr1 = head;

		while (ptr1.next != null) {
			Node ptr2 = ptr1.next;
			//System.out.println(ptr1.data);
			//System.out.println(ptr2.data);

			while (ptr2 != null) {
				if (ptr1.data == ptr2.data) {
					//System.out.println(true);
					ptr1.next = ptr2.next;
					// ptr2.next=null;
					size--;
				}
				//System.out.println(false);
				ptr2 = ptr2.next;
			}
			if (ptr1.next == null)
				return;
			ptr1 = ptr1.next;
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MyLinkedList l1 = new MyLinkedList();
		l1.add(1);
		l1.add(1);
		l1.add(2);
		l1.add(3);
		l1.add(4);
		l1.add(4);
		System.out.println(l1);

		l1.removeDuplicates();
		System.out.println(l1);

	}

}
