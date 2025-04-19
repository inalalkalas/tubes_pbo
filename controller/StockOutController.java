package controller;

import dao.StockOutDAO;
import model.StockOut;
import java.util.List;

public class StockOutController {

    private StockOutDAO stockOutDAO;

    public StockOutController() {
        this.stockOutDAO = new StockOutDAO();
    }

    // Menambahkan transaksi stock out
    public void addStockOut(int productID, int quantity, java.sql.Date stockOutDate) {
        StockOut stockOut = new StockOut(productID, quantity, stockOutDate);
        stockOutDAO.addStockOut(stockOut);
    }

    // Mendapatkan daftar transaksi stock out
    public List<StockOut> getAllStockOut() {
        return stockOutDAO.getAllStockOut();
    }

    // Menghapus transaksi stock out
    public void deleteStockOut(int stockOutID) {
        stockOutDAO.deleteStockOut(stockOutID);
    }
}
