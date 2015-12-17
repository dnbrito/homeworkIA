import java.awt.Point;
import java.awt.Polygon;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;

public class PolygonControl {
	
	private JFrame frame;
    private Point startPoint;
    private Point endPoint;
    public List<Polygon> poligonos = new ArrayList<Polygon>();
	List<Polygon> poligonosPlus = new ArrayList<Polygon>();
	//List<Point> solucao = new ArrayList<Point>();
	
	public Point getStartPoint() {
		return startPoint;
	}

	public void setStartPoint(Point startPoint) {
		this.startPoint = startPoint;
	}

	public Point getEndPoint() {
		return endPoint;
	}

	public void setEndPoint(Point endPoint) {
		this.endPoint = endPoint;
	}
	
	public List<Point> getPontosPlus(){
    	Point ponto;
    	List<Point> todosPontos = new ArrayList<Point>();

    	todosPontos.add(startPoint);
    	
    	for(Polygon p : poligonosPlus){
    		for(int i = 0; i < p.npoints; i++){
    			ponto = new Point(p.xpoints[i], p.ypoints[i]);
    			todosPontos.add(ponto);
    		}
    	}
    	todosPontos.add(endPoint);
    	return todosPontos;
    }
    
//    public List<Point> getPontos(){
//    	Point ponto;
//    	List<Point> todosPontos = new ArrayList<Point>();
//    	
//    	todosPontos.add(startPoint);
//    	
//    	for(Polygon p : poligonos){
//    		for(int i = 0; i < p.npoints; i++){
//    			ponto = new Point(p.xpoints[i], p.ypoints[i]);
//    			todosPontos.add(ponto);
//    		}
//    	}
//    	
//    	todosPontos.add(endPoint);
//    	return todosPontos;
//    }
    
	private Polygon criarPoligonoPlus(int [] xPoly, int [] yPoly){
		int [] xPolyPlus = new int[xPoly.length];
		int [] yPolyPlus = new int[xPoly.length];
		
		// for com i = 0 e i = 2
		for(int i = 0; i < xPolyPlus.length; i+=2){
			if(i == 0 ){
				xPolyPlus[i] = xPoly[i] - 1;
				xPolyPlus[i+1] = xPoly[i+1] - 1;
				yPolyPlus[i] = yPoly[i] - 1;
				yPolyPlus[i+1] = yPoly[i+1] + 1;
			}
			else{
				xPolyPlus[i] = xPoly[i] + 1;
				xPolyPlus[i+1] = xPoly[i+1] + 1;
				yPolyPlus[i] = yPoly[i] + 1;
				yPolyPlus[i+1] = yPoly[i+1] - 1;
			}
		}
		Polygon retorno = new Polygon(xPolyPlus, yPolyPlus, xPolyPlus.length);
		return retorno;
	}
	
	public double calcularDistancia(Point p1, Point p2){
		return p1.distance(p2);
	}
	
	
	// verifica se a linha cruza com cada poligono
	private boolean intersectaArea(Line2D linha){
		for(Polygon p : poligonos){
			int x = p.xpoints[0];
	    	int y = p.ypoints[0];
	    	int w = p.xpoints[2] - x;
	    	int h = p.ypoints[2] - y;
	    	
	    	if(linha.intersects(x, y, w, h))
	    		return true;
		}	
		return false;
	}
	
    public boolean intersectaPoligono(Polygon p){
        // Cria retas para comparar com os demais poligonos /*** MELHORAR ***/
    	for(int i = 0; i < 3; i++){
    		Line2D linha2 = new Line2D.Double(p.xpoints[i], p.ypoints[i], p.xpoints[i+1], p.ypoints[i+1]);
    		Line2D linha1 = new Line2D.Double(p.xpoints[i], p.ypoints[i], p.xpoints[4-i-1], p.ypoints[4-i-1]);
   	    	if(intersectaArea(linha1))
    	    	return true;
    	    else if(intersectaArea(linha2))
    	    	return true;
    		}
    	return false;
    }
    
    public List<Point> pontosAlcancaveis(Point pontoInicial){
    	List<Point> filhos = new ArrayList<Point>();
    	
    	for (Point p : getPontosPlus()) {
	    	if(p.getX() != pontoInicial.getX() && p.getY() != pontoInicial.getY()){
	    		Line2D linha = new Line2D.Double(pontoInicial, p);
	    		if(!(intersectaArea(linha)))
	    			filhos.add(p);
	    	}
    	}
    	
//	    for(int i = 0; i < todosPontos.size(); i++){
//	    	Point p = todosPontos.get(i);
//	    	if(p.getX() != pontoInicial.getX() && p.getY() != pontoInicial.getY()){
//	    		Line2D linha = new Line2D.Double(pontoInicial, p);
//	    		if(!(intersectaArea(linha)))
//	    			filhos.add(p);
//	    	}
//	    }

    	return filhos;
    }
    
    private int [] gerarY(int heightFrame, int larguraDoPoligon){
    	int y = (int) (Math.random()* (heightFrame - 200 - 10));
    	int yPoly [] = {y, y + larguraDoPoligon, y + larguraDoPoligon, y};
    	return yPoly;
    }
    
    private int [] gerarX(int widhtFrame, int larguraDoPoligono){
    	int x = (int) (Math.random()* (widhtFrame - 200)) + 30;
    	int xPoly[] = {x, x, x + larguraDoPoligono, x + larguraDoPoligono };
    	return xPoly;
    }
    
    public PolygonControl() {

        initComponents();
        
    }
    
    private void initComponents() {
    	int width = 800;
    	int height = 600;
    	
    	// startPoint com x = 10 e y = aleatorio
    	startPoint = new Point(10, (int) (height * Math.random()));
    	// endPoint com x = largura do frame - 10 e altura = aleatoria
    	endPoint   = new Point(width - 10, (int) (height * Math.random()));
    	// numero de poligonos
    	int nPolygons = 5;

    	// Cria os poligonos
    	for (int i = 0; i < nPolygons; i++) {
    		// largura default do poligono
    		int largura = 100;
    		
    		// Recebe os vetores com os pontos para criar o poligono
    		int xPoly[] = gerarX(width, largura);
    		int yPoly[] = gerarY(height, largura);
    		
    		// Cria os poligonos e seus bounds
    		Polygon poly = new Polygon(xPoly, yPoly, xPoly.length);
    		Polygon polyPlus = criarPoligonoPlus(xPoly, yPoly);
    		
    		if(!(intersectaPoligono(poly))){
    			poligonos.add(poly);
    			poligonosPlus.add(polyPlus);
    		}
    		else
    			i--;	     
    	}
    }
}
