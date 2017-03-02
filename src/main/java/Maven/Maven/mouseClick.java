package Maven.Maven;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Point2D;

import javax.swing.JComponent;

import org.jxmapviewer.viewer.GeoPosition;
import org.jxmapviewer.viewer.Waypoint;

class MyComponent extends JComponent implements MouseListener {

	/** generated. */
	private static final long serialVersionUID = 6845230025649741885L;
	private Carte map;
	private int current_zoom;

	public MyComponent(Carte _map) {
		this.map = _map;
	}

	public void mouseClicked(MouseEvent clic) {

		this.current_zoom = this.map.getCarte().getMainMap().getZoom();
		Point mousePosition_Point = map.getCarte().getMousePosition();
		boolean flag = true;

		for (Waypoint currentPoint : map.getWayPoint()) {
			System.out.println(currentPoint.getPosition());
			GeoPosition waypoint_courant_geo = currentPoint.getPosition();
			Point2D waypoint_courant_Point2D = this.map.getCarte().getMainMap()
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
			} else {
				flag = false;
			}

		}
		if (true) {
			GeoPosition point = this.map.getCarte().getMainMap().convertPointToGeoPosition(mousePosition_Point);
			this.map.addWaypoint(point);
		}

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