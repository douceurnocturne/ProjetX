package Maven.Maven;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JComponent;

class MyComponent extends JComponent implements MouseListener {

	/** generated. */
	private static final long serialVersionUID = 6845230025649741885L;
	private Map current_map;
	public ArrayList<CustomDefaultWaypoint> clickWaypointResults;

	public MyComponent(Map _map, ArrayList<CustomDefaultWaypoint> _clickWaypointResults) { // instanciation
																							// de
																							// mouseClick
		this.current_map = _map;
		this.clickWaypointResults = _clickWaypointResults;
	}

	public void mouseClicked(MouseEvent clic) {

		// on récupère les coordonnées de là où on 
		//clic sur la map
		Point mousePosition_Point = current_map.getMap().getMousePosition(); 
		
																				
		// appel de la méthode check de la classe 
		// regarder s'il y a des waypoints à côté du clic
		// et mettre à jour la liste clickWaypointsResults
		IsWaypointsAroundClick.check(this.current_map, mousePosition_Point, this.clickWaypointResults);

		if (!clickWaypointResults.isEmpty()) {
			System.out.println("Un waypoint a été trouvé à proximité");

		} else {
			System.out.println("Aucun waypoint à proximité");

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