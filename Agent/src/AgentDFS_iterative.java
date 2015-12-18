
public class AgentDFS_iterative extends AgentDFS{
	int k = 1;
	
	public void add(Node node){
			
		if(node.children.get(0).depth <= k){
			for(int i = 0; i < node.children.size(); i++){
				fringe.add(node.children.get(i));
			}		k++;
		}
	}

}
