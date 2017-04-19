package Maven.Maven;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;

public class Principal extends JFrame implements ActionListener {

	static Map current_map;

	private JButton buttonAdd = new JButton("Ajouter Image");
	private JButton buttonExit = new JButton("Quitter");

	private JTabbedPane panel_R = new JTabbedPane();

	private JPanel panel_L = new JPanel();

	private JPanel panel_Down = new JPanel();

	private JScrollPane panel_scroll_l = new JScrollPane(panel_L);

	public Principal() throws IOException {

		// map
		current_map = new Map();

		// Panel du bas avec des boutons

		panel_Down.setLayout(new FlowLayout());
		panel_Down.setBackground(Color.blue);
		panel_Down.setPreferredSize(new Dimension(800, 50));
		panel_Down.add(buttonExit);
		panel_Down.add(buttonAdd);
		buttonAdd.addActionListener(this);
		buttonExit.addActionListener(this);

		// panel de gauche
		panel_L.setLayout(new FlowLayout());
		panel_L.setBackground(Color.lightGray);
		panel_L.setPreferredSize(new Dimension(200, 300));

		panel_scroll_l.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		panel_scroll_l.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

		// panel de droite

		panel_R.setBackground(Color.lightGray);
		panel_R.setPreferredSize(new Dimension(200, 300));

		// frame

		add(current_map.getMap());
		add(panel_scroll_l, BorderLayout.WEST);
		add(panel_R, BorderLayout.EAST);

		add(panel_Down, BorderLayout.SOUTH);
		setSize(1000, 1000);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object source = e.getSource();

		if (source == buttonAdd) {
			try {
				this.current_map.addImg();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}
		if (source == buttonExit){
			this.setVisible(false);
			dispose();
		}
	}

	public static void main(String[] args) {

		// java.awt.EventQueue. ou SwingUtilities
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				try {
					new Principal().setVisible(true);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
	}

}
