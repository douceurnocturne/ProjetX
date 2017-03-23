package Maven.Maven;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Principal {

	public static void main(String[] args) {

		Map current_map = new Map();

		final JFrame frame = new JFrame();
		frame.add(current_map.getMap());
		frame.setSize(800, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				frame.setVisible(true); 
			}
		});
	}
}