package model;
import java.sql.Date;


public class StockOut {
    private int stockOutID;
    private int productID;
    private int quantity;
    private Date stockOutDate;
    private int userID;
    private String stockOutNotes;
    private String productName;

    // Constructor
    public StockOut(int stockOutID, int productID, int quantity, Date stockOutDate, int userID, String stockOutNotes) {
        this.stockOutID = stockOutID;
        this.productID = productID;
        this.quantity = quantity;
        this.stockOutDate = stockOutDate;
        this.userID = userID;
        this.stockOutNotes = stockOutNotes;
    }

    public StockOut(int stockOutID, int productID, int quantity, Date stockOutDate){
        this.stockOutID = stockOutID;
        this.productID = productID;
        this.quantity = quantity;
        this.stockOutDate = stockOutDate;
    }

    public StockOut(String productName, int quantity, Date stockOutDate){
        this.productName = productName;
        this.quantity = quantity;
        this.stockOutDate = stockOutDate;
    }

    public StockOut(int productID, int quantity, java.sql.Date stockOutDate) {
        this.productID = productID;
        this.quantity = quantity;
        this.stockOutDate = stockOutDate;
    }

    public String getProductName() {
        return productName;
    }

    public void getProductName(String productName) {
        this.productName = productName;
    }

    // Getters and Setters
    public int getStockOutID() {
        return stockOutID;
    }

    public void setStockOutID(int stockOutID) {
        this.stockOutID = stockOutID;
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

    public Date getStockOutDate() {
        return stockOutDate;
    }

    public void setStockOutDate(Date stockOutDate) {
        this.stockOutDate = stockOutDate;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getStockOutNotes() {
        return stockOutNotes;
    }

    public void setStockOutNotes(String stockOutNotes) {
        this.stockOutNotes = stockOutNotes;
    }
}
