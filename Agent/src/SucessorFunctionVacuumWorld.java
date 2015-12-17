
public class SucessorFunctionVacuumWorld extends SucessorFunction {
	
	public SucessorFunctionVacuumWorld() {
		add(State.DIRTY_DIRTY_LEFT, new ActionState(State.CLEAN_DIRTY_LEFT, Action.SUCK));
		add(State.DIRTY_DIRTY_LEFT, new ActionState(State.DIRTY_DIRTY_LEFT, Action.LEFT));
		add(State.DIRTY_DIRTY_LEFT, new ActionState(State.DIRTY_DIRTY_RIGHT, Action.RIGHT));
		
		add(State.DIRTY_DIRTY_RIGHT, new ActionState(State.DIRTY_CLEAN_RIGHT, Action.SUCK));
		add(State.DIRTY_DIRTY_RIGHT, new ActionState(State.DIRTY_DIRTY_LEFT, Action.LEFT));
		add(State.DIRTY_DIRTY_RIGHT, new ActionState(State.DIRTY_DIRTY_RIGHT, Action.RIGHT));
		
		add(State.CLEAN_DIRTY_LEFT, new ActionState(State.CLEAN_DIRTY_LEFT, Action.SUCK));
		add(State.CLEAN_DIRTY_LEFT, new ActionState(State.CLEAN_DIRTY_LEFT, Action.LEFT));
		add(State.CLEAN_DIRTY_LEFT, new ActionState(State.CLEAN_DIRTY_RIGHT, Action.RIGHT));
		
		add(State.CLEAN_DIRTY_RIGHT, new ActionState(State.CLEAN_CLEAN_RIGHT, Action.SUCK));
		add(State.CLEAN_DIRTY_RIGHT, new ActionState(State.CLEAN_DIRTY_LEFT, Action.LEFT));
		add(State.CLEAN_DIRTY_RIGHT, new ActionState(State.CLEAN_DIRTY_RIGHT, Action.RIGHT));
		
		add(State.DIRTY_CLEAN_LEFT, new ActionState(State.CLEAN_CLEAN_LEFT, Action.SUCK));
		add(State.DIRTY_CLEAN_LEFT, new ActionState(State.DIRTY_CLEAN_LEFT, Action.LEFT));
		add(State.DIRTY_CLEAN_LEFT, new ActionState(State.DIRTY_CLEAN_RIGHT, Action.RIGHT));
		
		add(State.DIRTY_CLEAN_RIGHT, new ActionState(State.DIRTY_CLEAN_RIGHT, Action.SUCK));
		add(State.DIRTY_CLEAN_RIGHT, new ActionState(State.DIRTY_CLEAN_LEFT, Action.LEFT));
		add(State.DIRTY_CLEAN_RIGHT, new ActionState(State.DIRTY_CLEAN_RIGHT, Action.RIGHT));
		
		add(State.CLEAN_CLEAN_LEFT, new ActionState(State.CLEAN_CLEAN_LEFT, Action.SUCK));
		add(State.CLEAN_CLEAN_LEFT, new ActionState(State.CLEAN_CLEAN_LEFT, Action.LEFT));
		add(State.CLEAN_CLEAN_LEFT, new ActionState(State.CLEAN_CLEAN_RIGHT, Action.RIGHT));
		
		add(State.CLEAN_CLEAN_RIGHT, new ActionState(State.CLEAN_CLEAN_RIGHT, Action.SUCK));
		add(State.CLEAN_CLEAN_RIGHT, new ActionState(State.DIRTY_CLEAN_LEFT, Action.LEFT));
		add(State.CLEAN_CLEAN_RIGHT, new ActionState(State.CLEAN_CLEAN_RIGHT, Action.RIGHT));
	}
}

