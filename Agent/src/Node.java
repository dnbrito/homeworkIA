import java.awt.Point;
import java.util.ArrayList;

public class Node implements Comparable<Node>{
	int depth;
	Node parent;
	Point point;
	ArrayList<Node> children;
	
	// f(State) = g(State) + h(State)
	// path_cost == h(State)
	double f, g, path_cost;
	
	public Node() {
		children = null;
	}
	
	public Node (Point p){
		point = p;
		depth = 0;
		f = 0;
		g = 0;
		path_cost = 0;
		parent = null;
		children = null;
	}

	public Node (Point p, double cost){
		point = p;
		depth = 0;
		f = 0;
		g = 0;
		path_cost = cost;
		parent = null;
		children = null;
	}
	
	@Override
	public int compareTo(Node o) {
//        // For ascending order
        return (int) ((int) this.f-o.f);
	}
	
}
