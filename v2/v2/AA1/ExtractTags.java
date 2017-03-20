package AA1.AA1;


import com.drew.imaging.ImageMetadataReader;
import com.drew.imaging.ImageProcessingException;
import com.drew.metadata.Directory;
import com.drew.metadata.Metadata;
import com.drew.metadata.Tag;
import com.drew.metadata.exif.GpsDirectory;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.drew.metadata.exif.*; 
import com.drew.metadata.iptc.*; 
import com.drew.metadata.jpeg.*;

public class ExtractTags {

    String allTags;
    String latitude;
    File jpegFile = new File("C:\\Users\\Public\\Pictures\\Sample Pictures\\HTC Desire.jpg");

    public String getTags() {

        try {
            Metadata metadata = ImageMetadataReader.readMetadata(jpegFile);

            for (Directory directory : metadata.getDirectories()) {
                for (Tag allTags : directory.getTags()) {

                    System.out.println(allTags);
                }
            }
        } catch (ImageProcessingException ex) {
            Logger.getLogger(Metadata.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Metadata.class.getName()).log(Level.SEVERE, null, ex);
        }
        return allTags;
    }

    public String getLatitude() {
        try {
            Metadata metadata = ImageMetadataReader.readMetadata(jpegFile);
            if (metadata.containsDirectoryOfType(GpsDirectory.class)) {
                GpsDirectory gpsDir = (GpsDirectory) metadata.getDirectoriesOfType(GpsDirectory.class);
                GpsDescriptor gpsDesc = new GpsDescriptor(gpsDir);
                System.out.println("Latitude: " + gpsDesc.getGpsLatitudeDescription());
            }
        } catch (ImageProcessingException ex) {
            Logger.getLogger(ExtractTags.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error 1");
        } catch (IOException ex) {
            Logger.getLogger(ExtractTags.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error 2");
        }

        return latitude;
    }
}
