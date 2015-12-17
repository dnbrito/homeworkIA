import java.util.ArrayList;

public class AppGreedy {
	public static void main(String[] args) {
		// CREATE AGENT
		
		AgentGreedy agentRomania = new AgentGreedy();
		
		// CREATE SUCESSOR FUNCTION
		
		SucessorFunctionRomania functionRomania = new SucessorFunctionRomania();
		
		// SELECT THE START AND END STATE
		
		State initialRomania = State.ARAD;
		State endRomania = State.BUCHAREST;

		// START SEARCH
		
		ArrayList<ActionState> listRomania = agentRomania.treeSearch(initialRomania, endRomania, functionRomania);
			
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
