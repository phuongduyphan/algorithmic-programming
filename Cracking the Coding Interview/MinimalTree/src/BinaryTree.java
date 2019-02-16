import java.util.ArrayList;

public class BinaryTree<E> {
	public BinaryTreeNode<E> root;
	
	public BinaryTree(BinaryTreeNode<E> root) {
		this.root = root;
	}
	
	public static <E> BinaryTreeNode<E> minimalTree(ArrayList<E> sortedArr) {
		return BinaryTree.minimalTree(sortedArr, 0, sortedArr.size() - 1);
	}
	
	public static <E> BinaryTreeNode<E> minimalTree(ArrayList<E> sortedArr,
			int lo, int hi) {
		if (lo > hi) return null;
		
		int mid = lo + (hi - lo) / 2;
		BinaryTreeNode<E> node = new BinaryTreeNode<>(sortedArr.get(mid));
		node.left = minimalTree(sortedArr, lo, mid - 1);
		node.right = minimalTree(sortedArr, mid + 1, hi);
		
		return node;
	}
	
	public void preOrderPrint() {
		preOrderPrint(this.root);
	}
	
	public void preOrderPrint(BinaryTreeNode<E> node) {
		if (node == null) return;
		System.out.print(node.data + " ");
		preOrderPrint(node.left);
		preOrderPrint(node.right);
	}
}
