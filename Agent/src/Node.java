import java.util.ArrayList;

public class Node implements Comparable<Node>{
	int depth;
	Node parent;
	State state;
	Action action;
	ArrayList<Node> children;
	
	// f(State) = g(State) + h(State)
	// path_cost == h(State)
	int path_cost;
	int f;
	int g;
	
	public Node() {
		children = null;
	}
	
	public Node (State initial){
		depth = 0;
		f = 0;
		g = 0;
		path_cost = 0;
		parent = null;
		state = initial;
		children = null;
	}

	@Override
	public int compareTo(Node o) {
        // For ascending order
        return this.f-o.f;
	}
	
}
