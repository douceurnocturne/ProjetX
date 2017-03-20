package AA1.AA1;

import com.drew.metadata.exif.*; 
import com.drew.metadata.iptc.*; 
import com.drew.metadata.jpeg.*;
public class MetaData {

    public static void main(String[] args) {

        ExtractTags extractAllTags = new ExtractTags();

        //extractAllTags.getTags();
        System.out.println("\n\n\n Has this ");
        extractAllTags.getLatitude();     
    }
}
