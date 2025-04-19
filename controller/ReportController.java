package controller;

import dao.ProductDAO;
import dao.StockDAO;
import model.Product;
import model.StockIn;
import model.StockOut;
import java.util.List;
import javax.swing.*;

public class ReportController {

    private ProductDAO productDAO;
    private StockDAO stockDAO;

    public ReportController() {
        this.productDAO = new ProductDAO();
        this.stockDAO = new StockDAO();
    }

    // Menampilkan laporan produk
    public void showProductReport() {
        List<Product> products = productDAO.getAllProducts();
        if (products.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No products found.");
            return;
        }

        StringBuilder report = new StringBuilder("Product Report:\n");
        report.append(String.format("%-20s%-10s%-10s\n", "Product Name", "Category", "Stock"));
        for (Product product : products) {
            report.append(String.format("%-20s%-10s%-10d\n", product.getProductName(), product.getCategoryID(), product.getStock()));
        }

        JOptionPane.showMessageDialog(null, report.toString());
    }

    // Menampilkan laporan stok masuk
    public void showStockInReport() {
        List<StockIn> stockInList = stockDAO.getAllStockIn();
        if (stockInList.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No stock-in records found.");
            return;
        }

        StringBuilder report = new StringBuilder("Stock In Report:\n");
        report.append(String.format("%-20s%-10s%-10s%-10s\n", "Product Name", "Quantity", "Date", "Supplier"));
        for (StockIn stockIn : stockInList) {
            report.append(String.format("%-20s%-10d%-10s%-10s\n", stockIn.getProductName(), stockIn.getQuantity(), stockIn.getStockInDate(), stockIn.getSupplierName()));
        }

        JOptionPane.showMessageDialog(null, report.toString());
    }

    // Menampilkan laporan stok keluar
    public void showStockOutReport() {
        List<StockOut> stockOutList = stockDAO.getAllStockOut();
        if (stockOutList.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No stock-out records found.");
            return;
        }

        StringBuilder report = new StringBuilder("Stock Out Report:\n");
        report.append(String.format("%-20s%-10s%-10s%-10s\n", "Product Name", "Quantity", "Date"));
        for (StockOut stockOut : stockOutList) {
            report.append(String.format("%-20s%-10d%-10s%-10s\n", stockOut.getProductName(), stockOut.getQuantity(), stockOut.getStockOutDate()));
        }

        JOptionPane.showMessageDialog(null, report.toString());
    }
}
