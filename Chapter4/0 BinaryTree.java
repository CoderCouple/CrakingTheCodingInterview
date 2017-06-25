
public class BinaryTree {

	TNode root;

	public BinaryTree() {
		root = null;
	}

	public void add(int element) {
		TNode n = new TNode(element);
		if (root == null) {
			root = n;
			return;
		}

		TNode ptr = root;
		TNode parent = ptr;
		boolean isLeft = true;

		while (ptr != null) {
			parent = ptr;
			if (element <= ptr.data) {
				ptr = ptr.leftChild;
				isLeft = true;
			} else {
				ptr = ptr.rightChild;
				isLeft = false;
			}
		}

		if (isLeft)
			parent.leftChild = n;
		else
			parent.rightChild = n;
	}

	public boolean search(int element) {
		if (root == null) {
			return false;
		}

		TNode ptr = root;
		TNode parent = ptr;
		boolean isLeft = true;

		while (ptr != null) {
			parent = ptr;

			if (element == ptr.data) {
				return true;
			} else if (element < ptr.data) {
				ptr = ptr.leftChild;
				isLeft = true;
			} else {
				ptr = ptr.rightChild;
				isLeft = false;
			}
		}

		return false;

	}

	public boolean remove(int element) {

		if (root == null) {
			return false;
		}

		// case 1 : root is element
		if (root.data == element) {
			if (root.rightChild == null) {
				root = root.leftChild;
				return true;
			}

			if (root.leftChild == null) {
				root = root.rightChild;
				return true;
			}

			// mainDelete(root);

		}

		TNode current = root;
		TNode parent = null;
		while (current != null) {
			parent = current;
			if (current.data == element) {
				break;
			}

			if (current.data < element) {
				current = current.rightChild;

			} else {
				current = current.leftChild;
			}

		}

		// Reached theend of the tree but did not find the element
		if (current == null) {
			return false;
		}

		// case2: deleting the leaf node

		if (current.leftChild == null && current.rightChild == null) {
			if (parent.leftChild == current)
				parent.leftChild = null;
			else {
				parent.rightChild = null;
			}
		}

		// case3: deleting a node with one child
		
		if (current.leftChild == null && current.rightChild != null) {
			if (parent.leftChild == current)
				parent.leftChild = null;
			else {
				parent.rightChild = null;
			}
		}

		return false;

	}

	public void inOrderTraversal(TNode node) {
		if (node == null)
			return;

		inOrderTraversal(node.leftChild);
		System.out.println(node.data + " ");
		inOrderTraversal(node.rightChild);
	}

	public void inOrderTraversalReversed(TNode node) {
		if (node == null)
			return;

		inOrderTraversalReversed(node.rightChild);
		System.out.println(node.data + " ");
		inOrderTraversalReversed(node.leftChild);
	}

	public void preOrderTraversal(TNode node) {
		if (node == null)
			return;

		System.out.println(node.data + " ");
		preOrderTraversal(node.leftChild);
		preOrderTraversal(node.rightChild);
	}

	public void postOrderTraversal(TNode node) {
		if (node == null)
			return;

		postOrderTraversal(node.leftChild);
		postOrderTraversal(node.rightChild);
		System.out.println(node.data + " ");
	}

	public void printStrategy(int strategy) {
		if (strategy == 1)
			inOrderTraversal(root);
		else if (strategy == 2)
			preOrderTraversal(root);
		else if (strategy == 3)
			postOrderTraversal(root);
		else if (strategy == 4)
			inOrderTraversalReversed(root);
	}

	public static void main(String[] args) {

		BinaryTree bt = new BinaryTree();
		bt.add(5);
		bt.add(-55);
		bt.add(55);
		bt.add(100);
		bt.add(200);
		bt.add(-5);
		bt.add(95);
		bt.add(12);
		System.out.println("Element Present: " + bt.search(-55));
		bt.printStrategy(4);

	}

}
