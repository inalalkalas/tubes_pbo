package model;

import java.sql.Date;


public class StockIn {
    private int stockInID;
    private int productID;
    private int quantity;
    private Date stockInDate;
    private int userID;
    private String supplierName;
    private String notes;
    private String productName;

    // Constructor
    public StockIn(int stockInID, int productID, int quantity, Date stockInDate, int userID, String supplierName, String notes) {
        this.stockInID = stockInID;
        this.productID = productID;
        this.quantity = quantity;
        this.stockInDate = stockInDate;
        this.userID = userID;
        this.supplierName = supplierName;
        this.notes = notes;
    }

    public StockIn(int stockInID, int productID, int quantity, Date stockInDate){
        this.stockInID = stockInID;
        this.productID = productID;
        this.quantity = quantity;
        this.stockInDate = stockInDate;
    }

    public StockIn(String productName, int quantity, Date stockInDate, String supplierName){
        this.productName = productName;
        this.quantity = quantity;
        this.stockInDate = stockInDate;
        this.supplierName = supplierName;
    }

    public StockIn (int productID, int quantity, java.sql.Date stockInDate) {
        this.productID = productID;
        this.quantity = quantity;
        this.stockInDate = stockInDate;
    }

    public String getProductName() {
        return productName;
    }

    public void getProductName(String productName) {
        this.productName = productName;
    }
    

    // Getters and Setters
    public int getStockInID() {
        return stockInID;
    }

    public void setStockInID(int stockInID) {
        this.stockInID = stockInID;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Date getStockInDate() {
        return stockInDate;
    }

    public void setStockInDate(Date stockInDate) {
        this.stockInDate = stockInDate;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
