package main;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ItemDAO {
    private Connection conn;

    public ItemDAO() throws Exception {
        DBConnectionSQLSever db = new DBConnectionSQLSever();
        this.conn = db.getConnection();
    }

    // CREATE
    public void addItem(Item item) throws SQLException {
        String query = "INSERT INTO items (item, category, damage_condition, price, phone, email) VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setString(1, item.getItem());
        stmt.setString(2, item.getCategory());
        stmt.setString(3, item.getDamageCondition());
        stmt.setDouble(4, item.getPrice());
        stmt.setString(5, item.getPhone());
        stmt.setString(6, item.getEmail());
        stmt.executeUpdate();
    }

    // READ
    public List<Item> getAllItems() throws SQLException {
        List<Item> items = new ArrayList<>();
        String query = "SELECT * FROM items";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        while (rs.next()) {
            Item item = new Item();
            item.setId(rs.getInt("id"));
            item.setItem(rs.getString("item"));
            item.setCategory(rs.getString("category"));
            item.setDamageCondition(rs.getString("damage_condition"));
            item.setPrice(rs.getDouble("price"));
            item.setPhone(rs.getString("phone"));
            item.setEmail(rs.getString("email")); 
            items.add(item);
        }
        return items;
    }

    // UPDATE
    public void updateItem(Item item) throws SQLException {
        String query = "UPDATE items SET item = ?, category = ?, damage_condition = ?, price = ?, phone = ?, email = ? WHERE id = ?";
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setString(1, item.getItem());
        stmt.setString(2, item.getCategory());
        stmt.setString(3, item.getDamageCondition());
        stmt.setDouble(4, item.getPrice());
        stmt.setString(5, item.getPhone());
        stmt.setString(6, item.getEmail());
        stmt.setInt(7, item.getId());
        stmt.executeUpdate();
    }

    // DELETE
    public void deleteItem(int id) throws SQLException {
        String query = "DELETE FROM items WHERE id = ?";
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setInt(1, id);
        stmt.executeUpdate();
    }
}
