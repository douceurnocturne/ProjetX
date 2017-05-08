import java.util.Dictionary;
import java.awt.Graphics;
import java.awt.Image;
import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.metadata.IIOMetadata;
import javax.imageio.stream.ImageInputStream;
import javax.swing.JPanel;
import javax.swing.text.html.HTMLDocument.Iterator;

import java.io.File;
import java.awt.datatransfer.*;

public class Metadata {

	public static void main(String[] args) {
	    Metadata meta = new Metadata();
	    String filename = "C:\\Users\\luckheart\\Pictures\\Sample Pictures\\Koala.jpg";
	    if (new File(filename).exists()) {
	        meta.readAndDisplayMetadata(filename);
	    } else {
	        System.out.println("cannot find file: " + filename);
	    }
	}

    void readAndDisplayMetadata( String fileName ) {
        try {

            File file = new File( fileName );
            ImageInputStream iis = ImageIO.createImageInputStream(file);
            Iterator<ImageReader> readers = ImageIO.getImageReaders(iis);

            if (readers.hasNext()) {

                // pick the first available ImageReader
                ImageReader reader = readers.next();

                // attach source to the reader
                reader.setInput(iis, true);

                // read metadata of first image
                IIOMetadata metadata = reader.getImageMetadata(0);

                String[] names = metadata.getMetadataFormatNames();
                int length = names.length;
                for (int i = 0; i < length; i++) {
                    System.out.println( "Format name: " + names[ i ] );
                    displayMetadata(metadata.getAsTree(names[i]));
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

}