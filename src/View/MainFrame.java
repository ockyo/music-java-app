package View;

import javax.swing.*;

import Model.ButtonCustom;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    private ButtonCustom addProfileBtn;
    private JPanel panelContainer;
    private int count = 1; // Đếm số panel đã thêm
    private final int PANEL_SIZE = 300; // Kích thước của các panel con
    private final int MAX_COLUMNS = 600 / PANEL_SIZE; // Tính số cột tối đa
    private final int MAX_ROWS = 700 / PANEL_SIZE; // Tính số hàng tối đa
    private int currentColumn = 0; // Cột hiện tại
    private int currentRow = 0; // Hàng hiện tại
    // private final int GAP = 10; // Khoảng cách giữa các panel con

    public MainFrame() {
        // setup main frame
        super("Music App");
        setLayout(new BorderLayout());
        setSize(600, 700);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // add button to create profile
        addProfileBtn = new ButtonCustom("Add Profile", "src\\Image\\add.png");
        addProfileBtn.setFont(new Font("Arial", Font.BOLD, 20));
        add(addProfileBtn, BorderLayout.NORTH);
        // create a panel to contain child panels
        panelContainer = new JPanel();
        panelContainer.setPreferredSize(new Dimension(600, 700));
        panelContainer.setLayout(null);

        // init action for button add profile
        addProfileBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addNewPanel();
            }
        });

        add(addProfileBtn, BorderLayout.NORTH);
        add(panelContainer, BorderLayout.CENTER);
    }

    private void addNewPanel() {
        if (count > MAX_COLUMNS * MAX_ROWS) { // Kiểm tra số lượng panel đã thêm
            JOptionPane.showMessageDialog(this, "All slots are filled.");
            return;
        }
        String panelName = JOptionPane.showInputDialog(this, "Enter name for the new panel:", "Panel Name",
                JOptionPane.PLAIN_MESSAGE);
        if (panelName == null || panelName.trim().isEmpty()) {
            return; // Neu khong nhap ten hoac nhan cancel se khong tao
        }

        // ProfilePanel profilePanel = new ProfilePanel();
        ProfilePanel profilePanel = new ProfilePanel(panelName);

        profilePanel.setBounds(currentColumn * PANEL_SIZE, currentRow * PANEL_SIZE, PANEL_SIZE, PANEL_SIZE);
        profilePanel.setBackground(Color.LIGHT_GRAY);
        profilePanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        //add child panel to parent panel
        panelContainer.add(profilePanel);
        panelContainer.revalidate(); // update layout
        panelContainer.repaint(); // repaint panel

        count++;
        currentColumn++;
        if (currentColumn >= MAX_COLUMNS) {
            currentColumn = 0;
            currentRow++;
        }
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
