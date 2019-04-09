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
// This is the RentalDue driver class which input the property information from
// a databas file, compute the rental and output the result
//

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class RentalDueTest2
{
	
	public static void main(String[] args) {
		String fileName;
        if (args.length == 0)
            fileName = "rentalDB.txt";
        else
            fileName = args[0];
        // The following code read the file twice, first is to acquire the total number
        // of the properities and second is to acquire the data for these properties.
		PropertyInfo propertyInfo = new PropertyInfo();
        int numberOfProperty = propertyInfo.get_numberOfProperty(fileName);

		// Construct objects for differnt type of rental properties 
		RentalProperty[] property = propertyInfo.get_typeOfProperty(fileName, numberOfProperty);
		propertyInfo.sortProperty(property, numberOfProperty);
		
		// Apply polymorphism to different rental property for the rent increase
		for (RentalProperty currentProperty : property) {
			if (currentProperty instanceof ApartmentRental) {
				ApartmentRental prop = (ApartmentRental) currentProperty;
				prop.setmonthlyRent(1.08 * prop.getmonthlyRent());
			}
			if (currentProperty instanceof SingleFamilyRental) {
				SingleFamilyRental prop = (SingleFamilyRental) currentProperty;
				prop.setmonthlyRent(1.04 * prop.getmonthlyRent());
			}
		}
		
		// List the rent for different kind of property, sorted order
		System.out.println("Single-Family Rental Summary:");
		System.out.printf("%-21s%-12s%14s%n", "House ID Number", "# of Bedrooms", "Rental Due");
		System.out.printf("%-21s%-12s%14s%n", "===============", "=============", "==========");
		
		for (RentalProperty currentProperty : property)
			if (currentProperty instanceof SingleFamilyRental)
				System.out.println(currentProperty);
		
		System.out.println();
		System.out.println("Apartment Rental Summary:");
		System.out.printf("%-21s%-12s%14s%n", "House ID Number", "# of Bedrooms", "Rental Due");
		System.out.printf("%-21s%-12s%14s%n", "===============", "=============", "==========");
		
		for (RentalProperty currentProperty : property)
			if (currentProperty instanceof ApartmentRental)
				System.out.println(currentProperty);
	}
}

	
class PropertyInfo {
	private static File file;
	private static RentalProperty[] property;
	Scanner input;
	int numberOfProperty;
	
	public int get_numberOfProperty(String DBFile) {
		file = new File(DBFile);
		try {
			input = new Scanner(file);
		} catch (FileNotFoundException e) {
			System.out.printf("%nError on file: %s (either enpty or wrong file format)%n%n", file); 
			e.printStackTrace();
			System.exit(1);
		}
		
		while (true) {
			if (input.hasNextLine()){
				numberOfProperty++;
				input.nextLine();
			} else
				break;
		}
		return numberOfProperty;
	}
	
	public RentalProperty[] get_typeOfProperty(String DBFile, int numberOfProperty) {
		file = new File(DBFile);
		try {
			input = new Scanner(file);
		} catch (FileNotFoundException e) {
			System.out.printf("%nError on file: %s (either enpty or wrong file format)%n%n", file); 
			e.printStackTrace();
			System.exit(1);
		}
		property = new RentalProperty[numberOfProperty];

		for (int i = 0; i < numberOfProperty; i++) {
			if (input.next().equals("A"))
				property[i] = new ApartmentRental(input.next(), Integer.parseInt(input.next()));
			else
				property[i] = new SingleFamilyRental(input.next(), Integer.parseInt(input.next()));
		}
		return property;
	}
	
	public void sortProperty(RentalProperty[] property, int numberOfProperty) {
		for (int i = 0; i < numberOfProperty; i++){
			RentalProperty placeholder;
			for (int j = i+1; j < numberOfProperty; j++) {
				if (property[i].getNumBedrooms() < property[j].getNumBedrooms()) {		// primary sort key
					placeholder = property[j];
					property[j] = property[i];
					property[i] = placeholder;
				}
			}
		}

		for (int i = 0; i < numberOfProperty; i++) {
			RentalProperty placeholder;	
			for (int j = i+1; j < numberOfProperty; j++) {
				if (property[i].getNumBedrooms() == property[j].getNumBedrooms() && 
					property[i].getiDNum().compareTo(property[j].getiDNum()) > 0) {		// secondary sort key
					placeholder = property[j];
					property[j] = property[i];
					property[i] = placeholder;
				}
			}
		}
	}
	
		
}