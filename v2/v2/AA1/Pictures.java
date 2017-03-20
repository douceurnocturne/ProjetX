package AA1.AA1;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class Pictures extends JFrame{
	public Pictures(){
		this.setTitle("Phototèque");
		this.setSize(500, 500);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);             

		JPanel pan = new JPanel();

		JLabel lab = new JLabel(new ImageIcon("space.jpg"));

		pan.setLayout(new BorderLayout());
		pan.add(lab);

		this.getContentPane().add(pan);
		this.setVisible(true);	

	}
	private Image space;
	public void paintComponent(Graphics g){
		g.drawImage(space, 0, 0, this);
		//Pour une image de fond
		//g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);

	}
	public static void main(String[] args){
		/*testphoto lab = new testphoto();*/

		//Affichage de plusieurs images
		JFrame frmM = new JFrame();
		JPanel pnlM = new JPanel();
	    String picturelist[] = {"space.jpg","space.jpg","space.jpg","space.jpg","space.jpg","space.jpg"};

		for(int i=0; i<picturelist.length;i++){
			JLabel lblMi = new JLabel();
			lblMi.setIcon(new ImageIcon(picturelist[i]));
			pnlM.add(lblMi);
		}
		JScrollPane scrollPane = new JScrollPane(pnlM);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBounds(50,30,300,50);
        JPanel contentPane = new JPanel(null);
        contentPane.setPreferredSize(new Dimension(300, 700));
        contentPane.add(scrollPane);
        frmM.setContentPane(contentPane);
        frmM.pack();
		frmM.setTitle("Phototèque");
		frmM.setContentPane(pnlM);
		frmM.setVisible(true);
		frmM.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
}       
