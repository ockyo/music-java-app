package View;

import javax.swing.*;

import Model.ButtonCustom;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    private ButtonCustom addProfileBtn;
    private JPanel panelContainer;

    public MainFrame() {
        super("Music App");
        setLayout(new BorderLayout());
        setSize(600, 700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        addProfileBtn = new ButtonCustom("Them Profile", "src\\Image\\add.png");
        addProfileBtn.setFont(new Font("Arial", Font.BOLD, 20));
        add(addProfileBtn, BorderLayout.NORTH);

        JButton addButton = new JButton("+");
        addButton.setFont(new Font("Arial", Font.BOLD, 20));

        // Tạo một JPanel để chứa các panel con
        panelContainer = new JPanel();
        panelContainer.setLayout(new GridLayout(0, 2, 10, 10));
        panelContainer.setBackground(Color.BLUE);
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addNewPanel();
            }
        });

        add(addButton, BorderLayout.NORTH);
        // add(new JScrollPane(panelContainer), BorderLayout.CENTER);
        add(panelContainer, BorderLayout.CENTER);
    }

    private void addNewPanel() {
        ProfilePanel profilePanel = new ProfilePanel();

        profilePanel.setSize(50, 30);
    
        profilePanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        // Thêm panel mới vào panelContainer
        panelContainer.add(profilePanel);
        // Cập nhật hiển thị
        panelContainer.revalidate();
        panelContainer.repaint();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }
}
