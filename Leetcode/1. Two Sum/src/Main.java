import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int target = scanner.nextInt();
		int[] nums = new int[n];
		for (int i = 0; i < n; i++) {
			nums[i] = scanner.nextInt();
		}
		scanner.close();
		
		Solution so = new Solution();
		int[] result = so.twoSum(nums, target);
		System.out.println(result[0] + " " + result[1]);
	}

}
