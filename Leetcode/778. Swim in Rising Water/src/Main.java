import java.util.LinkedList;
import java.util.Queue;

class Pair {
	public int first;
	public int second;
	
	public Pair(int first,int second) {
		this.first = first;
		this.second = second;
	}
}

class Solution {
    public int swimInWater(int[][] grid) {
    	int n = grid.length;
    	int result = -1;
    	
    	int l = grid[0][0];
    	int r = n * n - 1;
    	
    	while (r - l >= 0) {
    		int m = (l + r)/2;
    		if (this.canSwim(m, n, grid)) {
    			r = m - 1;
    			result = m;
    		}
    		else {
    			l = m + 1;
    		}
    	}
    	return result;
    }
    
    private boolean canSwim(int t, int n, int[][] grid) {
    	boolean[][] visit = new boolean[n][n];
    	int[] rowDir = { 0, 1, 0, -1 };
    	int[] colDir = { 1, 0, -1, 0 };
    	Queue<Pair> queue = new LinkedList<>();
    	
    	visit[0][0] = true;
    	queue.add(new Pair(0, 0));
    	
    	while (!queue.isEmpty()) {
    		Pair curPair = queue.poll();
    		if (curPair.first == n - 1 && curPair.second == n - 1) {
    			return true;
    		}
    		
    		for (int i = 0; i < 4; i++) {
    			int nextRow = curPair.first + rowDir[i];
    			int nextCol = curPair.second + colDir[i];
    			
    			if (nextRow >= 0 && nextRow < n && nextCol >= 0 && nextCol < n
    				 && !visit[nextRow][nextCol] && grid[nextRow][nextCol] <= t) {
    				queue.add(new Pair(nextRow, nextCol));
    				visit[nextRow][nextCol] = true;
    			}
    		}
    	}
    	
    	return false;
    }
} 

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution so = new Solution();
		int [][] grid = {{0,1,2,3,4},{24,23,22,21,5},{12,13,14,15,16},
		                 {11,17,18,19,20},{10,9,8,7,6}};
		System.out.println(so.swimInWater(grid));
	}

}
