// Programming Assignment #2 -- RentalDue
// CSCI-2251 spring 2019, Section 101, Intermediate Computer Programming
// By: Dr. Chu J. Jong, 02/18/2019
//
// ============================================================================
// This assignment implements interface, and applies object inheritance and
// polymorphism to the class hierarchy.
// There are three objects, RentalProperty is the super class of to subclasses
// SingleFamilyRental and ApartmentRental. A payment interface is implemented
// by the two subclasses. Polymorphism is used to increase the monthly rental
// by certain percentage subject to the property types. Finally list all monthly
// rentals on the console in a sorted order.
// ============================================================================= 
//
// This is the superclass for other rental property subclasses
//

public abstract class RentalProperty
{
	private String iDNum;			// the rental property identification number
	private int numBedrooms;		// the total bedrooms 
	private double monthlyRent;		// the monthly rent
	
	public RentalProperty(String iDNum, int numBedrooms) {
		this.iDNum = iDNum;
		this.numBedrooms = numBedrooms;
	}
	
	// Following are the get and put methods for access the instant variables
	public String getiDNum() {
		return iDNum;
	}
	
	public int getNumBedrooms()	{
		return numBedrooms;
	}
	
	public double getmonthlyRent() {
		return monthlyRent;
	}
	
	public void setmonthlyRent(double rent) {
		this.monthlyRent = rent;
	}
	
	@Override
	public String toString() {
		return String.format("   %-23s%-12d", iDNum, numBedrooms);
	}
}