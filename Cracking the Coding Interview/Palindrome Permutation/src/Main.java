import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

class Solution {
	public boolean checkPalindromePermutation(String s) {
		Map<Character, Integer> charMap = new HashMap<>();
		
		for (int i = 0; i < s.length(); i++) {
			charMap.put(s.charAt(i), charMap.getOrDefault(s.charAt(i), 0) + 1);
		}
		Collection<Integer> valueList = charMap.values();
		
		boolean foundOdd = false;
		for (Integer value : valueList) {
			if (value % 2 != 0) {
				if (foundOdd) return false;
				else foundOdd = true;
			}
		}
		return true;
	}
}

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution so = new Solution();
		String s = "daaad";
		System.out.println(so.checkPalindromePermutation(s));
	}

}
