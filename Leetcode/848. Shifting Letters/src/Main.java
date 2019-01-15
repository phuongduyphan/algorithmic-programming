
class Solution {
    public String shiftingLetters(String S, int[] shifts) {
    	long[] numberOfShifts = new long[shifts.length];
    	String result = "";
    	
    	numberOfShifts[numberOfShifts.length - 1] = shifts[shifts.length - 1];
    	for (int i = shifts.length - 2; i >= 0; i--) {
    		numberOfShifts[i] = numberOfShifts[i+1] + shifts[i]; 
    	}
    	
    	for (int i = 0; i < S.length(); i++) {
    		long asciiCode = ((int) S.charAt(i) - (int)'a' + numberOfShifts[i]) % 26 + 97;
    		result += (char) asciiCode;
    	}
    	return result;
    }
}

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution so = new Solution();
		int[] shifts = {505870226,437526072,266740649,224336793,532917782,311122363,567754492,595798950,81520022,684110326,137742843,275267355,856903962,148291585,919054234,467541837,622939912,116899933,983296461,536563513};
		System.out.println(so.shiftingLetters("mkgfzkkuxownxvfvxasy", shifts));
	}

}
