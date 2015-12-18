import java.awt.Point;
import java.awt.Polygon;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PolygonControl {

	// MARK: - VARIÁVEIS
	final int width, height;
    Point startPoint;
    Point endPoint;
    List<Polygon> polygons = new ArrayList<Polygon>();
	List<Polygon> polygonsBounds = new ArrayList<Polygon>();
	
	// MARK: - CONSTRUTORES
	
	// CONSTRUTOR RECEBE O NÚMERO DE POLIGONOS, LARGURA E ALTURA DO FRAME
    public PolygonControl(int numbersOfPolygons, int w, int h) {
    	width = w;
    	height = h;
        initComponents(numbersOfPolygons);
    }
    
    
    // MÉTODO QUE INSTANCIA OS COMPONENTES (PONTO INICIAL, FINAL E POLIGONOS)
    private void initComponents(int nPolygons) {
    	// INSTANSIANDO startPoint E endPoint ALEATORIOS
    	startPoint = new Point(20, (int) (height * Math.random()));
    	endPoint   = new Point(width - 20, (int) (height * Math.random()));

    	// LIMITES PARA OS LADOS
    	int sideSizeMin = 10;
    	int sideSizeMax = 100;
    	
    	// CRIA UMA LISTA COM TAMANHOS DO LADO ALEATÓRIO
    	List<Integer> side = new ArrayList<Integer>();
    	
    	for (int i = 0; i < nPolygons; i++){
    		int largura = sideSizeMin + (int)(Math.random()*sideSizeMax); 
    		side.add(largura);
    	}
    	
    	// SORT PARA ORDEM DECRESCENTE
    	Collections.sort(side, Collections.reverseOrder());
    	
    	// CRIAÇÃO DOS POLIGONOS
    	for (int i = 0; i < nPolygons; i++) {
    		int sideSize = side.get(i); 
    		
    		// GERA OS VETORES COM OS PONTOS PARA CRIAR O POLIGONO
    		int x = (int) (Math.random()* (width - 200)) + 40;
        	int xPoly[] = {x, x, x + sideSize, x + sideSize};

        	int y = (int) (Math.random()* (height - 200 - 40));
        	int yPoly[] = {y, y + sideSize, y + sideSize, y};

    		// CRIA O POLIGONO E SEU POLIGONO LIMITANTE
    		Polygon polygon = new Polygon(xPoly, yPoly, xPoly.length);
    		Polygon polygonBound = createPolygonBound(xPoly, yPoly);
    		
    		// VERIFICA SE O POLIGO PODE SER ADD AO FRAME 
    		if(allowInsert(polygon)) {
    			polygons.add(polygon);
    			polygonsBounds.add(polygonBound);
    		}else{
    			// GARANTE QUE SERÃO INSERIDOS nPolygons
    			i--;
    		}
    	}
    }
	
    // MARK: - MÉTODOS DE CONTROLE
    
    // MÉTODO PARA CRIAR OS POLIGONOS LIMITANTES
 	Polygon createPolygonBound(int [] xPoly, int [] yPoly){
 		int xPolygonBound[] = new int[xPoly.length];
 		int yPolygonBound[] = new int[yPoly.length];
 		int length = xPoly.length;
 		
 		// PARA i = 0 E i = 2
 		for(int i = 0; i < 2; i+=2){
 			if(i == 0 ){
 				xPolygonBound[i] = xPoly[i] - 1;
 				xPolygonBound[i+1] = xPoly[i+1] - 1;
 				yPolygonBound[i] = yPoly[i] - 1;
 				yPolygonBound[i+1] = yPoly[i+1] + 1;
 			}else{
 				xPolygonBound[i] = xPoly[i] + 1;
 				xPolygonBound[i+1] = xPoly[i+1] + 1;
 				yPolygonBound[i] = yPoly[i] + 1;
 				yPolygonBound[i+1] = yPoly[i+1] - 1;
 			}
 		}
 		
 		return new Polygon(xPolygonBound, yPolygonBound, length);
 	}
    
 	
 	// MÉTODO PARA VERIFICAR SE ALGUMAS DAS LINHAS DO POLIGONO CRUZAM A ÁREA DE OUTRO POLIGONO
   	boolean allowInsert(Polygon p){
   		Point startPointLine, endPoitLine;
   		
   		// CRIAR CADA LINHA DO POLIGONO PARA PASSAR PARA O MÉTODO 
    	for(int i = 0; i < 4; i++){
    		startPointLine = new Point(p.xpoints[i], p.ypoints[i]);
    		if (i != 3) {
    			endPoitLine = new Point(p.xpoints[i+1], p.ypoints[i+1]);
    		} else {
    			endPoitLine = new Point(p.xpoints[0], p.ypoints[0]);
    		}
    		
    		Line2D line = new Line2D.Double(startPointLine, endPoitLine);
    		
    		// VERIFICA SE INTERSECTA COM A ÁREA DE ALGUM DOS POLIGONOS
    		if(intersectsWithPolygonsArea(line)){
    	    	return false;
   	    	}
    	}
    	return true;
    }
    
	// VERIFICA SE A LINHA RECEBIDA INTERSECTA COM A ÁREA DE ALGUM POLIGONO
	public boolean intersectsWithPolygonsArea(Line2D line){
		
		// PEGA AS INFORMAÇÕES DE CADA POLIGONO PARA COMPARAR COM A LINHA
		for(Polygon polygon : polygons){
			int xPoint = polygon.xpoints[0];
	    	int yPoint = polygon.ypoints[0];
	    	int width = polygon.xpoints[3] - xPoint;
	    	int height = polygon.ypoints[1] - yPoint;

	    	// COMPARA
	    	if(line.intersects(xPoint, yPoint, width, height)){
	    		return true;
	    	}
		}	
		return false;
	}
	
	// MÉTODO RETORNA UMA LISTA COM TODOS OS PONTOS DOS POLIGONOS LIMITANTES
	public List<Point> getPolygonsBoundsPoints(){
    	List<Point> allPoints = new ArrayList<Point>();
    	
    	// ADD O PONTO INICIAL
    	allPoints.add(startPoint); 
    	
    	Point pointAux;
    	for(Polygon polygon : polygonsBounds){
    		for(int i = 0; i < polygon.npoints; i++){
    			// CRIANDO CADA PONTO DO POLIGONO ATUAL
    			pointAux = new Point(polygon.xpoints[i], polygon.ypoints[i]);
    			allPoints.add(pointAux);
    		}
    	}
    	
    	allPoints.add(endPoint);
    	
    	return allPoints;
    }

	
	// MÉTODO QUE RETORNA OS FILHOS DO PONTO = PONTOS ALCANÇAVEIS POR ELE
    public List<Point> reachablePoints(Point startPoint){
    	List<Point> children = new ArrayList<Point>();
    	List<Point> allPoints = getPolygonsBoundsPoints();
    	
    	for (Point point : allPoints){
    		// EXCLUINDO A POSSIBILIDADE DE SE AUTO-ALCANÇAR
	    	if(point.getX() != startPoint.getX() && point.getY() != startPoint.getY()){
	    		Line2D line = new Line2D.Double(startPoint, point);
	    		if(!(intersectsWithPolygonsArea(line)))
	    			children.add(point);
	    	}
    	}

    	return children;
    }

    
}
