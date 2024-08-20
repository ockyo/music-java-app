package Model;

import java.util.ArrayList;

public class Profile {

    public String background_music; //nhac nen khi khong co nhac
    public String cross_sound; //nhac chuyen bai
    public ArrayList<GiftConfig> gift_config;
    public Profile(String background_music, String cross_sound, ArrayList<GiftConfig> gift_config) {
        this.background_music = background_music;
        this.cross_sound = cross_sound;
        this.gift_config = gift_config;
    }
    
    public String getBackground_music() {
        return background_music;
    }
    public void setBackground_music(String background_music) {
        this.background_music = background_music;
    }
    public String getCross_sound() {
        return cross_sound;
    }
    public void setCross_sound(String cross_sound) {
        this.cross_sound = cross_sound;
    }
    public ArrayList<GiftConfig> getGift_config() {
        return gift_config;
    }
    public void setGift_config(ArrayList<GiftConfig> gift_config) {
        this.gift_config = gift_config;
    }

}
