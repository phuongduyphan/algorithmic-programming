class Pair<T, U> {
	public T first;
	public U second;
	
	public Pair(T first, U second) {
		this.first = first;
		this.second = second;
	}
}

public class BinaryTree<E> {
	public BinaryTreeNode<E> root;
	
	public BinaryTree(BinaryTreeNode<E> root) {
		this.root = root;
	}
	
	public boolean checkBalanced() {
		Pair<Integer, Boolean> result = this.checkBalanced(this.root);
		return result.second;
	}
	
	public Pair<Integer, Boolean> checkBalanced(BinaryTreeNode<E> node) {
		if (node == null) return new Pair<Integer, Boolean>(0, true);
		
		Pair<Integer, Boolean> leftSubTree = checkBalanced(node.left);
		Pair<Integer, Boolean> rightSubTree = checkBalanced(node.right);
		
		Boolean result = leftSubTree.second && rightSubTree.second && 
				(Math.abs(leftSubTree.first - rightSubTree.first) <= 1);
		
		return new Pair<Integer, Boolean>(Math.max(leftSubTree.first, rightSubTree.first) + 1,
				result);
	}
}
