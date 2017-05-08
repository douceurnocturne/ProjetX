package Maven.Maven;

import org.jxmapviewer.viewer.DefaultWaypoint;
import org.jxmapviewer.viewer.GeoPosition;

public class CustomDefaultWaypoint extends DefaultWaypoint {

	private int key;
	private GeoPosition position;

	public CustomDefaultWaypoint(double latitude, double longitude, int _key) {
		super(latitude, longitude);
		this.key = _key;

	}

	public CustomDefaultWaypoint(GeoPosition coord, int _key) {
		super(coord);
		this.key = _key;
	}

	public int getKey() {
		return this.key;
	}
}
