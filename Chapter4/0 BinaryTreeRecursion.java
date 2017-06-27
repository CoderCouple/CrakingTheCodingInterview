import java.util.Stack;

public class BinaryTreeRecursion {

	TNode root;

	public BinaryTreeRecursion() {
		root = null;
	}

	public void addRecursive(int element, TNode node) {

		if (node == null) {
			TNode n = new TNode(element);
			node = n;
			return;
		}

		if (element <= node.data) {
			addRecursive(element, node.leftChild);
		} else {
			addRecursive(element, node.rightChild);

		}

	}

	public void add(int element) {
		addRecursive(element, root);
	}

	public boolean searchRecursive(int element, TNode node) {

		if (node == null) {
			return false;
		}

		if (element == node.data) {
			return true;
		} else if (element < node.data) {
			searchRecursive(element, node.leftChild);
		} else {
			searchRecursive(element, node.rightChild);

		}

		return false;

	}

	public boolean search(int element) {

		boolean result = searchRecursive(element, root);
		return result;
	}

	public boolean remove(int element) {
		// if the binary tree is empty
		if (root == null) {
			return false;
		}

		// case 1 : root is element to be deleted
		if (root.data == element) {
			if (root.rightChild == null) {
				root = root.leftChild;
				return true;
			}

			if (root.leftChild == null) {
				root = root.rightChild;
				return true;
			}

			if (root.leftChild != null && root.rightChild != null) {
				TNode min = minNode(root.rightChild);
				TNode minParent = minNodeParent(root.rightChild);
				root.data = min.data;
				minParent.leftChild = null;
				return true;
			}

		}

		TNode current = root;
		TNode parent = null;
		while (current != null) {
			if (element == current.data) {
				break;
			}
			parent = current;
			if (element > current.data) {
				current = current.rightChild;

			} else if (element < current.data) {
				current = current.leftChild;
			}

		}

		// Reached the end of the tree but did not find the element
		if (current == null) {
			return false;
		}

		// case2: deleting the leaf node

		if (current.leftChild == null && current.rightChild == null) {
			if (parent.leftChild == current) {
				parent.leftChild = null;
				return true;
			}

			else if (parent.rightChild == current) {
				parent.rightChild = null;
				return true;
			}
		}

		// case3: deleting a node with one child

		if (current.leftChild != null && current.rightChild == null) {
			if (parent.leftChild == current) {
				parent.leftChild = current.leftChild;
				current.leftChild = null;
				return true;
			}
			if (parent.rightChild == current) {
				parent.rightChild = current.leftChild;
				current.leftChild = null;
				return true;
			}
		}

		if (current.leftChild == null && current.rightChild != null) {
			if (parent.leftChild == current) {
				parent.leftChild = current.rightChild;
				current.rightChild = null;
				return true;
			}
			if (parent.rightChild == current) {
				parent.rightChild = current.rightChild;
				current.rightChild = null;
				return true;
			}
		}

		// case4: deleting a node with two child
		if (current.leftChild != null && current.rightChild != null) {
			TNode min = minNode(current.rightChild);
			TNode minParent = minNodeParent(current.rightChild);
			current.data = min.data;
			minParent.leftChild = null;
			return true;
		}

		return false;

	}

	public TNode minNode(TNode node) {
		TNode minNode = root;
		while (minNode.leftChild != null) {
			minNode = minNode.leftChild;
		}
		return minNode;
	}

	public TNode minNodeParent(TNode node) {
		TNode minNode = root;
		TNode minNodeParent = root;
		while (minNode.leftChild != null) {
			minNodeParent = minNode;
			minNode = minNode.leftChild;
		}
		return minNodeParent;
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
		bt.add(50);
		bt.add(35);
		bt.add(30);
		bt.add(40);
		bt.add(55);
		bt.add(52);
		bt.add(60);
		System.out.println("Is element present :"+bt.search(50));
		System.out.println("Is element present :"+bt.search(40));
		System.out.println("Is element present :"+bt.search(52));
		System.out.println("Is element present :"+bt.search(60));
		System.out.println("Is element present :"+bt.search(25));
		System.out.println("***================================***");
		bt.printStrategy(1);
		System.out.println("***================================***");
		System.out.println("Is element present ? :" + bt.search(35));
		bt.remove(40);
		System.out.println("***================================***");
		bt.printStrategy(1);
		System.out.println("***================================***");
		

	}

}
