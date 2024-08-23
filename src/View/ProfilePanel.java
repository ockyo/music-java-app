package View;

import javax.swing.*;

import Model.ButtonCustom;

public class ProfilePanel extends JPanel {

    private JLabel panelName;
    private ButtonCustom configBtn;
    public ProfilePanel(String name) {
        panelName = new JLabel(name);
        configBtn = new ButtonCustom("Config", "src\\Image\\configuration.png");
        add(panelName);
        add(configBtn);
        configBtn.addActionListener(e -> editProfile());
    }
    public void editProfile(){
        GiftFrame giftFrame = new GiftFrame();
        giftFrame.setVisible(true);

    }
}