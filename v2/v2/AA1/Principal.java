package AA1.AA1;


import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.SwingUtilities;

import java.awt.event.ActionListener;

public abstract class Principal implements ActionListener  {

	public static void main(String[] args) {

		Map map = new Map();

		final JFrame frame = new JFrame();
		frame.setSize(800, 800);
		frame.setLocationRelativeTo(null);
		frame.setLayout(new BorderLayout());

		
		// Création de panel pour l'ajout du/des bouttons
        

        
        JPanel panel1 = new JPanel(); 
        panel1.setLayout(new FlowLayout());
		panel1.setBackground(Color.lightGray);
		panel1.setPreferredSize(new Dimension(200, 800));
        
       
        
        JPanel panel2 = new JPanel();
        panel2.setLayout(new FlowLayout());
		panel2.setBackground(Color.white);
        panel2.add(map.getMap());
        
        
        JPanel panel3 = new JPanel();
        panel3.setLayout(new FlowLayout());
		panel3.setBackground(Color.lightGray);
		panel3.setPreferredSize(new Dimension(200, 800));
        JLabel  lab=new JLabel("Ajoute ton image et regarde d'où vient-elle !!!");  //créé un label
        panel3.add(lab);
        
        JPanel panel4 = new JPanel();
        panel4.setLayout(new FlowLayout());
		panel4.setBackground(Color.blue);
		panel4.setPreferredSize(new Dimension(800, 50));
        JButton buttonAdd = new JButton("Ajouter Image"); 
		buttonAdd.addActionListener(new FenetreClick());//ne la fenetre ne souvre pas
		panel4.add(buttonAdd);
		JButton buttonExit = new JButton("Quitter"); 
		panel4.add(buttonExit);
		
        frame.add(panel1, BorderLayout.WEST); 
       
        frame.add(panel2, BorderLayout.CENTER);
       frame.add(panel3, BorderLayout.EAST);
       frame.add(panel4, BorderLayout.SOUTH);
        
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        frame.getContentPane().add(panel1, BorderLayout.WEST);
        frame.getContentPane().add(panel2,BorderLayout.CENTER);
        frame.getContentPane().add(panel3,BorderLayout.EAST);
        frame.getContentPane().add(panel4,BorderLayout.SOUTH);
  
        

		SwingUtilities.invokeLater(new Runnable() 
		{
			public void run() {
				frame.setVisible(true);
			}
		});
	}
}