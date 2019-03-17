
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] intervals = { {800, 1100}, {1300,1400}, {1000,1200}, {1050,1250}, {1350,1500} };
		Solution so = new Solution();
		int[][] mergedIntervals = so.badDayAtSchool(intervals);
		for (int[] interval : mergedIntervals) {
			System.out.println(interval[0] + " " + interval[1]);
		}
	}

}
