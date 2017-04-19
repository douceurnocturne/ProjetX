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

//	public static void main(String[] args) throws IOException {
//		Img bonsoir = LoadImage();
//	}

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
			monimage = new Img(f, 0, 0);
		}
		InputStream input = new FileInputStream(f);
		File dossier;
		try {//Si l'image existe deja dans le dossier
			dossier = new File("Donnees").getCanonicalFile();
			String[] liste = dossier.list();
			int i=0;
			while (i < liste.length) {
				if(liste[i].equals(name)){
					String[] prefixe = name.split("\\.");
					name = prefixe[0].concat("(copie)").concat(".").concat(prefixe[1]);
				}
				i++;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		OutputStream output = new FileOutputStream(new File(ImgManager.DIR_DATA_FILE, name));
		IOUtils.copy(input, output);
		return monimage;
	}

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
		String[] tab0 = latitude.split("Â°");
		tab0[1] = tab0[1].substring(1, tab0[1].length());
		String[] tab1 = tab0[1].split("'");
		tab1[1] = tab1[1].substring(1, tab1[1].length() - 1);
		float Degree = Integer.parseInt(tab0[0]);
		float Minute = Integer.parseInt(tab1[0]);
		float Second = Integer.parseInt(tab1[1]);
		float DD = Degree + Minute / 60 + Second / 3600;
		return DD;
	}

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
		String[] tab0 = longitude.split("Â°");
		tab0[1] = tab0[1].substring(1, tab0[1].length());
		String[] tab1 = tab0[1].split("'");
		tab1[1] = tab1[1].substring(1, tab1[1].length() - 1);
		float Degree = Integer.parseInt(tab0[0]);
		float Minute = Integer.parseInt(tab1[0]);
		float Second = Integer.parseInt(tab1[1]);
		float DD = Degree + Minute / 60 + Second / 3600;
		return DD;
	}
}