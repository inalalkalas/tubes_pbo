package dao;

import model.StockIn;
import model.StockOut;
import utils.DbConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class StockDAO {

    private Connection conn;

    // Konstruktor untuk menginisialisasi koneksi database
    public StockDAO() {
        this.conn = DbConnection.getConnection();
    }    

    // Mendapatkan semua data stok masuk (Stock In)
    public List<StockIn> getAllStockIn() {
        List<StockIn> stockInList = new ArrayList<>();
        try {
            String sql = "SELECT * FROM stock_in";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            // Mengambil data dari ResultSet dan memasukkan ke dalam list StockIn
            while (rs.next()) {
                String productName = rs.getString("product_name");
                int quantity = rs.getInt("stock_in_quantity");
                Date stockInDate = rs.getDate("stockInDate");
                String supplierName = rs.getString("suppliername");

                // Membuat objek StockIn dan menambahkannya ke dalam list
                stockInList.add(new StockIn(productName, quantity, stockInDate, supplierName));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return stockInList;
    }

    // Mendapatkan semua data stok keluar (Stock Out)
    public List<StockOut> getAllStockOut() {
        List<StockOut> stockOutList = new ArrayList<>();
        try {
            String sql = "SELECT * FROM stock_out";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            // Mengambil data dari ResultSet dan memasukkan ke dalam list StockOut
            while (rs.next()) {
                String productName = rs.getString("product_name");
                int quantity = rs.getInt("stock_out_quantity");
                Date stockOutDate = rs.getDate("stockOutDate");

                // Membuat objek StockOut dan menambahkannya ke dalam list
                stockOutList.add(new StockOut(productName, quantity, stockOutDate));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return stockOutList;
    }

    // Menambahkan stok masuk ke dalam database
    public boolean addStockIn(StockIn stockIn) {
        try {
            String sql = "INSERT INTO stock_in (product_name, stock_in_quantity, date, supplier_name) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, stockIn.getProductName());
            ps.setInt(2, stockIn.getQuantity());
            ps.setDate(3, stockIn.getStockInDate());
            ps.setString(4, stockIn.getSupplierName());

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Menambahkan stok keluar ke dalam database
    public boolean addStockOut(StockOut stockOut) {
        try {
            String sql = "INSERT INTO stock_out (product_name, stock_out_quantity, date) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, stockOut.getProductName());
            ps.setInt(2, stockOut.getQuantity());
            ps.setDate(3, stockOut.getStockOutDate());
            int rowsAffected = ps.executeUpdate();

            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Mengupdate stok masuk dalam database
    public boolean updateStockIn(StockIn stockIn) {
        try {
            String sql = "UPDATE stock_in SET stock_in_quantity = ?, date = ?, supplier_name = ? WHERE product_name = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, stockIn.getQuantity());
            ps.setDate(2, stockIn.getStockInDate());
            ps.setString(3, stockIn.getSupplierName());
            ps.setString(4, stockIn.getProductName());
            int rowsAffected = ps.executeUpdate();

            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Mengupdate stok keluar dalam database
    public boolean updateStockOut(StockOut stockOut) {
        try {
            String sql = "UPDATE stock_out SET stock_out_quantity = ?, date = ?, WHERE product_name = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, stockOut.getQuantity());
            ps.setDate(2, stockOut.getStockOutDate());
            ps.setString(4, stockOut.getProductName());
            int rowsAffected = ps.executeUpdate();

            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Menghapus stok masuk dari database
    public boolean deleteStockIn(String productName) {
        try {
            String sql = "DELETE FROM stock_in WHERE product_name = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, productName);
            int rowsAffected = ps.executeUpdate();

            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Menghapus stok keluar dari database
    public boolean deleteStockOut(String productName) {
        try {
            String sql = "DELETE FROM stock_out WHERE product_name = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, productName);
            int rowsAffected = ps.executeUpdate();

            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
