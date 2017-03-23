package projetUMLv2.AA1;


import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import org.jxmapviewer.viewer.DefaultWaypoint;
import org.jxmapviewer.viewer.GeoPosition;

/**
 * A waypoint that is represented by a button on the map.
 *
 * @author Daniel Stahr
 */
public class SwingWaypoint extends DefaultWaypoint {
	private final JButton button;
	private final String text;

	public SwingWaypoint(String text, GeoPosition coord) {
		super(coord);
		this.text = text;

		button = new JButton(text.substring(0, 1));
		button.setSize(10, 10);
		// button.setIcon();
		button.setPreferredSize(new Dimension(24, 24));
		button.addMouseListener(new SwingWaypointMouseListener());
		button.setVisible(true);
	}

	JButton getButton() {
		return button;
	}

	private class SwingWaypointMouseListener implements MouseListener {

		public void mouseClicked(MouseEvent e) {
			JOptionPane.showMessageDialog(button, "You clicked on " + text);
			System.out.println("lol");
		}

		public void mousePressed(MouseEvent e) {
		}

		public void mouseReleased(MouseEvent e) {
		}

		public void mouseEntered(MouseEvent e) {
		}

		public void mouseExited(MouseEvent e) {
		}
	}
}