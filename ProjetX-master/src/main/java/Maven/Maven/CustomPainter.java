package Maven.Maven;

import java.util.Set;

import org.jxmapviewer.viewer.Waypoint;
import org.jxmapviewer.viewer.WaypointPainter;

class CustomPainter extends WaypointPainter<Waypoint> {

	public void setWaypoints(Set<? extends Waypoint> waypoints) {
		super.setWaypoints(waypoints);
	}
}