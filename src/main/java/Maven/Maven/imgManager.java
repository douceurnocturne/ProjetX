package Maven.Maven;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.JPanel;

public class ImgManager extends JPanel {

	public static final String DIR_DATA_NAME = "Donnees";

	public static final File DIR_DATA_FILE = new File(DIR_DATA_NAME);

	public ArrayList<Img> imgList;

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

	public void DataBaseClosed(ArrayList<Img> listImg) {
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
