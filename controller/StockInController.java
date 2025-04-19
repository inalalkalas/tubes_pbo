package controller;

import dao.StockInDAO;
import model.StockIn;
import java.util.List;

public class StockInController {

    private StockInDAO stockInDAO;

    public StockInController() {
        this.stockInDAO = new StockInDAO();
    }

    // Menambahkan transaksi stock in
    public void addStockIn(int productID, int quantity, java.sql.Date stockInDate) {
        StockIn stockIn = new StockIn(productID, quantity, stockInDate);
        stockInDAO.addStockIn(stockIn);
    }

    // Mendapatkan daftar transaksi stock in
    public List<StockIn> getAllStockIn() {
        return stockInDAO.getAllStockIn();
    }

    // Menghapus transaksi stock in
    public void deleteStockIn(int stockInID) {
        stockInDAO.deleteStockIn(stockInID);
    }
}
