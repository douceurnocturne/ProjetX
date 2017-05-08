import java.util.Dictionary;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JPanel;
import java.io.File;
import java.awt.datatransfer.*;

public class Images extends JPanel{
	private double coordonnees;
	private String nom;
	private String [] commentaire;


	private static final long   serialVersionUID    = 1L;

	public Images(Image buffer){
		File jpegFile = new File("myImage.jpg");
		Metadata metadata = JpegMetadataReader.readMetadata(jpegFile);
	}  

	public void AddCommentaire(){

	}
	public void AfficherImage(){

	}
	public double GetCoorIm(){
		return this.coordonnees;
	}
	public String GetNomIm(){
		return this.nom;
	}
	public String[] GetCommIm(){
		return this.commentaire;
	}
}


