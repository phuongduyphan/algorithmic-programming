import java.util.Collection;
import java.util.HashMap;
import java.util.Stack;

public class Graph {
	private HashMap<String, Project> map = new HashMap<>();

	public Project getOrCreateNode(String name) {
		if (!map.containsKey(name)) {
			map.put(name, new Project(name));
		}
		return map.get(name);
	}

	public void addEdge(Project u, Project v) {
		u.addNeighbor(v);
	}

	public static Graph buildGraph(String[] projects, String[][] dependencies) {
		Graph graph = new Graph();

		for (String projectName : projects) {
			graph.getOrCreateNode(projectName);
		}

		for (String[] dependency : dependencies) {
			Project first = graph.getOrCreateNode(dependency[0]);
			Project second = graph.getOrCreateNode(dependency[1]);
			graph.addEdge(first, second);
		}

		return graph;
	}

	public Stack<Project> buildOrder() {
		Stack<Project> stackOrder = new Stack<>();

		Collection<Project> projects = this.map.values();
		for (Project project : projects) {
			project.setState(Project.State.BLANK);
		}

		for (Project project : projects) {
			if (project.getState() == Project.State.BLANK) {
				if (!this.dfs(project, stackOrder)) {
					return null;
				};
			}
		}

		return stackOrder;
	}

	private boolean dfs(Project project, Stack<Project> stackOrder) {
		if (project.getState() == Project.State.PARTIAL) {
			return false;
		}

		if (project.getState() == Project.State.BLANK) {
			project.setState(Project.State.PARTIAL);
			for (Project neighbor : project.getChildren()) {
				if (!dfs(neighbor, stackOrder)) {
					return false;
				}
			}
			stackOrder.push(project);
			project.setState(Project.State.COMPLETE);
		}
		return true;
	}
}
