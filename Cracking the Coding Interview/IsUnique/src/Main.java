class Solution {
	public boolean isUnique(String s) {
		// assume character set is ASCII (0-127)
		if (s.length() > 128) return false;
		boolean[] charMap = new boolean[128];
		
		for (int i = 0; i < s.length(); i++) {
			int charCode = s.charAt(i);
			if (charMap[charCode]) return false;
			charMap[charCode] = true;
		}
		return true;
	}
	
	public boolean isUnique2(String s) {
		// only lowercase letters (a-z)
		if (s.length() > 26) return false;
		int checker = 0;
		for (int i = 0; i < s.length(); i++) {
			int val = s.charAt(i) - 'a';
			if ((checker & (1 << val)) != 0) return false;
			checker |= (1 << val);
		}
		return true;
	}
}

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "abcd10jk";
		Solution so = new Solution();
		
		System.out.println(so.isUnique2(s));
	}

}
