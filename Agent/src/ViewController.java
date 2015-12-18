import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Polygon;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class ViewController {
	
	final SucessorFunction f = new SucessorFunction(5);
	
	public ViewController(){
		Agent agentBFS = new AgentBFS();
		//Agent agentDFS = new AgentDFS();
		Agent agentDFS_limited = new AgentDFS_limited(10);
		Agent agentDFS_iterative = new AgentDFS_iterative();
		Agent agentGreedy = new AgentGreedy();
		Agent agentA_Star = new AgentA_Star();
		
		createViewComponentsGENERIC(agentBFS, "AgentBFS");
		createViewComponentsGENERIC(agentDFS_limited, "AgentDFS_limited");
		createViewComponentsGENERIC(agentDFS_iterative, "AgentDFS_iterative");
		createViewComponentsGENERIC(agentGreedy, "AgentGreedy");
		createViewComponentsGENERIC(agentA_Star, "AgentA_Star");
		
		//createViewComponentsGENERIC(agentDFS, "AgentDFS");
	}
	
	void createViewComponentsGENERIC(Agent agent, String name) {
		JFrame frame = new JFrame(name);
		frame.setBackground(Color.WHITE);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setBounds(0, 0, 800, 600);
		
		final ArrayList<Node> solution = agent.treeSearch(f.polygonControl.startPoint,f.polygonControl.endPoint, f);
    	
    	JPanel jPanel = new JPanel() {

			private static final long serialVersionUID = 1L;

			@Override
    		protected void paintComponent(Graphics g) {
        		
        		super.paintComponent(g);
        		this.setBackground(Color.WHITE);
    			g.setColor(Color.BLACK);
    			g.drawOval(f.polygonControl.startPoint.x - 10, f.polygonControl.startPoint.y, 10, 10);
    			g.fillOval(f.polygonControl.endPoint.x, f.polygonControl.endPoint.y, 11, 11);

    			
    			for (Polygon p : f.polygonControl.polygons) {
    				g.fillPolygon(p);
    			}
    			
    			g.setColor(Color.RED);
    			for(int i = 0; i < solution.size(); i++){
    				Point point = solution.get(i).point;
    				g.drawLine(solution.get(i).parent.point.x, solution.get(i).parent.point.y, point.x, point.y);
    				
    			}
    			
    		}

    		@Override
    		public Dimension getPreferredSize() {
    			return new Dimension(800, 600);
    		}
    	};
    	
    	frame.add(jPanel);
    	frame.pack();
    	frame.setVisible(true);

	}
	
}
