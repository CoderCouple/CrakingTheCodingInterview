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
		Node n = new Node(data);
		if (size == 0)
			tail = n;

		n.next = head;
		head = n;
		size++;
	}

	public void addAtTail(int data) {
		Node n = new Node();
		if (size == 0)
			head = n;

		tail.next = n;
		tail = n;
		n.data = data;
	}

	public void add(int data) {
		if (head == null && tail == null) {
			head = tail = new Node(data);
			size++;
			return;
		}

		Node n3 = new Node(data);
		tail.next = n3;
		tail = n3;
		size++;
	}

	public void add(int index, int data) throws Exception {
		if (index < 0 || index > size)
			throw new Exception("Index is invalid");
		if (index == 0) {
			addAtHead(data);
			return;
		}

		if (index == size) {
			addAtTail(data);
			return;
		}

		Node curr_ptr = head;
		Node next_ptr = curr_ptr.next;
		for (int i = 0; i < index - 1; i++) {
			curr_ptr = curr_ptr.next;
			next_ptr = curr_ptr.next;
		}
		Node n4 = new Node();
		n4.data = data;
		curr_ptr.next = n4;
		n4.next = next_ptr;
		size++;
	}

	public void removeAtHead() throws Exception {
		if (size == 0)
			throw new Exception("There is no element in the node..!!!");

		Node ptr;
		if (size == 1) {
			tail = null;
		}

		ptr = head;
		head = head.next;
		size--;
	}

	public void removeAtTail() throws Exception {
		if (size == 0)
			throw new Exception("There is no element in the node..!!!");
		

		Node curr_ptr = head;
		Node prev_ptr = null;

		for (int i = 1; i < size; i++) {
			prev_ptr = curr_ptr;
			curr_ptr = curr_ptr.next;
		}

		if (size == 1) {
			head = null;
		}
		tail = prev_ptr;
		if(tail!=null)
		tail.next=null;
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
			removeAtHead();
			return;
		}

		for (int i = 0; i <= index; i++) {
			prev_ptr = curr_ptr;
			curr_ptr = curr_ptr.next;
		}

		if (index == size) {
			removeAtTail();
			return;
		}

		prev_ptr.next = curr_ptr.next;

	}

	public void removeElement(int data) throws Exception {
		
		Node curr_ptr = head;
        Node prev_ptr = null;
        int count=0;
        
		while (curr_ptr != null) {
			prev_ptr=curr_ptr;	
			curr_ptr = curr_ptr.next;
			if(curr_ptr.data==data)
			{   
				prev_ptr.next=curr_ptr.next;
				size--;
				return;
			}
		}
		
		throw new Exception("No such element to remove...!!!");
		
	}

	public String toString() {
		Node ptr = head;
		StringBuilder sb = new StringBuilder("");

		while (ptr != null) {
			sb.append(ptr.data);
			sb.append(" ");
			ptr = ptr.next;

		}
		return sb.toString();
	}

	public boolean isEmpty() {
		if (head == tail && head == null && tail == null) {
			return true;
		}
		return false;
	}

	public int size() {
		int count = 0;
		Node ptr = head;
		while (ptr != null) {
			ptr = ptr.next;
			count++;
		}
		return count;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MyLinkedList l1 = new MyLinkedList();
		l1.add(6);
		l1.add(7);
		l1.add(3);

		System.out.println(l1);
		System.out.println(l1.size);
		try {
			l1.add(2, 99);
			l1.add(1,10);
			System.out.println(l1);
			l1.remove(0);
			l1.removeElement(99);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println(l1);

	}

}
