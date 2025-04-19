package controller;

import dao.ProductDAO;
import dao.StockInDAO;
import dao.StockOutDAO;
import model.Product;
import model.StockIn;
import model.StockOut;

public class StaffController {

    private ProductDAO productDAO;
    private StockInDAO stockInDAO;
    private StockOutDAO stockOutDAO;

    public StaffController() {
        this.productDAO = new ProductDAO();
        this.stockInDAO = new StockInDAO();
        this.stockOutDAO = new StockOutDAO();
    }

    // Menambahkan produk
    public void addProduct(String productName, int categoryID, int subCategoryID, int subSubCategoryID, double price, int stockQuantity) {
        Product product = new Product(productName, categoryID, subCategoryID, subSubCategoryID, price, stockQuantity);
        productDAO.addProduct(product);
    }

    // Menghapus produk
    public void deleteProduct(int productID) {
        productDAO.deleteProduct(productID);
    }

    // Mengubah produk
    public void updateProduct(int productID, String productName, int categoryID, int subCategoryID, int subSubCategoryID, double price, int stockQuantity) {
        productDAO.updateProduct(productID, productName, categoryID, subCategoryID, subSubCategoryID, price, stockQuantity);
    }

    // Menambahkan transaksi stock in
    public void addStockIn(int productID, int quantity, java.sql.Date date) {
        StockIn stockIn = new StockIn(productID, quantity, date);
        stockInDAO.addStockIn(stockIn);
    }

    // Menambahkan transaksi stock out
    public void addStockOut(int productID, int quantity, java.sql.Date date) {
        StockOut stockOut = new StockOut(productID, quantity, date);
        stockOutDAO.addStockOut(stockOut);
    }
}
