package Model;

import java.util.ArrayList;

public class GiftConfig {
    public int id;
    public String name; //ten hien thi
    public String gift_name; //ten qua
    public String thumbnail; //anh cua qua
    public int price;
    public ArrayList<String> types;
    public ArrayList<String> sounds;

    public GiftConfig(){

    }

    public GiftConfig(int id, String name, String gift_name, String thumbnail, int price, ArrayList<String> types,
            ArrayList<String> sounds) {
        this.id = id;
        this.name = name;
        this.gift_name = gift_name;
        this.thumbnail = thumbnail;
        this.price = price;
        this.types = types;
        this.sounds = sounds;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGift_name() {
        return gift_name;
    }

    public void setGift_name(String gift_name) {
        this.gift_name = gift_name;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public ArrayList<String> getTypes() {
        return types;
    }

    public void setTypes(ArrayList<String> types) {
        this.types = types;
    }

    public ArrayList<String> getSounds() {
        return sounds;
    }

    public void setSounds(ArrayList<String> sounds) {
        this.sounds = sounds;
    }


}