package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import Model.ButtonCustom;

public class ProfilePanel extends JPanel {
    private ButtonCustom btnAddGift;
    private ButtonCustom btnSetting;
    private ButtonCustom btnUseProfile;
    private ButtonCustom btnClearProfile;

    public ProfilePanel() {
        btnAddGift = new ButtonCustom("Thêm quà", "src\\Image\\add.png");
        add(btnAddGift);
        btnSetting = new ButtonCustom("Cài đặt", "src\\Image\\setting.png");
        add(btnSetting);
        btnUseProfile = new ButtonCustom("Sử dụng", "src\\Image\\checklist.png");
        add(btnUseProfile);
        btnClearProfile = new ButtonCustom("Xóa", "src\\Image\\trash-can.png");
        add(btnClearProfile);

        btnAddGift.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e ){
                System.out.println("add Clicked");
                AddGiftFrame addGiftFrame = new AddGiftFrame();
                addGiftFrame.setVisible(true);

            }
        });
        btnSetting.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e ){
                System.out.println("setting Clicked");
            }
        });
        btnUseProfile.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e ){
                System.out.println("use clicked");
            }
        });
        btnClearProfile.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e ){
                System.out.println("clear clicked");
            }
        });
    }


}
