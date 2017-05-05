package Maven.Maven;

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class transformImgListIntoFrame extends JFrame {

	public Frame transformImgFrame(ArrayList<Img> imgList) {
		
		JFrame frmM = new JFrame();
		JPanel pnlM = new JPanel();
		
		for (int i=0; i<imgList.size();i++) {
			
			String chemin = imgList.get(i).file.getAbsolutePath();
			JLabel label=new JLabel();
			ImageIcon imageIcon = new ImageIcon(chemin);
			label.setIcon(imageIcon);
			
			pnlM.add(label);
			
		}
		
			JPanel contentPane = new JPanel(null);
	        contentPane.setPreferredSize(new Dimension(300, 700));
	        frmM.setContentPane(contentPane);

	        frmM.pack();
			frmM.setTitle("Phototèque");
			frmM.setContentPane(pnlM);
			frmM.setVisible(true);
			frmM.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
			
	return frmM;
		
	}
}
