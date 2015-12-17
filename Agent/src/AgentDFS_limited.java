
public class AgentDFS_limited extends AgentDFS {
	int depth_limit;
	
	public AgentDFS_limited(int k) {
		depth_limit = k;
	}
	
	protected void add(Node node) {
		if (node.children.get(0).depth < depth_limit) {
			for (int i = fringe.size()-1; i >= 0; i--)
				stack.push(fringe.remove(i));
			
			for (int j = node.children.size()-1; j >= 0  ;j--)
				stack.push(node.children.get(j));
			
			for (int k = 0; k < stack.size();k++)
				fringe.add(stack.pop());
		}
	}
	
}
