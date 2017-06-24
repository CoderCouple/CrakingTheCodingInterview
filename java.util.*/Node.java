public class Node {
	int data;
	Node next;

	public Node() {
	}

	public Node(int data) {
		this.data = data;
	}

	public Node(Node next, int data) {
		this.data = data;
		this.next = next;
	}
}
