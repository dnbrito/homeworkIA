
public class AgentBFS extends Agent {
	
	@Override
	protected void add(Node node) {
		for (int i = 0; i < node.children.size() ;i++)
			fringe.add(node.children.get(i));
	}
	
}
