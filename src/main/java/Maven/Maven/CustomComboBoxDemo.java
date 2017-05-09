package Maven.Maven;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;

public class CustomComboBoxDemo extends JPanel {
	ImageIcon[] images;

	public CustomComboBoxDemo(ArrayList<Img> imgList) {

		images = new ImageIcon[imgList.size()];
		Integer[] intArray = new Integer[imgList.size()];
		for (int i = 0; i < imgList.size(); i++) {
			intArray[i] = new Integer(i);
			String path = imgList.get(i).file.getAbsolutePath();
			ImageIcon imageIcon = new ImageIcon(path); 
			Image image = imageIcon.getImage(); // transforme l'image
			Image newimg = image.getScaledInstance(300, 200, java.awt.Image.SCALE_SMOOTH); 
			imageIcon = new ImageIcon(newimg);
			images[i] = imageIcon;

		}
		JComboBox petList = new JComboBox(intArray);
		ComboBoxRenderer renderer = new ComboBoxRenderer();
		renderer.setPreferredSize(new Dimension(200, 300));
		petList.setRenderer(renderer);
		petList.setMaximumRowCount(3);

		add(petList, BorderLayout.PAGE_START);
		setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

	}

	protected static ImageIcon createImageIcon(String path) {
		if (path != null) {
			return new ImageIcon(path);
		} else {
			System.err.println("Couldn't find file: " + path);
			return null;
		}
	}

	public static JComponent createAndShowGUI(ArrayList<Img> imgList) {
		JComponent newContentPane = new CustomComboBoxDemo(imgList);
		return newContentPane;
	}

	class ComboBoxRenderer extends JLabel implements ListCellRenderer {
		private Font uhOhFont;

		public ComboBoxRenderer() {
			setOpaque(true);
			setHorizontalAlignment(CENTER);
			setVerticalAlignment(CENTER);
		}

		/*
		 * Classe permettant de selectionner l'image dans la JcomboBox.
		 */
		public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected,
				boolean cellHasFocus) {
			if (!list.isSelectionEmpty()) {
				int selectedIndex = ((Integer) value).intValue();

				if (isSelected) {
					setBackground(list.getSelectionBackground());
					setForeground(list.getSelectionForeground());
				} else {
					setBackground(list.getBackground());
					setForeground(list.getForeground());
				}

				ImageIcon icon = images[selectedIndex];
				setIcon(icon);
				if (icon != null) {
					setFont(list.getFont());
				}

				return this;
			} else {
				return this;
			}
		}

	}
}
