import java.util.ArrayList;

public class AgentDFS extends Agent {

	ArrayList<Node> stack = new ArrayList<Node>();
	
	@Override
	protected void add(Node node) {
		for (int i = fringe.size()-1; i >= 0; i--)
			stack.add(fringe.remove(i));
		
		for (int j = node.children.size()-1; j >= 0  ;j--)
			stack.add(node.children.get(j));
		
		for (int k = stack.size()-1; k >= 0; k--){
			Node node1 = stack.get(k);
			//if(!visited.contains(node1.point))
				fringe.add(node1);
		}
			
	}
	
}
