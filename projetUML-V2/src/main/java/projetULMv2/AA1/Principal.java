package projetUMLv2.AA1;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import java.awt.event.ActionListener;

public abstract class Principal implements ActionListener  {

	public static void main(String[] args) {

		Carte map = new Carte();

		final JFrame frame = new JFrame();
		JPanel frameMap = new JPanel();
		
		frame.setSize(800, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		// Création d'un panel pour l'ajout du/des bouttons
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());
		panel.setBackground(Color.white);

		frame.setLayout(new BorderLayout());
		JLabel  lab=new JLabel("Ajoute ton image et regarde d'où vient-elle !!!");  //créé un label
        panel.add(lab); 

		JButton boutonAjout = new JButton("Ajouter Image"); 
		boutonAjout.addActionListener(new FenetreClick());//ne la fenetre ne souvre pas

		panel.add(map.getCarte());
		panel.add(boutonAjout);
		frame.add(panel);
		frame.setContentPane(panel);

		SwingUtilities.invokeLater(new Runnable() 
		{
			public void run() {
				frame.setVisible(true);
			}
		});
	}
}