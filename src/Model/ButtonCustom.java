package Model;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class ButtonCustom extends JButton{
    
    private ImageIcon icon ;
    public ButtonCustom(String btnName, String url){
        super(btnName);
        icon = new ImageIcon(url);
        Image image = icon.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        this.setIcon(new ImageIcon(image));
    }

}
