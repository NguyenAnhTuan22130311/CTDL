package Tree;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class BST<E extends Comparable<E>> {
	private BNode<E> root;

	public BST() {
		this.root = null;
	}

	// Add element e into BST
	public void add(E e) {
		// Nếu tree rỗng, tạo node mới như root
		if (root == null) {
			root = new BNode<E>(e);
		} else {
			root.add(e);
		}
	}

	// Add a collection of elements col into BST
	public void add(Collection<E> col) {
		for (E e : col) {
			add(e);
		}
	}

	// compute the depth of a node in BST
	public int depth(E node) {
		if (root == null) {
			return -1;
		}
		return root.depth(node, 0);
	}

	// compute the height of BST
	public int height() {
		if (root == null) {
			return 0;
		} else {
			return root.height();
		}
	}

	// Compute total nodes in BST
	public int size() {
		return root == null ? root.size() : 0;
	}

	// Check whether element e is in BST
	public boolean contains(E e) {
		if (root == null) {
			return false;
		}
		return root.contains(e);
	}

	// Find the minimum element in BST
	public E findMin() {
		if (root == null) {
			return null;
		}
		BNode<E> current = root;
		while (current.getMyLeft() != null) {
			current = current.getMyLeft();
		}
		return current.getData();
	}

	// Find the maximum element in BST
	public E findMax() {
		if (root == null) {
			return null;
		}
		BNode<E> current = root;
		while (current.getMyRight() != null) {
			current = current.getMyRight();
		}
		return current.getData();
	}

	// Remove element e from BST
	public boolean remove(E e) {
		if (root == null) {
			return false;
		} else {
			if (root.getData().equals(e)) {
				BNode<E> auxRoot = new BNode<>(null);
				auxRoot.setMyLeft(root);
				boolean result = root.remove(e, auxRoot);
				root = auxRoot.getMyLeft();
				return result;
			} else {
				return root.remove(e, null);
			}
		}
	}

	// get the descendants of a node
	public List<E> descendants(E data) {
		if (root == null) {
			return new ArrayList<>();
		}
		return root.descendants(data);
	}

	// get the ancestors of a node
	public List<E> ancestors(E data) {
		if (root == null) {
			return new ArrayList<>();
		}
		return root.ancestors(data);
	}

	// display BST using inorder approach
	public void inorder() {
		if (root != null) {
			root.inorder();
		}
	}
	// display BST using preorder approach

	public void preorder() {
		if (root != null) {
			root.preorder();
		}
	}

	// display BST using postorder approach
	public void postorder() {
		if (root != null) {
			root.postorder();
		}
	}

	public static void main(String[] args) {
		BST<Integer> bst = new BST<>();
		bst.add(50);
		bst.add(30);
		bst.add(20);
		bst.add(40);
		bst.add(20);
		bst.add(70);
		bst.add(60);
		bst.add(80);
		bst.remove(30);

		System.out.println("Inorder traversal:");
		bst.inorder();
		System.out.println("\nPreorder traversal:");
		bst.preorder();
		System.out.println("\nPostorder traversal:");
		bst.postorder();

		System.out.println("Descendants of 30: " + bst.descendants(30));
		System.out.println("Ancestors of 60: " + bst.ancestors(60));
	}
}
