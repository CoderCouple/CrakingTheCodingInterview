
import java.util.Stack;

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
		TNode parent = null;
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
		TNode parent = null;
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

		Stack<TNode> nodeStorage = new Stack<TNode>();
		TNode currentNode = node;

		while (currentNode != null) {
			nodeStorage.push(currentNode);
			currentNode = currentNode.leftChild;
		}

		while (nodeStorage.size() > 0) {

			currentNode = nodeStorage.pop();
			System.out.println(currentNode.data + " ");
			if (currentNode.rightChild != null) {
				currentNode = currentNode.rightChild;

				while (currentNode != null) {
					nodeStorage.push(currentNode);
					currentNode = currentNode.leftChild;
				}
			}

		}
	}

	public void preOrderTraversal(TNode node) {
		if (node == null)
			return;

		Stack<TNode> nodeStorage = new Stack<TNode>();
		TNode currentNode = node;
		nodeStorage.push(currentNode);

		while (nodeStorage.size() > 0) {

			TNode mynode = nodeStorage.peek();
			System.out.print(mynode.data + " ");
			nodeStorage.pop();

			if (mynode.rightChild != null) {
				nodeStorage.push(mynode.rightChild);
			}
			if (mynode.leftChild != null) {
				nodeStorage.push(mynode.leftChild);
			}
		}
	}

	public void inOrderTraversalReversed(TNode node) {
		if (node == null)
			return;

	}

	public void postOrderTraversal(TNode node) {
		Stack<TNode> s1 = new Stack<>();
		Stack<TNode> s2 = new Stack<>();

		if (node == null)
			return;

		s1.push(node);

		// Run while first stack is not empty
		while (!s1.isEmpty()) {
			TNode temp = s1.pop();
			s2.push(temp);

			if (temp.leftChild != null)
				s1.push(temp.leftChild);
			if (temp.rightChild != null)
				s1.push(temp.rightChild);
		}

		// Print all elements of second stack
		while (!s2.isEmpty()) {
			TNode temp = s2.pop();
			System.out.print(temp.data + " ");
		}
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

	public static boolean isLeaf(TNode n) {
		return n.leftChild == null && n.rightChild == null;
	}

	public static void main(String[] args) {

		BinaryTree bt = new BinaryTree();

		bt.add(4);
		bt.add(2);
		bt.add(1);
		bt.add(3);
		bt.add(5);
		bt.add(55);
		bt.add(45);
		bt.add(40);
		bt.add(-5);
		bt.add(-55);
		
		System.out.println("***================================***");
		bt.printStrategy(1);
		System.out.println("***================================***");
		System.out.println("Is element present ? :" + bt.search(35));
		bt.remove(45);
		System.out.println("***================================***");
		bt.printStrategy(1);
		System.out.println("***================================***");

	}

}
