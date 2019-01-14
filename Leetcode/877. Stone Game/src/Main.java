
class Solution {
		private int maxScore(int i, int j, int[][] score, int[] piles, int[] sum) {
			if (score[i][j] != 0) return score[i][j];
			
			if (i + 1 == j) {
				score[i][j] = Math.max(piles[i], piles[j]);
				return score[i][j];
			}
			
			int scoreCase1 = maxScore(i + 1, j, score, piles, sum);
			int scoreCase2 = maxScore(i, j - 1, score, piles, sum);
			
			if (scoreCase1 < scoreCase2) {
				score[i][j] = piles[i] + sum[j] - sum[i] - scoreCase1;
			} else {
				int prevSum = 0;
				if (i != 0) prevSum = sum[i-1];
				score[i][j] = piles[j] + sum[j-1] - prevSum - scoreCase2;
			}
			return score[i][j];
		}
	
    public boolean stoneGame(int[] piles) {
    	int n = piles.length;
    	int[] sum = new int[n];
    	int[][] score = new int[n][n];
    	sum[0] = piles[0];
    	
    	for (int i = 1; i < n; i++) {
    		sum[i] = sum[i-1] + piles[i];
    	}
    	
    	int maxSumCanPlay = this.maxScore(0, n-1, score, piles, sum);
    	return maxSumCanPlay > sum[n-1] - maxSumCanPlay ? true : false; 
    }
}

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution so = new Solution();
		int[] piles = { 1,2,3,1 };
		System.out.println(so.stoneGame(piles));
	}

}
