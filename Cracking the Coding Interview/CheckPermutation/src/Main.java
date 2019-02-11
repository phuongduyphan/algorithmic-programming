import java.util.HashMap;
import java.util.Map;
import java.util.Set;

class Solution {
	public boolean checkPermutation(String s1, String s2) {
		if (s1.length() != s2.length()) return false;
		
		Map<Character, Integer> charMap = new HashMap<>();
		
		for (int i = 0; i < s1.length(); i++) {
			charMap.put(s1.charAt(i), charMap.getOrDefault(s1.charAt(i), 0) + 1);
			charMap.put(s2.charAt(i), charMap.getOrDefault(s2.charAt(i), 0) - 1);
		}
		
		Set<Map.Entry<Character, Integer>> entrySet = charMap.entrySet();
		
		for(Map.Entry<Character, Integer> item : entrySet) {
			if (item.getValue() != 0) return false;
		}
		return true;
	}
}

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution so = new Solution();
		String s1 = "abcde";
		String s2 = "bdcae";
		System.out.println(so.checkPermutation(s1, s2));
	}

}
