package model;

public class SubSubCategory extends SubCategory {
    private int parentSubCategoryID;  // Referensi ke subkategori induk

    // Constructor
    public SubSubCategory(int categoryID, String categoryName, String description, int parentCategoryID, int parentSubCategoryID) {
        super(categoryID, categoryName, description, parentCategoryID);
        this.parentSubCategoryID = parentSubCategoryID;
    }

    // Getter and Setter
    public int getParentSubCategoryID() {
        return parentSubCategoryID;
    }

    public void setParentSubCategoryID(int parentSubCategoryID) {
        this.parentSubCategoryID = parentSubCategoryID;
    }

    @Override
    public void displayCategoryDetails() {
        System.out.println("SubSubCategory: " + getCategoryName() + " (Parent SubCategory ID: " + getParentSubCategoryID() + ")");
        System.out.println("Parent Category ID: " + getParentCategoryID());
        System.out.println("Description: " + getDescription());
    }
}
