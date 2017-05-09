package Maven.Maven;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class TransformImgIntoJPanel {

	public static JPanel method(final Map _map) {
		JPanel panel = new JPanel();
		panel.setBackground(Color.lightGray);
		panel.setPreferredSize(new Dimension(300, 200));

		GridBagConstraints c = new GridBagConstraints();
		c.weightx = 0.0;
		c.gridx = 0;
		c.insets = new Insets(1, 0, 1, 0);
		panel.setLayout(new GridBagLayout());
		panel.add(CustomComboBoxDemo.createAndShowGUI(_map.getImgWaypointsResult()), c);
		String nb_results = Integer.toString(_map.getImgWaypointsResult().size()) + " résultat(s) trouvé(s)";
		panel.add(new JLabel(nb_results), c);
		return panel;
	}
}