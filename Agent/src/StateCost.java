
public class StateCost {
	private State state;
	private int cost;
	
	public StateCost(State state, int cost) {
		this.state = state;
		this.cost = cost;
	}
	
	public State getState() {
		return state;
	}
	
	public int getCost() {
		return cost;
	}
}
