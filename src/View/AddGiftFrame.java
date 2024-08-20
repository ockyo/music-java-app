package View;

import javax.swing.*;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JComboBox;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class AddGiftFrame extends JFrame {
    private JPanel panelAddGift;
    private JLabel profileNameLB;
    private JTextField profile_JTextField;
    private JLabel nameLB;
    private JTextField name_TextField;
    private JLabel gift_Label;

    @SuppressWarnings("rawtypes")
    private JComboBox gift_typeComboBox; 

    private JPanel fileListPanel;
    private JButton addFileButton;

    public AddGiftFrame() {
        super("Thêm quà");
        setSize(450, 600);
        setLocationRelativeTo(null);

        panelAddGift = new JPanel();
        profileNameLB = new JLabel("Profile");
        add(profileNameLB);
        profile_JTextField = new JTextField("Demo profile", 35);
        add(profile_JTextField);
        panelAddGift.add(profileNameLB);
        panelAddGift.add(profile_JTextField);
        nameLB = new JLabel("Tên hiển thị");
        panelAddGift.add(nameLB);
        name_TextField = new JTextField(35);
        panelAddGift.add(name_TextField);
        String city[] = { "BingChiling", "Potato", "Okay" };
        gift_Label = new JLabel("Chọn quà");
        panelAddGift.add(gift_Label);
        gift_typeComboBox = new JComboBox<>(city);
        panelAddGift.add(gift_typeComboBox);

        // Tạo một JPanel để hiển thị danh sách các tập tin
        fileListPanel = new JPanel();
        fileListPanel.setLayout(new BoxLayout(fileListPanel, BoxLayout.Y_AXIS));
        panelAddGift.add(new JLabel("Danh sách tập tin:"));
        panelAddGift.add(fileListPanel);

        // Tạo nút để thêm tập tin
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

        add(panelAddGift);
    }

    private void addFileToList(String filePath) {
        // Tạo một JLabel hoặc JTextField để hiển thị đường dẫn tập tin
        JTextField fileField = new JTextField(filePath);
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
}
