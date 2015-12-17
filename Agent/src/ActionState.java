
public class ActionState {
	private State state;
	private Action action;
	
	public ActionState(State state, Action action) {
		this.state = state;
		this.action = action;
	}
	
	public State getState() {
		return state;
	}
	
	public Action getAction() {
		return action;
	}
}
