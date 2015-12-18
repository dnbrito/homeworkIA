import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.awt.Point;

public abstract class SucessorFunction implements ISucessorFunction {
	Map<Point, List<CostFor>> map = new HashMap<Point, List<CostFor>>();
	Map<Point, Double> cost = new HashMap<Point, Double>();
	
	PolygonControl polygonControl;
	
	public SucessorFunction(){
		List<Point> points = new ArrayList<Point>();
		polygonControl = new PolygonControl(5, 800, 600);
		points = polygonControl.getPontosPlus();
		
		for(Point point : points){
			
			// ADD O CUSTO DE CADA PONTO AO PONTO FINAL
			cost.put(point, point.distance(polygonControl.endPoint));
			List<Point> pointChildren = polygonControl.intersectaPonto(point);
			for(Point point2 : pointChildren){
				// ADD O CUSTO DE UM PONTO PARA CADA OUTRO PONTO
				add(point, new CostFor(point2, calculateDistance(point, point2)));
			}
		}
				
	}
	
	
	// MÉTODO PARA CALCULAR A DISTÂNCIA ENTRE DOIS PONTOS
	public double calculateDistance(Point initialPoint, Point finalPoint){
		return initialPoint.distance(finalPoint);
	}
	
	// ADD NO HASHMAP
	@Override
	public void add(Point key, CostFor destination){
		List<CostFor> list = map.get(key);
		
		// VERIFICA SE A LISTA COM A "CHAVE" NÃO EXISTE ? CRIA, ADD NA LISTA E ADD NO HASHMAP : ADD NA LISTA QUE JÁ EXISTE
		if (list == null){
			list = new ArrayList<CostFor>();
			list.add(destination);
			map.put(key, list);
		}else{
			list.add(destination);
		}
	}

}
