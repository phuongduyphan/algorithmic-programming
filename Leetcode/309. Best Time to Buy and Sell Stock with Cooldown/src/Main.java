import java.util.Arrays;

class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[] buy = new int[n];
        int[] sell = new int[n];
        
        if (n <= 1) return 0;
        buy[0] = -prices[0];
        buy[1] = Math.max(buy[0], -prices[1]);
        sell[1] = Math.max(0, prices[1] + buy[0]);
        for (int i = 2; i < n; i++) {
        	buy[i] = Math.max(buy[i-1], sell[i-2] - prices[i]);
        	sell[i] = Math.max(sell[i-1], buy[i-1] + prices[i]);
        }
        return sell[n-1];
    }
}

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution so = new Solution();
		
		int[] prices = { 1,2,3,0,2 };
		System.out.println(so.maxProfit(prices));
	}

}
