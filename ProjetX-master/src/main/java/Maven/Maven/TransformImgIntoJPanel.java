package Maven.Maven;

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class TransformImgIntoJPanel {
	
	public static JPanel method(final Map _map) {
		JPanel panel = new JPanel();
		panel.add(CustomComboBoxDemo.createAndShowGUI(_map.getImgWaypointsResult()));
		panel.setBackground(Color.lightGray);
		panel.setPreferredSize(new Dimension(200, 300));
		
		return panel;
	}
}
