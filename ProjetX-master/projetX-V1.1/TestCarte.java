


import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Point2D;
import java.util.HashSet;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;



import com.roots.map.MapPanel;

public class TestCarte implements MouseListener, ActionListener{
	
	public static MapPanel mapPanel = new MapPanel();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		 // just a JPanel extension, add to any swing/awt container
		mapPanel.setZoom(10); // set some zoom level (1-18 are valid)
		double lon = 1.87;
		double lat = 44.07;
		Point position = mapPanel.computePosition(new Point2D.Double(lon, lat));
		mapPanel.setCenterPosition(position); // sets to the computed position
		mapPanel.repaint(); // if already visible trigger a repaint here
		
		TestCarte cartecarte = new TestCarte();
		
		
		JFrame frame = new JFrame("Carte");
		frame.getContentPane().add(mapPanel);
		frame.setSize(800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		Point a = mapPanel.getCenterPosition();
		
		frame.setLayout(new FlowLayout());
		
		Button ajoutImage = new Button ("ajouter image");
		frame.add(ajoutImage);
		ajoutImage.addActionListener(cartecarte);
		
	}
		public void paintComponent(Graphics g) {
			
			g.setColor(Color.black);
			g.fillOval(400, 400, 400, 400);
			mapPanel.repaint();
	}
		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}

}



