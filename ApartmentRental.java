public class ApartmentRental extends RentalProperty implements Payment
{

	public ApartmentRental(String iDNum, String rentalType, int numOfBedrooms, String description) {
		super(iDNum,rentalType,numOfBedrooms, description);
		switch (numOfBedrooms) {
			case 1:
			    super.setmonthlyRent(600.00);
				break;
			case 2:
			    super.setmonthlyRent(800.00);
				break;
		}
	}
	public double outputCurrentRent() {
		return super.getmonthlyRent();
	}
	
	@Override
	public String toString() {
		return String.format("%s            $%,8.2f", super.toString(), outputCurrentRent());
	}
}

