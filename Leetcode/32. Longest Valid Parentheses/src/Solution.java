import java.util.Arrays;

public class Solution {
	public int longestValidParentheses(String s) {
		s = " " + s;
		int[] dp = new int[s.length()];
		Arrays.fill(dp, 0);
		int result = 0;

		for (int i = 1; i < s.length(); i++) {
			if (s.charAt(i) == ')') {
				int lastOpenParenthese = i - dp[i - 1] - 1;
				if (s.charAt(lastOpenParenthese) == '(')
					dp[i] = i - lastOpenParenthese + 1 + dp[lastOpenParenthese - 1];
				result = Integer.max(result, dp[i]);
			}
		}
		return result;
	}
}
