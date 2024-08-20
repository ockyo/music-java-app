package View;

import javax.swing.JFrame;

public class MainFrame extends JFrame{
    private ProfilePanel profile;
    public MainFrame(){
        super("Profile");
        setSize(600,700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        profile = new ProfilePanel();
        add(profile);
        
    }
    public static void main(String[] args) {
        new MainFrame().setVisible(true);
    }
}
