import java.util.Collections;

public class AgentGreedy extends Agent{
	
	@Override
	protected void add(Node node) {
		for (int i = 0; i < node.children.size() ;i++)
			fringe.add(node.children.get(i));
			Collections.sort(fringe);
	}
	
	@Override
	protected void addInFringe(Node node, SucessorFunction f) {
		node.children = expand(node, f);
		add(node);
	}
	
}
