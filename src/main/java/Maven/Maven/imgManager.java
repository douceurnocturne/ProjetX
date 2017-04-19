package Maven.Maven;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JPanel;

public class ImgManager extends JPanel {
	public ArrayList<Img> imgList;

	// public static void main(String[] args) {
	// File f = new File("Donnees\\image.png");
	// System.out.println(f.getAbsolutePath());
	// }

	public ImgManager() {
		this.imgList = new ArrayList<Img>();
		File dossier;
		try {
			dossier = new File("Donnees").getCanonicalFile();
			String[] liste = dossier.list();
			for (int i = 0; i < liste.length; i++) {
				if (liste[i].endsWith(".jpg") || liste[i].endsWith(".gif") || liste[i].endsWith(".png")
						|| liste[i].endsWith(".bnp") || liste[i].endsWith(".tif")) {
					File f = new File("Donnees\\" + liste[i]).getCanonicalFile();
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

}
