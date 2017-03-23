package projetUMLv2.AA1;

import java.awt.Component;
import java.awt.event.MouseListener;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import javax.swing.*;
import org.jxmapviewer.JXMapKit;
import org.jxmapviewer.viewer.DefaultWaypoint;
import org.jxmapviewer.viewer.GeoPosition;
import org.jxmapviewer.viewer.Waypoint;

public class Carte {
	private JXMapKit map;
	private Set<DefaultWaypoint> waypoints;
	private CustomPainter painter;

	public Carte() {
		this.waypoints = new HashSet<DefaultWaypoint>();
		this.waypoints.add(new DefaultWaypoint(51.50, -0.12));

		this.map = new JXMapKit();
		this.map.setDefaultProvider(JXMapKit.DefaultProviders.OpenStreetMaps);

		this.painter = new CustomPainter();

		this.map.getMainMap().setOverlayPainter(painter);
		Component mouseClick = new MyComponent(this);
		this.map.getMainMap().addMouseListener(((MouseListener) mouseClick));
	}

	public void paint() {
		this.painter.setWaypoints(waypoints);
		this.map.getMainMap().repaint();
	}

	public JXMapKit getCarte() {
		return this.map;
	}

	public void addWaypoint(double xpx, double ypx) {
		this.waypoints.add(new DefaultWaypoint(xpx, ypx));
		this.paint();
	}

	public Collection<? extends Waypoint> getWayPoint() {
		return waypoints;
	}

	public void addWaypoint(GeoPosition point) {
		this.waypoints.add(new DefaultWaypoint(point));
		this.paint();
	}
}