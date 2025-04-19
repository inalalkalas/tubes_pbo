package model;

public class SubCategory extends Category {
    private int parentCategoryID;  // Referensi ke kategori induk

    // Constructor
    public SubCategory(int categoryID, String categoryName, String description, int parentCategoryID) {
        super(categoryID, categoryName, description);
        this.parentCategoryID = parentCategoryID;
    }

    // Getter and Setter
    public int getParentCategoryID() {
        return parentCategoryID;
    }

    public void setParentCategoryID(int parentCategoryID) {
        this.parentCategoryID = parentCategoryID;
    }

    @Override
    public void displayCategoryDetails() {
        System.out.println("SubCategory: " + getCategoryName() + " (Parent ID: " + getParentCategoryID() + ")");
        System.out.println("Description: " + getDescription());
    }
}
