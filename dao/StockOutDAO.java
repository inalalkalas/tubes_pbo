package dao;

import model.StockOut;
import utils.DbConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StockOutDAO {

    // Menambahkan transaksi stock out baru
    public void addStockOut(StockOut stockOut) {
        String sql = "INSERT INTO stock_out (product_id, quantity, date) VALUES (?, ?, ?)";

        try (Connection conn = DbConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, stockOut.getProductID());
            ps.setInt(2, stockOut.getQuantity());
            ps.setDate(3, stockOut.getStockOutDate());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Mendapatkan semua transaksi stock out
    public List<StockOut> getAllStockOut() {
        List<StockOut> stockOuts = new ArrayList<>();
        String sql = "SELECT * FROM stock_out";

        try (Connection conn = DbConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                int stockOutID = rs.getInt("stock_out_id");
                int productID = rs.getInt("product_id");
                int quantity = rs.getInt("quantity");
                Date stockOutDate = rs.getDate("stockOutDate");

                StockOut stockOut = new StockOut(stockOutID, productID, quantity, stockOutDate);
                stockOuts.add(stockOut);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return stockOuts;
    }

    // Menghapus transaksi stock out berdasarkan ID
    public void deleteStockOut(int stockOutID) {
        String sql = "DELETE FROM stock_out WHERE stock_out_id = ?";

        try (Connection conn = DbConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, stockOutID);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
