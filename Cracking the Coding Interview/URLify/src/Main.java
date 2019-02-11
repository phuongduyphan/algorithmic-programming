import java.util.Scanner;

class Solution {
	public char[] replaceSpaces(char[] str, int trueLength) {
		int spaceCount = 0;
		for (int i = 0; i < trueLength; i++) {
			if (str[i] == ' ') spaceCount++;
		}
		
		int index = trueLength + spaceCount * 2;
		for (int i = trueLength - 1; i >= 0; i--) {
			if (str[i] == ' ') {
				str[index - 1] = '0';
				str[index - 2] = '2';
				str[index - 3] = '%';
				index -= 3;
			} else {
				str[index - 1] = str[i];
				index--;
			}
		}
		return str;
	}
}

public class Main {
	
	public static void main(String[] args) {
		Solution so = new Solution();
		
		Scanner scanner = new Scanner(System.in);
		String s = scanner.nextLine();
		int trueLength = scanner.nextInt();
		
		char[] str = s.toCharArray();
		System.out.println(so.replaceSpaces(str, trueLength));
	}

}
