import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		String s = scanner.next();
		String p = scanner.next();
		scanner.close();
		
		Solution so = new Solution();
		System.out.println(so.isMatch(s, p));
	}

}
