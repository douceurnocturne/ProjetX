package Maven.Maven;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.ListCellRenderer;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class Principal extends JFrame implements ActionListener {
    ImageIcon[] images;
    

	static Map current_map;

	private JButton buttonAdd = new JButton("Ajouter Image");
	private JButton buttonExit = new JButton("Quitter");

	private JPanel panel_R = new JPanel();

	private JPanel panel_Down = new JPanel();
	private JScrollPane panel_L;
	
	
	
	public Principal() throws IOException {

		// map
		current_map = new Map();
		
		
		this.panel_L = transformImgListIntoJScroll.method(current_map.getImgList(), current_map);

		panel_Down.setLayout(new FlowLayout());
		panel_Down.setBackground(Color.blue);
		panel_Down.setPreferredSize(new Dimension(800, 50));
		panel_Down.add(buttonExit);
		panel_Down.add(buttonAdd);
		buttonAdd.addActionListener(this);
		buttonExit.addActionListener(this);

		// panel de gauche
		

		
		// panel de droite

		panel_R=TransformImgIntoJPanel.method(current_map);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
		// frame
		add(current_map.getMap(), BorderLayout.CENTER);
	
		
		add(panel_L, BorderLayout.WEST);
		add(panel_R, BorderLayout.EAST);

		add(panel_Down, BorderLayout.SOUTH);
		
		setSize(1600, 1000);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setTitle("Application de Localisation d'Images");
		

		current_map.getMap().getMainMap().addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				remove(panel_R);
				panel_R=TransformImgIntoJPanel.method(current_map);
				add(panel_R, BorderLayout.EAST);
				revalidate();
				repaint();
				
				
			}
		}); 
		
		
	}
		
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//String name=((ImagesNText)combo.getSelectedItem()).getName();
		Object source = e.getSource();

		if (source == buttonAdd) {
			try {
				this.current_map.addImg();
				this.remove(panel_L);
				this.panel_L = transformImgListIntoJScroll.method(current_map.getImgList(), current_map);
				this.add(panel_L, BorderLayout.WEST);
				this.repaint();
				this.revalidate();
				
				
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