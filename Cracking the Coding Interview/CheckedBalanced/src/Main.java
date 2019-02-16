
public class Main {

	public static void main(String[] args) {
		BinaryTreeNode<Integer> root = new BinaryTreeNode<>(4);
		root.left = new BinaryTreeNode<>(2);
		root.left.left = new BinaryTreeNode<>(1);
		root.left.right = new BinaryTreeNode<>(3);
		
		root.right = new BinaryTreeNode<>(6);
		root.right.left = new BinaryTreeNode<>(5);
		root.right.right = new BinaryTreeNode<>(7);
		
		BinaryTree<Integer> tree = new BinaryTree<>(root);
		System.out.println(tree.checkBalanced());
	}

}
