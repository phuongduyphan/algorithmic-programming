import java.util.HashMap;
import java.util.Map;

public class Tree {
	public TreeNode<Integer> root;
	
	public Tree(TreeNode<Integer> root) {
		this.root = root;
	}
	
	public int countPathsWithSum(int sum) {
		Map<Integer, Integer> map = new HashMap<>();
		map.put(0, 1);
		return countPathsWithSum(this.root, 0, sum, map);
	}
	
	public int countPathsWithSum(TreeNode<Integer> node, int curSum, int sum,
			Map<Integer, Integer> map) {
		if (node == null) return 0;
		curSum += node.data;
		int result = map.getOrDefault(curSum - sum, 0);
		if (result != 0) {
			System.out.println(node.data);
		}
		map.put(curSum, map.getOrDefault(curSum, 0) + 1);
		
		result += countPathsWithSum(node.left, curSum, sum, map);
		result += countPathsWithSum(node.right, curSum, sum, map);
		map.put(curSum, map.get(curSum) - 1);
		
		return result;
	}
}
