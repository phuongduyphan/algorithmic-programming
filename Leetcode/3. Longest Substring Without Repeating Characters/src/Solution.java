import java.util.HashMap;
import java.util.Map;

class Solution {
	public int lengthOfLongestSubstring(String s) {
		int i = 0, j = 0;
		int result = 0;
		HashMap<Character, Integer> repeatCharMap = new HashMap<>();

		while (j < s.length()) {
			if (!repeatCharMap.containsKey(s.charAt(j))) repeatCharMap.put(s.charAt(j), 0);
			repeatCharMap.put(s.charAt(j), repeatCharMap.get(s.charAt(j)) + 1);
			
			while (!checkCondition(repeatCharMap)) {
				repeatCharMap.put(s.charAt(i), repeatCharMap.get(s.charAt(i)) - 1);
				i++;
			}
			
			result = Integer.max(result, j - i + 1);
			j++;
		}
		return result;
	}

	public boolean checkCondition(HashMap<Character, Integer> repeatCharArr) {
		for (Map.Entry<Character, Integer> entry : repeatCharArr.entrySet()) {
			if (entry.getValue() > 1) return false;
		}
		return true;
	}
}