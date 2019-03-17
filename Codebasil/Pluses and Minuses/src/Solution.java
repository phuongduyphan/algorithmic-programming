import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Solution {
	public int plusesAndMinuses(int[] numbers, int sum) {
		ArrayList<Map<Integer, Integer>> listOfMaps = new ArrayList<>(numbers.length);
		
		for (int i = 0; i < numbers.length; i++) {
			listOfMaps.add(new HashMap<>());
		}
		
		return plusesAndMinuses(numbers.length - 1, numbers, sum, listOfMaps);
	}
	
	public int plusesAndMinuses(int i, int[] numbers, int sum, 
			ArrayList<Map<Integer, Integer>> listOfMaps) {
		if (i == -1) {
			if (sum == 0) return 1;
			return 0;
		}
		
		if (listOfMaps.get(i).containsKey(sum)) return listOfMaps.get(i).get(sum);
		
		int result = plusesAndMinuses(i - 1, numbers, sum - numbers[i], listOfMaps) +
				plusesAndMinuses(i - 1, numbers, sum + numbers[i], listOfMaps);
		
		listOfMaps.get(i).put(sum, result);
		return result;
	}
}
