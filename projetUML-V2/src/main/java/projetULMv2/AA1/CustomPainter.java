package projetUMLv2.AA1;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.jxmapviewer.JXMapViewer;
import org.jxmapviewer.viewer.Waypoint;
import org.jxmapviewer.viewer.WaypointPainter;

class CustomPainter extends WaypointPainter<Waypoint> {

	public void setWaypoints(Set<? extends Waypoint> waypoints) {
		super.setWaypoints(waypoints);
	}
}