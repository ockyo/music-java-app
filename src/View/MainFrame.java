package View;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Components.PanelCustom;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.*;

public class MainFrame extends JFrame implements ActionListener {

    private JMenuBar menuBar;
    private JMenu menu;
    private JMenuItem profileItem;
    private JMenuItem dashboardItem;
    private JPanel mainPanel;
    private JPanel profilePanel;
    private JPanel dashboardPanel;
    private CardLayout cardLayout;
    private PanelCustom clickablePanel;
    private int count = 1; // Đếm số panel đã thêm
    private final int PANEL_SIZE = 200; // Kích thước của các panel con
    private final int MAX_COLUMNS = 600 / PANEL_SIZE; // Tính số cột tối đa
    private final int MAX_ROWS = 700 / PANEL_SIZE; // Tính số hàng tối đa
    private int currentColumn = 0; // Cột hiện tại
    private int currentRow = 0; // Hàng hiện tại

    public MainFrame() {
        // init main frame
        super("Main frame");
        setSize(600, 700);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // init menubar component
        menuBar = new JMenuBar();
        menu = new JMenu("Menu");
        profileItem = new JMenuItem("Profile");
        dashboardItem = new JMenuItem("Dashboard");
        menuBar.add(menu);
        menu.add(profileItem);
        menu.add(dashboardItem);
        setJMenuBar(menuBar);

        // add action
        profileItem.addActionListener(this);
        dashboardItem.addActionListener(this);

        // Initialize CardLayout and mainPanel
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        // create profile panel
        profilePanel = new JPanel();
        clickablePanel = new PanelCustom(30, 30, "src\\Image\\add.png");
        profilePanel.add(clickablePanel);
        clickablePanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Xử lý click dựa trên điều kiện
                addProfile();
                System.out.println("add profile clicked");
            }
        });

        // create dashboard panel
        dashboardPanel = new JPanel();
        dashboardPanel.setBackground(Color.RED);
        dashboardPanel = new JPanel();

        // Add both panels to mainPanel with identifiers
        mainPanel.add(profilePanel, "Profile");
        mainPanel.add(dashboardPanel, "Dashboard");

        // Add mainPanel to the frame
        add(mainPanel);

        // Show the dashboard panel by default
        cardLayout.show(mainPanel, "Dashboard");
    }

    public static void main(String[] args) {
        new MainFrame().setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == profileItem) {
            System.out.println("Profile clicked");
            cardLayout.show(mainPanel, "Profile");// Show profile panel

        } else {
            System.out.println("Dashboard clicked");
            cardLayout.show(mainPanel, "Dashboard"); // Show dashboard panel
        }
    }

    public void addProfile() {
        if (count > MAX_COLUMNS * MAX_ROWS) { // Kiểm tra số lượng panel đã thêm
            JOptionPane.showMessageDialog(this, "All slots are filled.");
            return;
        }
        String panelName = JOptionPane.showInputDialog(this, "Enter name for the profile:", "Profilename",
                JOptionPane.PLAIN_MESSAGE);
        if (panelName == null || panelName.trim().isEmpty()) {
            return; // Neu khong nhap ten hoac nhan cancel se khong tao
        }
        ProfilePanel childProfilePanel = new ProfilePanel(panelName, 30, 30);
        childProfilePanel.setPreferredSize(new Dimension(200, 100));
        profilePanel.add(childProfilePanel);
        profilePanel.revalidate();
        profilePanel.repaint();
        
        count++;
        currentColumn++;
        if (currentColumn >= MAX_COLUMNS) {
            currentColumn = 0;
            currentRow ++;
        }
    }
}
