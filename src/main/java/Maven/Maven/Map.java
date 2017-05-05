package Maven.Maven;

import java.awt.Component;
import java.awt.event.MouseListener;
import java.io.IOException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.jxmapviewer.JXMapKit;
import org.jxmapviewer.viewer.GeoPosition;

public class Map {

	private JXMapKit map;
	private Set<CustomDefaultWaypoint> set_waypoints; // Set des
														// CustomDefaultWaypoint
														// qui seront dessinés
														// sur la map
	private CustomPainter painter;
	private ImgManager imgManager; // ImgManager qui contient la liste des Img
	private Component clickOnMap;
	private ArrayList<CustomDefaultWaypoint> clickWaypointResults; 
	private ArrayList<Img> ImgWaypointsResults;
	// Liste qui contient
																	// les
																	// résultats
																	// (CustomDefaultWaypoint
																	// d'un clic
																	// sur la
																	// map)

	public Map() {

		this.imgManager = new ImgManager();
		this.set_waypoints = new HashSet<CustomDefaultWaypoint>(); // instanciation
																	// des
																	// divers
																	// outils
																	// nécessaires
																	// à la map
		this.clickWaypointResults = new ArrayList<CustomDefaultWaypoint>();

		this.map = new JXMapKit();
		this.map.setDefaultProvider(JXMapKit.DefaultProviders.OpenStreetMaps);
		
		Component clic_on_map = new MyComponent(this, this.clickWaypointResults);		
		this.map.getMainMap().addMouseListener(((MouseListener) clic_on_map));
		
		this.painter = new CustomPainter();
		this.map.getMainMap().setOverlayPainter(painter);
		this.init();
	}

	public void paint() {
		this.painter.setWaypoints(set_waypoints); // donne au painter la liste
													// des Waypoints
		this.map.getMainMap().repaint();
	}

	public JXMapKit getMap() { // getter de la map
		return this.map;
	}

	public ImgManager getImgManager() { // getter de ImgManager
		return this.imgManager;
	}

	public ArrayList<Img> getImgList() { // getter de la liste des Img présente
											// dans ImgManager
		return this.imgManager.imgList;
	}

	public ArrayList<CustomDefaultWaypoint> getClickWaypointResult() { // getter
																		// de la
																		// liste
																		// des
																		// Waypoints
																		// présents
																		// autour
																		// du
																		// clic
		return this.clickWaypointResults;
	}
	
	public ArrayList<Img> getImgWaypointsResult() {
		this.ImgWaypointsResults = new ArrayList<Img>();
		
		for (int i=0; i<this.getClickWaypointResult().size(); i++) {
			int current_key = this.getClickWaypointResult().get(i).getKey();
			this.ImgWaypointsResults.add(this.getImgList().get(current_key));
		}
		
		return this.ImgWaypointsResults;
	}
	
	public void addWaypoint(double coord_x, double coord_y, int key) { // ajoute
																		// un
																		// waypoint
																		// au
																		// Set
																		// de
																		// waypoints
		this.set_waypoints.add(new CustomDefaultWaypoint(coord_x, coord_y, key));
		this.paint();
	}

	public void addWaypoint(GeoPosition point, int key) { // ajoute un waypoint
															// au set de
															// waypoints
		this.set_waypoints.add(new CustomDefaultWaypoint(point, key));
		this.paint();
	}

	public void addImg() throws IOException { // ouvre une fenetre parcourir,
												// ajoute l'Img à la liste
												// d'images présente dans
												// imgManager
												// et ajoute un waypoint
												// correspondant à sa latitude
												// et longitude

		Img new_image = ImageExtract.LoadImage();
		this.imgManager.imgList.add(new_image);
		System.out.println("latitude");
		System.out.println("longitude");

		this.addWaypoint(new_image.Lattitude, new_image.Longitude, this.imgManager.imgList.size() - 1);

	}

	public void centerImg(GeoPosition pos) { // permet de centrer à la position
												// voulue
		this.map.getMainMap().setCenterPosition(pos);
		this.paint();
	}

	public void init() { // si on instancie la map avec une liste d'images non
							// vide, alors on va chercher chaque image
							// et créer un waypoint pour chacun, avant de paint
							// sur la carte,

		if (!this.imgManager.imgList.isEmpty()) {

			for (int i = 0; i < this.imgManager.imgList.size(); i++) {
				this.set_waypoints.add(new CustomDefaultWaypoint(this.imgManager.imgList.get(i).Lattitude,
						this.imgManager.imgList.get(i).Longitude, i));
			}
		}

		this.paint();

	}

	public Collection<? extends CustomDefaultWaypoint> getSetWaypoints() { // retourne
																			// le
																			// set
																			// de
																			// waypoints
		return this.set_waypoints;
	}

}