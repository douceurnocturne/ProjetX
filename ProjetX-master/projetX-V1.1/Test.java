package T;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseListener;
import java.awt.geom.Point2D;
import java.util.HashSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import org.jxmapviewer.JXMapViewer;
import org.jxmapviewer.OSMTileFactoryInfo;
import org.jxmapviewer.viewer.DefaultTileFactory;
import org.jxmapviewer.viewer.GeoPosition;
import org.jxmapviewer.viewer.TileFactoryInfo;
import org.jxmapviewer.viewer.Waypoint;
import org.jxmapviewer.viewer.WaypointPainter;

import com.roots.map.MapPanel;

public class Test {
	
	public static MapPanel mapPanel = new MapPanel();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		 // just a JPanel extension, add to any swing/awt container
		mapPanel.setZoom(10); // set some zoom level (1-18 are valid)
		double lon = 3.69;
		double lat = 45.33;
		Point position = mapPanel.computePosition(new Point2D.Double(lon, lat));
		mapPanel.setCenterPosition(position); // sets to the computed position
		mapPanel.repaint(); // if already visible trigger a repaint here
		mapPanel.setSize(new Dimension(1024,1024));
		
		Point b = mapPanel.getMapPosition(); //position en haut à gauche
		System.out.println(b);
		java.awt.geom.Point2D.Double p =mapPanel.getLongitudeLatitude(b); //position lat long en haut à gauche
					
		//Point a = mapPanel.getCenterPosition();
		
		JButton jj = new JButton();
		jj.setBackground(Color.green);
		jj.setSize(1024,1024);
	
		System.out.println(p);
		jj.setBounds(256,256, 10, 10);
		JLayeredPane j = new JLayeredPane();
		//j.add(jj, Integer.valueOf(2));
		j.add(mapPanel, Integer.valueOf(1));
		
		
		j.setSize(1024,1024);
		j.setVisible(true);
		
		JFrame frame = new JFrame("Carte");
		
		frame.getContentPane().add(j);
		
		frame.setSize(1024,1024);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
	}
		
}
