package dao;

import model.StockIn;
import utils.DbConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StockInDAO {

    // Menambahkan transaksi stock in baru
    public void addStockIn(StockIn stockIn) {
        String sql = "INSERT INTO stock_in (productID, stock_in_quantity, stock_in_date) VALUES (?, ?, ?)";

        try (Connection conn = DbConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, stockIn.getProductID());
            ps.setInt(2, stockIn.getQuantity());
            ps.setDate(3, stockIn.getStockInDate());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Mendapatkan semua transaksi stock in
    public List<StockIn> getAllStockIn() {
        List<StockIn> stockIns = new ArrayList<>();
        String sql = "SELECT * FROM stock_in";

        try (Connection conn = DbConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                int stockInID = rs.getInt("stock_inID");
                int productID = rs.getInt("product_id");
                int quantity = rs.getInt("stock_in_quantity");
                Date stockInDate = rs.getDate("stock_in_date");

                StockIn stockIn = new StockIn(stockInID, productID, quantity, stockInDate);
                stockIns.add(stockIn);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return stockIns;
    }

    // Menghapus transaksi stock in berdasarkan ID
    public void deleteStockIn(int stockInID) {
        String sql = "DELETE FROM stock_in WHERE stock_in_ID = ?";

        try (Connection conn = DbConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, stockInID);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
