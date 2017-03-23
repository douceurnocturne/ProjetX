package projetUMLv2.AA1;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class FenetreClick extends JFrame implements ActionListener{
	
	public FenetreClick(){

	this.setTitle("ma fenetre");
	this.setSize(500,300);
	JPanel pan= new JPanel();
	BoxLayout    bl=new BoxLayout(pan,BoxLayout.Y_AXIS);   //layoutManager
    pan.setLayout(bl);                      //attache le layoutManager au panel           

    JLabel  lab=new JLabel("Gestions des images");  //créé un label
    pan.add(lab); 
	
	
	JTextField  tf=new JTextField("Editez commentaire!"); //un champ texte!
    pan.add(tf); 
    
  //un 2eme panel qui va etre imbriqué dans le 1er panel !
    JPanel  pan2=new   JPanel();   //2eme panel
    bl=new BoxLayout(pan2,BoxLayout.X_AXIS);  //un autre alignement
    pan2.setLayout(bl);       

    lab=new JLabel("Supprimer/Modifier");
    pan2.add(lab);  //ajout dans le 2eme panel
    String  c[] ={"image1","image2","image3","..."};   //liste de nos images 
    JComboBox   cb=new JComboBox(c);
    pan2.add(cb);       

    //ajoute le panel 2 dans le panel 1!
    pan.add(pan2);       

 
    JButton but=new JButton("?");
    pan.add(but);       

    //
    setContentPane(pan);        //defini le panel de la JFrame
    setVisible(true);           //affiche la JFrame
   setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}   

}
