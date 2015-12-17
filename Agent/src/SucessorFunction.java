import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class SucessorFunction implements ISucessorFunction {
	Map<State, List<ActionState>> map = new HashMap<State, List<ActionState>>();
	Map<State, Integer> cost = new HashMap<State, Integer>();
	Map<State, List<StateCost>> costForNextCity = new HashMap<State, List<StateCost>>();
	
	@Override
	public void add(State key, ActionState actionState){
		List<ActionState> list = map.get(key);
		
		// VERIFICA SE A LISTA COM A "CHAVE" DO ESTADO ATUAL NÃO EXISTE ? CRIA, ADD NA LISTA E ADD NO HASHMAP : ADD NA LISTA QUE JÁ EXISTE
		if (list == null){
			list = new ArrayList<>();
			list.add(actionState);
			map.put(key, list);
		}else{
			list.add(actionState);
		}
	}

}
