package model;

public class Product {
    private int productID;
    private int categoryID;
    private String productName;
    private int weight;
    private int product_stock;
    private int minStock;
    private double price;
    private int SubSubCategoryID;
    private int SubCategoryID;
    private String numberCode;
    private String description;
    private byte[] productImg;

    // Constructor
    public Product(int productID, int categoryID, String productName, int weight, int product_stock, int minStock, String numberCode, String description, byte[] productImg) {
        this.productID = productID;
        this.categoryID = categoryID;
        this.productName = productName;
        this.weight = weight;
        this.product_stock = product_stock;
        this.minStock = minStock;
        this.numberCode = numberCode;
        this.description = description;
        this.productImg = productImg;
    }

    public Product(int productID, String productName, int categoryID, int subCategoryID, int subSubCategoryID, double price, int product_stock){
        this.productID = productID;
        this.categoryID = categoryID;
        this.productName = productName;
        this.price = price;
        this.SubSubCategoryID = SubSubCategoryID;
        this.SubCategoryID = SubCategoryID;
        this.product_stock = product_stock;
    }

    public Product(String productName, int categoryID, int subCategoryID, int subSubCategoryID, double price, int product_stock){
        this.productName = productName;
        this.categoryID = categoryID;
        this.SubSubCategoryID = SubSubCategoryID;
        this.SubCategoryID = SubCategoryID;
        this.price = price;
        this.product_stock = product_stock;
    }

    public Product(int productID, String productName, double price) {
        this.productID = productID;
        this.productName = productName;
        this.price = price;
    }

    // Getters and Setters
    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public int getSubSubCategoryID() {
        return SubSubCategoryID;
    }

    public void setSubSubCategoryID(int SubSubCategoryID) {
        this.SubSubCategoryID = SubSubCategoryID;
    }
    
    public int getSubCategoryID() {
        return SubCategoryID;
    }

    public void setSubCategoryID(int SubCategoryID) {
        this.SubCategoryID = SubCategoryID;
    }

    public double getProductPrice(){
        return price;
    }

    public void setProductPrice(double Price){
        this.price = price;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getStock() {
        return product_stock;
    }

    public void setStock(int product_stock) {
        this.product_stock = product_stock;
    }

    public int getMinStock() {
        return minStock;
    }

    public void setMinStock(int minStock) {
        this.minStock = minStock;
    }

    public String getNumberCode() {
        return numberCode;
    }

    public void setNumberCode(String numberCode) {
        this.numberCode = numberCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public byte[] getProductImg() {
        return productImg;
    }

    public void setProductImg(byte[] productImg) {
        this.productImg = productImg;
    }

}
