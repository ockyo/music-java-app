package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AddGiftDAO {
    public void insertGift(int ID, String name, String gift_name, String thumbnail, int price, String type,
            String sound) {
        String sql = "INSERT INTO giftconfig(id, name, gift_name, thumbnail, price, types, sounds) VALUES(?, ?,?,?,?,?,?)";
        try (Connection conn = DatabaseConnector.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, ID);
            pstmt.setString(2, name);
            pstmt.setString(3, gift_name);
            pstmt.setString(4, thumbnail);
            pstmt.setInt(5, price);
            pstmt.setString(6, type);
            pstmt.setString(7, sound);
            System.out.println("Inserted.");
            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public String getGiftNameById(int id) {
        String sql = "SELECT gift_name FROM giftconfig WHERE id = ?";
        String giftName = null;
        
        try (Connection conn = DatabaseConnector.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setInt(1, id);             
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) { 
                    giftName = rs.getString("gift_name"); 
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return giftName; 
    }
}
