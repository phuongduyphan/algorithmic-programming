
public class Solution {
	public int interpretArrayOfDigits(String s) {
    s = " " + s;
		int[] dp = new int[s.length()];
    dp[0] = 1;
    for (int i = 1; i < s.length(); i++) {
    	if (Integer.parseInt("" + s.charAt(i)) > 0) dp[i] = dp[i - 1];
      if (i - 2 >= 0 && Integer.parseInt("" + s.charAt(i-1) + s.charAt(i)) <= 26
      		&& s.charAt(i-1) != '0') {
      	dp[i] += dp[i-2];
      }
    }
    return dp[s.length() - 1];
	}
}
