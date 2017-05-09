package Maven.Maven;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import org.jxmapviewer.viewer.GeoPosition;

public class transformImgListIntoJScroll extends JFrame {

	public static JScrollPane method(final ArrayList<Img> imgList, final Map _map) {

		// création d'un GridBagContraints pour afficher seulement sur une
		// colonne
		GridBagConstraints c = new GridBagConstraints();
		c.weightx = 0.0;
		c.gridx = 0;
		c.insets = new Insets(1, 0, 1, 0);

		// création du JPanel qui contiendra les label
		JPanel pnlM = new JPanel(new GridBagLayout());
		pnlM.setLayout(new GridBagLayout());

		for (int i = 0; i < imgList.size(); i++) {
			// récupération du path de chaque image stockée dans imgList
			String path = imgList.get(i).file.getAbsolutePath();
			// création d'un CustomJLabel permettant l'ajout d'un indice sur
			// chaque JLabel
			JLabel label = new CustomJLabel(i);

			label.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					// permet de dire sur quelle image nous cliquons et permet
					// de centrer la vision de la map sur
					// la position de la photo sur laquelle nous cliquons
					int indice_jlabel = (((CustomJLabel) e.getSource()).indice);

					_map.centerImg(new GeoPosition(imgList.get(indice_jlabel).Lattitude,
							imgList.get(indice_jlabel).Longitude));
				}
			});

			// changement de la taille de l'image
			ImageIcon image = new ImageIcon(path);
			Image image2 = image.getImage(); // transform it
			Image newimg = image2.getScaledInstance(300, 200, java.awt.Image.SCALE_SMOOTH); // scale
																							// it
																							// the
																							// smooth
																							// way
			image = new ImageIcon(newimg); // transform it back
			label.setIcon(image);
			// ajout du label au panel
			pnlM.add(label, c);

		}
		// création du JScrollPane
		JScrollPane panel_scroll_l = new JScrollPane(pnlM);

		panel_scroll_l.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		panel_scroll_l.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

		JScrollPane imageScroll = new JScrollPane(pnlM);
		imageScroll.setPreferredSize(new Dimension(300, 700));

		return imageScroll;
	}

}
