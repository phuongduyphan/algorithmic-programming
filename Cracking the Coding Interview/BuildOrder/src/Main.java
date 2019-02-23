import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] projects = { "a", "b", "c", "d", "e", "f" };
		String[][] dependencies = { { "a", "d" }, { "f", "b" }, { "b", "d" }, { "f", "a" },
				{ "d", "c" }, { "d", "e" } };

		Graph graph = Graph.buildGraph(projects, dependencies);
		Stack<Project> stackOrder = graph.buildOrder();

		if (stackOrder == null) {
			System.out.println("Cannot find build order");
		} else {
			while (!stackOrder.isEmpty()) {
				System.out.print(stackOrder.pop().getName() + " ");
			}
		}
	}

}
