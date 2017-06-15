package Chapter2;

import java.net.PasswordAuthentication;
import java.util.HashSet;

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
			// System.out.println(ptr1.data);
			// System.out.println(ptr2.data);

			while (ptr2 != null) {
				if (ptr1.data == ptr2.data) {
					// System.out.println(true);
					ptr1.next = ptr2.next;
					// ptr2.next=null;
					size--;
				}
				// System.out.println(false);
				ptr2 = ptr2.next;
			}
			if (ptr1.next == null)
				return;
			ptr1 = ptr1.next;
		}

	}

	public void removeDuplicatesByHashTable() {
		Node prev = null;
		Node curr = head;
		HashSet<Integer> table = new HashSet<Integer>();
		while (curr != null) {
			if (table.contains(curr.data)) {
				prev.next = curr.next;
				size--;
			} else {
				table.add(curr.data);

				prev = curr;
			}
			curr = curr.next;
		}

	}

	public Node getNthNode(int n) throws Exception {
		if (n > size)
			throw new Exception("Nuber is greater than the size of the linked list");

		Node ptr = head;
		int count = 0;
		while (ptr != null) {
			count++;
			if (count == n)
				return ptr;

			ptr = ptr.next;

		}

		return ptr;
	}

	public void deleteNthNode(Node ptr) throws Exception {

		if (head == null && tail == null) {
			throw new Exception("There is no element to remove...!!!");
		}

		Node curr_ptr = head;
		Node prev_ptr = null;
		
		if(head==ptr || tail==ptr){throw new Exception("Can Not Remove the first and last element...!!!");}

		while (curr_ptr != null) {

			if (ptr.data == curr_ptr.data && ptr.next == curr_ptr.next) {
				prev_ptr.next = curr_ptr.next;
				curr_ptr.next = null;
			}

			prev_ptr = curr_ptr;
			curr_ptr = curr_ptr.next;
		}

	}

	
	public void deleteNthNodeWithoutAccessToHead(Node ptr) throws Exception {

		if (head == null && tail == null) {
			throw new Exception("There is no element to remove...!!!");
		}
		
		if(head==ptr || tail==ptr){throw new Exception("Can Not Remove the first and last element...!!!");}

		Node prev_ptr = ptr;
		Node curr_ptr = prev_ptr.next;
		
		prev_ptr.data=curr_ptr.data;
		prev_ptr.next=curr_ptr.next;
		curr_ptr.next=null;
	}

	
	public int getKthElement(int k) throws Exception {

		if (size < k)
			throw new Exception("Insufficient elements!");
		int m = k;
		Node fastPtr = head;
		Node slowPtr = null;

		while (fastPtr != null) {
			fastPtr = fastPtr.next;

			if (m > 0) {
				m--;
			}

			if (m == 0) {
				slowPtr = head;
				m--;
			} else if (m == -1) {
				slowPtr = slowPtr.next;
			}

		}

		return slowPtr.data;
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

		// l1.removeDuplicates();
		// l1.removeDuplicatesByHashTable();

		/*
		 * try { System.out.println(l1.getKthElement(6)); } catch (Exception e)
		 * { // TODO Auto-generated catch block e.printStackTrace(); }
		 */

		try {
			l1.deleteNthNodeWithoutAccessToHead(l1.getNthNode(4));
			System.out.println(l1);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
