package Maven.Maven;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class ImgManager {

	public static final String DIR_DATA_NAME = "Donnees";

	public static final File DIR_DATA_FILE = new File(DIR_DATA_NAME);

	public ArrayList<Img> imgList;

	// Parcours le dossier est initialiste la liste des img avec
	// toute les images présente dans le dossier
	public ImgManager() {
		this.imgList = new ArrayList<Img>();
		File dossier;
		try {
			dossier = new File("Donnees").getCanonicalFile();
			String[] liste = dossier.list();
			for (int i = 0; i < liste.length; i++) {
				if (liste[i].endsWith(".jpg") || liste[i].endsWith(".gif") || liste[i].endsWith(".png")
						|| liste[i].endsWith(".bnp") || liste[i].endsWith(".tif")) {
					File f = new File(DIR_DATA_FILE, liste[i]).getCanonicalFile();
					float lon = ImageExtract.getLatitude(f);
					float lat = ImageExtract.getLongitude(f);
					Img im = new Img(f, lon, lat);
					this.imgList.add(im);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// vérifie que l'utilisateur n'a pas ajouter d'image dans le dossier Donnees
	// a la fermeture du logiciel
	public static void DataBaseClosed(ArrayList<Img> listImg) {
		File dossier;
		try {
			dossier = new File("Donnees").getCanonicalFile();
			String[] liste = dossier.list();
			for (int i = 0; i < liste.length; i++) {
				File f = new File(DIR_DATA_FILE, liste[i]).getCanonicalFile();
				Img image = new Img(f, ImageExtract.getLatitude(f), ImageExtract.getLongitude(f));
				if (!(listImg.contains(image))) {
					f.delete();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
