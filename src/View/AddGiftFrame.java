package View;

import javax.swing.*;

import DAO.AddGiftDAO;


import java.awt.Dimension;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class AddGiftFrame extends JFrame {
    private JPanel panelAddGift;
    private JLabel profileNameLB;
    private JTextField profile_JTextField;
    private JLabel nameLB;
    private JTextField name_TextField;
    private JLabel gift_Label;
    private JButton sendForm;
    private List<String> filePaths;
    @SuppressWarnings("rawtypes")
    private JComboBox gift_typeComboBox;

    private JPanel fileListPanel;
    private JButton addFileButton;
    private JTextField fileField;

    public AddGiftFrame() {
        super("Thêm quà");
        setSize(450, 600);
        setLocationRelativeTo(null);

        filePaths = new ArrayList<>(); // Khởi tạo danh sách lưu các file paths
        // tao panel chinh va thiet lap layout
        panelAddGift = new JPanel();
        panelAddGift.setLayout(new BoxLayout(panelAddGift, BoxLayout.Y_AXIS));
        panelAddGift.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Thêm khoảng cách xung quanh

        // tao nhan profile va textfield
        profileNameLB = new JLabel("Profile");
        profile_JTextField = new JTextField("Demo profile", 20);

        // Tao label va textfield ten hien thi cua qua
        nameLB = new JLabel("Tên hiển thị");
        name_TextField = new JTextField(20);

        // Them cac thanh phan vao panel
        panelAddGift.add(profileNameLB);
        panelAddGift.add(profile_JTextField);
        panelAddGift.add(Box.createRigidArea(new Dimension(0, 10)));
        panelAddGift.add(nameLB);
        panelAddGift.add(name_TextField);

        String gift[] = { "BingChiling", "Potato", "Okay" };
        gift_Label = new JLabel("Chọn quà");
        panelAddGift.add(gift_Label);
        gift_typeComboBox = new JComboBox<>(gift);
        panelAddGift.add(gift_typeComboBox);

        // Tao panel hien thi cac tap tin
        fileListPanel = new JPanel();
        fileListPanel.setLayout(new BoxLayout(fileListPanel, BoxLayout.Y_AXIS));
        panelAddGift.add(new JLabel("Danh sách tập tin:"));
        panelAddGift.add(fileListPanel);

        // Tao nut them tap tin
        addFileButton = new JButton("Thêm tập tin +");
        addFileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Tạo JFileChooser để chọn tập tin
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

                int result = fileChooser.showOpenDialog(AddGiftFrame.this);

                if (result == JFileChooser.APPROVE_OPTION) {
                    // Lấy tập tin được chọn
                    File selectedFile = fileChooser.getSelectedFile();
                    // Thêm tập tin vào danh sách
                    addFileToList(selectedFile.getAbsolutePath());
                }
            }
        });

        panelAddGift.add(addFileButton);
        // tao nut gui form va insert va db
        sendForm = new JButton("Gửi");
        sendForm.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                insertDataToDB();
            }
        });
        panelAddGift.add(sendForm);

        add(panelAddGift);
    }

    private void addFileToList(String filePath) {
        // Tạo một JLabel hoặc JTextField để hiển thị đường dẫn tập tin
        fileField = new JTextField(filePath);
        fileField.setEditable(false); // Không cho phép chỉnh sửa

        // Tạo nút để xóa tập tin khỏi danh sách
        JButton removeButton = new JButton("Xóa");
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Xóa fileField và removeButton khỏi fileListPanel
                fileListPanel.remove(fileField);
                fileListPanel.remove(removeButton);
                fileListPanel.revalidate();
                fileListPanel.repaint();
                // Xóa đường dẫn tập tin khỏi danh sách filePaths
                filePaths.remove(filePath);
            }
        });

        // Thêm fileField và removeButton vào fileListPanel
        JPanel filePanel = new JPanel();
        filePanel.setLayout(new BoxLayout(filePanel, BoxLayout.X_AXIS));
        filePanel.add(fileField);
        filePanel.add(removeButton);

        fileListPanel.add(filePanel);
        fileListPanel.revalidate();
        fileListPanel.repaint();
    }

    private void insertDataToDB() {
        int ID = 6;
        String profileName = profile_JTextField.getText();
        String name = name_TextField.getText();
        String  gift_name =  (String) gift_typeComboBox.getSelectedItem();
        String thumbnail = "Thumbnail";
        int price = 10;
        String types = "type1";
        String  sounds = fileField.getText() ;
 
        AddGiftDAO addGiftDAO =  new AddGiftDAO();
        addGiftDAO.insertGift(ID, name, gift_name, thumbnail, price, types, sounds);
        // addGiftDAO.insertGift(3, "4", "5", "4", 4, "5", "6");
        System.out.println(addGiftDAO.getGiftNameById(2));
        System.out.println(ID+profileName+name);
    }
    public static void main(String[] args) {
        new AddGiftFrame().setVisible(true);
    }
}
