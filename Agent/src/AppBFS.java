import java.util.ArrayList;

public class AppBFS {
	public static void main(String[] args) {
		
		// CREATE AGENTS
		
		AgentBFS agentVacuumWorld = new AgentBFS();
		AgentBFS agentRomania = new AgentBFS();
		
		// CREATE SUCESSOR FUNCTIONS
		
		SucessorFunctionVacuumWorld functionVacuumWorld = new SucessorFunctionVacuumWorld();
		SucessorFunctionRomania functionRomania = new SucessorFunctionRomania();
		
		// SELECT THE START AND END STATES
		
		State initialVacuumWorld = State.DIRTY_DIRTY_LEFT;
		State endVacuumWorld = State.CLEAN_CLEAN_RIGHT;
		
		State initialRomania = State.ORADEA;
		State endRomania = State.NEAMT;

		// START SEARCH
		
		ArrayList<ActionState> listVacuumWorld = agentVacuumWorld.treeSearch(initialVacuumWorld, endVacuumWorld, functionVacuumWorld);
		ArrayList<ActionState> listRomania = agentRomania.treeSearch(initialRomania, endRomania, functionRomania);
		
		// PRINT VACUUM WORLD RESULTS
		
		System.out.println("### Vacuum World ###\n");
		
		if(listVacuumWorld != null){
			System.out.print("From "+initialVacuumWorld);
			for (int i = 0; i < listVacuumWorld.size(); i++){
				if(i == 0)
					System.out.println(" arrived in "+listVacuumWorld.get(i).getState()+" with action "+listVacuumWorld.get(i).getAction());
				else
					System.out.println("From " +listVacuumWorld.get(i-1).getState()+ " arrived in "+listVacuumWorld.get(i).getState()+" with action "+listVacuumWorld.get(i).getAction());
			}
			System.out.println("\nDestination: "+endVacuumWorld);
		}else{
			System.out.println("Not found!");
		}
		System.out.println("\n----------------------------------------");
			
		// PRINT ROMANIA RESULTS
		
		System.out.println("### Romania Map ###\n");
		if (listRomania != null) {
			System.out.print("From " + initialRomania +" ");
			for (int i = 0; i < listRomania.size(); i++){
				if(i == 0)
					System.out.println(listRomania.get(i).getAction() + " " +listRomania.get(i).getState());
				else
					System.out.println("From "+ listRomania.get(i-1).getState() + " " + listRomania.get(i).getAction() + " " + listRomania.get(i).getState());
			}
			System.out.println("\nDestination: "+endRomania);
		}else{
			System.out.println("Not found!");
		}
		System.out.println("\n----------------------------------------");
	}
}

