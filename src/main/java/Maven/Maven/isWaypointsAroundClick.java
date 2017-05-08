package Maven.Maven;

import java.awt.Point;
import java.util.ArrayList;

import org.jxmapviewer.viewer.GeoPosition;

import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.LinearRing;

public class IsWaypointsAroundClick {

	public static void check(Map _map, Point _mousePosition, ArrayList<CustomDefaultWaypoint> clickWaypointResults) {

		// on efface les éléments de la liste des résultats pour la rafraichir
		clickWaypointResults.clear();

		// création d'un polygone à 4 côtés (rectangle)

		Point point_polygon_bg = new Point();
		Point point_polygon_bd = new Point();
		Point point_polygon_hg = new Point();
		Point point_polygon_hd = new Point();

		// coordonnées du polygone : bas gauche, bas droite, haut gauche, haut
		// droite, en fonction du clic
		// la hauteur et la largeur sont brutes et non logiques
		// il s'agit de mesures faites lors de tests, qui se rapprochent le plus
		// de l'image du waypoint sur la carte
		point_polygon_bg.setLocation(_mousePosition.getX() - 5, _mousePosition.getY());
		point_polygon_bd.setLocation(_mousePosition.getX() + 5, _mousePosition.getY());
		point_polygon_hg.setLocation(_mousePosition.getX() - 10, _mousePosition.getY() + 37);
		point_polygon_hd.setLocation(_mousePosition.getX() + 20, _mousePosition.getY() + 37);

		// transformation des coordonnées de pixel à long/lat
		GeoPosition geo_polygon_bg = _map.getMap().getMainMap().convertPointToGeoPosition(point_polygon_bg);
		GeoPosition geo_polygon_bd = _map.getMap().getMainMap().convertPointToGeoPosition(point_polygon_bd);
		GeoPosition geo_polygon_hg = _map.getMap().getMainMap().convertPointToGeoPosition(point_polygon_hg);
		GeoPosition geo_polygon_hd = _map.getMap().getMainMap().convertPointToGeoPosition(point_polygon_hd);

		// création d'un tableau répertoriant les coordonnées dans l'ordre de
		// création du polygone
		Coordinate[] coords = new Coordinate[5];
		coords[0] = new Coordinate(geo_polygon_bg.getLongitude(), geo_polygon_bg.getLatitude());
		coords[1] = new Coordinate(geo_polygon_hg.getLongitude(), geo_polygon_hg.getLatitude());
		coords[2] = new Coordinate(geo_polygon_hd.getLongitude(), geo_polygon_hd.getLatitude());
		coords[3] = new Coordinate(geo_polygon_bd.getLongitude(), geo_polygon_bd.getLatitude());
		coords[4] = new Coordinate(geo_polygon_bg.getLongitude(), geo_polygon_bg.getLatitude());

		// création du polygone à l'aide de GeometryFactory
		GeometryFactory geomFactory = new GeometryFactory();
		LinearRing polygonBoundary = geomFactory.createLinearRing(coords);

		Geometry polygon = geomFactory.createPolygon(polygonBoundary);

		// pour chaque waypoint apparaissant sur la carte, on va voir si l'un
		// d'eux est situé dans le polygone
		for (CustomDefaultWaypoint currentWaypoint : _map.getSetWaypoints()) {
			Geometry waypoint_to_test = geomFactory.createPoint(new Coordinate(
					currentWaypoint.getPosition().getLongitude(), currentWaypoint.getPosition().getLatitude()));

			// on ajoute chaque waypoint qui se trouve autour du clic dans la
			// liste clickWaypointsResults passée en paramètres
			if (polygon.contains(waypoint_to_test)) {
				clickWaypointResults.add(currentWaypoint);
			}

		}

	}

}
