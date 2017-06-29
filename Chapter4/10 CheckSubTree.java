package Chapter4;

import java.util.Queue;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

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

			// printing the data first abd then
			// pushing the right child first and left child later in the stack
			// because I want to print it in the reverse order i.e.(root -> left
			// -> right)

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

	public void levelOrderTraversal(TNode node) {

		if (node == null)
			return;

		Queue<TNode> nodeQueue = new LinkedList<TNode>();
		TNode marker = new TNode(-1);

		nodeQueue.add(node);
		nodeQueue.add(marker);
		while (!nodeQueue.isEmpty()) {

			TNode temp = nodeQueue.peek();
			nodeQueue.remove();
			if (temp.data == -1) {
				System.out.println("\n");
				if (nodeQueue.size() != 0)
					nodeQueue.add(marker);

			} else {
				System.out.print(temp.data + " ");
				if (temp.leftChild != null)
					nodeQueue.add(temp.leftChild);
				if (temp.rightChild != null)
					nodeQueue.add(temp.rightChild);
			}

		}

	}

	public void myOwnPostOrderTraversal() {
		Stack<TNode> s1 = new Stack<>();
		Stack<Integer> s2 = new Stack<>();

		TNode n = root;
		if (n != null) {
			s1.push(n);
			s2.push(1);
		}

		while (!s1.isEmpty()) {
			TNode newN = s1.pop();
			Integer i = s2.pop();

			if (i.equals(1)) {
				s1.push(newN);
				s2.push(2);
				if (newN.leftChild != null) {
					s1.push(newN.leftChild);
					s2.push(1);
				}
			} else if (i.equals(2)) {
				s1.push(newN);
				s2.push(3);
				if (newN.rightChild != null) {
					s1.push(newN.rightChild);
					s2.push(1);
				}
			} else if (i.equals(3)) {
				System.out.print(newN.data + " ");
			}
		}
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
		else if (strategy == 5)
			myOwnPostOrderTraversal();
		else if (strategy == 6)
			levelOrderTraversal(root);
	}

	public static boolean isLeaf(TNode n) {
		return n.leftChild == null && n.rightChild == null;
	}

	public void getNodesForMinimalTree(int a[], int upperBound, int lowerBound) {

		if (lowerBound > upperBound)
			return;

		int mid = (upperBound + lowerBound) / 2;
		add(a[mid]);
		getNodesForMinimalTree(a, upperBound, mid + 1);
		getNodesForMinimalTree(a, mid - 1, lowerBound);

	}

	public void getListOfDepth() {
		if (root == null)
			return;

		Queue<TNode> nodeQueue = new LinkedList<TNode>();
		TNode marker = new TNode(-1);

		nodeQueue.add(root);
		LinkedList<Integer> lk0 = new LinkedList<Integer>();
		nodeQueue.add(marker);
		while (!nodeQueue.isEmpty()) {

			TNode temp = nodeQueue.peek();
			nodeQueue.remove();
			if (temp.data == -1) {
				int i = 1;
				LinkedList<Integer> lki = new LinkedList<Integer>();
				lki = lk0;
				lk0 = new LinkedList<Integer>();
				while (!lki.isEmpty()) {
					System.out.print("Linked Lis :" + lki.removeFirst());

				}
				System.out.println("\n");
				if (nodeQueue.size() != 0)
					nodeQueue.add(marker);

			} else {
				System.out.print(temp.data + " ");
				lk0.add(temp.data);
				if (temp.leftChild != null)
					nodeQueue.add(temp.leftChild);
				if (temp.rightChild != null)
					nodeQueue.add(temp.rightChild);
			}

		}

	}

	public int getTreeHeight(TNode node) {

		if (node == null)
			return 0;

		int left = getTreeHeight(node.leftChild);
		int right = getTreeHeight(node.rightChild);

		if (left >= right)
			return left + 1;
		else
			return right + 1;
	}

	public boolean checkBalanced() {
		return checkBalanced(root);
	}

	public boolean checkBalanced(TNode node) {
		int leftHeight;
		int rightHeight;

		// System.out.println(getTreeHeight(root));

		if (node == null) {
			return false;
		}

		leftHeight = getTreeHeight(node.leftChild);
		rightHeight = getTreeHeight(node.rightChild);

		if (Math.abs(leftHeight - rightHeight) > 1) {
			return false;
		} else {
			checkBalanced(node.leftChild);
			checkBalanced(node.rightChild);
		}

		return true;
	}

	public boolean checkChildProperty(TNode node) {

		return false;
	}

	public boolean checkLeftRightProperty(TNode node) {

		if (node == null)
			return false;

		if (node.leftChild != null)
			if (node.leftChild.data <= node.data) {
				if (!checkLeftRightProperty(node.leftChild)) {
					return false;
				}
			} else
				return false;

		if (node.rightChild != null)
			if (node.rightChild.data > node.data) {
				if (!checkLeftRightProperty(node.rightChild)) {
					return false;
				}
			} else
				return false;

		return true;
	}

	public boolean isBinaryTree() {

		boolean ch = checkChildProperty(root);
		boolean lr = checkLeftRightProperty(root);
		// return lr;
		return ch && lr;

	}

	public int getSuccessor(TNode n) {
		TNode result;
		if (n.leftChild == null && n.rightChild == null) {

			// if(leftOfParent){}
			// return parent;

			// if(rightOfParent){}
			// return (first parent greater than n)
		} else {

			result = getMinimumFromBST(n);
			return result.data;
		}

		return 0;
	}

	public TNode getMinimumFromBST(TNode node) {

		int tempData = node.data;
		TNode tempNode = node;
		while (node != null) {
			tempNode = node;
			node = node.leftChild;
		}

		return tempNode;
	}

	public List inOrderArray(TNode node) {
		if (node == null)
			return null;
		List<Integer> inOrderArray = new ArrayList<Integer>();
		Stack<TNode> nodeStorage = new Stack<TNode>();
		TNode currentNode = node;

		while (currentNode != null) {
			nodeStorage.push(currentNode);
			currentNode = currentNode.leftChild;
		}

		while (nodeStorage.size() > 0) {

			currentNode = nodeStorage.pop();
			System.out.println(currentNode.data + " ");
			inOrderArray.add(currentNode.data);
			if (currentNode.rightChild != null) {
				currentNode = currentNode.rightChild;

				while (currentNode != null) {
					nodeStorage.push(currentNode);
					currentNode = currentNode.leftChild;
				}
			}

		}
		return inOrderArray;
	}

	public boolean isSubTree(TNode baseNode, TNode testNode) {

		if(baseNode==null || testNode==null)
			return false;
		
		List baseNodeArray = inOrderArray(baseNode);
		System.out.println("==============================");
		List testNodeArray = inOrderArray(testNode);

		for (int x = 0; x < baseNodeArray.size(); x++){
			if (baseNodeArray.get(x)==testNodeArray.get(0)) {
				for (int y = 0; y < testNodeArray.size(); y++) {
					if (baseNodeArray.get(x + y) != testNodeArray.get(y)) {
						return false;
					} 
				}
		
			}
		}
		
		return true;
	}

	public static void main(String[] args) {

		BinaryTree bt = new BinaryTree();

		// int array[]={0,1,2,3,4,5,6,7,8,9,10};
		// int array[]={1,2,3,4,5,6,7,8,9,10};

		// bt.getNodesForMinimalTree(array, array.length-1, 0);

		
		bt.add(100);
		bt.add(200);
		bt.add(50);
		bt.add(80);
		bt.add(40);
		bt.add(250);
		bt.add(150);
		bt.add(30);
		bt.add(45);
		bt.add(70);
		bt.add(90);
		bt.add(140);
		bt.add(160);
		bt.add(225);
		bt.add(275);
		
		
		BinaryTree bt1 = new BinaryTree();
		bt1.add(50);
		bt1.add(80);
		bt1.add(70);
		bt1.add(90);
		bt1.add(500);
		/*
		 * bt.add(5); bt.add(1); bt.add(10); bt.add(15); bt.add(20); bt.add(-5);
		 * bt.add(-55); bt.add(-555); bt.add(-5555);
		 */

		/*
		 * bt.add(4); bt.add(2); bt.add(1); bt.add(300); bt.add(5); bt.add(-10);
		 * bt.add(45); bt.add(40); bt.add(-5); bt.add(-55);
		 */
		// bt.getListOfDepth();
		System.out.println("***================================***");
		bt.printStrategy(6);
		System.out.println("***================================***");
		System.out.println("***================================***");
		bt1.printStrategy(6);
		System.out.println("***================================***");
		//System.out.println("Is this tree balanced ? :" + bt.checkBalanced());
		// System.out.println("Is element present ? :" + bt.search(35));
		// bt.remove(45);

		//System.out.println("Is it a binary search tree ? :" + bt.isBinaryTree());
		
		System.out.println("Is it a subtree ? :"+bt.isSubTree(bt.root,bt1.root));

		// System.out.println("***================================***");
		// bt.printStrategy(3);
		// System.out.println("\n***================================***");
		// System.out.println("***================================***");
		// bt.printStrategy(5);
		// System.out.println("\n***================================***");
		// bt.printStrategy(6);

	

	}

}
