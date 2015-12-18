
public class AgentA_Star extends AgentGreedy{

	double addG(Node node, SucessorFunction f, int position){
		return node.g + f.map.get(node.point).get(position).cost;
	}
}
