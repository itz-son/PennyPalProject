package pennypal.model;

/**
 * Represents a tax rate (by occupation, region, etc.).
 */
public class Tax {

    private String occupation;
    private String region;
    private double rate; // e.g. 0.22 for 22%

    public Tax(String occupation, String region, double rate) {
        this.occupation = occupation;
        this.region = region;
        this.rate = rate;
    }

    public String getOccupation() {
        return occupation;
    }

    public String getRegion() {
        return region;
    }

    public double getRate() {
        return rate;
    }

    public double applyTax(double income) {
        return income * rate;
    }
}
