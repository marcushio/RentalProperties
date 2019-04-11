public class VacationRental extends RentalProperty implements Payment
{

	public VacationRental(String iDNum, String rentalType,int numOfBedrooms, String description) {
		super(iDNum, rentalType,numOfBedrooms, description);
		switch (numOfBedrooms) {
			case 1:
			    super.setmonthlyRent(1500.00);//at $50/day
                            super.setweeklyRent(350.00);
                            super.setdailyRent(50.00);
				break;
			case 2:
			    super.setmonthlyRent(1800.00); //at #60/day
                            super.setweeklyRent(420.00);
                            super.setdailyRent(60.00);
				break;
                        case 3:
			    super.setmonthlyRent(2400.00);  //at $80/day
                            super.setweeklyRent(560.00);
                            super.setdailyRent(80.00);
		}
	}

    
        @Override
	public double outputCurrentRent() {
            if ("M".equals(rentalType)) {
		return super.getmonthlyRent();
        }
            if ("W".equals(rentalType)) {
                return super.getweeklyRent();
        }
            if ("D".equals(rentalType)) {
                return super.getdailyRent();
	}
            return 0;
        }
	
	@Override
	public String toString() {
		return String.format("%s          $%,8.2f", super.toString(), outputCurrentRent());
	}
}
