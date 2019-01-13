
public class Solution {
	public boolean isMatch(String s, String p) {
		s = " " + s;
		p = " " + p;
		Boolean[][] dp = new Boolean[s.length()][p.length()];
		dp[0][0] = true;
		
		for (int i = 0; i < s.length(); i++) {
			for (int j = 0; j < p.length(); j++) {
				if (i == 0 && j == 0) continue;
				if (isLetter(s.charAt(i)) && isLetter(p.charAt(j))) {
					dp[i][j] = isEqual(s.charAt(i), p.charAt(j)) ? dp[i-1][j-1] : false;
				}
				else if (isLetter(s.charAt(i)) && !isLetter(p.charAt(j))) {
					dp[i][j] = isEqual(s.charAt(i), p.charAt(j-1)) ? dp[i-1][j] || dp[i][j-2] : dp[i][j-2];
				}
				else if (!isLetter(s.charAt(i)) && isLetter(p.charAt(j))) {
					dp[i][j] = isEqual(s.charAt(i-1), p.charAt(j)) ? dp[i][j-1] || dp[i-2][j] : dp[i-2][j];
				}
				else {
					dp[i][j] = isEqual(s.charAt(i-1), p.charAt(j-1));
				}
			}
		}
		return dp[s.length()-1][p.length()-1];
	}
	
	public Boolean isLetter(char c) {
		return (c != '*');
	}
	
	public Boolean isEqual(char c1, char c2) {
		if (c1 == c2) return true;
		if ((c1 == '.' && c2 != ' ') || (c2 == '.' && c1 != ' ')) return true;
		return false;
	}
}
