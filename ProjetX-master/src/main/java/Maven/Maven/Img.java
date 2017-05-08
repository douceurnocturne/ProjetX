package Maven.Maven;

import java.io.File;
import java.util.ArrayList;

public class Img {
	File file;
	float Lattitude;
	float Longitude;
	ArrayList<String> commentaire;
	String nom;

	public Img(File f, float la, float lon) {
		this.file = f;
		this.Lattitude = la;
		this.Longitude = lon;
		this.commentaire = new ArrayList<String>();
		this.nom = f.getName();
	}

	public void addComm(String com) throws EmptyStringException {
		if (com == "") {
			throw new EmptyStringException();
		} else {
			this.commentaire.add(com);
		}
	}

}
