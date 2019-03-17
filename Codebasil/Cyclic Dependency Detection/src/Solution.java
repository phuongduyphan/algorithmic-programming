import java.util.ArrayList;
import java.util.LinkedList;

public class Solution {
	public enum State {
		BLANK, PARTIAL, COMPLETED
	}
	
	public boolean cyclicDependencyDetection(int numPackages, int[][] dependencies) {
		ArrayList<LinkedList<Integer>> graph = new ArrayList<>(numPackages);
		ArrayList<State> stateList = new ArrayList<>(numPackages);
		
		for (int i = 0; i < numPackages; i++) {
    	stateList.add(i, State.BLANK);
    	graph.add(i, new LinkedList<>());
    }
		
    for (int i = 0; i < dependencies.length; i++) {
    	graph.get(dependencies[i][0]).add(dependencies[i][1]);
    }
    
    for (int i = 0; i < numPackages; i++) {
    	if (stateList.get(i) == State.BLANK) {
    		if (!dfs(i, graph, stateList)) return false;
    	}
    }
    return true;
  }
	
	public boolean dfs(int u, ArrayList<LinkedList<Integer>> graph, 
			ArrayList<State> stateList) {
		if (stateList.get(u) == State.PARTIAL) return false;
		
		
		if (stateList.get(u) == State.BLANK) {
			stateList.set(u, State.PARTIAL);
  		for (Integer v : graph.get(u)) {
  			if (!dfs(v, graph, stateList)) return false;
  		}
		}
		
		stateList.set(u,  State.COMPLETED);
		return true;
	}
}
