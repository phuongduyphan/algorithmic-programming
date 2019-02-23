import java.util.ArrayList;

public class Project {
	public enum State { COMPLETE, PARTIAL, BLANK }; 
	
	private String name;
	private ArrayList<Project> children = new ArrayList<>();
	private State state;
	
	public Project(String name) {
		this.name = name;
	}
	
	public void addNeighbor(Project v) {
		this.children.add(v);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Project> getChildren() {
		return children;
	}

	public void setChildren(ArrayList<Project> children) {
		this.children = children;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}
	
}
