public class SingleFamilyRental extends RentalProperty implements Payment
{
	
	public SingleFamilyRental(String iDNum,String rentalType, int numOfBedrooms, String description) {
		super(iDNum,rentalType, numOfBedrooms, description);
		switch (numOfBedrooms) {
			case 1:
			    super.setmonthlyRent(900.00);
				break;
			case 2:
			    super.setmonthlyRent(1100.00);
				break;
			case 3:
			    super.setmonthlyRent(1300.00);
		}
	}
	
	public double outputCurrentRent() {
		return super.getmonthlyRent();
	}
	
	@Override
	public String toString() {
		return String.format("%s           $%,8.2f", super.toString(), outputCurrentRent());
	}
}
