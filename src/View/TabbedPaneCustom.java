package View;

import javax.swing.JTabbedPane;

public class TabbedPaneCustom extends JTabbedPane{
    private GiftFrame profile1;
    private GiftFrame profile2;
    public TabbedPaneCustom(){
        profile1 = new GiftFrame();
        profile2 = new GiftFrame();

        add(profile1);
        add(profile2);
    }
}
