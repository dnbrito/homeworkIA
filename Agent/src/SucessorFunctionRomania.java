import java.util.ArrayList;
import java.util.List;

public class SucessorFunctionRomania extends SucessorFunction {
	public SucessorFunctionRomania() {
		add(State.ARAD, new ActionState(State.SIBIU, Action.GOES_TO));
		add(State.ARAD, new ActionState(State.TIMISOARA, Action.GOES_TO));
		add(State.ARAD, new ActionState(State.ZERIND, Action.GOES_TO));
		
		add(State.BUCHAREST, new ActionState(State.FAGARAS, Action.GOES_TO));
		add(State.BUCHAREST, new ActionState(State.GIURGIU, Action.GOES_TO));
		add(State.BUCHAREST, new ActionState(State.PITEST, Action.GOES_TO));
		add(State.BUCHAREST, new ActionState(State.URZICENI, Action.GOES_TO));
		
		add(State.CRAIOVA, new ActionState(State.DOBRETA, Action.GOES_TO));
		add(State.CRAIOVA, new ActionState(State.PITEST, Action.GOES_TO));
		add(State.CRAIOVA, new ActionState(State.RIMNICU_VILCEA, Action.GOES_TO));
		
		add(State.DOBRETA, new ActionState(State.CRAIOVA, Action.GOES_TO));
		add(State.DOBRETA, new ActionState(State.MEHADIA, Action.GOES_TO));
		
		add(State.EFORIE, new ActionState(State.HIRSOVA, Action.GOES_TO));
		
		add(State.FAGARAS, new ActionState(State.BUCHAREST, Action.GOES_TO));
		add(State.FAGARAS, new ActionState(State.SIBIU, Action.GOES_TO));
		
		add(State.GIURGIU, new ActionState(State.BUCHAREST, Action.GOES_TO));
		
		add(State.HIRSOVA, new ActionState(State.EFORIE, Action.GOES_TO));
		add(State.HIRSOVA, new ActionState(State.URZICENI, Action.GOES_TO));
		
		add(State.IASI, new ActionState(State.NEAMT, Action.GOES_TO));
		add(State.IASI, new ActionState(State.VASLUI, Action.GOES_TO));
		
		add(State.LUGOJ, new ActionState(State.MEHADIA, Action.GOES_TO));
		add(State.LUGOJ, new ActionState(State.TIMISOARA, Action.GOES_TO));
		
		add(State.MEHADIA, new ActionState(State.LUGOJ, Action.GOES_TO));
		add(State.MEHADIA, new ActionState(State.DOBRETA, Action.GOES_TO));
		
		add(State.NEAMT, new ActionState(State.IASI, Action.GOES_TO));
		
		add(State.ORADEA, new ActionState(State.SIBIU, Action.GOES_TO));
		add(State.ORADEA, new ActionState(State.ZERIND, Action.GOES_TO));
		
		add(State.PITEST, new ActionState(State.BUCHAREST, Action.GOES_TO));
		add(State.PITEST, new ActionState(State.CRAIOVA, Action.GOES_TO));
		add(State.PITEST, new ActionState(State.RIMNICU_VILCEA, Action.GOES_TO));
		
		add(State.RIMNICU_VILCEA, new ActionState(State.CRAIOVA, Action.GOES_TO));
		add(State.RIMNICU_VILCEA, new ActionState(State.PITEST, Action.GOES_TO));
		add(State.RIMNICU_VILCEA, new ActionState(State.SIBIU, Action.GOES_TO));
		
		add(State.SIBIU, new ActionState(State.ARAD, Action.GOES_TO));
		add(State.SIBIU, new ActionState(State.FAGARAS, Action.GOES_TO));
		add(State.SIBIU, new ActionState(State.ORADEA, Action.GOES_TO));
		add(State.SIBIU, new ActionState(State.RIMNICU_VILCEA, Action.GOES_TO));
		
		add(State.TIMISOARA, new ActionState(State.ARAD, Action.GOES_TO));
		add(State.TIMISOARA, new ActionState(State.LUGOJ, Action.GOES_TO));
		
		add(State.URZICENI, new ActionState(State.BUCHAREST, Action.GOES_TO));
		add(State.URZICENI, new ActionState(State.HIRSOVA, Action.GOES_TO));
		add(State.URZICENI, new ActionState(State.VASLUI, Action.GOES_TO));
		
		add(State.VASLUI, new ActionState(State.IASI, Action.GOES_TO));
		add(State.VASLUI, new ActionState(State.URZICENI, Action.GOES_TO));
		
		add(State.ZERIND, new ActionState(State.ARAD, Action.GOES_TO));
		add(State.ZERIND, new ActionState(State.ORADEA, Action.GOES_TO));
		
		// Add the cost straight BUCHAREST
		
		addCost(State.ARAD, 366);
		addCost(State.BUCHAREST, 0); 
		addCost(State.CRAIOVA, 160); 
		addCost(State.DOBRETA, 242); 
		addCost(State.EFORIE, 161); 
		addCost(State.FAGARAS, 176); 
		addCost(State.GIURGIU, 77); 
		addCost(State.HIRSOVA, 151); 
		addCost(State.IASI, 226); 
		addCost(State.LUGOJ, 244); 
		addCost(State.MEHADIA, 241); 
		addCost(State.NEAMT, 234); 
		addCost(State.ORADEA, 380); 
		addCost(State.PITEST, 100); 
		addCost(State.RIMNICU_VILCEA, 193); 
		addCost(State.SIBIU, 253); 
		addCost(State.TIMISOARA, 329); 
		addCost(State.URZICENI, 80); 
		addCost(State.VASLUI, 199); 
		addCost(State.ZERIND, 374);
		
		// Add the cost for next city
		
		addCostForNextCity(State.ARAD, new StateCost(State.SIBIU, 140));
		addCostForNextCity(State.ARAD, new StateCost(State.TIMISOARA, 118));
		addCostForNextCity(State.ARAD, new StateCost(State.ZERIND, 75));
		
		addCostForNextCity(State.BUCHAREST, new StateCost(State.FAGARAS, 211));
		addCostForNextCity(State.BUCHAREST, new StateCost(State.GIURGIU, 90));
		addCostForNextCity(State.BUCHAREST, new StateCost(State.PITEST, 101));
		addCostForNextCity(State.BUCHAREST, new StateCost(State.URZICENI, 85));
		
		addCostForNextCity(State.CRAIOVA, new StateCost(State.DOBRETA, 120));
		addCostForNextCity(State.CRAIOVA, new StateCost(State.PITEST, 138));
		addCostForNextCity(State.CRAIOVA, new StateCost(State.RIMNICU_VILCEA, 146));
		
		addCostForNextCity(State.DOBRETA, new StateCost(State.CRAIOVA, 120));
		addCostForNextCity(State.DOBRETA, new StateCost(State.MEHADIA, 75));
		
		addCostForNextCity(State.EFORIE, new StateCost(State.HIRSOVA, 86));
		
		addCostForNextCity(State.FAGARAS, new StateCost(State.BUCHAREST, 211));
		addCostForNextCity(State.FAGARAS, new StateCost(State.SIBIU, 99));
		
		addCostForNextCity(State.GIURGIU, new StateCost(State.BUCHAREST, 90));
		
		addCostForNextCity(State.HIRSOVA, new StateCost(State.EFORIE, 86));
		addCostForNextCity(State.HIRSOVA, new StateCost(State.URZICENI, 98));
		
		addCostForNextCity(State.IASI, new StateCost(State.NEAMT, 87));
		addCostForNextCity(State.IASI, new StateCost(State.VASLUI, 92));
		
		addCostForNextCity(State.LUGOJ, new StateCost(State.MEHADIA, 70));
		addCostForNextCity(State.LUGOJ, new StateCost(State.TIMISOARA, 111));
		
		addCostForNextCity(State.MEHADIA, new StateCost(State.LUGOJ, 70));
		addCostForNextCity(State.MEHADIA, new StateCost(State.DOBRETA, 75));
		
		addCostForNextCity(State.NEAMT, new StateCost(State.IASI, 87));
		
		addCostForNextCity(State.ORADEA, new StateCost(State.SIBIU, 151));
		addCostForNextCity(State.ORADEA, new StateCost(State.ZERIND, 71));
		
		addCostForNextCity(State.PITEST, new StateCost(State.BUCHAREST, 101));
		addCostForNextCity(State.PITEST, new StateCost(State.CRAIOVA, 138));
		addCostForNextCity(State.PITEST, new StateCost(State.RIMNICU_VILCEA, 97));
		
		addCostForNextCity(State.RIMNICU_VILCEA, new StateCost(State.CRAIOVA, 146));
		addCostForNextCity(State.RIMNICU_VILCEA, new StateCost(State.PITEST, 97));
		addCostForNextCity(State.RIMNICU_VILCEA, new StateCost(State.SIBIU, 80));
		
		addCostForNextCity(State.SIBIU, new StateCost(State.ARAD, 140));
		addCostForNextCity(State.SIBIU, new StateCost(State.FAGARAS, 99));
		addCostForNextCity(State.SIBIU, new StateCost(State.ORADEA, 151));
		addCostForNextCity(State.SIBIU, new StateCost(State.RIMNICU_VILCEA, 80));
		
		addCostForNextCity(State.TIMISOARA, new StateCost(State.ARAD, 118));
		addCostForNextCity(State.TIMISOARA, new StateCost(State.LUGOJ, 111));
		
		addCostForNextCity(State.URZICENI, new StateCost(State.BUCHAREST, 85));
		addCostForNextCity(State.URZICENI, new StateCost(State.HIRSOVA, 98));
		addCostForNextCity(State.URZICENI, new StateCost(State.VASLUI, 142));
		
		addCostForNextCity(State.VASLUI, new StateCost(State.IASI, 92));
		addCostForNextCity(State.VASLUI, new StateCost(State.URZICENI, 142));
		
		addCostForNextCity(State.ZERIND, new StateCost(State.ARAD, 71));
		addCostForNextCity(State.ZERIND, new StateCost(State.ORADEA, 75));
	}

	private void addCost(State key, int value) {
		if (cost.get(key) == null){
			cost.put(key, value);
		}
	}

	private void addCostForNextCity(State key, StateCost stateCost){
		List<StateCost> list = costForNextCity.get(key);
		
		// VERIFICA SE A LISTA COM A "CHAVE" DO ESTADO ATUAL NÃO EXISTE ? CRIA, ADD NA LISTA E ADD NO HASHMAP : ADD NA LISTA QUE JÁ EXISTE
		if (list == null){
			list = new ArrayList<>();
			list.add(stateCost);
			costForNextCity.put(key, list);
		}else{
			list.add(stateCost);
		}
	}
	
}
