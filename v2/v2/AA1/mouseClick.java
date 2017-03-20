package AA1.AA1;


import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Hashtable;

import javax.swing.JComponent;

import org.jxmapviewer.viewer.GeoPosition;
import org.jxmapviewer.viewer.Waypoint;

class MyComponent extends JComponent implements MouseListener {

	/** generated. */
	private static final long serialVersionUID = 6845230025649741885L;
	private Map map;
	private int current_zoom;
	private ArrayList<GeoPosition> listePoint = new ArrayList();
	private Hashtable dico = new Hashtable();
	public MyComponent(Map _map) {
		this.map = _map;
	}

	public void mouseClicked(MouseEvent clic) {

		this.current_zoom = this.map.getMap().getMainMap().getZoom();
		Point mousePosition_Point = map.getMap().getMousePosition();
		boolean flag = true;

		for (Waypoint currentPoint : map.getWayPoint()) {
			System.out.println(currentPoint.getPosition());
			GeoPosition waypoint_courant_geo = currentPoint.getPosition();
			Point2D waypoint_courant_Point2D = this.map.getMap().getMainMap()
					.convertGeoPositionToPoint(waypoint_courant_geo);
			Point waypoint_courant_Point = new Point((int) waypoint_courant_Point2D.getX(),
					(int) waypoint_courant_Point2D.getY());
			//
			int tolerance = 50;
			if (waypoint_courant_Point.x - mousePosition_Point.x < (tolerance - this.current_zoom)
					&& mousePosition_Point.y - waypoint_courant_Point.y < (tolerance - this.current_zoom)) {
				// on a cliqué sur le point
				System.out.println("HOURRRA");
				System.out.println("zoom" + current_zoom);
				System.out.println(listePoint);
			} else {
				flag = false;
			}

		}
		if (true) {
			
			GeoPosition point = this.map.getMap().getMainMap().convertPointToGeoPosition(mousePosition_Point);
			listePoint.add(point);
			
			/* metre l'image et ces coordonnée dans un tablde de h
			dico.put(IDimage, point);
			
			mettre l'image sur la carte
			*/
			this.map.addWaypoint(point);
		}
		/* il faut caster une des liste en point ou deoposition pour faire la comparaison
		for(int i=0; i<listePoint.size(); i++){
		if (mousePosition_Point==listePoint.get(i)){
			new FenetreClick(); ouverture d'une nouvelle fenetre avec differente actions
		}
		
	}
		*/
		
	}

	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
	}

}
public class mouseClick {

}
