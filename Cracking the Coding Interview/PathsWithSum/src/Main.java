
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode<Integer> root = new TreeNode<>(2);
		root.left = new TreeNode<>(1);
		root.left.left = new TreeNode<>(4);
		root.left.left.left = new TreeNode<>(5);
		root.left.right = new TreeNode<>(-3);
		root.left.right.left = new TreeNode<>(3);
		root.left.right.right = new TreeNode<>(2);
		
		root.right = new TreeNode<>(-3);
		root.right.left = new TreeNode<>(1);
		root.right.left.right = new TreeNode<>(2);
		root.right.right = new TreeNode<>(3);
		Tree tree = new Tree(root);
		System.out.println(tree.countPathsWithSum(2));
	}

}
