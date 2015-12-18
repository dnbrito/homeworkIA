import java.awt.Point;
import java.util.ArrayList;
import java.util.Collections;

public abstract class Agent {
	
	ArrayList<Node> fringe = new ArrayList<Node>();
	// TRATAR DFS CONTRA LOOPS INFINITOS
	// ArrayList<Point> visited = new ArrayList<Point>();
	
	protected ArrayList<Node> treeSearch(Point initial, Point end, SucessorFunction f){
		fringe.add(new Node(initial, f.cost.get(initial)));
		while (true){
			if (fringe.isEmpty()){
				return null;
			}else{
				Node node = fringe.remove(0);
				//TRATAR DFS CONTRA LOOPS INFINITOS
				// visited.add(node.point);
				if (node.point == end){
					ArrayList<Node> solution = new ArrayList<Node>();
					while(node.parent != null){
						solution.add(node);
						node = node.parent;
					}
					Collections.reverse(solution);
					return solution;
				}else{
					addInFringe(node, f);
				}
			}
		}	
	}
	
	protected ArrayList<Node> expand(Node node, SucessorFunction f){
		ArrayList<Node> successors = new ArrayList<Node>();
		for (int i = 0; i < f.map.get(node.point).size(); i++){
			Node s = new Node();
			s.depth = node.depth+1;
			s.parent = node;
			
			CostFor cost = f.map.get(node.point).get(i);
			s.point = cost.destination;
			// h(x)
			s.path_cost = f.cost.get(s.point); 
			// g(x)
			s.g = addG(node, f, i); 
			// f(x) = g(x) + h(x);
			s.f = s.g + s.path_cost;
			
			successors.add(s);
		}
		return successors;
	}

	double addG(Node node, SucessorFunction f, int position){
		return 0;
	}
	
	abstract protected void add(Node node); 
	
	abstract protected void addInFringe(Node node, SucessorFunction f);
	
}
