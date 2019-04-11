public abstract class RentalProperty {

    private String iDNum; // the rental property identification number
    String rentalType; //rental type monthly, weekly, daily
    private int numBedrooms;		// the total bedrooms 
    private double monthlyRent;		// the monthly rent
    private double weeklyRent;     //the weekly rent
    private double dailyRent;  //daily rent
    private String description;
    
    public RentalProperty(String iDNum,String rentalType, int numBedrooms, String description) {
        this.iDNum = iDNum;
        this.rentalType = rentalType;
        this.numBedrooms = numBedrooms;
        this.description = description;
    }

    // Following are the get and put methods for access the instant variables
    public String getiDNum() {
        return iDNum;
    }
    public String getrentalType() {
        return rentalType;
    }

    public int getNumBedrooms() {
        return numBedrooms;
    }
    public String getDescription() {
        return description;
    }

    public double getmonthlyRent() {
        return monthlyRent;
    }

    public void setmonthlyRent(double rent) {
        this.monthlyRent = rent;
    }

    public double getweeklyRent() {
        return weeklyRent;
    }
    
    public void setweeklyRent(double rent) {
        this.weeklyRent = rent;
    }
    public double getdailyRent() {
        return weeklyRent;
    }
    
    public void setdailyRent(double rent) {
        this.dailyRent = rent;
    }

    @Override
    public String toString() {
        return String.format("   %-23s%-12s%12d%25s", iDNum,rentalType, numBedrooms, description);
    }
}
