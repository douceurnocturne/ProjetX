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
    String[] petStrings = {"Bird", "Cat", "Dog", "Rabbit", "Pig"};

	static Map current_map;

	private JButton buttonAdd = new JButton("Ajouter Image");
	private JButton buttonExit = new JButton("Quitter");

	private JTabbedPane panel_R = new JTabbedPane();

	private JPanel panel_Down = new JPanel();
	private JScrollPane panel_L;
	
	
	
	public Principal() throws IOException {

		// map
		current_map = new Map();
		
		/*current_map.getMap().getMainMap().addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				System.out.println("Clic sur la map");
			}
		}); pour marc */
		
		// Panel du bas avec des boutons
		
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

		panel_R.setBackground(Color.lightGray);
		panel_R.setPreferredSize(new Dimension(200, 300));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		final JComboBox combo=new JComboBox();
		combo.setModel(populate());
		combo.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				String name=((ImagesNText)combo.getSelectedItem()).getName();
				JOptionPane.showMessageDialog(null, null);
				
			}
		});
		panel_R.add(combo);
		
		// frame
		add(current_map.getMap(), BorderLayout.CENTER);
	
		
		add(panel_L, BorderLayout.WEST);
		add(panel_R, BorderLayout.EAST);

		add(panel_Down, BorderLayout.SOUTH);
		
		setSize(1600, 1000);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
	
	}
		
	
	private DefaultComboBoxModel populate(){
		DefaultComboBoxModel model=new DefaultComboBoxModel();
		model.addElement(new ImagesNText(new ImageIcon("C:\\images\\fond.jpg"),"fond"));
		model.addElement(new ImagesNText(new ImageIcon("C:\\images\\fond1.jpg"),"fond1"));
		model.addElement(new ImagesNText(new ImageIcon("C:\\images\\fond2.jpg"),"fond2"));
		
		return model;
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//String name=((ImagesNText)combo.getSelectedItem()).getName();
		Object source = e.getSource();

		if (source == buttonAdd) {
			try {
				this.current_map.addImg();
				this.panel_L = transformImgListIntoJScroll.method(current_map.getImgList(), current_map);
				
				
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
class ImagesTextRenderer extends JLabel implements ListCellRenderer{
	

	public Component getListCellRendererComponent(JList list, Object val, int index, boolean isSelected,boolean focused){
		// TODO Auto-generated method stub
		ImagesNText it=(ImagesNText) val;
		setIcon(it.getImg());
		setText(it.getName());
		if(isSelected){
			setBackground(list.getSelectionBackground());
			setForeground(list.getSelectionForeground());
		}else{
			setBackground(list.getBackground());
			setForeground(list.getForeground());
		}
		setFont(list.getFont());
		return this;
	}
	}
	
}
class ImagesNText{
	private Icon img;
	private String name;
	public ImagesNText(Icon img,String name){
		this.img=img;
		this.name=name;
	}
	public Icon getImg() {
		return img;
	}
	public void setImg(Icon img) {
		this.img = img;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}

	


