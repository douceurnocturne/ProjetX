import java.util.Dictionary;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JPanel;

public class ImExtract {
	private double coordonnees;
	private String nom;
	private String [] commentaire;



	public ImExtract() extends JPanel{
		private static final long   serialVersionUID    = 1L;

		protected Image buffer;    

		public ImExtract(Image buffer){
			this.buffer = buffer;
		}  

		public void paintComponent(Graphics g) {
			g.drawImage(buffer,0,0,null);
		}

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
