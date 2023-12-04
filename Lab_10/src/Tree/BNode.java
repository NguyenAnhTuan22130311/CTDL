package Tree;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class BNode<E extends Comparable<E>> {
	private E data;
	private BNode<E> myLeft;
	private BNode<E> myRight;

	public BNode(E data) {
		this.data = data;
		this.myLeft = null;
		this.myRight = null;
	}

	public BNode(E data, BNode<E> left, BNode<E> right) {
		this.data = data;
		this.myLeft = left;
		this.myRight = right;
	}

	public E getData() {
		return data;
	}

	public void setData(E data) {
		this.data = data;
	}

	public BNode<E> getMyLeft() {
		return myLeft;
	}

	public void setMyLeft(BNode<E> myLeft) {
		this.myLeft = myLeft;
	}

	public BNode<E> getMyRight() {
		return myRight;
	}

	public void setMyRight(BNode<E> myRight) {
		this.myRight = myRight;
	}

	// Add element e into BST
	public void add(E e) {
		int cmp = data.compareTo(e);
		if (cmp < 0) {
			// Nếu data nhỏ hơn e
			if (this.myRight == null) {
				this.myRight = new BNode<>(e);
			} else {
				this.myRight.add(e);
			}
			// Nếu data lớn hơn e
		} else if (cmp > 0) {
			if (this.myLeft == null) {
				this.myLeft = new BNode<>(e);
			} else {
				this.myLeft.add(e);
			}
			// Nếu data = e
		} else {

		}
	}

	// compute the depth of a node in BST
	public int depth(E node, int currenDepth) {
		int cmp = data.compareTo(node);
		if (cmp == 0) {
			return currenDepth;
		} else if (cmp > 0 && myLeft != null) {
			return myLeft.depth(node, currenDepth + 1);
		} else if (cmp < 0 && myRight != null) {
			return myRight.depth(node, currenDepth + 1);
		}
		return -1;
	}

	// compute the height of BST
	public int height() {
		if (myLeft == null && myRight == null) {
			return 0;
		} else {
			int leftHeight = myLeft != null ? myLeft.height() : 0;
			int rightHeight = myRight != null ? myRight.height() : 0;
			return 1 + Math.max(leftHeight, rightHeight);
		}
	}

	// Compute total nodes in BST
	public int size() {
		int leftSize = myLeft == null ? myLeft.size() : 0;
		int rightSize = myRight == null ? myRight.size() : 0;
		return 1 + leftSize + rightSize;
	}

	// Find the minimum element in BST
	public E findMin() {
		if (myLeft == null) {
			return data;
		}
		return myLeft.findMin();
	}

	// Find the maximum element in BST
	public E findMax() {
		if (myLeft == null) {
			return data;
		}
		return myRight.findMin();
	}

	// Remove element e from BST
	public boolean remove(E e, BNode<E> parent) {
		if (e.compareTo(data) < 0) {
			if (myLeft != null) {
				return myLeft.remove(e, this);
			} else {
				return false;
			}
		} else if (e.compareTo(data) > 0) {
			if (myRight != null) {
				return myRight.remove(e, this);
			} else {
				return false;
			}
		} else {
			if (myLeft != null && myRight != null) {
				data = myRight.findMin();
				myRight.remove(data, this);
			} else if (parent.myLeft == this) {
				parent.myLeft = (myLeft != null) ? myLeft : myRight;
			} else if (parent.myRight == this) {
				parent.myRight = (myLeft != null) ? myLeft : myRight;
			}
			return true;
		}
	}

	// Check whether element e is in BST
	public boolean contains(E e) {
		int comp = e.compareTo(data);
		if (comp == 0) {
			return true;
		} else if (comp < 0) {
			return (myLeft == null) ? false : myLeft.contains(e);
		} else {
			return (myRight == null) ? false : myRight.contains(e);
		}
	}

	public List<E> descendants(E e) {
		int comp = data.compareTo(e);
		List<E> re = new ArrayList<>();
		if (comp == 0) {
			if (myLeft == null) {
				re.add(myLeft.data);
				re.addAll(myLeft.descendants(e));
			} else if (myRight == null) {
				re.add(myRight.data);
				re.addAll(myRight.descendants(e));
			}
		}
		return re;
	}

	public List<E> ancestors(E e) {
		int comp = e.compareTo(data);
		List<E> re = new ArrayList<>();
		if (comp == 0)
			return re;
		if (myLeft != null) {
			if (myLeft.contains(e)) {
				re.add(data);
				re.addAll(myLeft.ancestors(e));
			}
		}
		if (myRight != null) {
			if (myRight.contains(e)) {
				re.add(data);
				re.addAll(myRight.ancestors(e));
			}
		}
		return re;
	}

	// display BST using inorder approach
	public void inorder() {
		if (myLeft != null) {
			myLeft.inorder();
		}
		System.out.print(data + " ");
		if (myRight != null) {
			myRight.inorder();
		}
	}

	// display BST using preorder approach
	public void preorder() {
		System.out.print(data + " ");
		if (myLeft != null) {
			myLeft.preorder();
		}
		if (myRight != null) {
			myRight.preorder();
		}
	}

	// display BST using postorder approach
	public void postorder() {
		if (myLeft != null) {
			myLeft.postorder();
		}
		if (myRight != null) {
			myRight.postorder();
		}
		System.out.println(data);
	}
}