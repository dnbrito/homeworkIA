import java.util.ArrayList;
import java.util.Collections;

public abstract class Agent {
	
	ArrayList<Node> fringe = new ArrayList<Node>();
	
	protected ArrayList<ActionState> treeSearch(State initial, State end, SucessorFunction f){
		fringe.add(new Node(initial));
		while (true){
			if (fringe.isEmpty()){
				return null;
			}else{
				Node node = fringe.remove(0);
				if (node.state == end){
					ArrayList<ActionState> solution = new ArrayList<ActionState>();
					while(node.parent != null){
						solution.add(new ActionState(node.state, node.action));
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
		for (int i = 0; i < f.map.get(node.state).size(); i++){
			ActionState current = f.map.get(node.state).get(i);
			Node s = new Node();
			s.parent = node;
			s.action = current.getAction();
			s.state = current.getState();
			s.depth = node.depth+1;
			if (f.cost.get(s.state) != null) {
				s.path_cost = f.cost.get(s.state);
				s.g = addG(node, f, i);
				s.f = s.g + s.path_cost;
			}
			successors.add(s);
		}
		return successors;
	}

	int addG(Node node, SucessorFunction f, int position){
		return 0;
	}
	
	abstract protected void add(Node node); 
	
	abstract protected void addInFringe(Node node, SucessorFunction f);
	
}
