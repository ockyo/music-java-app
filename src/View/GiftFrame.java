package View;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import Model.ButtonCustom;

public class GiftFrame extends JFrame {
    private ButtonCustom btnAddGift;
    private ButtonCustom btnSetting;
    private ButtonCustom btnUseProfile;
    private ButtonCustom btnClearProfile;
    private JPanel panel;

    public GiftFrame() {
        super("Gift Frame");
        setLayout(new BorderLayout());
        setSize(600, 700);
        setLocationRelativeTo(null);
        setResizable(false);

        panel = new JPanel();
        btnAddGift = new ButtonCustom("Thêm quà", "src\\Image\\add.png");
        panel.add(btnAddGift);
        btnSetting = new ButtonCustom("Cài đặt", "src\\Image\\setting.png");
        panel.add(btnSetting);
        btnUseProfile = new ButtonCustom("Sử dụng", "src\\Image\\checklist.png");
        panel.add(btnUseProfile);
        btnClearProfile = new ButtonCustom("Xóa", "src\\Image\\trash-can.png");
        panel.add(btnClearProfile);
        
        btnAddGift.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("add Clicked");
                AddGiftFrame addGiftFrame = new AddGiftFrame();
                addGiftFrame.setVisible(true);

            }
        });
        btnSetting.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("setting Clicked");
            }
        });
        btnUseProfile.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("use clicked");
            }
        });
        btnClearProfile.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("clear clicked");
            }
        });
        add(panel, BorderLayout.NORTH);
    }

}
