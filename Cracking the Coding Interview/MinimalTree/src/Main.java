import java.util.ArrayList;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] sortedArray = { 1, 2, 3, 4, 5, 6, 7 };
		ArrayList<Integer> sortedArrayList = new ArrayList<>(Arrays.asList(sortedArray));
		BinaryTreeNode<Integer> root = BinaryTree.minimalTree(sortedArrayList);
		BinaryTree<Integer> tree = new BinaryTree<>(root);
		tree.preOrderPrint();
	}

}
