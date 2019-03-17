import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Solution {
	/**
	 * @param {int[][]} intervals
	 * @return {int[][]} List of merged intervals.
	 */
  public class Pair<T,U> {
  	public T first;
    public U second;
    
    public Pair(T first, U second) {
    	this.first = first;
      this.second = second;
    }
  }
  
	public int[][] badDayAtSchool(int[][] intervals) {
		ArrayList<Pair<Integer,Integer>> listIntervals = new ArrayList<>();
    ArrayList<Pair<Integer,Integer>> mergeIntervals = new ArrayList<>();
    
    for (int[] interval : intervals) {
    	listIntervals.add(new Pair(interval[0], interval[1]));
    }
    
    Collections.sort(listIntervals, new Comparator<Pair<Integer,Integer>>() {
    	@Override 
      public int compare(Pair<Integer,Integer> p1, Pair<Integer,Integer> p2) {
      	return p1.first.compareTo(p2.first);
      }
    });
    
    Pair<Integer,Integer> curInterval = listIntervals.get(0);
    for (int i = 1; i < listIntervals.size(); i++) {
      Pair<Integer,Integer> interval = listIntervals.get(i);
    	if (interval.first <= curInterval.second) { 
      	curInterval.second = curInterval.second < interval.second ?
        	interval.second : curInterval.second;
      } else {
      	mergeIntervals.add(curInterval);
        curInterval = interval;
      }
    }
    mergeIntervals.add(curInterval);
    
    int[][] mergeArr = new int[mergeIntervals.size()][2];
    for (int i = 0; i < mergeIntervals.size(); i++) {
    	mergeArr[i][0] = mergeIntervals.get(i).first;
      mergeArr[i][1] = mergeIntervals.get(i).second;
    }
    
    return mergeArr;
	}
}