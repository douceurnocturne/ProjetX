package Maven.Maven;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collection;

import javax.swing.JFileChooser;

import org.apache.commons.io.IOUtils;

import com.drew.imaging.ImageMetadataReader;
import com.drew.imaging.ImageProcessingException;
import com.drew.metadata.Metadata;
import com.drew.metadata.exif.GpsDescriptor;
import com.drew.metadata.exif.GpsDirectory;

public class ImageExtract {

	// Methode qui ouvre un gestionaire de fichier permetant de selectionner une
	// image
	// qui sera convertis en format img
	public static Img LoadImage() throws IOException {
		File repertoireCourant = null;
		try {
			repertoireCourant = new File(".").getCanonicalFile();
			System.out.println("Repertoire courant : " + repertoireCourant);
		} catch (IOException e) {
			System.out.print("Erreur");
		}

		JFileChooser dialogue = new JFileChooser(repertoireCourant);

		dialogue.showOpenDialog(null);

		System.out.println("Fichier choisi : " + dialogue.getSelectedFile());
		File f = dialogue.getSelectedFile();
		String name = f.getName();
		Img monimage = null;
		try {
			monimage = new Img(f, getLatitude(f), getLongitude(f));
		} catch (java.lang.ArrayIndexOutOfBoundsException e) {
			// si l'image n'a pas de coordonées gps ont lui ajoute 0,0
			monimage = new Img(f, 0, 0);
		}
		InputStream input = new FileInputStream(f);
		File dossier;
		try {// Si l'image existe deja dans le dossier
			dossier = new File("Donnees").getCanonicalFile();
			String[] liste = dossier.list();
			int i = 0;

			boolean contain = false;
			while (i < liste.length) {
				// si l'image existe déjà dans notre img manager
				if (liste[i].equals(name)) {
					contain = true;
				}
				i++;
			}
			if (contain == true) {
				int j = 0;
				int cpt = 0;
				while (j < liste.length) {
					String[] prefixe = name.split("\\.");
					if (liste[j].startsWith(prefixe[0])) {
						cpt = cpt + 1;
					}
					j++;
				}
				String[] prefixe = name.split("\\.");
				String stri = String.valueOf(cpt);
				String stri2 = "(".concat(stri).concat(")");
				name = prefixe[0].concat(stri2).concat(".").concat(prefixe[1]);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		OutputStream output = new FileOutputStream(new File(ImgManager.DIR_DATA_FILE, name));
		IOUtils.copy(input, output);
		return monimage;
	}

	// Méthode qui récupère la coordonée latitude et la convertis en degrees
	public static float getLatitude(File file) {

		String latitude = "";
		try {
			Metadata metadata = ImageMetadataReader.readMetadata(file);
			if (metadata.containsDirectoryOfType(GpsDirectory.class)) {
				Collection<GpsDirectory> gpsDirs = metadata.getDirectoriesOfType(GpsDirectory.class);
				for (GpsDirectory gpsDirectory : gpsDirs) {
					GpsDescriptor gpsDesc = new GpsDescriptor(gpsDirectory);
					latitude = latitude + gpsDesc.getGpsLatitudeDescription();
				}
			}
		} catch (ImageProcessingException e) {
			System.out.println("erreur 1");
		} catch (IOException e) {
			System.out.println("erreur 2");
		} catch (java.lang.ClassCastException e) {
			System.out.println("erreur 3");
		}
		// convertion dms to dd:
		latitude = latitude.replace(',', '.');
		// parfois les coordonnees ont des virgules
		String[] tab0 = latitude.split("°");
		tab0[1] = tab0[1].substring(1, tab0[1].length());
		String[] tab1 = tab0[1].split("'");
		tab1[1] = tab1[1].substring(1, tab1[1].length() - 1);
		float Degree = Float.parseFloat(tab0[0]);
		float Minute = Float.parseFloat(tab1[0]);
		float Second = Float.parseFloat(tab1[1]);
		float DD = Degree + Minute / 60 + Second / 3600;
		return DD;
	}

	// Méthode qui récupère la coordonée longitude et la convertis en degrees
	public static float getLongitude(File file) {
		String longitude = "";
		try {
			Metadata metadata = ImageMetadataReader.readMetadata(file);
			if (metadata.containsDirectoryOfType(GpsDirectory.class)) {
				Collection<GpsDirectory> gpsDirs = metadata.getDirectoriesOfType(GpsDirectory.class);
				for (GpsDirectory gpsDirectory : gpsDirs) {
					GpsDescriptor gpsDesc = new GpsDescriptor(gpsDirectory);
					longitude = longitude + gpsDesc.getGpsLongitudeDescription();
				}
			}
		} catch (ImageProcessingException e) {
			System.out.println("erreur 1");
		} catch (IOException e) {
			System.out.println("Attention l'image ne semble pas avoir de coordonees GPS atachees");
		} catch (java.lang.ClassCastException e) {
			System.out.println("erreur 3");
		}
		// convertion dms to dd:
		longitude = longitude.replace(',', '.');
		// parfois les coordonnees ont des virgules

		String[] tab0 = longitude.split("°");
		tab0[1] = tab0[1].substring(1, tab0[1].length());
		String[] tab1 = tab0[1].split("'");
		tab1[1] = tab1[1].substring(1, tab1[1].length() - 1);

		float Degree = Float.parseFloat(tab0[0]);
		float Minute = Float.parseFloat(tab1[0]);
		float Second = Float.parseFloat(tab1[1]);
		float DD = Degree + Minute / 60 + Second / 3600;
		return DD;
	}
}