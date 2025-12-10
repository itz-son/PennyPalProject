package pennypal.model;

/**
 * Budget category with a percentage allocation.
 */
public class Category {

    private String categoryName;
    private double percentageAllocated; // e.g. 20 for 20%

    public Category(String categoryName, double percentageAllocated) {
        this.categoryName = categoryName;
        this.percentageAllocated = percentageAllocated;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public double getPercentageAllocated() {
        return percentageAllocated;
    }

    public double calculateAllocation(double income) {
        return income * (percentageAllocated / 100.0);
    }
}
