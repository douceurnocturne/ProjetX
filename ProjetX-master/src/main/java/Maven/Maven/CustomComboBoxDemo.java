package Maven.Maven;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;

public class CustomComboBoxDemo extends JPanel {
	ImageIcon[] images;
	
	public CustomComboBoxDemo(ArrayList<Img> imgList){
        
 
        //Load the pet images and create an array of indexes.
        images = new ImageIcon[imgList.size()];
        Integer[] intArray = new Integer[imgList.size()];
        for (int i = 0; i < imgList.size(); i++) {
            intArray[i] = new Integer(i);
            String path = imgList.get(i).file.getAbsolutePath();
            ImageIcon imageIcon = new ImageIcon(path); // load the image to a imageIcon
            Image image = imageIcon.getImage(); // transform it 
            Image newimg = image.getScaledInstance(300, 200,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
            imageIcon = new ImageIcon(newimg);
            images[i] = imageIcon;
            
        }
        JComboBox petList = new JComboBox(intArray);
        ComboBoxRenderer renderer= new ComboBoxRenderer();
        renderer.setPreferredSize(new Dimension(200, 300));
        petList.setRenderer(renderer);
        petList.setMaximumRowCount(3);
 
        //Lay out the demo.
        add(petList, BorderLayout.PAGE_START);
        setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
        
    }


protected static ImageIcon createImageIcon(String path) {
    if (path != null) {
        return new ImageIcon(path);
    } else {
        System.err.println("Couldn't find file: " + path);
            return null;
    }
}
public static JComponent createAndShowGUI(ArrayList<Img> imgList) {
    //Create and set up the window.
 
    //Create and set up the content pane.
    JComponent newContentPane = new CustomComboBoxDemo(imgList);
    return newContentPane;
}
class ComboBoxRenderer extends JLabel
implements ListCellRenderer {
private Font uhOhFont;

public ComboBoxRenderer() {
setOpaque(true);
setHorizontalAlignment(CENTER);
setVerticalAlignment(CENTER);
}

/*
* This method finds the image and text corresponding
* to the selected value and returns the label, set up
* to display the text and image.
*/
public Component getListCellRendererComponent(
                JList list,
                Object value,
                int index,
                boolean isSelected,
                boolean cellHasFocus) {
//Get the selected index. (The index param isn't
//always valid, so just use the value.)
if (!list.isSelectionEmpty()) {
int selectedIndex = ((Integer)value).intValue();

if (isSelected) {
setBackground(list.getSelectionBackground());
setForeground(list.getSelectionForeground());
} else {
setBackground(list.getBackground());
setForeground(list.getForeground());
}

//Set the icon and text.  If icon was null, say so.
ImageIcon icon = images[selectedIndex];
setIcon(icon);
if (icon != null) {
setFont(list.getFont());
} 

return this;
}
else {
	return this;
}
}

//Set the font and text when no image was found.
protected void setUhOhText(String uhOhText, Font normalFont) {
if (uhOhFont == null) { //lazily create this font
uhOhFont = normalFont.deriveFont(Font.ITALIC);
}
setFont(uhOhFont);

}
}
}
	
