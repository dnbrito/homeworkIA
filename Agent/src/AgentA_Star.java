
public class AgentA_Star extends AgentGreedy{

	int addG(Node node, SucessorFunction f, int position){
		if (f.costForNextCity.get(node.state).get(position) != null){
			return f.costForNextCity.get(node.state).get(position).getCost() + node.g;
		}
		return 0;
	}
	
}
