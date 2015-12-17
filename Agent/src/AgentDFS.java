import java.util.Stack;


public class AgentDFS extends Agent {

	Stack<Node> stack = new Stack<Node>();
	
	@Override
	protected void add(Node node) {
		for (int i = fringe.size()-1; i >= 0; i--)
			stack.push(fringe.remove(i));
		
		for (int j = node.children.size()-1; j >= 0  ;j--)
			stack.push(node.children.get(j));
		
		for (int k = 0; k < stack.size();k++)
			fringe.add(stack.pop());

	}

	@Override
	protected void addInFringe(Node node, SucessorFunction f) {
		node.children = expand(node, f);
		if (node.children.isEmpty()) {
			if (node.parent.children.size() == 1) {
				Node aux = node.parent;
				aux.parent.children.remove(0);
				aux.parent = null;
			} else {
				node.parent.children.remove(0);
				node.parent = null;
			}
		} else {
			add(node);
		}
	}
	
}
