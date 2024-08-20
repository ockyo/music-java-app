package View;

import javax.swing.JTabbedPane;

public class TabbedPaneCustom extends JTabbedPane{
    private ProfilePanel profile1;
    private ProfilePanel profile2;
    public TabbedPaneCustom(){
        profile1 = new ProfilePanel();
        profile2 = new ProfilePanel();

        add(profile1);
        add(profile2);
    }
}
